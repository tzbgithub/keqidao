package com.qidao.qidao.member.subscribe.mapper;

import com.github.pagehelper.Page;
import com.qidao.qidao.member.member.domain.Member;
import com.qidao.qidao.member.subscribe.domain.SubscribeListReq;
import com.qidao.qidao.member.subscribe.domain.SubscribeListRes;
import com.qidao.qidao.member.subscribe.domain.SubscribeToEdit;
import com.qidao.qidao.organization.organization.domain.Organization;
import org.apache.catalina.LifecycleState;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 关注Mapper接口
 *
 * @author autuan
 * @date 2020-12-24
 */
public interface CustomSubscribeMapper {
    /**
     * 清空指定会员的关注列表(逻辑删除)
     *
     * @param memberId 会员ID
     * @return 结果
     */
    int logicDelByMemberId(String memberId);

    Page<SubscribeListRes> getSubscribe(SubscribeListReq req);

    SubscribeToEdit getSubscribeById(Long id);

    List<Member> findSubscribeMember(List<Long> ids , String code);

    List<Member> findMember(@Param("code") String code);

    List<Organization> listOrganization(Long id , String code);
}
