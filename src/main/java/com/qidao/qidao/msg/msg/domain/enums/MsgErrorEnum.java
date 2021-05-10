package com.qidao.qidao.msg.msg.domain.enums;

import com.qidao.common.enums.BusinessErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MsgErrorEnum implements BusinessErrorEnum {

    TITLE_TO_LONG("" , "标题过长请适当精简")
    ;
    private final String code;

    private final String msg;

}
