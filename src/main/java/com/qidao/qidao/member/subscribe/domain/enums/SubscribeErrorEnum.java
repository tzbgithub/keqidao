package com.qidao.qidao.member.subscribe.domain.enums;

import com.qidao.common.enums.BusinessErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SubscribeErrorEnum implements BusinessErrorEnum {

    SUBSCRIBE_ERROR_ENUM("" , "已经关注或屏蔽过此用户请先取消再操作"),
    SUBSCRIBE_ORGANIZATION("" , "已经关注或屏蔽过此组织请先取消再操作"),
    ORGANIZATION_DEL("" , "该组织已注销或不存在")
    ;
    private final String code;

    private final String msg;

}
