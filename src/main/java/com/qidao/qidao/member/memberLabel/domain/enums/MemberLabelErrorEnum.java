package com.qidao.qidao.member.memberLabel.domain.enums;

import com.qidao.common.enums.BusinessErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberLabelErrorEnum implements BusinessErrorEnum {

    LABEL_IS_NOT("LxAPI-011001" , "该标签不存在")
    ;
    private final String code;

    private final String msg;
}
