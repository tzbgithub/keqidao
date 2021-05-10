package com.qidao.qidao.salesman.sales.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: xinfeng
 * @create: 2021-02-01 13:12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkSalesmanQuery {
    /** 销售员ID */
    private Long salesmanId;
    /** 销售员用户名 */
    private String salesmanName;
    /** 开始时间 */
    private Date startTime;
    /** 结束时间 */
    private Date endTime;
}
