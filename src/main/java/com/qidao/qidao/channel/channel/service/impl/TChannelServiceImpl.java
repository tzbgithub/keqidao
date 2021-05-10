package com.qidao.qidao.channel.channel.service.impl;

import java.util.List;

import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.common.utils.security.ShiroUtils;

import java.time.LocalDateTime;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.channel.channel.mapper.TChannelMapper;
import com.qidao.qidao.channel.channel.domain.TChannel;
import com.qidao.qidao.channel.channel.service.ITChannelService;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;

import javax.annotation.Resource;


/**
 * 频道Service业务层处理
 *
 * @author yqj
 * @date 2021-02-03
 */
@Service
public class TChannelServiceImpl implements ITChannelService {
    @Autowired
    private TChannelMapper tChannelMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;

    /**
     * 查询频道
     *
     * @param id 频道ID
     * @return 频道
     */
    @Override
    public TChannel selectTChannelById(Long id) {
        return tChannelMapper.selectTChannelById(id);
    }

    /**
     * 查询频道列表
     *
     * @param tChannel 频道
     * @return 频道
     */
    @Override
    public List<TChannel> selectTChannelList(TChannel tChannel) {
        return tChannelMapper.selectTChannelList(tChannel);
    }

    /**
     * 新增频道
     *
     * @param tChannel 频道
     * @return 结果
     */
    @Override
    public int insertTChannel(TChannel tChannel) {
        tChannel.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
        tChannel.setId(snowflakeIdWorker.nextId());
        return tChannelMapper.insertTChannel(tChannel);
    }

    /**
     * 修改频道
     *
     * @param tChannel 频道
     * @return 结果
     */
    @Override
    public int updateTChannel(TChannel tChannel) {


        tChannel.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));


        return tChannelMapper.updateTChannel(tChannel);
    }

    /**
     * 删除频道对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTChannelByIds(String ids) {
        return tChannelMapper.deleteTChannelByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除频道信息
     *
     * @param id 频道ID
     * @return 结果
     */
    @Override
    public int deleteTChannelById(Long id) {
        return tChannelMapper.deleteTChannelById(id);
    }


    /**
     * 逻辑删除频道对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int logicDelByIds(String ids) {
        return tChannelMapper.logicDelByIds(Convert.toStrArray(ids));
    }

}
