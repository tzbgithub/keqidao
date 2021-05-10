package com.qidao.qidao.member.member.domain.enums;

import com.qidao.common.enums.BusinessErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberErrorEnum implements BusinessErrorEnum {
    USER_LOGBEHAVEMEMBER_ERROR("LxAPI-011003", "用户不存在"),

    ;
    private final String code;

    private final String msg;

}
