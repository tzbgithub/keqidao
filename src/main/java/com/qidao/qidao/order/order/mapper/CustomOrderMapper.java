package com.qidao.qidao.order.order.mapper;

import com.qidao.qidao.order.order.domain.Order;
import com.qidao.qidao.order.order.domain.OrderDetails;
import com.qidao.qidao.order.order.domain.OrderListReq;
import com.qidao.qidao.order.order.domain.TOrder;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: liu Le
 * @create: 2021-01-23 13:27
 */
public interface CustomOrderMapper {

    /**
     * 根据用户ID查询该用户未开发票的订单
     *
     * @param member_id:用户ID主键 keyword-关键词
     * @return 查询结果
     */
    List<TOrder> selectOrderByMemberId(String member_id, String keyword);

    /**
     * 查询订单
     *
     * @param id 订单ID
     * @return 订单
     */
    OrderDetails selectTOrderById(Long id);

    /**
     * 查询订单列表
     *
     * @param req 订单
     * @return 订单集合
     */
    List<Order> selectTOrderList(OrderListReq req);

    /**
     * 新增订单
     *
     * @param tOrder 订单
     * @return 结果
     */
    int insertTOrder(TOrder tOrder);

    /**
     * 修改订单
     *
     * @param tOrder 订单
     * @return 结果
     */
    int updateTOrder(TOrder tOrder);

    /**
     * 删除订单
     *
     * @param id 订单ID
     * @return 结果
     */
    int deleteTOrderById(Long id);

    /**
     * 批量删除订单
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTOrderByIds(String[] ids);

    int logicDelByIds(String[] ids);

    int getYesterdayData(LocalDateTime startTime , LocalDateTime endTime);

    int getAllData();
}
