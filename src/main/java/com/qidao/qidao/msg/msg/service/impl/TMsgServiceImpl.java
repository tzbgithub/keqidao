package com.qidao.qidao.msg.msg. service.impl;

import java.util.List;
                                                                                                                            import com.qidao.common.utils.security.ShiroUtils;
                            import com.qidao.common.utils.security.ShiroUtils;
                    import java.time.LocalDateTime;
                            import java.time.LocalDateTime;
                                                                                                                                                                                                        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.msg.msg. mapper.TMsgMapper;
import com.qidao.qidao.msg.msg. domain.TMsg;
import com.qidao.qidao.msg.msg. service.ITMsgService;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;

import javax.annotation.Resource;


/**
 * 消息Service业务层处理
 *
 * @author yqj
 * @date 2021-02-19
 */
@Service
public class TMsgServiceImpl implements ITMsgService {
    @Autowired
    private TMsgMapper tMsgMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;
    /**
     * 查询消息
     *
     * @param id 消息ID
     * @return 消息
     */
    @Override
    public TMsg selectTMsgById(Long id) {
        return tMsgMapper.selectTMsgById(id);
    }

    /**
     * 查询消息列表
     *
     * @param tMsg 消息
     * @return 消息
     */
    @Override
    public List<TMsg> selectTMsgList(TMsg tMsg) {
        return tMsgMapper.selectTMsgList(tMsg);
    }

    /**
     * 新增消息
     *
     * @param tMsg 消息
     * @return 结果
     */
    @Override
    public int insertTMsg(TMsg tMsg) {
                                                                                                                                            tMsg.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
                                                                                                                                                                                                                                                        tMsg.setId(snowflakeIdWorker.nextId());
        return tMsgMapper.insertTMsg(tMsg);
    }

    /**
     * 修改消息
     *
     * @param tMsg 消息
     * @return 结果
     */
    @Override
    public int updateTMsg(TMsg tMsg) {
                    
                    
                    
                    
                    
                            tMsg.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));
            
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                return tMsgMapper.updateTMsg(tMsg);
    }

    /**
     * 删除消息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTMsgByIds(String ids) {
        return tMsgMapper.deleteTMsgByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除消息信息
     *
     * @param id 消息ID
     * @return 结果
     */
    @Override
    public int deleteTMsgById(Long id) {
        return tMsgMapper.deleteTMsgById(id);
    }
    


                                                                        /**
             * 逻辑删除消息对象
             *
             * @param ids 需要删除的数据ID
             * @return 结果
             */
            @Override
            public int logicDelByIds(String ids) {
                return tMsgMapper.logicDelByIds(Convert.toStrArray(ids));
            }
                                                                                                                                                                        
}
