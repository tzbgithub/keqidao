package com.qidao.qidao.channel.channel.service;

import com.qidao.qidao.channel.channel.domain.TChannel;
import java.util.List;

/**
 * 频道Service接口
 * 
 * @author yqj
 * @date 2021-02-03
 */
public interface ITChannelService {
    /**
     * 查询频道
     * 
     * @param id 频道ID
     * @return 频道
     */
    TChannel selectTChannelById(Long id);

    /**
     * 查询频道列表
     * 
     * @param tChannel 频道
     * @return 频道集合
     */
    List<TChannel> selectTChannelList(TChannel tChannel);

    /**
     * 新增频道
     * 
     * @param tChannel 频道
     * @return 结果
     */
    int insertTChannel(TChannel tChannel);

    /**
     * 修改频道
     * 
     * @param tChannel 频道
     * @return 结果
     */
    int updateTChannel(TChannel tChannel);

    /**
     * 批量删除频道
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTChannelByIds(String ids);

    /**
     * 删除频道信息
     * 
     * @param id 频道ID
     * @return 结果
     */
    int deleteTChannelById(Long id);

                                    int logicDelByIds(String ids);
                                                                        }
