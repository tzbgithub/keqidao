package com.qidao.qidao.member.subscribe.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscribeListRes {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long memberId;

    /**
     * 用户ID
     */
    private String  memberName;

    /**
     * 被关注/屏蔽者ID
     */
    private Long subscribeId;

    /**
     * 关注/屏蔽时间
     */
    private LocalDateTime subscribeTime;

    /**
     * 类型0-关注 1-屏蔽
     */
    private Integer type;

    /**
     * 被关注/屏蔽者名字
     */
    private String subscribeName;

    /**
     * 被关注/屏蔽者职位
     */
    private String subscribePosition;

    /**
     * 被关注/屏蔽者组织机构名字
     */
    private String subscribeOrganizationName;

    /**
     * 关注对象身份 0-会员 1-组织机构
     */
    private Integer subscribeType;

    /**
     * 被关注/屏蔽者学历
     */
    private String subscribeEducation;

    /**
     * 被关注/屏蔽者所属单位
     */
    private String subscribeBelong;
}
