package com.qidao.qidao.dynamic.service.impl;

import java.util.List;
                                                                                                                                                                                                                                                                                                                                                                            import com.qidao.common.utils.security.ShiroUtils;

import com.qidao.qidao.dynamic.domain.TDynamic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.dynamic.mapper.TDynamicMapper;
import com.qidao.qidao.dynamic. service.IDynamicService;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;

import javax.annotation.Resource;


/**
 * 动态Service业务层处理
 *
 * @author yqj
 * @date 2021-01-25
 */
@Service
public class DynamicServiceImpl implements IDynamicService {
    @Autowired
    private TDynamicMapper TDynamicMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;
    /**
     * 查询动态
     *
     * @param id 动态ID
     * @return 动态
     */
    @Override
    public TDynamic selectDynamicById(Long id) {
        return TDynamicMapper.selectDynamicById(id);
    }

    /**
     * 查询动态列表
     *
     * @param TDynamic 动态
     * @return 动态
     */
    @Override
    public List<TDynamic> selectDynamicList(TDynamic TDynamic) {
        return TDynamicMapper.selectDynamicList(TDynamic);
    }

    /**
     * 新增动态
     *
     * @param TDynamic 动态
     * @return 结果
     */
    @Override
    public int insertDynamic(TDynamic TDynamic) {
                                                                                                                                                                                                                                                                                                                                                                                            TDynamic.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
                                                                                        TDynamic.setId(snowflakeIdWorker.nextId());
        return TDynamicMapper.insertDynamic(TDynamic);
    }

    /**
     * 修改动态
     *
     * @param TDynamic 动态
     * @return 结果
     */
    @Override
    public int updateDynamic(TDynamic TDynamic) {
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                            TDynamic.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));
            
                    
                    
                    
                    
                return TDynamicMapper.updateDynamic(TDynamic);
    }

    /**
     * 删除动态对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDynamicByIds(String ids) {
        return TDynamicMapper.deleteDynamicByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除动态信息
     *
     * @param id 动态ID
     * @return 结果
     */
    @Override
    public int deleteDynamicById(Long id) {
        return TDynamicMapper.deleteDynamicById(id);
    }
    


                                                                                                                                                                                                                        /**
             * 逻辑删除动态对象
             *
             * @param ids 需要删除的数据ID
             * @return 结果
             */
            @Override
            public int logicDelByIds(String ids) {
                return TDynamicMapper.logicDelByIds(Convert.toStrArray(ids));
            }
                                                                        
}
