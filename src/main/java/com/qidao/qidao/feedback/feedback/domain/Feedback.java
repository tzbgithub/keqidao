package com.qidao.qidao.feedback.feedback.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 反馈对象 feedback
 * 
 * @author autuan
 * @date 2021-01-28
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Feedback extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 处理客服名称 */
    @Excel(name = "处理客服名称")
    private String replyUserName;
    /** 处理客服ID */
    @Excel(name = "处理客服ID")
    private Long replyUserId;
    /** 会员等级 */
    @Excel(name = "会员等级")
    private Integer level;
    /** 提交会员 */
    @Excel(name = "提交会员")
    private Long memberId;
    /** 0-未处理 1-处理中 2-已处理 */
    @Excel(name = "0-未处理 1-处理中 2-已处理")
    private Integer status;
    /** 客服对反馈进行的回复 */
    @Excel(name = "客服对反馈进行的回复")
    private String reply;
    /** 描述 */
    @Excel(name = "描述")
    private String description;
    /** 反馈原因id 关联select_config */
    @Excel(name = "反馈原因id 关联select_config")
    private Long reasonId;
    /** 主键 */
    private Long id;
}
