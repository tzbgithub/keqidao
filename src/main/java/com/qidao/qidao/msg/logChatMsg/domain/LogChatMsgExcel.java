package com.qidao.qidao.msg.logChatMsg.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogChatMsgExcel {

    @Excel(name = "主键ID")
    private Long id;

    @Excel(name = "发送者")
    private String fromEasemobMember;

    @Excel(name = "接收者/聊天室ID")
    private String toEasemob;

    @Excel(name = "内容")
    private String chatMsg;

    @Excel(name = "发送时间")
    private String msgTime;

    @Excel(name = "聊天类型")
    private String chatType;

    @Excel(name = "消息类型")
    private String msgType;


}
