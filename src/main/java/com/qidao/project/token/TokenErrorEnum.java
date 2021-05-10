package com.qidao.project.token;

import com.qidao.common.enums.BusinessErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TokenErrorEnum implements BusinessErrorEnum {
    /**
     * JWT 错误常量
     */

    FAIL("100000","请先登录"),
    ;
    String code;
    String msg;
}
