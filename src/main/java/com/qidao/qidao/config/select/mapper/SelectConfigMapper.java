package com.qidao.qidao.config.select.mapper;

import com.qidao.qidao.config.select.domain.SelectConfig;
import java.util.List;

/**
 * 选择配置Mapper接口
 * 
 * @author autuan
 * @date 2020-12-16
 */
public interface SelectConfigMapper {
    /**
     * 查询选择配置
     * 
     * @param id 选择配置ID
     * @return 选择配置
     */
    SelectConfig selectSelectConfigById(String id);

    /**
     * 查询选择配置列表
     * 
     * @param selectConfig 选择配置
     * @return 选择配置集合
     */
    List<SelectConfig> selectSelectConfigList(SelectConfig selectConfig);

    /**
     * 新增选择配置
     * 
     * @param selectConfig 选择配置
     * @return 结果
     */
    int insertSelectConfig(SelectConfig selectConfig);

    /**
     * 修改选择配置
     * 
     * @param selectConfig 选择配置
     * @return 结果
     */
    int updateSelectConfig(SelectConfig selectConfig);

    /**
     * 删除选择配置
     * 
     * @param id 选择配置ID
     * @return 结果
     */
    int deleteSelectConfigById(String id);

    /**
     * 批量删除选择配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteSelectConfigByIds(String[] ids);

                        int logicDelByIds(String[] ids);
                                                                                                                        }
