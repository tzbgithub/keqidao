package com.qidao.qidao.msg.msgRecord.service;

import com.qidao.qidao.msg.msgRecord.domain.TMsgRecord;
import java.util.List;

/**
 * 用户-消息Service接口
 * 
 * @author yqj
 * @date 2021-02-22
 */
public interface ITMsgRecordService {
    /**
     * 查询用户-消息
     * 
     * @param id 用户-消息ID
     * @return 用户-消息
     */
    TMsgRecord selectTMsgRecordById(Long id);

    /**
     * 查询用户-消息列表
     * 
     * @param tMsgRecord 用户-消息
     * @return 用户-消息集合
     */
    List<TMsgRecord> selectTMsgRecordList(TMsgRecord tMsgRecord);

    /**
     * 新增用户-消息
     * 
     * @param tMsgRecord 用户-消息
     * @return 结果
     */
    int insertTMsgRecord(TMsgRecord tMsgRecord);

    /**
     * 修改用户-消息
     * 
     * @param tMsgRecord 用户-消息
     * @return 结果
     */
    int updateTMsgRecord(TMsgRecord tMsgRecord);

    /**
     * 批量删除用户-消息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTMsgRecordByIds(String ids);

    /**
     * 删除用户-消息信息
     * 
     * @param id 用户-消息ID
     * @return 结果
     */
    int deleteTMsgRecordById(Long id);

                                    int logicDelByIds(String ids);
                                                                                                            }
