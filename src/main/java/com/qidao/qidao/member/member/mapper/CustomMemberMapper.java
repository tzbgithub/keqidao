package com.qidao.qidao.member.member.mapper;

import com.github.pagehelper.Page;
import com.qidao.project.monitor.server.domain.Mem;
import com.qidao.qidao.member.member.domain.*;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface CustomMemberMapper {

     Member findByPhone(String phone);

    /**
     * 通过关键字(用户名或者手机号)模糊查询用户
     *
     * @param keyword
     * @return
     */
    List<TMember> searchMemberByNameOrPhone(String keyword);

    Page<MemberListRes> getMember(MemberListReq req);

    MemberDetails getDetails(Long id);

    int resetPassword(MemberDo memberDo);

    int disable(MemberDo memberDo);

    int getYesterdayData(LocalDateTime startTime , LocalDateTime endTime);

    int getAllVip();

    BigDecimal getOrderPrice();

    int update(Member member);

    List<Member> findMemberByName(String code , Integer type);

}
