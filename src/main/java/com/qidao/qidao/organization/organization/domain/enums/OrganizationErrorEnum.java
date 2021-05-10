package com.qidao.qidao.organization.organization.domain.enums;

import com.qidao.common.enums.BusinessErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrganizationErrorEnum implements BusinessErrorEnum {


    ILLEGAL_CHARACTER("" , "科研方向存在非法字符"),
    MEMBER_FROZEN("" , "用户已被冻结"),
    LABELS_TOO_LONG("" , "科研方向太多，请精简为五个或以下"),
    JOINED_ORGANIZATION("" , "已加入组织"),
    ALREADY_EXISTS("" , "组织已存在")
    ;
    private final String code;

    private final String msg;

}
