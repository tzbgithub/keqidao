package com.qidao.qidao.invoice.invoice.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.qidao.qidao.invoice.invoice.domain.Invoice;
import com.qidao.qidao.invoice.invoice.domain.InvoiceEnum;
import com.qidao.qidao.invoice.invoice.domain.InvoiceRes;
import com.qidao.qidao.invoice.invoice.mapper.InvoiceMapper;
import com.qidao.qidao.invoice.invoice.service.CustomInvoiceService;
import com.qidao.qidao.member.member.domain.TMember;
import com.qidao.qidao.member.member.mapper.TMemberMapper;
import com.qidao.qidao.organization.organization.domain.TOrganization;
import com.qidao.qidao.organization.organization.mapper.TOrganizationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CustomInvoiceServiceImpl implements CustomInvoiceService {

    @Resource
    private InvoiceMapper invoiceMapper;

    @Resource
    private TOrganizationMapper TOrganizationMapper;

    @Resource
    private TMemberMapper TMemberMapper;

    /**
     * 查询发票列表
     *
     * @param invoice
     * @return 查询结果
     */
    @Override
    public List<InvoiceRes> selectInvoiceList(Invoice invoice) {
        log.info("CustomInvoiceServiceImpl -> selectInvoiceList -> start -> invoice : {}", invoice);
        List<Invoice> list = invoiceMapper.selectInvoiceList(invoice);
        List<InvoiceRes> invoiceResList = new ArrayList<>();
        log.info("CustomInvoiceServiceImpl -> selectInvoiceList -> CollUtil.isNotEmpty(list) : {}", (CollUtil.isNotEmpty(list)));
        if(CollUtil.isNotEmpty(list)){
            for(Invoice invo : list){
                String memberName = null;
                String organizationName = null;
                log.info("CustomInvoiceServiceImpl -> selectInvoiceList -> ObjectUtil.isNotNull(invo.getOrganizationId()) : {}", (ObjectUtil.isNotNull(invo.getOrganizationId())));
                if(ObjectUtil.isNotNull(invo.getOrganizationId())){
                    TOrganization TOrganization = TOrganizationMapper.selectOrganizationById(invo.getOrganizationId().toString());
                    log.info("CustomInvoiceServiceImpl -> selectInvoiceList -> ObjectUtil.isNotEmpty(organization) && organization.getDelFlag().equals(\"0\") : {}", (ObjectUtil.isNotEmpty(TOrganization) && TOrganization.getDelFlag().equals("0")));
                    if(ObjectUtil.isNotEmpty(TOrganization) && TOrganization.getDelFlag().equals("0")){
                        organizationName = TOrganization.getName();
                    }
                }
                TMember TMember = TMemberMapper.selectMemberById(invo.getMemberId().toString());
                log.info("CustomInvoiceServiceImpl -> selectInvoiceList -> ObjectUtil.isNotEmpty(member) && member.getDelFlag().equals(\"0\") : {}", (ObjectUtil.isNotEmpty(TMember) && TMember.getDelFlag().equals("0")));
                if(ObjectUtil.isNotEmpty(TMember) && TMember.getDelFlag().equals("0")){
                    memberName = TMember.getName();
                }
                InvoiceRes invoiceRes = InvoiceRes.builder()
                        .status(invo.getStatus().intValue())
                        .type(invo.getType().intValue())
                        .dutyParagraph(invo.getDutyParagraph())
                        .orderId(invo.getOrderId())
                        .email(invo.getEmail())
                        .invoiceHead(invo.getInvoiceHead())
                        .id(invo.getId())
                        .memberName(memberName)
                        .organizationName(organizationName)
                        .build();
                invoiceResList.add(invoiceRes);
            }
        }
        log.info("CustomInvoiceServiceImpl -> selectInvoiceList -> end");
        return invoiceResList;
    }
}
