package com.qidao.qidao.order.order.service.impl;

import java.util.List;

import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.common.utils.security.ShiroUtils;

import java.time.LocalDateTime;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.order.order.mapper.TOrderMapper;
import com.qidao.qidao.order.order.domain.TOrder;
import com.qidao.qidao.order.order.service.ITOrderService;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;

import javax.annotation.Resource;


/**
 * 订单Service业务层处理
 *
 * @author yqj
 * @date 2021-02-02
 */
@Service
public class TOrderServiceImpl implements ITOrderService {
    @Autowired
    private TOrderMapper tOrderMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;

    /**
     * 查询订单
     *
     * @param id 订单ID
     * @return 订单
     */
    @Override
    public TOrder selectTOrderById(Long id) {
        return tOrderMapper.selectTOrderById(id);
    }

    /**
     * 查询订单列表
     *
     * @param tOrder 订单
     * @return 订单
     */
    @Override
    public List<TOrder> selectTOrderList(TOrder tOrder) {
        return tOrderMapper.selectTOrderList(tOrder);
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
        return tOrderMapper.insertTOrder(tOrder);
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


        return tOrderMapper.updateTOrder(tOrder);
    }

    /**
     * 删除订单对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTOrderByIds(String ids) {
        return tOrderMapper.deleteTOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单信息
     *
     * @param id 订单ID
     * @return 结果
     */
    @Override
    public int deleteTOrderById(Long id) {
        return tOrderMapper.deleteTOrderById(id);
    }


    /**
     * 逻辑删除订单对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int logicDelByIds(String ids) {
        return tOrderMapper.logicDelByIds(Convert.toStrArray(ids));
    }

}
