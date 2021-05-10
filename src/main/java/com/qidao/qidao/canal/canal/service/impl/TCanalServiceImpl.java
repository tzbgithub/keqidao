package com.qidao.qidao.canal.canal. service.impl;

import java.util.List;
                                                                                                        import com.qidao.common.utils.security.ShiroUtils;
                            import com.qidao.common.utils.security.ShiroUtils;
                    import java.time.LocalDateTime;
                            import java.time.LocalDateTime;
                                        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.canal.canal. mapper.TCanalMapper;
import com.qidao.qidao.canal.canal. domain.TCanal;
import com.qidao.qidao.canal.canal. service.ITCanalService;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;

import javax.annotation.Resource;


/**
 * 各包分发渠道Service业务层处理
 *
 * @author yqj
 * @date 2021-02-18
 */
@Service
public class TCanalServiceImpl implements ITCanalService {
    @Autowired
    private TCanalMapper tCanalMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;
    /**
     * 查询各包分发渠道
     *
     * @param id 各包分发渠道ID
     * @return 各包分发渠道
     */
    @Override
    public TCanal selectTCanalById(Long id) {
        return tCanalMapper.selectTCanalById(id);
    }

    /**
     * 查询各包分发渠道列表
     *
     * @param tCanal 各包分发渠道
     * @return 各包分发渠道
     */
    @Override
    public List<TCanal> selectTCanalList(TCanal tCanal) {
        return tCanalMapper.selectTCanalList(tCanal);
    }

    /**
     * 新增各包分发渠道
     *
     * @param tCanal 各包分发渠道
     * @return 结果
     */
    @Override
    public int insertTCanal(TCanal tCanal) {
                                                                                                                        tCanal.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
                                                                                        tCanal.setId(snowflakeIdWorker.nextId());
        return tCanalMapper.insertTCanal(tCanal);
    }

    /**
     * 修改各包分发渠道
     *
     * @param tCanal 各包分发渠道
     * @return 结果
     */
    @Override
    public int updateTCanal(TCanal tCanal) {
                    
                    
                    
                    
                            tCanal.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));
            
                    
                    
                    
                    
                return tCanalMapper.updateTCanal(tCanal);
    }

    /**
     * 删除各包分发渠道对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTCanalByIds(String ids) {
        return tCanalMapper.deleteTCanalByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除各包分发渠道信息
     *
     * @param id 各包分发渠道ID
     * @return 结果
     */
    @Override
    public int deleteTCanalById(Long id) {
        return tCanalMapper.deleteTCanalById(id);
    }
    


                                                            /**
             * 逻辑删除各包分发渠道对象
             *
             * @param ids 需要删除的数据ID
             * @return 结果
             */
            @Override
            public int logicDelByIds(String ids) {
                return tCanalMapper.logicDelByIds(Convert.toStrArray(ids));
            }
                                                                        
}
