package com.qidao.qidao.canal.canal.mapper;

import com.qidao.qidao.canal.canal.domain.TCanal;
import java.util.List;

/**
 * 各包分发渠道Mapper接口
 * 
 * @author yqj
 * @date 2021-02-18
 */
public interface TCanalMapper {
    /**
     * 查询各包分发渠道
     * 
     * @param id 各包分发渠道ID
     * @return 各包分发渠道
     */
    TCanal selectTCanalById(Long id);

    /**
     * 查询各包分发渠道列表
     * 
     * @param tCanal 各包分发渠道
     * @return 各包分发渠道集合
     */
    List<TCanal> selectTCanalList(TCanal tCanal);

    /**
     * 新增各包分发渠道
     * 
     * @param tCanal 各包分发渠道
     * @return 结果
     */
    int insertTCanal(TCanal tCanal);

    /**
     * 修改各包分发渠道
     * 
     * @param tCanal 各包分发渠道
     * @return 结果
     */
    int updateTCanal(TCanal tCanal);

    /**
     * 删除各包分发渠道
     * 
     * @param id 各包分发渠道ID
     * @return 结果
     */
    int deleteTCanalById(Long id);

    /**
     * 批量删除各包分发渠道
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTCanalByIds(String[] ids);

                                                            int logicDelByIds(String[] ids);
                                                                        }
