package com.qidao.qidao.order.order.mapper;

import com.qidao.qidao.order.order.domain.TOrder;

import java.util.List;

/**
 * 订单Mapper接口
 *
 * @author yqj
 * @date 2021-02-02
 */
public interface TOrderMapper {
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
}
