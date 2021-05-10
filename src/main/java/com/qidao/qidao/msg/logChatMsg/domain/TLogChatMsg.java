package com.qidao.qidao.msg.logChatMsg.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import io.swagger.models.auth.In;
import lombok.Builder;
import java.util.Date;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 环信聊天记录对象 log_chat_msg
 * 
 * @author yqj
 * @date 2021-02-27
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TLogChatMsg extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 消息内容 */
    @Excel(name = "消息内容")
    private String chatMsg;
    /** 消息发送时间 */
    @Excel(name = "消息发送时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String msgTime;
    /** 消息类型  0-文本类型消息 1-图片类型消息 2-地址位置类型消息 3-语音类型消息 4-视频类型消息 5-文件类型消息 */
    @Excel(name = "消息类型  0-文本类型消息 1-图片类型消息 2-地址位置类型消息 3-语音类型消息 4-视频类型消息 5-文件类型消息")
    private Integer msgType;
    /** 聊天类型 0-单聊、1-群聊、2-聊天室 */
    @Excel(name = "聊天类型 0-单聊、1-群聊、2-聊天室")
    private Integer chatType;
    /** （环信）接收人的username或者接收group的ID */
    @Excel(name = "", readConverterExp = "环=信")
    private String toEasemob;
    /** (环信）发送人username */
    @Excel(name = "(环信）发送人username")
    private String fromEasemobMember;
    /** 接收人ID */
    @Excel(name = "接收人ID")
    private Long toMemberId;
    /** 发送人id */
    @Excel(name = "发送人id")
    private Long fromMemberId;
    /** null */
    @Excel(name = "null")
    private Long easemobMsgId;
    /** 主键 */
    private Long id;
}
