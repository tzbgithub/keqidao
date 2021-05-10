package com.qidao.qidao.product.product.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductEnum {

    /**计费方式 0-时间**/
    TYPE_TIME(0),

    /**已删除**/
    DEL_FLAG_TRUE(1),

    /**未删除**/
    DEL_FLAG_FALSE(0)
    ;

    private final Integer code;

}
