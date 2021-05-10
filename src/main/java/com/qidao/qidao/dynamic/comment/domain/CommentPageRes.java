package com.qidao.qidao.dynamic.comment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentPageRes {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 评论用户
     */
    private String memberName;

    /**
     * 用户ID
     */
    private Long memberId;

    /**
     * 用户手机号
     */
    private Long phone;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    private String commentTime;

    private Integer verifyStatus;

}
