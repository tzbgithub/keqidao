package com.qidao.qidao.salesman.sales.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.qidao.framework.aspectj.lang.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author: xinfeng
 * @create: 2021-02-01 13:04
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalesPerformanceRes {
    /** 推广人用户名 */
    @Excel(name = "推广人用户名")
    private String salesmanName;
    /** 推广人标识 */
    @ExcelIgnore
    private Long salesmanId;
    /** 负责组织发布成果数 */
    @Excel(name = "负责组织发布成果数")
    private Integer equipments;
    /** 推广业绩 */
    @Excel(name = "推广业绩")
    private Integer performance;
}
