package com.qidao.qidao.salesman.sales.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: xinfeng
 * @create: 2021-02-01 13:50
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LinkOrganizationSalesmanRes {
    /** 组织机构名称 */
    private String organizationName;
    /** 关联类型 (0-无实验室新增 1-已有此实验室) */
    private Integer type;
    /** 销售员名字 */
    private String salesmanName;
    /** 销售员标识 */
    private Long salesmanId;
    /** 组织机构标识 */
    private Long organizationId;
    /** 推广时间 */
    private Date createTime;
    /** null */
    private Long id;
}
