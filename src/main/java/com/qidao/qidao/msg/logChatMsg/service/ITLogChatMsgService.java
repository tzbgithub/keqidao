package com.qidao.qidao.msg.logChatMsg.service;

import com.qidao.qidao.msg.logChatMsg.domain.LogChatMsgExcel;
import com.qidao.qidao.msg.logChatMsg.domain.LogChatMsgPageReq;
import com.qidao.qidao.msg.logChatMsg.domain.TLogChatMsg;
import java.util.List;

/**
 * 环信聊天记录Service接口
 * 
 * @author yqj
 * @date 2021-02-27
 */
public interface ITLogChatMsgService {
    /**
     * 查询环信聊天记录
     * 
     * @param id 环信聊天记录ID
     * @return 环信聊天记录
     */
    TLogChatMsg selectTLogChatMsgById(Long id);

    /**
     * 查询环信聊天记录列表
     * 
     * @param tLogChatMsg 环信聊天记录
     * @return 环信聊天记录集合
     */
    List<TLogChatMsg> selectTLogChatMsgList(LogChatMsgPageReq tLogChatMsg);

    List<LogChatMsgExcel> findAll();

    /**
     * 新增环信聊天记录
     * 
     * @param tLogChatMsg 环信聊天记录
     * @return 结果
     */
    int insertTLogChatMsg(TLogChatMsg tLogChatMsg);

    /**
     * 修改环信聊天记录
     * 
     * @param tLogChatMsg 环信聊天记录
     * @return 结果
     */
    int updateTLogChatMsg(TLogChatMsg tLogChatMsg);

    /**
     * 批量删除环信聊天记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTLogChatMsgByIds(String ids);

    /**
     * 删除环信聊天记录信息
     * 
     * @param id 环信聊天记录ID
     * @return 结果
     */
    int deleteTLogChatMsgById(Long id);

            int logicDelByIds(String ids);
                                                                                                                                                                                    }
