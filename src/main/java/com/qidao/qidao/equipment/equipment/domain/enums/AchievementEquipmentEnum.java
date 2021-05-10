package com.qidao.qidao.equipment.equipment.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AchievementEquipmentEnum {

    /**
     * 审核通过
     */
    VERIFY_PASS(1),
    /**
     * 审核拒绝
     */
    VERIFY_FAIL(2),
    /**
     * 初始化
     */
    VERIFY_INIT(0)
    ;
    private final Integer code;

}
