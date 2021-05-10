package com.qidao.qidao.dynamic.complaint.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComplaintRes {

    /** 会员等级 */
    private Integer level;
    /** 处理客服名 */
    private String replyUserName;
    /** 客服回复内容 */
    private String reply;
    /** 处理状态 */
    private Integer status;
    /** 投诉原因 */
    private String reason;
    /** 被投诉方的用户名 */
    private String complaintMemberName;
    /** 投诉者用户名 */
    private String memberName;
    /** 被投诉动态ID */
    private Long dynamicId;
    /** 主键 */
    private Long id;
}
