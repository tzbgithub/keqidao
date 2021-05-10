package com.qidao.qidao.salesman.salesman.domain;

import lombok.Getter;

/**
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2020/12/30 4:03 PM
 */
@Getter
public enum SalesmanEnum {
    /**
     * 初始密码 123456
     */
    INITIAL_PASSWORD("123456");

    private final String value;

    SalesmanEnum(String value) {
        this.value = value;
    }
}
