package com.qidao.qidao.invoice.invoice.service;

import com.qidao.qidao.member.member.domain.TMember;

import java.util.List;

/**
 * @Description:
 * @author: liu Le
 * @create: 2021-01-21 16:58
 */
public interface InvoiceMemberService {

    /**
     * 通过关键字(用户名或者手机号)模糊查询用户
     *
     * @param keyword
     * @return
     */
    List<TMember> searchMemberByNameOrPhone(String keyword);
}
