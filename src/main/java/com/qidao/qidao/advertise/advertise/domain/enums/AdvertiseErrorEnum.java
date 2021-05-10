package com.qidao.qidao.advertise.advertise.domain.enums;

import com.qidao.common.enums.BusinessErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AdvertiseErrorEnum implements BusinessErrorEnum {

    EXISTS("" , "该广告已在该渠道发布请勿重复"),
    LOCATION_EXISTS("" , "该广告在该位置已存在请勿重复")
    ;
    private final String code;
    private final String msg;

}
