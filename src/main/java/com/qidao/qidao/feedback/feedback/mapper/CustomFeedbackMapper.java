package com.qidao.qidao.feedback.feedback.mapper;

import com.github.pagehelper.Page;
import com.qidao.qidao.feedback.feedback.domain.FeedbackPageRes;
import com.qidao.qidao.feedback.feedback.domain.FeedbackReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomFeedbackMapper {

    Page<FeedbackPageRes> findFeedbackRes(FeedbackReq req);

}
