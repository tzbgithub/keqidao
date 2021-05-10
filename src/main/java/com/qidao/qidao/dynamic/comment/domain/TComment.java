package com.qidao.qidao.dynamic.comment.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import java.util.Date;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 评论对象 comment
 * 
 * @author autuan
 * @date 2021-01-29
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TComment extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Integer likeNum;
    /** 评论时间 */
    @Excel(name = "评论时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date commentTime;
    /** 内容 */
    @Excel(name = "内容")
    private String content;
    /** 评论者头像 */
    @Excel(name = "评论者头像")
    private String memberHeadImg;
    /** 动态ID */
    @Excel(name = "动态ID")
    private Long dynamicId;
    /** 评论者名称 */
    @Excel(name = "评论者名称")
    private String memberName;
    /** 评论者用户ID */
    @Excel(name = "评论者用户ID")
    private Long memberId;
    /** 主键 */
    private Long id;
}
