package com.qidao.qidao.order.order.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import java.util.Date;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 订单对象 order
 * 
 * @author yqj
 * @date 2021-02-02
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TOrder extends BaseEntity{
    private static final long serialVersionUID = 1L;

    @Excel(name = "支付方式")
    private Integer payWay;
    /** 产品购买数量 */
    @Excel(name = "产品购买数量")
    private Integer quantity;
    /** 订单金额 */
    @Excel(name = "订单金额")
    private Double orderPrice;
    /** 支付金额 */
    @Excel(name = "支付金额")
    private Double payPrice;
    /** 支付时间 */
    @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payTime;
    /** 会员名称 */
    @Excel(name = "会员名称")
    private String memberName;
    /** 订单状态：0-未支付；1-已支付；2-已关闭；3-已退款；4-申诉; 5-已完成 */
    @Excel(name = "订单状态：0-未支付；1-已支付；2-已关闭；3-已退款；4-申诉; 5-已完成")
    private Integer status;
    /** 用户ID */
    @Excel(name = "用户ID")
    private Long memberId;
    /** 产品ID */
    @Excel(name = "产品ID")
    private Long productSkuId;
    /** 订单流水号 */
    @Excel(name = "订单流水号")
    private Long no;
    /** 主键 */
    private Long id;
}
