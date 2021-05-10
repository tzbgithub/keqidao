package com.qidao.qidao.contract.contract.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author: xinfeng
 * @create: 2021-03-02 15:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContractRes {
    /** 合同名称 */
    private String serverTitle;
    /** 合同到期时间 */
    private String endTime;
    /** 签订时间 */
    private String signTime;
    /** 合同编号 */
    private String noNumber;
    /** 承接方 */
    private String memberNamePartB;
    /** 需求方 */
    private String memberNamePartyA;
    /** 主键 */
    private Long id;
}
