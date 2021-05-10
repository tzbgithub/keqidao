package com.qidao.qidao.dynamic.domain.enums;

import com.qidao.common.enums.BusinessErrorEnum;
import lombok.Getter;

@Getter
public enum DynamicExceptionEnum implements BusinessErrorEnum {

    /**只有实验室可以发布动态**/
    ONLY_LABORATORY("LxAPI-010001" , "只有实验室可以发布动态"),
    /**视频和图片只能选择一项添加**/
    VIDEO_OR_IMG("LxAPI-010002" , "视频和图片只能选择一项添加"),
    /**带有视频或图片必须添加封面**/
    VIDEO_OR_IMG_THUMB("LxAPI-010003" , "带有视频或图片必须添加封面"),
    /**纯文字内容不需要添加封面**/
    CONTENT_NOT_THUMB("LxAPI-010004" , "纯文字内容不需要添加封面"),
    /**没有点过赞无法取消**/
    DYNAMIC_NOT_LIKE("LxAPI-010005" , "没有点过赞无法取消"),
    /**点过赞不可重复点赞**/
    DYNAMIC_AFTER_LIKE("LxAPI-010006" , "点过赞不可重复点赞"),
    /**图片、视频、链接、正文至少选择一个添加，不能全部为空**/
    DYNAMIC_NOT_NULL("LxAPI-010008" , "图片、视频、链接、正文至少选择一个添加，不能全部为空"),
    /**该动态已删除**/
    DELETE_TRUE("LxAPI-010007" , "该动态已删除")
    ;

    private final String code;
    private final String msg;

    DynamicExceptionEnum(String code, String message) {
        this.code = code;
        this.msg = message;
    }

}
