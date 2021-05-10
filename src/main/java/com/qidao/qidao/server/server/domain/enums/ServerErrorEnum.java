package com.qidao.qidao.server.server.domain.enums;

import com.qidao.common.enums.BusinessErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServerErrorEnum implements BusinessErrorEnum {

    NOT_ORGANIZATION("" , "发布人没有加入实验室/企业，发布失败"),
    NO_VIP("" , "您不是VIP会员不能发布需求，快去加入VIP吧~"),
    FROZEN("" , "您的帐号已被冻结，请先解除")
    ;
    private final String code;

    private final String msg;

}
