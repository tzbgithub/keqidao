package com.qidao.qidao.msg.msgRecord.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MsgRecordListRes {

    /**
     * 状态
     */
    private Integer status;

    /**
     * 用户名字
     */
    private String memberName;

    /**
     * 发送时间
     */
    private String sendTime;

    /**
     * ID
     */
    private Long id;

    /**
     * 接收者ID
     */
    private Long memberId;

    /**
     * 消息ID
     */
    private Long msgId;

    /**
     * 消息标题
     */
    private String msgTitle;

    /**
     * 重复发送次数
     */
    private Integer sendNum;


}
