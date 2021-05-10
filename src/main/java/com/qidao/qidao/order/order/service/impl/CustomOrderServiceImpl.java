package com.qidao.qidao.order.order.service.impl;

import com.github.pagehelper.Page;
import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;
import com.qidao.qidao.order.order.domain.*;
import com.qidao.qidao.order.order.mapper.CustomOrderMapper;
import com.qidao.qidao.order.order.mapper.TOrderMapper;
import com.qidao.qidao.order.order.service.CustomOrderService;
import com.qidao.qidao.order.order.service.ITOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


/**
 * 订单Service业务层处理
 *
 * @author yqj
 * @date 2021-02-02
 */
@Service
public class CustomOrderServiceImpl implements CustomOrderService {
    @Autowired
    private CustomOrderMapper customOrderMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;

    /**
     * 查询订单
     *
     * @param id 订单ID
     * @return 订单
     */
    @Override
    public OrderDetails selectTOrderById(Long id) {
        return customOrderMapper.selectTOrderById(id);
    }

    /**
     * 查询订单列表
     *
     * @param req 订单
     * @return 订单
     */
    @Override
    public List<OrderListRes> selectTOrderList(OrderListReq req) {
        List<Order> orders = customOrderMapper.selectTOrderList(req);
        Page<OrderListRes> res = new Page<>();
        orders.forEach(order -> {
            OrderListRes orderListRes = new OrderListRes();
            BeanUtils.copyProperties(order , orderListRes);
            res.add(orderListRes);
        });
        if (orders instanceof Page){
            res.setTotal(((Page<Order>)orders).getTotal());
        }
        return res;
    }

    /**
     * 新增订单
     *
     * @param tOrder 订单
     * @return 结果
     */
    @Override
    public int insertTOrder(TOrder tOrder) {
        tOrder.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
        tOrder.setId(snowflakeIdWorker.nextId());
        return customOrderMapper.insertTOrder(tOrder);
    }

    /**
     * 修改订单
     *
     * @param tOrder 订单
     * @return 结果
     */
    @Override
    public int updateTOrder(TOrder tOrder) {
        tOrder.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));
        return customOrderMapper.updateTOrder(tOrder);
    }

    /**
     * 删除订单对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTOrderByIds(String ids) {
        return customOrderMapper.deleteTOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单信息
     *
     * @param id 订单ID
     * @return 结果
     */
    @Override
    public int deleteTOrderById(Long id) {
        return customOrderMapper.deleteTOrderById(id);
    }


    /**
     * 逻辑删除订单对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int logicDelByIds(String ids) {
        return customOrderMapper.logicDelByIds(Convert.toStrArray(ids));
    }

    @Override
    public int getYesterdayData() {
        LocalDate yesterday = LocalDate.now().minusDays(1L);
        LocalDateTime startTime = LocalDateTime.of(yesterday, LocalTime.MIN);
        LocalDateTime endTime = LocalDateTime.of(yesterday, LocalTime.MAX);
        return customOrderMapper.getYesterdayData(startTime , endTime);
    }

    @Override
    public int getAllData() {
        return customOrderMapper.getAllData();
    }

}
