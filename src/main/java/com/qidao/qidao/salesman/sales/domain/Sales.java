package com.qidao.qidao.salesman.sales.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: xinfeng
 * @create: 2021-02-04 16:32
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sales {
    /** 销售员名字 */
    private String salesmanName;
    /** 组织机构名称 */
    private String organizationName;
    /** 新增类型 */
    private Integer type;
}
