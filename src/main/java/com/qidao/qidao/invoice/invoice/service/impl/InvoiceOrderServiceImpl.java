package com.qidao.qidao.invoice.invoice.service.impl;

import com.qidao.qidao.invoice.invoice.service.InvoiceOrderService;
import com.qidao.qidao.order.order.domain.TOrder;
import com.qidao.qidao.order.order.mapper.CustomOrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class InvoiceOrderServiceImpl implements InvoiceOrderService {

    @Resource
    private CustomOrderMapper customOrderMapper;

    /**
     * 根据用户ID查询该用户未开发票的所有订单列表
     *
     * @param member_id:用户主键 keyword:关键词
     * @return 查询结果
     */
    @Override
    public List<TOrder> searchOrderByMemberId(String member_id, String keyword) {
        log.info("InvoiceOrderServiceImpl -> searchOrderByMemberId -> start -> member_id : {} , keyword : {}", member_id, keyword);
        log.info("InvoiceOrderServiceImpl -> searchOrderByMemberId -> end");
        return customOrderMapper.selectOrderByMemberId(member_id, keyword);
    }
}
