package com.qidao.qidao.member.subscribe.service;

import com.github.pagehelper.Page;
import com.qidao.qidao.member.member.domain.Member;
import com.qidao.qidao.member.subscribe.domain.*;
import com.qidao.qidao.organization.organization.domain.Organization;

import java.util.List;

/**
 * 关注Service接口
 *
 * @author autuan
 * @date 2020-12-24
 */
public interface ICustomSubscribeService {
    /**
     * 清空指定会员的关注列表(逻辑删除)
     *
     * @param memberId 会员ID
     * @return 关注
     */
    int logicDelByMemberId(String memberId);

    Page<SubscribeListRes> getSubscribe(SubscribeListReq req);

    int create(SubscribeAddReq req);

    int createOrganization(SubscribeAddReq req);

    List<Member> getSubscribeMember(Long id);

    List<Member> findSubscribeMember(QuerySubscribeMemberReq req);

    SubscribeToEdit getSubscribeById(Long id);

    int update(SubscribeUpdateReq req);

    List<Member> searchSubscribeMember(Long id , String code);

    List<Member> findMember(String code);

    List<Organization> listOrganization(Long id , String code);
}
