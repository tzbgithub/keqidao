package com.qidao.qidao.product.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    /**
     * 主键
     */
    private Long id;

    /**
     *创建时间
     */
    private String createTime;

    /**
     *修改时间
     */
    private String updateTime;

    /**
     *创建者
     */
    private Long createBy;

    /**
     *修改者
     */
    private Long updateBy;

    /**
     *产品名
     */
    private String name;

    /**
     *简介
     */
    private String summary;

    /**
     *图片
     */
    private String imgs;

    /**
     *销售价
     */
    private BigDecimal salePrice;

    /**
     *市场价
     */
    private BigDecimal marketPrice;

    /**
     *计费方式：0-时间；1-次数
     */
    private Integer type;

    /**
     *type=0 存放本产品的服务时间(单位：分)；type=1本产品的最大服务次数
     */
    private Integer serverVal;

    /**
     *购买权限 0-都可购买 1-只限实验室下属导师购买 2-只限企业机构购买
     */
    private Integer permission;

    /**
     *库存
     */
    private Integer stock;

    /**
     *状态 0-已上架 1-未上架
     */
    private Integer status;

}
