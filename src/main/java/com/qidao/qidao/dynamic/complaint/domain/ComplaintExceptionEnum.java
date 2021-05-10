package com.qidao.qidao.dynamic.complaint.domain;

import lombok.Getter;

/**
 * @Description:
 * @author: liu Le
 * @create: 2021-01-20 14:09
 */
@Getter
public enum  ComplaintExceptionEnum {

    COMPLAINT_MEMBER_NOT_EXIST("被投诉用户不存在"),
    COMPLAINT_BY_MEMBER_NOT_EXIST("投诉用户不存在"),
    COMPLAINT_REASON_NOT_EXIST("投诉原因不存在"),
    REPLY_MEMBER_NOT_EXIST("回复用户不存在"),
    ;
    private final String message;

    ComplaintExceptionEnum(String message){
        this.message = message;
    }
}
