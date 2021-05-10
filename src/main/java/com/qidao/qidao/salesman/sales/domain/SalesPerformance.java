package com.qidao.qidao.salesman.sales.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * @author: xinfeng
 * @create: 2021-02-01 13:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalesPerformance {
    /** 销售员名字 */
    private String salesmanName;
    /** 销售员标识 */
    private Long salesmanId;
    /** 推广数量(业绩) */
    private Integer performance;
    /** 推广开始时间 */
    private String startTime;
    /** 推广持续天数 */
    private String salesTime;
}
