package com.qidao.qidao.dynamic.complaint.domain;

import cn.hutool.db.DaoTemplate;
import com.qidao.framework.aspectj.lang.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author: xinfeng
 * @create: 2021-02-06 14:20
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintDynamic {
    /** 图片 */
    private String img;
    /** 审核状态:0-待审核 1-审核通过 2-审核拒绝 */
    private Integer verifyStatus;
    /** 点赞数 */
    private Integer likeNum;
    /** 缩略内容 */
    private String summary;
    /** 评论数 */
    private Long commentNum;
    /** 缩略图 */
    private String thumb;
    /** 视频路径 */
    private String video;
    /** 内容 */
    private String content;
    /** 标题 */
    private String title;
    /** 发布时间 */
    private LocalDateTime publishTime;
    /** 上架时间 */
    private LocalDateTime putTime;
    /** 用户名 */
    private String dynamicMemberName;
    /** 投诉原因 */
    private Integer reason;
    /** 投诉者用户名 */
    private String memberName;
    /** 投诉者ID */
    private Long memberId;
    /** 投诉时间 */
    private LocalDateTime complaintTime;
}
