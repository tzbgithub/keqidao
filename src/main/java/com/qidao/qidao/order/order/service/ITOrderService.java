package com.qidao.qidao.order.order.service;

import com.qidao.qidao.order.order.domain.TOrder;

import java.util.List;

/**
 * 订单Service接口
 *
 * @author yqj
 * @date 2021-02-02
 */
public interface ITOrderService {
    /**
     * 查询订单
     *
     * @param id 订单ID
     * @return 订单
     */
    TOrder selectTOrderById(Long id);

    /**
     * 查询订单列表
     *
     * @param tOrder 订单
     * @return 订单集合
     */
    List<TOrder> selectTOrderList(TOrder tOrder);

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
     * 批量删除订单
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTOrderByIds(String ids);

    /**
     * 删除订单信息
     *
     * @param id 订单ID
     * @return 结果
     */
    int deleteTOrderById(Long id);

    int logicDelByIds(String ids);
}
