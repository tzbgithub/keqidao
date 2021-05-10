package com.qidao.qidao.member.favor.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavorPageRes {

    /**
     * 动态ID
     */
    private Long dynamicId;

    /**
     * 动态发布时间
     */
    @JsonFormat(pattern= "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime dynamicPushTime;

    /**
     * 动态标题
     */
    private String dynamicTitle;

    /**
     * 动态发布者ID
     */
    private Long dynamicPushMemberId;

    /**
     * 动态发布者名字
     */
    private String dynamicPushMemberName;

    /**
     * 收藏动态者ID
     */
    private Long memberId;

    /**
     * 收藏动态者名字
     */
    private String memberName;

    /**
     * 主键ID
     */
    private Long id;

}
