package com.qidao.qidao.advertise.advertise.service.impl;

import java.util.List;

import com.qidao.common.utils.security.ShiroUtils;

import java.time.LocalDateTime;

import com.qidao.common.utils.security.ShiroUtils;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.advertise.advertise.mapper.TAdvertiseMapper;
import com.qidao.qidao.advertise.advertise.domain.TAdvertise;
import com.qidao.qidao.advertise.advertise.service.ITAdvertiseService;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;

import javax.annotation.Resource;


/**
 * 广告信息Service业务层处理
 *
 * @author autuan
 * @date 2021-02-23
 */
@Service
public class TAdvertiseServiceImpl implements ITAdvertiseService {
    @Autowired
    private TAdvertiseMapper tAdvertiseMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;

    /**
     * 查询广告信息
     *
     * @param id 广告信息ID
     * @return 广告信息
     */
    @Override
    public TAdvertise selectTAdvertiseById(Long id) {
        return tAdvertiseMapper.selectTAdvertiseById(id);
    }

    /**
     * 查询广告信息列表
     *
     * @param tAdvertise 广告信息
     * @return 广告信息
     */
    @Override
    public List<TAdvertise> selectTAdvertiseList(TAdvertise tAdvertise) {
        return tAdvertiseMapper.selectTAdvertiseList(tAdvertise);
    }

    /**
     * 新增广告信息
     *
     * @param tAdvertise 广告信息
     * @return 结果
     */
    @Override
    public int insertTAdvertise(TAdvertise tAdvertise) {
        tAdvertise.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
        tAdvertise.setId(snowflakeIdWorker.nextId());
        return tAdvertiseMapper.insertTAdvertise(tAdvertise);
    }

    /**
     * 修改广告信息
     *
     * @param tAdvertise 广告信息
     * @return 结果
     */
    @Override
    public int updateTAdvertise(TAdvertise tAdvertise) {

        tAdvertise.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));


        return tAdvertiseMapper.updateTAdvertise(tAdvertise);
    }

    /**
     * 删除广告信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTAdvertiseByIds(String ids) {
        return tAdvertiseMapper.deleteTAdvertiseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除广告信息信息
     *
     * @param id 广告信息ID
     * @return 结果
     */
    @Override
    public int deleteTAdvertiseById(Long id) {
        return tAdvertiseMapper.deleteTAdvertiseById(id);
    }


    /**
     * 逻辑删除广告信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int logicDelByIds(String ids) {
        return tAdvertiseMapper.logicDelByIds(Convert.toStrArray(ids));
    }

}
