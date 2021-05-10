package com.qidao.qidao.link.publishContent.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PublishContentEnum {

    /**
     * 代发布动态
     */
    TYPE_DYNAMIC(0),
    /**
     * 代发布设备/成果
     */
    TYPE_EQUIPMENT(1),
    /**
     * 发布人 运营人员
     */
    PUBLISH_TYPE_SALESMAN(0),
    /**
     * 发布人 助手
     */
    PUBLISH_TYPE_ASSISTANT(1),
    ;
    private final Integer code;

}
