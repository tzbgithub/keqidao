package com.qidao.qidao.msg.msg.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MsgListRes {

    /**
     * 主键
     */
    private Long id;

    /**
     * 内容
     */
    private String content;


    private String menu;

    private Long createById;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 发送时间
     */
    private String pushTime;

    /**
     * 接收类型 0-全平台发送 1-指定用户发送
     */
    private Integer receiveType;

    private Integer type;

    private Integer status;

    private Long menuId;

}
