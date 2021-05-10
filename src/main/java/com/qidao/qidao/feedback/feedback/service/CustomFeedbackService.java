package com.qidao.qidao.feedback.feedback.service;

import com.qidao.qidao.feedback.feedback.domain.Feedback;
import com.qidao.qidao.feedback.feedback.domain.FeedbackPageRes;
import com.qidao.qidao.feedback.feedback.domain.FeedbackReq;
import com.qidao.qidao.feedback.feedback.domain.FeedbackRes;

import java.util.List;

/**
 * @author: xinfeng
 * @create: 2021-01-28 10:53
 */
public interface CustomFeedbackService {

    /**
     * 查询反馈结果列表
     *
     * @param feedback
     * @return 查询结果
     */
    List<FeedbackRes> selectFeedbackList(Feedback feedback);

    List<FeedbackPageRes> findFeedbackList(FeedbackReq req);
}
