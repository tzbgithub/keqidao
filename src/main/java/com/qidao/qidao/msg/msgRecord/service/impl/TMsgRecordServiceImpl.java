package com.qidao.qidao.msg.msgRecord. service.impl;

import java.util.List;
                                                                                    import com.qidao.common.utils.security.ShiroUtils;
                            import com.qidao.common.utils.security.ShiroUtils;
                    import java.time.LocalDateTime;
                            import java.time.LocalDateTime;
                                                                                                    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.msg.msgRecord. mapper.TMsgRecordMapper;
import com.qidao.qidao.msg.msgRecord. domain.TMsgRecord;
import com.qidao.qidao.msg.msgRecord. service.ITMsgRecordService;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;

import javax.annotation.Resource;


/**
 * 用户-消息Service业务层处理
 *
 * @author yqj
 * @date 2021-02-22
 */
@Service
public class TMsgRecordServiceImpl implements ITMsgRecordService {
    @Autowired
    private TMsgRecordMapper tMsgRecordMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;
    /**
     * 查询用户-消息
     *
     * @param id 用户-消息ID
     * @return 用户-消息
     */
    @Override
    public TMsgRecord selectTMsgRecordById(Long id) {
        return tMsgRecordMapper.selectTMsgRecordById(id);
    }

    /**
     * 查询用户-消息列表
     *
     * @param tMsgRecord 用户-消息
     * @return 用户-消息
     */
    @Override
    public List<TMsgRecord> selectTMsgRecordList(TMsgRecord tMsgRecord) {
        return tMsgRecordMapper.selectTMsgRecordList(tMsgRecord);
    }

    /**
     * 新增用户-消息
     *
     * @param tMsgRecord 用户-消息
     * @return 结果
     */
    @Override
    public int insertTMsgRecord(TMsgRecord tMsgRecord) {
                                                                                                    tMsgRecord.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
                                                                                                                                                    tMsgRecord.setId(snowflakeIdWorker.nextId());
        return tMsgRecordMapper.insertTMsgRecord(tMsgRecord);
    }

    /**
     * 修改用户-消息
     *
     * @param tMsgRecord 用户-消息
     * @return 结果
     */
    @Override
    public int updateTMsgRecord(TMsgRecord tMsgRecord) {
                    
                    
                    
                            tMsgRecord.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));
            
                    
                    
                    
                    
                    
                    
                    
                return tMsgRecordMapper.updateTMsgRecord(tMsgRecord);
    }

    /**
     * 删除用户-消息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTMsgRecordByIds(String ids) {
        return tMsgRecordMapper.deleteTMsgRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户-消息信息
     *
     * @param id 用户-消息ID
     * @return 结果
     */
    @Override
    public int deleteTMsgRecordById(Long id) {
        return tMsgRecordMapper.deleteTMsgRecordById(id);
    }
    


                                                /**
             * 逻辑删除用户-消息对象
             *
             * @param ids 需要删除的数据ID
             * @return 结果
             */
            @Override
            public int logicDelByIds(String ids) {
                return tMsgRecordMapper.logicDelByIds(Convert.toStrArray(ids));
            }
                                                                                                            
}
