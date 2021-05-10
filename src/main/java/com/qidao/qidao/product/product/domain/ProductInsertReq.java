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
public class ProductInsertReq {

    /**
     * 产品名称
     */
    private String name;

    /**
     * 简介
     */
    private String summary;

    /**
     * 链接
     */
    private String url;

    /**
     * 图片
     */
    private String imgs;

    /**
     * 购买权限
     */
    private Integer permission;

    /**
     * 使用周期
     */
    private Integer serverVal;

    /**
     * 排序值
     */
    private Integer sequence;

    /**
     * 市场价
     */
    private BigDecimal marketPrice;

    /**
     * 销售价
     */
    private BigDecimal salePrice;

    private String extra;

    /*
    库存
    private Integer stock;
    */

}
