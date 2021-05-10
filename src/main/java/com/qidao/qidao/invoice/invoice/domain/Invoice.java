package com.qidao.qidao.invoice.invoice.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 发票对象 invoice
 * 
 * @author liule
 * @date 2021-01-19
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 开票状态：0-申请中；1-已开票 */
    @Excel(name = "开票状态：0-申请中；1-已开票")
    private Long status;
    /** 发送邮箱 */
    @Excel(name = "发送邮箱")
    private String email;
    /** 税号 */
    @Excel(name = "税号")
    private String dutyParagraph;
    /** 发票抬头 */
    @Excel(name = "发票抬头")
    private String invoiceHead;
    /** 发票类别：0-企业发票；1-个人发票 */
    @Excel(name = "发票类别：0-企业发票；1-个人发票")
    private Long type;
    /** 订单ID */
    @Excel(name = "订单ID")
    private Long orderId;
    /** 开票人用户ID */
    @Excel(name = "开票人用户ID")
    private Long memberId;
    /** 组织ID */
    @Excel(name = "组织ID")
    private Long organizationId;
    /** 主键 */
    private Long id;
}
