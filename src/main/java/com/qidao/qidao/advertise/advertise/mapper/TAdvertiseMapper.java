package com.qidao.qidao.advertise.advertise.mapper;

import com.qidao.qidao.advertise.advertise.domain.TAdvertise;
import java.util.List;

/**
 * 广告信息Mapper接口
 * 
 * @author autuan
 * @date 2021-02-23
 */
public interface TAdvertiseMapper {
    /**
     * 查询广告信息
     * 
     * @param id 广告信息ID
     * @return 广告信息
     */
    TAdvertise selectTAdvertiseById(Long id);

    /**
     * 查询广告信息列表
     * 
     * @param tAdvertise 广告信息
     * @return 广告信息集合
     */
    List<TAdvertise> selectTAdvertiseList(TAdvertise tAdvertise);

    /**
     * 新增广告信息
     * 
     * @param tAdvertise 广告信息
     * @return 结果
     */
    int insertTAdvertise(TAdvertise tAdvertise);

    /**
     * 修改广告信息
     * 
     * @param tAdvertise 广告信息
     * @return 结果
     */
    int updateTAdvertise(TAdvertise tAdvertise);

    /**
     * 删除广告信息
     * 
     * @param id 广告信息ID
     * @return 结果
     */
    int deleteTAdvertiseById(Long id);

    /**
     * 批量删除广告信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTAdvertiseByIds(String[] ids);

                        int logicDelByIds(String[] ids);
                                                                                                                                                                        }
