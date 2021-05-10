package com.qidao.qidao.msg.logChatMsg.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogChatMsgPageReq {

    private Integer chatType;

    private Integer msgType;

    private String fromMemberName;

    private String toMemberName;

    private String startTime;

    private String endTime;

    private String chatMsg;

}
