package com.qidao.qidao.equipment.equipment.domain.enums;

import com.qidao.common.enums.BusinessErrorEnum;
import lombok.Getter;

@Getter
public enum AchievementEquipmentErrorEnum implements BusinessErrorEnum {

    /**视频、图片、链接、内容至少添加一个**/
    NOT_NULL("LxAPI-090001" , "视频、图片、链接、内容至少添加一个")
    ;

    private final String code;
    private final String msg;

    AchievementEquipmentErrorEnum(String code, String message) {
        this.code = code;
        this.msg = message;
    }

}
