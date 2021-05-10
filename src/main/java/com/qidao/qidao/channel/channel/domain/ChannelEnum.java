package com.qidao.qidao.channel.channel.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChannelEnum {

    DEL_FLAG_TRUE((byte) 1),
    DEL_FLAG_FALSE((byte) 0)
    ;
    private final byte code;

}
