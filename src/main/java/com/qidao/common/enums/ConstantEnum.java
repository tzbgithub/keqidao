package com.qidao.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ConstantEnum {
    /**
     * 逻辑删除未删除
     */
    NOT_DEL((byte)0),
    /**
     * 逻辑删除已删除
     */
    DELETED((byte)1),
    ;
    private final byte value;

}
