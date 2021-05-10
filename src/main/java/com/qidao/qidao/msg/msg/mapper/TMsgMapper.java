package com.qidao.qidao.msg.msg.mapper;

import com.qidao.qidao.msg.msg.domain.TMsg;
import java.util.List;

/**
 * 消息Mapper接口
 * 
 * @author yqj
 * @date 2021-02-19
 */
public interface TMsgMapper {
    /**
     * 查询消息
     * 
     * @param id 消息ID
     * @return 消息
     */
    TMsg selectTMsgById(Long id);

    /**
     * 查询消息列表
     * 
     * @param tMsg 消息
     * @return 消息集合
     */
    List<TMsg> selectTMsgList(TMsg tMsg);

    /**
     * 新增消息
     * 
     * @param tMsg 消息
     * @return 结果
     */
    int insertTMsg(TMsg tMsg);

    /**
     * 修改消息
     * 
     * @param tMsg 消息
     * @return 结果
     */
    int updateTMsg(TMsg tMsg);

    /**
     * 删除消息
     * 
     * @param id 消息ID
     * @return 结果
     */
    int deleteTMsgById(Long id);

    /**
     * 批量删除消息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTMsgByIds(String[] ids);

                                                                        int logicDelByIds(String[] ids);
                                                                                                                                                                        }
