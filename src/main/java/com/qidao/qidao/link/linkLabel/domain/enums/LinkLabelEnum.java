package com.qidao.qidao.link.linkLabel.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LinkLabelEnum {

    /**
     * 标签类别：0-动态；1-服务；2-频道；3-用户；4-组织机构 5成果文章
     */
    TYPE_DYNAMIC(0),
    TYPE_SERVER(1),
    TYPE_CHANNEL(2),
    TYPE_MEMBER(3),
    TYPE_ORGANIZATION(4),
    TYPE_EQUIPMENT(5)
    ;
    private final Integer code;

}
