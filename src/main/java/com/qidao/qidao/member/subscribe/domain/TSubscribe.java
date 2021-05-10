package com.qidao.qidao.member.subscribe.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 关注对象 subscribe
 *
 * @author autuan
 * @date 2020-12-24
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TSubscribe extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 关注对象所属机构名称
     */
    @Excel(name = "关注对象所属机构名称")
    private String subscribeOrganizationName;
    /**
     * 关注对象职位
     */
    @Excel(name = "关注对象职位")
    private String subscribePosition;
    /**
     * 关注对象名称
     */
    @Excel(name = "关注对象名称")
    private String subscribeName;
    /**
     * 关注对象头像
     */
    @Excel(name = "关注对象头像")
    private String subscribeHeadImg;
    /**
     * 关注/屏蔽：0-关注；1-屏蔽
     */
    @Excel(name = "关注/屏蔽：0-关注；1-屏蔽")
    private Integer type;
    /**
     * 关注时间
     */
    @Excel(name = "关注时间")
    private LocalDateTime subscribeTime;
    /**
     * 关注对象会员ID
     */
    @Excel(name = "关注对象会员ID")
    private Long subscribeId;
    /**
     * 会员ID
     */
    @Excel(name = "会员ID")
    private Long memberId;
    /**
     * 主键
     */
    private Long id;
}
