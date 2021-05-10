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
public class FeedbackPageRes {
    private Long id;

    private String name;

    private String phone;

    private String createTime;

    private String reason;

    private String description;

    private Integer status;

    private Long createById;

    private String createByName;

    private String reply;

    private Integer level;
}
