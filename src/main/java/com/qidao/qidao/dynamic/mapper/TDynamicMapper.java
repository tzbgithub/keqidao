package com.qidao.qidao.dynamic.mapper;

import com.qidao.qidao.dynamic.domain.TDynamic;

import java.util.List;

/**
 * 动态Mapper接口
 * 
 * @author yqj
 * @date 2021-01-25
 */
public interface TDynamicMapper {
    /**
     * 查询动态
     * 
     * @param id 动态ID
     * @return 动态
     */
    TDynamic selectDynamicById(Long id);

    /**
     * 查询动态列表
     * 
     * @param TDynamic 动态
     * @return 动态集合
     */
    List<TDynamic> selectDynamicList(TDynamic TDynamic);

    /**
     * 新增动态
     * 
     * @param TDynamic 动态
     * @return 结果
     */
    int insertDynamic(TDynamic TDynamic);

    /**
     * 修改动态
     * 
     * @param TDynamic 动态
     * @return 结果
     */
    int updateDynamic(TDynamic TDynamic);

    /**
     * 删除动态
     * 
     * @param id 动态ID
     * @return 结果
     */
    int deleteDynamicById(Long id);

    /**
     * 批量删除动态
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteDynamicByIds(String[] ids);

                                                                                                                                                                                                                        int logicDelByIds(String[] ids);
                                                                        }
