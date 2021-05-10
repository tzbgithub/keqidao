package com.qidao.qidao.dynamic.complaint.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 动态投诉对象 complaint
 * 
 * @author autuan
 * @date 2021-01-19
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Complaint extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 会员等级 */
    @Excel(name = "会员等级")
    private Long level;
    /** 处理客服名 */
    @Excel(name = "处理客服名")
    private String replyUserName;
    /** 处理客服ID */
    @Excel(name = "处理客服ID")
    private Long replyUserId;
    /** 客服回复内容 */
    @Excel(name = "客服回复内容")
    private String reply;
    /** 0-未处理 1-处理中 2-已处理 */
    @Excel(name = "0-未处理 1-处理中 2-已处理")
    private Long status;
    /** 投诉原因id 关联select_config */
    @Excel(name = "投诉原因id 关联select_config")
    private Long reasonId;
    /** 被投诉方的用户ID */
    @Excel(name = "被投诉方的用户ID")
    private Long complaintMemberId;
    /** 投诉者用户ID */
    @Excel(name = "投诉者用户ID")
    private Long memberId;
    /** 动态ID（被投诉） */
    @Excel(name = "动态ID", readConverterExp = "被=投诉")
    private Long dynamicId;
    /** 主键 */
    private Long id;
}
