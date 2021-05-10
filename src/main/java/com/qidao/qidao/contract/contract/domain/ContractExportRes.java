package com.qidao.qidao.contract.contract.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.qidao.framework.aspectj.lang.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: xinfeng
 * @create: 2021-03-02 16:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContractExportRes {
    /** 合同名称 */
    @Excel(name = "合同名称")
    private String serverTitle;
    /** 合同到期时间 */
    @Excel(name = "合同到期时间")
    private String endTime;
    /** 签订时间 */
    @Excel(name = "签订时间")
    private String signTime;
    /** 合同编号 */
    @Excel(name = "合同编号")
    private String noNumber;
    /** 承接方 */
    @Excel(name = "承接方")
    private String memberNamePartB;
    /** 需求方 */
    @Excel(name = "需求方")
    private String memberNamePartyA;
    /** 主键 */
    @ExcelIgnore
    private Long id;
}
