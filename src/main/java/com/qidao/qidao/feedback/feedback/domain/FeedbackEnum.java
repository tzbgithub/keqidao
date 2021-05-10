package com.qidao.qidao.feedback.feedback.domain;

import lombok.Getter;

/**
 * @author: xinfeng
 * @create: 2021-01-28 10:01
 */

@Getter
public enum  FeedbackEnum {

    /**
     *
     * PROCESS_STATUS_ 反馈状态 0-未处理 1-处理中 2-已处理
     *
     * DELETE_FLAG_ 删除标志 YES(已删除) NO(未删除)
     *
     */

    PROCESS_STATUS_UN(0),
    PROCESS_STATUS_ING(1),
    PROCESS_STATUS_ED(2),

    DELETE_FLAG_NO(0),
    DELETE_FLAG_YES(1);

    private final int value;

    FeedbackEnum(int value) {
        this.value = value;
    }
}
