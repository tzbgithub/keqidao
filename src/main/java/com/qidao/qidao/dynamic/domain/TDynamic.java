package com.qidao.qidao.dynamic.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import java.util.Date;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 动态对象 dynamic
 * 
 * @author yqj
 * @date 2021-01-25
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TDynamic extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 是否热门0否；1是 */
    @Excel(name = "是否热门0否；1是")
    private Integer hot;
    /** 所需vip等级 */
    @Excel(name = "所需vip等级")
    private Integer needVip;
    /** 图片 */
    @Excel(name = "图片")
    private String img;
    /** 审核人员ID */
    @Excel(name = "审核人员ID")
    private Long verifyUserId;
    /** 审核原因 */
    @Excel(name = "审核原因")
    private String verifyReason;
    /** 审核状态:0-待审核 1-审核通过 2-审核拒绝 */
    @Excel(name = "审核状态:0-待审核 1-审核通过 2-审核拒绝")
    private Integer verifyStatus;
    /** 点赞数 */
    @Excel(name = "点赞数")
    private Integer likeNum;
    /** 缩略内容 */
    @Excel(name = "缩略内容")
    private String summary;
    /** 评论数 */
    @Excel(name = "评论数")
    private Long commentNum;
    /** 缩略图 */
    @Excel(name = "缩略图")
    private String thumb;
    /** 视频路径 */
    @Excel(name = "视频路径")
    private String video;
    /** 链接 */
    @Excel(name = "链接")
    private String url;
    /** 内容 */
    @Excel(name = "内容")
    private String content;
    /** 标题 */
    @Excel(name = "标题")
    private String title;
    /** 发布时间 */
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publishTime;
    /** 用户ID */
    @Excel(name = "用户ID")
    private Long memberId;
    /** 主键 */
    private Long id;

    /**
     * 技术成熟度
     */
    private Long maturity;

    /**
     * 合作类型
     */
    private Long cooperation;
}
