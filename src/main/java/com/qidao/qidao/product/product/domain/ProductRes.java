package com.qidao.qidao.product.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRes {
    /**
     * 主键
     */
    private Long id;

    /**
     * 创建者姓名
     */
    private String creatName;

    /**
     * 修改者姓名
     */
    private String updateName;

    /**
     *创建时间
     */
    private String createTime;

    /**
     * 销售价
     */
    private BigDecimal salePrice;

    /**
     *修改时间
     */
    private String updateTime;

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
     *购买权限 0-都可购买 1-只限实验室下属导师购买 2-只限企业机构购买
     */
    private Integer permission;

    /**
     *状态 0-已上架 1-未上架
     */
    private Integer status;
}
