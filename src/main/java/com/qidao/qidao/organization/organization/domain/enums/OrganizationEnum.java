package com.qidao.qidao.organization.organization.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrganizationEnum {

    DEL_TRUE((byte) 1),
    DEL_FALSE((byte) 0),
    ;

    private final byte value;

}
