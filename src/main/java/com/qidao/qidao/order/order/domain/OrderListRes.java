package com.qidao.qidao.order.order.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderListRes {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户ID
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

}
