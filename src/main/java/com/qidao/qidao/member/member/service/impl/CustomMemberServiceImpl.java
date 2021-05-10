package com.qidao.qidao.member.member.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.qidao.common.enums.ConstantEnum;
import com.qidao.common.exception.BusinessException;
import com.qidao.common.utils.Md5Utils;
import com.qidao.common.utils.StringUtils;
import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.common.utils.text.Convert;
import com.qidao.qidao.link.organizationSalesman.domain.ILinkOrganizationSalesman;
import com.qidao.qidao.link.organizationSalesman.domain.ILinkOrganizationSalesmanExample;
import com.qidao.qidao.link.organizationSalesman.mapper.ILinkOrganizationSalesmanMapper;
import com.qidao.qidao.member.member.domain.*;
import com.qidao.qidao.member.member.domain.enums.MemberErrorEnum;
import com.qidao.qidao.member.member.mapper.CustomMemberMapper;
import com.qidao.qidao.member.member.mapper.MemberMapper;
import com.qidao.qidao.member.member.service.CustomMemberService;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service("customMemberService")
public class CustomMemberServiceImpl implements CustomMemberService {

    @Resource
    private CustomMemberMapper customMemberMapper;

    @Resource
    private MemberMapper memberMapper;

    @Autowired
    private RedissonClient redissonClient;

    @Resource
    private ILinkOrganizationSalesmanMapper ILinkOrganizationSalesmanMapper;

    private final DateTimeFormatter timeDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @Override
    public int countMember(MemberCountReq req) {
        return 0;
    }

    @Override
    public List<MemberListRes> getMember(MemberListReq req) {
        return customMemberMapper.getMember(req);
    }

    @Override
    public MemberDetails getDetails(Long id) {
        return customMemberMapper.getDetails(id);
    }

    @Override
    public int resetPassword(String id) {
        return customMemberMapper.resetPassword(MemberDo.builder()
                .ids(Convert.toStrArray(id))
                .updateBy(ShiroUtils.getUserId())
                .password(Md5Utils.encryptPassword("123456"))
                .build());
    }

    @Override
    public int disable(String ids) {
        return customMemberMapper.disable(MemberDo.builder()
                .ids(Convert.toStrArray(ids))
                .updateBy(ShiroUtils.getUserId())
                .build());
    }

    @Override
    public List<Member> getMemberByName(SubscribeMemberReq req) {

        MemberExample example = new MemberExample();
        MemberExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike("%"+req.getName()+"%").andDelFlagEqualTo((byte)0);
        if (req.getId() != null && req.getId() > 0){
            criteria.andIdNotEqualTo(req.getId());
        }
        return memberMapper.selectByExample(example);
    }

    @Override
    public int verifyPass(Long id , String msg) {
        Member member = memberMapper.selectByPrimaryKey(id);
        int res = memberMapper.updateByPrimaryKeySelective(Member.builder()
                .id(id)
                .updateBy(ShiroUtils.getUserId())
                .verifyStatus(2)
                .vipEndTime(member.getVipEndTime() == null ? LocalDateTime.now().plusYears(1L) : member.getVipEndTime().plusYears(1L))
                .vipStartTime(member.getVipEndTime() == null ? LocalDateTime.now() : null)
                .verifyUserId(ShiroUtils.getUserId())
                .level(1)
                .verifyReason(msg)
                .build());
        Member queryMember = memberMapper.selectByPrimaryKey(member.getId());
        if (queryMember == null){
            throw new BusinessException(MemberErrorEnum.USER_LOGBEHAVEMEMBER_ERROR);
        }
        RBucket<String> bucket = redissonClient.getBucket("member::login::id::" + member.getId());
        bucket.set(JSONUtil.toJsonStr(queryMember), 120L, TimeUnit.MINUTES);
        return res;
    }

    @Override
    public int verifyDeft(Long id , String msg) {
        return customMemberMapper.update(Member.builder()
                .id(id)
                .updateBy(ShiroUtils.getUserId())
                .verifyStatus(1)
                .verifyUserId(ShiroUtils.getUserId())
                .verifyReason(msg)
                .organizationId(null)
                .build());
    }
    @Override
    public List<Member> findMemberByName(FindMemberReq req) {

        return customMemberMapper.findMemberByName(req.getName(), req.getType());
    }

    @Override
    public int editMemberVip(MemberAddVipReq req) {
        switch (req.getType()){
            case 0:
                int addVip = memberMapper.updateByPrimaryKeySelective(Member.builder()
                        .id(req.getId())
                        .level(1)
                        .updateBy(ShiroUtils.getUserId())
                        .vipStartTime(LocalDateTime.parse(req.getVipStartTime(), timeDtf))
                        .vipEndTime(LocalDateTime.parse(req.getVipEndTime(), timeDtf))
                        .build());
                Member queryMember = memberMapper.selectByPrimaryKey(req.getId());
                if (queryMember == null){
                    throw new BusinessException(MemberErrorEnum.USER_LOGBEHAVEMEMBER_ERROR);
                }
                RBucket<String> bucket = redissonClient.getBucket("member::login::id::" + queryMember.getId());
                bucket.set(JSONUtil.toJsonStr(queryMember), 120L, TimeUnit.MINUTES);
                return addVip;
            case 1:
                int delVip = memberMapper.updateByPrimaryKeySelective(Member.builder()
                        .id(req.getId())
                        .level(0)
                        .updateBy(ShiroUtils.getUserId())
                        .vipEndTime(LocalDateTime.now())
                        .build());
                Member member = memberMapper.selectByPrimaryKey(req.getId());
                if (member == null){
                    throw new BusinessException(MemberErrorEnum.USER_LOGBEHAVEMEMBER_ERROR);
                }
                RBucket<String> memberBucket = redissonClient.getBucket("member::login::id::" + member.getId());
                memberBucket.set(JSONUtil.toJsonStr(member), 120L, TimeUnit.MINUTES);
                return delVip ;
        }
        return 0;
    }

    @Override
    public int getYesterdayData() {
        LocalDate yesterday = LocalDate.now().minusDays(1L);
        LocalDateTime startTime = LocalDateTime.of(yesterday, LocalTime.MIN);
        LocalDateTime endTime = LocalDateTime.of(yesterday, LocalTime.MAX);
        return customMemberMapper.getYesterdayData(startTime , endTime);
    }

    @Override
    public int getAllVip() {
        return customMemberMapper.getAllVip();
    }

    @Override
    public BigDecimal getOrderPrice() {
        return customMemberMapper.getOrderPrice();
    }

    @Override
    public List<Member> getSalesmanMember(Long salesmanId) {
        ILinkOrganizationSalesmanExample example = new ILinkOrganizationSalesmanExample();
        example.createCriteria().andAuthoorizedEqualTo(1)
        .andAuthorizedSalesmanEqualTo(salesmanId)
        .andDelFlagEqualTo(ConstantEnum.NOT_DEL.getValue());
        List<ILinkOrganizationSalesman> organizationSalesmen = ILinkOrganizationSalesmanMapper.selectByExample(example);
        List<Long> memberIds = organizationSalesmen.stream().map(ILinkOrganizationSalesman::getMemberId).collect(Collectors.toList());
        if (CollUtil.isEmpty(memberIds)){
            return new ArrayList<>();
        }
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andDelFlagEqualTo(ConstantEnum.NOT_DEL.getValue()).andIdIn(memberIds);
        return memberMapper.selectByExample(memberExample);
    }

}
