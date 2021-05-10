package com.qidao.qidao.invoice.invoice.service;

import com.qidao.qidao.order.order.domain.TOrder;

import java.util.List;

/**
 * @author: liu Le
 * @create: 2021-01-23 12:59
 */
public interface InvoiceOrderService {

    /**
     * 根据用户ID查询该用户未开发票的所有订单列表
     *
     * @param member_id:用户主键 keyword:关键词
     * @return 查询结果
     */
    List<TOrder> searchOrderByMemberId(String member_id, String keyword);
}
