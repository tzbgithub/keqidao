package com.qidao.qidao.msg.logChatMsg. service.impl;

import java.util.ArrayList;
import java.util.List;
                                            import com.qidao.common.utils.security.ShiroUtils;
                            import com.qidao.common.utils.security.ShiroUtils;
                    import java.time.LocalDateTime;
                            import java.time.LocalDateTime;

import com.qidao.qidao.msg.logChatMsg.domain.LogChatMsgExcel;
import com.qidao.qidao.msg.logChatMsg.domain.LogChatMsgPageReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.msg.logChatMsg. mapper.TLogChatMsgMapper;
import com.qidao.qidao.msg.logChatMsg. domain.TLogChatMsg;
import com.qidao.qidao.msg.logChatMsg. service.ITLogChatMsgService;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;

import javax.annotation.Resource;


/**
 * 环信聊天记录Service业务层处理
 *
 * @author yqj
 * @date 2021-02-27
 */
@Service
public class TLogChatMsgServiceImpl implements ITLogChatMsgService {
    @Autowired
    private TLogChatMsgMapper tLogChatMsgMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;
    /**
     * 查询环信聊天记录
     *
     * @param id 环信聊天记录ID
     * @return 环信聊天记录
     */
    @Override
    public TLogChatMsg selectTLogChatMsgById(Long id) {
        return tLogChatMsgMapper.selectTLogChatMsgById(id);
    }

    /**
     * 查询环信聊天记录列表
     *
     * @param tLogChatMsg 环信聊天记录
     * @return 环信聊天记录
     */
    @Override
    public List<TLogChatMsg> selectTLogChatMsgList(LogChatMsgPageReq tLogChatMsg) {
        return tLogChatMsgMapper.selectTLogChatMsgList(tLogChatMsg);
    }

    @Override
    public List<LogChatMsgExcel> findAll() {
        List<LogChatMsgExcel> res  = new ArrayList<>();
        List<TLogChatMsg> tLogChatMsgs = tLogChatMsgMapper.selectTLogChatMsgList(LogChatMsgPageReq.builder().startTime("").endTime("").build());
        tLogChatMsgs.forEach(tLogChatMsg -> {
            LogChatMsgExcel logChatMsgExcel = new LogChatMsgExcel();
            BeanUtils.copyProperties(tLogChatMsg , logChatMsgExcel);
            switch (tLogChatMsg.getChatType()){
                case 0 :
                    logChatMsgExcel.setChatType("单聊");
                    break;
                case 1 :
                    logChatMsgExcel.setChatType("群聊");
                    break;
                case 2 :
                    logChatMsgExcel.setChatType("聊天室");
                    break;
            }
            switch (tLogChatMsg.getMsgType()){
                case 0 :
                    logChatMsgExcel.setMsgType("文本类型消息");
                    break;
                case 1 :
                    logChatMsgExcel.setMsgType("图片类型消息");
                    break;
                case 2 :
                    logChatMsgExcel.setMsgType("地址位置类型消息");
                    break;
                case 3 :
                    logChatMsgExcel.setMsgType("语音类型消息");
                    break;
                case 4 :
                    logChatMsgExcel.setMsgType("视频类型消息");
                    break;
                case 5 :
                    logChatMsgExcel.setMsgType("文件类型消息");
                    break;
                default:
                    logChatMsgExcel.setMsgType(tLogChatMsg.getMsgType().toString());
            }
            res.add(logChatMsgExcel);
        });
        return res;
    }

    /**
     * 新增环信聊天记录
     *
     * @param tLogChatMsg 环信聊天记录
     * @return 结果
     */
    @Override
    public int insertTLogChatMsg(TLogChatMsg tLogChatMsg) {
                                                            tLogChatMsg.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
                                                                                                                                                                                                                                                                            tLogChatMsg.setId(snowflakeIdWorker.nextId());
        return tLogChatMsgMapper.insertTLogChatMsg(tLogChatMsg);
    }

    /**
     * 修改环信聊天记录
     *
     * @param tLogChatMsg 环信聊天记录
     * @return 结果
     */
    @Override
    public int updateTLogChatMsg(TLogChatMsg tLogChatMsg) {
                    
                            tLogChatMsg.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));
            
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                return tLogChatMsgMapper.updateTLogChatMsg(tLogChatMsg);
    }

    /**
     * 删除环信聊天记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTLogChatMsgByIds(String ids) {
        return tLogChatMsgMapper.deleteTLogChatMsgByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除环信聊天记录信息
     *
     * @param id 环信聊天记录ID
     * @return 结果
     */
    @Override
    public int deleteTLogChatMsgById(Long id) {
        return tLogChatMsgMapper.deleteTLogChatMsgById(id);
    }
    


                        /**
             * 逻辑删除环信聊天记录对象
             *
             * @param ids 需要删除的数据ID
             * @return 结果
             */
            @Override
            public int logicDelByIds(String ids) {
                return tLogChatMsgMapper.logicDelByIds(Convert.toStrArray(ids));
            }
                                                                                                                                                                                    
}
