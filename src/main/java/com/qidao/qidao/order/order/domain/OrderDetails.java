package com.qidao.qidao.order.order.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {

    /**
     * 主键
     */
    private Long id;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 会员名称
     */
    private String memberName;

    /**
     * 会员ID
     */
    private Long memberId;

    /**
     * 角色
     */
    private Integer organizationType;

    /**
     * 所属单位
     */
    private String belong;

    /**
     * 订单编号
     */
    private Long no;

    /**
     * 支付时间
     */
    private String payTime;

    /**
     * 订单金额
     */
    private BigDecimal orderPrice;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 支付金额
     */
    private BigDecimal payPrice;

    /**
     * 购买数量
     */
    private Integer quantity;

    /**
     * 支付方式
     */
    private Integer payWay;

    private String vipStartTime;

    private String vipEndTime;

}
