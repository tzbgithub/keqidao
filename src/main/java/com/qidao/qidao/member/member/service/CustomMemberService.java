package com.qidao.qidao.member.member.service;

import com.qidao.qidao.member.member.domain.*;
import org.apache.logging.log4j.core.impl.MementoMessage;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface CustomMemberService {
    int countMember(MemberCountReq req);

    List<MemberListRes> getMember(MemberListReq req);

    MemberDetails getDetails(Long id);

    int resetPassword(String ids);

    int disable(String ids);

    List<Member> getMemberByName(SubscribeMemberReq req);

    int verifyPass(Long id , String msg);

    int verifyDeft(Long id , String msg);

    List<Member> findMemberByName(FindMemberReq req);

    int editMemberVip(MemberAddVipReq req);

    int getYesterdayData();

    int getAllVip();

    BigDecimal getOrderPrice();

    List<Member> getSalesmanMember(Long salesmanId);
}
