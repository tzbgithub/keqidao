package com.qidao.qidao.feedback.feedback.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: xinfeng
 * @create: 2021-01-28 10:01
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackReq {
    /** 反馈原因*/
    private Long reasonId;

    private String startTime;

    private String endTime;

    private Integer status;

    private String member;
}
