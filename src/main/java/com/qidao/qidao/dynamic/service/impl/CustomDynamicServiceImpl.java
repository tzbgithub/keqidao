package com.qidao.qidao.dynamic.service.impl;


import cn.hutool.core.collection.CollUtil;
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
import com.qidao.qidao.dynamic.domain.*;
import com.qidao.qidao.dynamic.domain.enums.DynamicExceptionEnum;
import com.qidao.qidao.dynamic.mapper.CustomDynamicMapper;
import com.qidao.qidao.dynamic.mapper.DynamicMapper;
import com.qidao.qidao.dynamic.service.CustomDynamicService;
import com.qidao.qidao.link.dynamicChannel.domain.LinkDynamicChannel;
import com.qidao.qidao.link.dynamicChannel.domain.LinkDynamicChannelExample;
import com.qidao.qidao.link.dynamicChannel.mapper.LinkDynamicChannelMapper;
import com.qidao.qidao.link.linkLabel.domain.LinkLabel;
import com.qidao.qidao.link.linkLabel.domain.LinkSelect;
import com.qidao.qidao.link.linkLabel.mapper.LinkLabelMapper;
import com.qidao.qidao.link.linkLabel.mapper.LinkSelectMapper;
import com.qidao.qidao.link.publishContent.domain.LinkPublishContent;
import com.qidao.qidao.link.publishContent.domain.enums.PublishContentEnum;
import com.qidao.qidao.link.publishContent.mapper.LinkPublishContentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("customDynamicService")
public class CustomDynamicServiceImpl implements CustomDynamicService {

    @Resource
    private CustomDynamicMapper customDynamicMapper;

    @Resource
    private LinkPublishContentMapper linkPublishContentMapper;

    @Resource
    private DynamicMapper dynamicMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private LinkLabelMapper linkLabelMapper;

    @Resource
    private LinkSelectMapper linkSelectMapper;

    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker53;

    @Resource
    private LinkDynamicChannelMapper linkDynamicChannelMapper;

    @Override
    public List<DynamicPageRes> getDynamic(DynamicPageReq req) {
        List<CustomDynamic> dynamics = customDynamicMapper.getDynamic(req);
        List<User> verifyUser = userMapper.getVerifyUser();
        Map<Long, String> userMap = verifyUser.stream().collect(Collectors.toMap(User::getUserId, User::getUserName, (oldV, newV) -> newV));
        Page<DynamicPageRes> res = new Page<>();
        dynamics.forEach(customDynamic -> {
            DynamicPageRes pageRes = new DynamicPageRes();
            BeanUtils.copyProperties(customDynamic , pageRes);
            pageRes.setChannel(customDynamic.getChannel());
            if (StringUtils.isNotEmpty(customDynamic.getChannel()) && customDynamic.getChannel().contains(",")){
                pageRes.setChannel(customDynamic.getChannel().substring(0,customDynamic.getChannel().indexOf(",")));
            }
            pageRes.setVerifyName(userMap.get(customDynamic.getVerifyUserId()));
            pageRes.setRecheckName(userMap.get(customDynamic.getRecheckId()));
            res.add(pageRes);
        });
        if(dynamics instanceof Page) {
            res.setTotal(((Page<CustomDynamic>) dynamics).getTotal());
        }
        return res;
    }

    @Override
    public DynamicDetails getDynamicById(Long id) {
        DynamicById dynamic = customDynamicMapper.getDynamicById(id);
        DynamicDetails dynamicDetails = new DynamicDetails();
        BeanUtils.copyProperties(dynamic , dynamicDetails);
        if (StrUtil.isNotEmpty(dynamic.getImg())){
            dynamicDetails.setImg(Arrays.asList(dynamic.getImg().split(",")));
        }
        return dynamicDetails;
    }

    @Override
    public List<DynamicChannel> getChannel() {
        return customDynamicMapper.getChannel();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int verifyDynamicPass(VerifyReq req) {
        saveChannel(req.getChannel(), req.getId());
        return customDynamicMapper.verifyDynamicPass(req.getId() , ShiroUtils.getUserId());
    }

    @Override
    public int verifyDynamicFailed(Long id) {
        return customDynamicMapper.verifyDynamicFailed(id , ShiroUtils.getUserId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int approvalDynamicPass(VerifyReq req) {
        saveChannel(req.getChannel(),req.getId());
        return customDynamicMapper.approvalDynamicPass(req.getId(), ShiroUtils.getUserId());
    }

    @Override
    public int approvalDynamicFailed(Long id) {
        return customDynamicMapper.approvalDynamicFailed(id , ShiroUtils.getUserId());
    }

    @Override
    public int checkPending(Long id) {
        return customDynamicMapper.checkPending(id , ShiroUtils.getUserId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int create(DynamicInsertReq req) {
        Long dynamicId = snowflakeIdWorker53.nextId();
        String video = req.getVideo();
        String img =  req.getImg();
        String thumb = req.getThumb();
        String url = req.getUrl();
        String content = req.getContent();
        int type = 5;
        if (StrUtil.isAllEmpty(video , img , url)){
            type = 1;
        }
        if (StrUtil.isNotEmpty(img) && StrUtil.isEmpty(video)){
            type = 2;
        }
        if (StrUtil.isNotEmpty(video)){
            type = 3;
        }
        if (StrUtil.isAllEmpty(video , img) && StrUtil.isNotEmpty(url)){
            type = 4;
        }
        boolean allNotEmpty = StrUtil.isAllEmpty(content, video, url, img);
        if (allNotEmpty){
            throw new BusinessException(DynamicExceptionEnum.DYNAMIC_NOT_NULL);
        }
        boolean imgVideoAllEmpty = StrUtil.isAllNotEmpty(video, img);
        if (imgVideoAllEmpty){
            throw new BusinessException(DynamicExceptionEnum.VIDEO_OR_IMG);
        }
        boolean imgOrVideoThumb = (StrUtil.isNotEmpty(video) || StrUtil.isNotEmpty(img)) && StrUtil.isEmpty(thumb);
        if (imgOrVideoThumb){
            throw new BusinessException(DynamicExceptionEnum.VIDEO_OR_IMG_THUMB);
        }
        boolean contentNoThumb = (StrUtil.isEmpty(video)&& StrUtil.isEmpty(img)&& StrUtil.isEmpty(url) && StrUtil.isNotEmpty(content))&& StrUtil.isNotEmpty(thumb);
        if (contentNoThumb){
            throw new BusinessException(DynamicExceptionEnum.CONTENT_NOT_THUMB);
        }
        JSONArray labels = JSON.parseArray(req.getLabels());
        if (CollUtil.isNotEmpty(labels)){
            for (Object id : labels) {
                LinkLabel linkLabel = new LinkLabel();
                linkLabel.setLabelId(Long.parseLong(id.toString()));
                linkLabel.setId(snowflakeIdWorker53.nextId());
                linkLabel.setSourceId(dynamicId);
                linkLabel.setType(0);
                linkLabelMapper.insertSelective(linkLabel);
            }
        }
        JSONArray articles = JSON.parseArray(req.getArticles());
        if (CollUtil.isNotEmpty(articles)){
            for (Object id : articles) {
               linkSelectMapper.insertSelective(LinkSelect.builder()
                        .id(snowflakeIdWorker53.nextId())
                        .sourceId(dynamicId)
                        .selectConfigId(Long.parseLong(id.toString()))
                        .type(13)
                        .build());
            }
        }
        linkDynamicChannelMapper.insertSelective(LinkDynamicChannel.builder().id(snowflakeIdWorker53.nextId()).type(0).channelId(req.getChannel()).dynamicId(dynamicId).build());
        Dynamic dynamic = new Dynamic();
        BeanUtils.copyProperties(req , dynamic);
        dynamic.setId(dynamicId);
        dynamic.setHot(req.getHot().byteValue());
        dynamic.setCooperationType(req.getCooperation());
        dynamic.setTechnologyMaturity(req.getMaturity());
        dynamic.setPublishTime(LocalDateTime.now());
        dynamic.setType(type);
        if (StrUtil.isNotEmpty(content) && content.length() > 63){
            dynamic.setSummary(content.substring(0,63));
        }else{
            dynamic.setSummary(content);
        }
        linkPublishContentMapper.insertSelective(LinkPublishContent.builder()
                .salesmanId(req.getSalesmanId())
                .memberId(req.getMemberId())
                .type(PublishContentEnum.TYPE_DYNAMIC.getCode())
                .publishType(PublishContentEnum.PUBLISH_TYPE_SALESMAN.getCode())
                .publishId(dynamicId)
                .createBy(ShiroUtils.getUserId())
                .build());
        return dynamicMapper.insertSelective(dynamic);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateChannel(VerifyReq req) {
        saveChannel(req.getChannel(), req.getId());
        return 1;
    }

    @Override
    public List<MemberInfo> getMember(String name) {
        return customDynamicMapper.getMember(name);
    }

    @Override
    public int allData() {
        return customDynamicMapper.allData();
    }

    @Override
    public int getYesterdayData() {
        LocalDate yesterday = LocalDate.now().minusDays(1L);
        LocalDateTime startTime = LocalDateTime.of(yesterday, LocalTime.MIN);
        LocalDateTime endTime = LocalDateTime.of(yesterday, LocalTime.MAX);
        return customDynamicMapper.getYesterdayData(startTime , endTime);
    }

    @Override
    public int verifyData() {
        return customDynamicMapper.verifyData();
    }

    private void saveChannel(Long channel , Long dynamicId) {
        LinkDynamicChannelExample example = new LinkDynamicChannelExample();
        example.createCriteria().andDynamicIdEqualTo(dynamicId).andDelFlagEqualTo(ConstantEnum.NOT_DEL.getValue());
        LinkDynamicChannel linkDynamicChannel = linkDynamicChannelMapper.selectOneByExample(example);
        if (linkDynamicChannel != null && !linkDynamicChannel.getChannelId().equals(channel)){
            linkDynamicChannelMapper.updateByPrimaryKeySelective(LinkDynamicChannel.builder()
                    .id(linkDynamicChannel.getId())
                    .channelId(channel)
                    .build());
        }
        if (linkDynamicChannel == null){
            linkDynamicChannelMapper.insertSelective(LinkDynamicChannel.builder()
                    .id(snowflakeIdWorker53.nextId())
                    .dynamicId(dynamicId)
                    .channelId(channel)
                    .build());
        }
    }
}
