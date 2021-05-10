package com.qidao.qidao.salesman.sales.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: xinfeng
 * @create: 2021-02-04 16:11
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalesExcel {
    /** 销售员名字 */
    @Excel(name = "销售员名字")
    private String salesmanName;
    /** 组织机构名称 */
    @Excel(name = "组织机构名称")
    private String organizationName;
    @Excel(name = "新增类型")
    /** 新增类型 */
    private String type;
}
