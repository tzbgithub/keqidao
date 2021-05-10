package com.qidao.qidao.config.select. service.impl;

import java.util.List;
                                            import com.qidao.common.utils.security.ShiroUtils;
                            import com.qidao.common.utils.security.ShiroUtils;
                    import java.time.LocalDateTime;
                            import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

import com.qidao.qidao.config.dict.domain.Dict;
import com.qidao.qidao.config.dict.domain.DictExample;
import com.qidao.qidao.config.dict.mapper.DictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.config.select. mapper.SelectConfigMapper;
import com.qidao.qidao.config.select. domain.SelectConfig;
import com.qidao.qidao.config.select. service.ISelectConfigService;
import com.qidao.common.utils.text.Convert;
import com.qidao.qidao.tools.snowflake.SnowflakeId;

import javax.annotation.Resource;


/**
 * 选择配置Service业务层处理
 *
 * @author autuan
 * @date 2020-12-16
 */
@Service
public class SelectConfigServiceImpl implements ISelectConfigService {
    @Autowired
    private SelectConfigMapper selectConfigMapper;
    @Resource
    private SnowflakeId snowflakeId;

    @Resource
    private DictMapper dictMapper;
    /**
     * 查询选择配置
     *
     * @param id 选择配置ID
     * @return 选择配置
     */
    @Override
    public SelectConfig selectSelectConfigById(String id) {
        return selectConfigMapper.selectSelectConfigById(id);
    }

    /**
     * 查询选择配置列表
     *
     * @param selectConfig 选择配置
     * @return 选择配置
     */
    @Override
    public List<SelectConfig> selectSelectConfigList(SelectConfig selectConfig) {
        List<SelectConfig> selectConfigs = selectConfigMapper.selectSelectConfigList(selectConfig);
        List<Dict> dicts = dictMapper.selectByExample(null);
        Map<Long, String> dict = dicts.stream().collect(Collectors.toMap(Dict::getId, Dict::getDictName, (oldV, newV) -> newV));
        selectConfigs.forEach(config -> {
            config.setTypeName(dict.get(config.getType()));
        });
        return selectConfigs;
    }

    /**
     * 新增选择配置
     *
     * @param selectConfig 选择配置
     * @return 结果
     */
    @Override
    public int insertSelectConfig(SelectConfig selectConfig) {
                                                            selectConfig.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
                                                                                                                                                                        selectConfig.setId(String.valueOf(snowflakeId.nextId()));
        return selectConfigMapper.insertSelectConfig(selectConfig);
    }

    /**
     * 修改选择配置
     *
     * @param selectConfig 选择配置
     * @return 结果
     */
    @Override
    public int updateSelectConfig(SelectConfig selectConfig) {
                    
                            selectConfig.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));
            
                    
                    
                    
                    
                    
                    
                    
                    
                return selectConfigMapper.updateSelectConfig(selectConfig);
    }

    /**
     * 删除选择配置对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSelectConfigByIds(String ids) {
        return selectConfigMapper.deleteSelectConfigByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除选择配置信息
     *
     * @param id 选择配置ID
     * @return 结果
     */
    @Override
    public int deleteSelectConfigById(String id) {
        return selectConfigMapper.deleteSelectConfigById(id);
    }
    


                        /**
             * 逻辑删除选择配置对象
             *
             * @param ids 需要删除的数据ID
             * @return 结果
             */
            @Override
            public int logicDelByIds(String ids) {
                return selectConfigMapper.logicDelByIds(Convert.toStrArray(ids));
            }
                                                                                                                        
}
