package com.qidao.qidao.dynamic.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomDynamic {

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 创建者
     */
    private Long createBy;

    /**
     * 修改者
     */
    private Long updateBy;

    /**
     * 逻辑删除 0-否 1-是
     */
    private Integer delFlag;

    /**
     * 作者ID
     */
    private Long memberId;

    /**
     * 发布人
     */
    private String memberName;

    /**
     * 发布时间
     */
    private String publishTime;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 链接路径
     */
    private String url;

    /**
     * 视频路径
     */
    private String video;

    /**
     * 缩略图
     */
    private String thumb;

    /**
     * 评论数
     */
    private Integer commentNum;

    /**
     * 点赞数
     */
    private Integer likeNum;

    /**
     * 缩略内容
     */
    private String summary;

    /**
     * 审核状态 0-待审核
     *        1-审核通过，未核准
     *        2-审核拒绝
     *        3-核准通过
     *        4-核准拒绝
     */
    private Integer verifyStatus;

    /**
     * 审核原因
     */
    private String verifyReason;

    /**
     * 审核人员ID
     */
    private Long verifyUserId;

    /**
     * 图片
     */
    private String img;

    /**
     * 所需vip等级
     */
    private Integer needVip;

    /**
     * 是否热门 0-否 1-是
     */
    private Integer hot;

    /**
     * 核准人ID
     */
    private Long recheckId;

    /**
     * 频道
     */
    private String channel;

}
