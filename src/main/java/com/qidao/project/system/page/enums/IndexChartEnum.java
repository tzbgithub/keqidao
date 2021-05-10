package com.qidao.project.system.page.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IndexChartEnum {
    MEMBER("会员",0),
    ENTERPRISE("企业",1),
    LAB("实验室",2),
    DYNAMIC("动态",3),
    SERVER("需求",4),
    CONTRACT("合同",5),
    ;
    private String name;
    private Integer type;

}
