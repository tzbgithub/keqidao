package com.qidao.qidao.order.order.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    /**
     * 主键
     */
    private Long id;

    /**
     * 会员ID
     */
    private Long memberId;

    /**
     * 用户名字
     */
    private String memberName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 订单流水号
     */
    private Long no;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 支付时间
     */
    private String payTime;

    /**
     * 订单金额
     */
    private BigDecimal orderPrice;

    /**
     * 订单状态 0-未支付；1-已支付；2-已关闭；3-已退款；4-申诉; 5-已完成
     */
    private Integer status;

    /**
     * 产品ID
     */
    private Long productSkuId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     *产品单价
     */
    private BigDecimal productSalePrice;

    /**
     * 创建者
     */
    private Long createBy;

    /**
     * 修改者
     */
    private Long updateBy;

    /**
     * 修改时间
     */
    private String updateTime;

    /**
     * 支付时间
     */
    private BigDecimal payPrice;

    /**
     * 购买数量
     */
    private Integer quantity;

    /**
     * 单位
     */
    private String belong;

    /**
     * vip生效时间
     */
    private String vipStartTime;

    /**
     * vip结束时间
     */
    private String vipEndTime;

    /**
     * 组织机构类型
     */
    private Integer organizationType;

}
