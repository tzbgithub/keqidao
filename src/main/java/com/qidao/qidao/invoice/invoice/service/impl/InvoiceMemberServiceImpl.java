package com.qidao.qidao.invoice.invoice.service.impl;

import com.qidao.qidao.invoice.invoice.service.InvoiceMemberService;
import com.qidao.qidao.member.member.domain.TMember;
import com.qidao.qidao.member.member.mapper.CustomMemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @author: liu Le
 * @create: 2021-01-21 16:59
 */
@Service("invoiceMember")
@Slf4j
public class InvoiceMemberServiceImpl implements InvoiceMemberService {

    @Resource
    private CustomMemberMapper customMemberMapper;

    /**
     * 通过关键字(用户名或者手机号)模糊查询用户
     *
     * @param keyword
     * @return
     */
    @Override
    public List<TMember> searchMemberByNameOrPhone(String keyword) {
        log.info("InvoiceMemberServiceImpl -> searchMemberByNameOrPhone -> start -> keyword : {}", keyword);
        log.info("InvoiceMemberServiceImpl -> searchMemberByNameOrPhone -> end");
        return customMemberMapper.searchMemberByNameOrPhone(keyword);
    }
}
