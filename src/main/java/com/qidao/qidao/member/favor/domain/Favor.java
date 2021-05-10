package com.qidao.qidao.member.favor.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 收藏对象 favor
 * 
 * @author autuan
 * @date 2020-12-24
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Favor extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 动态ID */
    @Excel(name = "动态ID")
    private Long dynamicId;
    /** 动态发布时间 */
    @Excel(name = "动态发布时间")
    private LocalDateTime dynamicPushTime;
    /** 动态评论数 */
    @Excel(name = "动态评论数")
    private Integer dynamicCommentNum;
    /** 动态点赞数量 */
    @Excel(name = "动态点赞数量")
    private Integer dynamicLikeNum;
    /** 动态的标签集(存json)  例 {"id":1,"val":"标签"} */
    @Excel(name = "动态的标签集(存json)  例 {}")
    private String dynamicLabelStr;
    /** 动态的简介 */
    @Excel(name = "动态的简介")
    private String dynamicSummary;
    /** 动态的图片 */
    @Excel(name = "动态的图片")
    private String dynamicImg;
    /** 动态的标题 */
    @Excel(name = "动态的标题")
    private String dynamicTitle;
    /** 发布动态的用户ID */
    @Excel(name = "发布动态的用户ID")
    private Long dynamicPushMemberId;
    /** 用户ID */
    @Excel(name = "用户ID")
    private Long memberId;
    /** 主键 */
    private Long id;
}
