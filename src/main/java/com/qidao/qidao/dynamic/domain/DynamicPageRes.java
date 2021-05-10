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
public class DynamicPageRes {

    /**
     * 主键
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 发布时间
     */
    private String publishTime;

    /**
     * 发布人
     */
    private String memberName;

    /**
     * 状态 0-待审核 1-审核通过,未核准 2-审核拒绝 3-核准通过 4-核准拒绝
     */
    private Integer verifyStatus;


    /**
     * 频道
     */
    private String channel;

    /**
     * 审核人
     */
    private String verifyName;

    /**
     * 核准人
     */
    private String recheckName;

}
