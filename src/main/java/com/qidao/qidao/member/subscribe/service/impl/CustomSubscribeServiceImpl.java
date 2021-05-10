package com.qidao.qidao.member.subscribe.service.impl;

import com.github.pagehelper.Page;
import com.qidao.common.enums.ConstantEnum;
import com.qidao.common.exception.BusinessException;
import com.qidao.common.utils.StringUtils;
import com.qidao.common.utils.bean.BeanUtils;
import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.framework.util.SnowflakeIdWorker53;
import com.qidao.qidao.member.member.domain.Member;
import com.qidao.qidao.member.member.domain.MemberDetails;
import com.qidao.qidao.member.member.domain.MemberExample;
import com.qidao.qidao.member.member.mapper.CustomMemberMapper;
import com.qidao.qidao.member.member.mapper.MemberMapper;
import com.qidao.qidao.member.subscribe.domain.*;
import com.qidao.qidao.member.subscribe.domain.enums.SubscribeErrorEnum;
import com.qidao.qidao.member.subscribe.mapper.CustomSubscribeMapper;
import com.qidao.qidao.member.subscribe.mapper.SubscribeMapper;
import com.qidao.qidao.member.subscribe.service.ICustomSubscribeService;
import com.qidao.qidao.organization.organization.domain.Organization;
import com.qidao.qidao.organization.organization.domain.OrganizationExample;
import com.qidao.qidao.organization.organization.mapper.OrganizationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 关注Service业务层处理
 *
 * @author autuan
 * @date 2020-12-24
 */
@Slf4j
@Service
public class CustomSubscribeServiceImpl implements ICustomSubscribeService {

    @Resource
    private CustomSubscribeMapper customSubscribeMapper;

    @Resource
    private CustomMemberMapper customMemberMapper;

    @Resource
    private SubscribeMapper subscribeMapper;

    @Resource
    private OrganizationMapper organizationMapper;

    @Resource
    private MemberMapper memberMapper;

    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;

    /**
     * 清空指定会员的关注列表(逻辑删除)
     *
     * @param memberId 会员ID
     * @return 结果
     */
    @Override
    public int logicDelByMemberId(String memberId) {
        log.info("CustomSubscribeServiceImpl -> logicDelByMemberId -> String memberId : {}", memberId);
        int count = customSubscribeMapper.logicDelByMemberId(memberId);
        log.info("CustomSubscribeServiceImpl -> logicDelByMemberId -> Return int : {}", count);
        return count;
    }

    @Override
    public Page<SubscribeListRes> getSubscribe(SubscribeListReq req) {
        return customSubscribeMapper.getSubscribe(req);
    }

    @Override
    public int create(SubscribeAddReq req) {
        SubscribeExample example = new SubscribeExample();
        example.createCriteria().andMemberIdEqualTo(req.getMemberId()).andSubscribeIdEqualTo(req.getSubscribeId()).andSubscribeTypeEqualTo(req.getSubscribeType());
        Subscribe subscribe1 = subscribeMapper.selectOneByExample(example);
        if (subscribe1 != null){
            throw new BusinessException(SubscribeErrorEnum.SUBSCRIBE_ERROR_ENUM);
        }
        MemberDetails member = customMemberMapper.getDetails(req.getSubscribeId());
        return subscribeMapper.insertSelective(Subscribe.builder()
                .id(snowflakeIdWorker.nextId())
                .createBy(ShiroUtils.getUserId())
                .memberId(req.getMemberId())
                .type(req.getType())
                .subscribeEducation(member.getEducation())
                .subscribeId(req.getSubscribeId())
                .subscribeName(member.getName())
                .subscribeHeadImg(member.getHeadImg())
                .subscribePosition(member.getPosition())
                .subscribeEducation(member.getEducation())
                .subscribeType(req.getSubscribeType())
                .subscribeOrganizationName(member.getOrganization())
                .subscribeTime(LocalDateTime.now())
                .build());
    }

    @Override
    public int createOrganization(SubscribeAddReq req) {
        SubscribeExample example = new SubscribeExample();
        example.createCriteria()
                .andDelFlagEqualTo(ConstantEnum.NOT_DEL.getValue())
                .andMemberIdEqualTo(req.getMemberId())
                .andSubscribeTypeEqualTo(req.getSubscribeType())
                .andSubscribeIdEqualTo(req.getSubscribeId());
        Subscribe subscribe = subscribeMapper.selectOneByExample(example);
        if (subscribe != null){
            throw new BusinessException(SubscribeErrorEnum.SUBSCRIBE_ORGANIZATION);
        }
        OrganizationExample organizationExample = new OrganizationExample();
        organizationExample.createCriteria()
                .andDelFlagEqualTo(ConstantEnum.DELETED.getValue()).andIdEqualTo(req.getSubscribeId());
        Organization organization = organizationMapper.selectOneByExample(organizationExample);
        if (organization == null){
            throw new BusinessException(SubscribeErrorEnum.ORGANIZATION_DEL);
        }
        return subscribeMapper.insertSelective(Subscribe.builder()
                .id(snowflakeIdWorker.nextId())
                .subscribeType(req.getSubscribeType())
                .subscribeOrganizationName(organization.getName())
                .subscribeId(req.getSubscribeId())
                .build());
    }

    @Override
    public List<Member> getSubscribeMember(Long id) {
        MemberExample example = new MemberExample();
        example.createCriteria().andIdNotEqualTo(id);
        return memberMapper.selectByExample(example);
    }

    @Override
    public List<Member> findSubscribeMember(QuerySubscribeMemberReq req) {
        MemberExample example = new MemberExample();
        MemberExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(req.getName())){
            criteria.andNameLike("%"+req.getName()+"%");
        }
        criteria.andIdNotEqualTo(req.getId());
        return memberMapper.selectByExample(example);
    }

    @Override
    public SubscribeToEdit getSubscribeById(Long id) {
        return customSubscribeMapper.getSubscribeById(id);
    }

    @Override
    public int update(SubscribeUpdateReq req) {
        Subscribe subscribe = new Subscribe();
        BeanUtils.copyProperties(req , subscribe);
        subscribe.setCreateBy(ShiroUtils.getUserId());
        if (!req.getOldSubscribeId().equals(req.getSubscribeId())){
            SubscribeExample example = new SubscribeExample();
            example.createCriteria().andMemberIdEqualTo(req.getMemberId()).andSubscribeIdEqualTo(req.getSubscribeId());
            Subscribe subscribe1 = subscribeMapper.selectOneByExample(example);
            if (subscribe1 != null){
                throw new BusinessException(SubscribeErrorEnum.SUBSCRIBE_ERROR_ENUM);
            }

            MemberDetails member = customMemberMapper.getDetails(req.getSubscribeId());
            subscribe.setSubscribeId(member.getId());
            subscribe.setSubscribeName(member.getName());
            subscribe.setSubscribeTime(LocalDateTime.now());
            subscribe.setSubscribeHeadImg(member.getHeadImg());
            subscribe.setSubscribeOrganizationName(member.getOrganization());
            subscribe.setSubscribePosition(member.getPosition());

        }
        return subscribeMapper.updateByPrimaryKeySelective(subscribe);
    }

    @Override
    public List<Member> searchSubscribeMember(Long id, String code) {
        if (id == null || id == 0L){
            return customSubscribeMapper.findSubscribeMember(null , code);
        }
        SubscribeExample subscribeExample = new SubscribeExample();
        subscribeExample.createCriteria().andMemberIdEqualTo(id).andDelFlagEqualTo(ConstantEnum.NOT_DEL.getValue());
        List<Subscribe> subscribes = subscribeMapper.selectByExample(subscribeExample);
        List<Long> ids = subscribes.stream().map(Subscribe::getSubscribeId).collect(Collectors.toList());
        ids.add(id);
        return customSubscribeMapper.findSubscribeMember(ids , code);
    }

    @Override
    public List<Member> findMember(String code) {
        return customSubscribeMapper.findMember(code);
    }

    @Override
    public List<Organization> listOrganization(Long id ,String code) {
        Member member = memberMapper.selectByPrimaryKey(id);
        return customSubscribeMapper.listOrganization(member.getOrganizationId(), code);
    }
}
