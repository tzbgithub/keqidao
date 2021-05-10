package com.qidao.qidao.feedback.feedback.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: xinfeng
 * @create: 2021-01-28 10:01
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackRes {
    /** 处理客服名称 */
    private String replyUserName;
    /** 会员等级 */
    private Integer level;
    /** 提交会员名 */
    private String memberName;
    /** 处理状态：0-未处理 1-处理中 2-已处理 */
    private Integer status;
    /** 客服对反馈进行的回复 */
    private String reply;
    /** 反馈描述 */
    private String description;
    /** 反馈原因*/
    private Integer reasonId;
    /** 主键 */
    private Long id;
}
