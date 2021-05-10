package com.qidao.qidao.server.server. service.impl;

import java.util.List;
                                                                                                                                                                                                                                                                                                                                                                                                                    import com.qidao.common.utils.security.ShiroUtils;
                            import com.qidao.common.utils.security.ShiroUtils;
                    import java.time.LocalDateTime;
                            import java.time.LocalDateTime;
                                        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.server.server. mapper.TServerMapper;
import com.qidao.qidao.server.server. domain.TServer;
import com.qidao.qidao.server.server. service.ITServerService;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;

import javax.annotation.Resource;


/**
 * 服务(需求)Service业务层处理
 *
 * @author yqj
 * @date 2021-02-18
 */
@Service
public class TServerServiceImpl implements ITServerService {
    @Autowired
    private TServerMapper tServerMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;
    /**
     * 查询服务(需求)
     *
     * @param id 服务(需求)ID
     * @return 服务(需求)
     */
    @Override
    public TServer selectTServerById(Long id) {
        return tServerMapper.selectTServerById(id);
    }

    /**
     * 查询服务(需求)列表
     *
     * @param tServer 服务(需求)
     * @return 服务(需求)
     */
    @Override
    public List<TServer> selectTServerList(TServer tServer) {
        return tServerMapper.selectTServerList(tServer);
    }

    /**
     * 新增服务(需求)
     *
     * @param tServer 服务(需求)
     * @return 结果
     */
    @Override
    public int insertTServer(TServer tServer) {
                                                                                                                                                                                                                                                                                                                                                                                                                                    tServer.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
                                                                                        tServer.setId(snowflakeIdWorker.nextId());
        return tServerMapper.insertTServer(tServer);
    }

    /**
     * 修改服务(需求)
     *
     * @param tServer 服务(需求)
     * @return 结果
     */
    @Override
    public int updateTServer(TServer tServer) {
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                            tServer.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));
            
                    
                    
                    
                    
                return tServerMapper.updateTServer(tServer);
    }

    /**
     * 删除服务(需求)对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTServerByIds(String ids) {
        return tServerMapper.deleteTServerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除服务(需求)信息
     *
     * @param id 服务(需求)ID
     * @return 结果
     */
    @Override
    public int deleteTServerById(Long id) {
        return tServerMapper.deleteTServerById(id);
    }
    


                                                                                                                                                                                                                                                /**
             * 逻辑删除服务(需求)对象
             *
             * @param ids 需要删除的数据ID
             * @return 结果
             */
            @Override
            public int logicDelByIds(String ids) {
                return tServerMapper.logicDelByIds(Convert.toStrArray(ids));
            }
                                                                        
}
