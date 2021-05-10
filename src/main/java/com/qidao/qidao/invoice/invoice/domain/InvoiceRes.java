package com.qidao.qidao.invoice.invoice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRes {

    /** 开票状态 */
    private Integer status;
    /** 发送邮箱 */
    private String email;
    /** 税号 */
    private String dutyParagraph;
    /** 发票抬头 */
    private String invoiceHead;
    /** 发票类别 */
    private Integer type;
    /** 订单ID */
    private Long orderId;
    /** 开票人用户名 */
    private String memberName;
    /** 组织ID名 */
    private String organizationName;
    /** 主键 */
    private Long id;
}
