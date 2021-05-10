package com.qidao.qidao.equipment.equipment.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.qidao.common.enums.ConstantEnum;
import com.qidao.common.exception.BusinessException;
import com.qidao.common.utils.StringUtils;
import com.qidao.common.utils.bean.BeanUtils;
import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.framework.util.SnowflakeIdWorker53;
import com.qidao.project.system.user.domain.User;
import com.qidao.project.system.user.mapper.UserMapper;
import com.qidao.qidao.equipment.equipment.domain.*;
import com.qidao.qidao.equipment.equipment.domain.enums.AchievementEquipmentEnum;
import com.qidao.qidao.equipment.equipment.domain.enums.AchievementEquipmentErrorEnum;
import com.qidao.qidao.equipment.equipment.mapper.AchievementEquipmentMapper;
import com.qidao.qidao.equipment.equipment.mapper.CustomAchievementEquipmentMapper;
import com.qidao.qidao.equipment.equipment.service.CustomAchievementEquipmentService;
import com.qidao.qidao.link.linkLabel.domain.LinkLabel;
import com.qidao.qidao.link.linkLabel.domain.LinkSelect;
import com.qidao.qidao.link.linkLabel.domain.enums.LinkLabelEnum;
import com.qidao.qidao.link.linkLabel.mapper.LinkLabelMapper;
import com.qidao.qidao.link.linkLabel.mapper.LinkSelectMapper;
import com.qidao.qidao.link.publishContent.domain.LinkPublishContent;
import com.qidao.qidao.link.publishContent.domain.enums.PublishContentEnum;
import com.qidao.qidao.link.publishContent.mapper.LinkPublishContentMapper;
import com.qidao.qidao.member.member.domain.Member;
import com.qidao.qidao.member.member.mapper.MemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("customAchievementEquipmentService")
public class CustomAchievementEquipmentServiceImpl implements CustomAchievementEquipmentService {

    @Resource
    private CustomAchievementEquipmentMapper customAchievementEquipmentMapper;

    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker53;

    @Resource
    private MemberMapper memberMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private LinkLabelMapper linkLabelMapper;

    @Resource
    private LinkSelectMapper linkSelectMapper;

    @Resource
    private AchievementEquipmentMapper achievementEquipmentMapper;

    @Resource
    private LinkPublishContentMapper linkPublishContentMapper;

    @Override
    public List<AchievementEquipmentPageRes> findAllEquipment(AchievementEquipmentPageReq req) {
        Page<AchievementEquipmentPageRes> res = customAchievementEquipmentMapper.findEquipmentPage(req);
        List<User> verifyUser = userMapper.getVerifyUser();
        Map<Long, String> userMap = verifyUser.stream().collect(Collectors.toMap(User::getUserId, User::getUserName, (oldV, newV) -> newV));
        res.forEach(achievement -> {
            achievement.setVerifyUserName(userMap.get(achievement.getVerifyUserId()));
        });
        return res;
    }

    @Override
    public AchievementEquipmentDescription findEquipmentDescription(Long id) {
        AchievementEquipmentDescription equipmentDescription = customAchievementEquipmentMapper.findEquipmentDescription(id);
        if (StrUtil.isNotEmpty(equipmentDescription.getImgs())){
            equipmentDescription.setImgList(Arrays.asList(equipmentDescription.getImgs().split(",")));
        }
        if (StrUtil.isNotEmpty(equipmentDescription.getLabels())){
            List<String> labels = Arrays.asList(equipmentDescription.getLabels().split(","));
            equipmentDescription.setLabels(labels.stream().distinct().collect(Collectors.joining(",")));
        }
        if (StrUtil.isNotEmpty(equipmentDescription.getArticles())){
            List<String> articles = Arrays.asList(equipmentDescription.getArticles().split(","));
            equipmentDescription.setArticles(articles.stream().distinct().collect(Collectors.joining(",")));
        }
        return equipmentDescription;
    }

    @Override
    public int verifyPass(Long id , String msg) {
        return achievementEquipmentMapper.updateByPrimaryKeySelective(AchievementEquipment.builder()
                .id(id)
                .verifyStatus(AchievementEquipmentEnum.VERIFY_PASS.getCode())
                .verifyUserId(ShiroUtils.getUserId())
                .verifyReason(msg)
                .build());
    }

    @Override
    public int verifyFail(Long id , String msg) {
        return achievementEquipmentMapper.updateByPrimaryKeySelective(AchievementEquipment.builder()
                .id(id)
                .verifyStatus(AchievementEquipmentEnum.VERIFY_FAIL.getCode())
                .verifyUserId(ShiroUtils.getUserId())
                .verifyReason(msg)
                .build());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int create(AchievementEquipmentAddReq req) {
        Long id = snowflakeIdWorker53.nextId();
        Member member = memberMapper.selectByPrimaryKey(req.getMemberId());
        if (StringUtils.isEmpty(req.getUrl()) && StringUtils.isEmpty(req.getImgs()) && StringUtils.isEmpty(req.getContent()) && StringUtils.isEmpty(req.getVideo())){
            throw new BusinessException(AchievementEquipmentErrorEnum.NOT_NULL);
        }
        if (StrUtil.isNotEmpty(req.getLabels())){
            JSONArray labels = JSON.parseArray(req.getLabels());
            for (Object labelId : labels) {
                linkLabelMapper.insertSelective(LinkLabel.builder()
                        .id(snowflakeIdWorker53.nextId())
                        .sourceId(id)
                        .labelId(Long.parseLong(labelId.toString()))
                        .type(LinkLabelEnum.TYPE_EQUIPMENT.getCode())
                        .build());
            }
        }
        if (StrUtil.isNotEmpty(req.getArticles())){
            JSONArray articles = JSON.parseArray(req.getArticles());
            for (Object articleId : articles) {
                linkSelectMapper.insertSelective(LinkSelect.builder()
                        .id(snowflakeIdWorker53.nextId())
                        .type(13)
                        .selectConfigId(Long.parseLong(articleId.toString()))
                        .sourceId(id)
                        .build());
            }
        }
        AchievementEquipment achievementEquipment = new AchievementEquipment();
        BeanUtils.copyProperties(req , achievementEquipment);
        if (StrUtil.isNotEmpty(req.getContent()) && req.getContent().length() > 63){
            achievementEquipment.setSummary(req.getContent().substring(0 , 63));
        }else{
            achievementEquipment.setSummary(req.getContent());
        }
        linkPublishContentMapper.insertSelective(LinkPublishContent.builder()
                .salesmanId(req.getSalesmanId())
                .memberId(req.getMemberId())
                .type(PublishContentEnum.TYPE_EQUIPMENT.getCode())
                .publishType(PublishContentEnum.PUBLISH_TYPE_SALESMAN.getCode())
                .publishId(id)
                .createBy(ShiroUtils.getUserId())
                .build());
        achievementEquipment.setCreateBy(ShiroUtils.getUserId());
        achievementEquipment.setDelFlag(ConstantEnum.NOT_DEL.getValue());
        achievementEquipment.setId(id);
        achievementEquipment.setOrganizationId(member.getOrganizationId());
        achievementEquipment.setCooperationType(req.getCooperation());
        achievementEquipment.setMaturity(req.getMaturity());
        achievementEquipment.setVerifyStatus(AchievementEquipmentEnum.VERIFY_INIT.getCode());
        return achievementEquipmentMapper.insertSelective(achievementEquipment);
    }
}
