package com.qidao.qidao.dynamic.comment.service;

import com.qidao.qidao.dynamic.comment.domain.CommentPageRes;

import java.util.List;

public interface CustomCommentService {

    List<CommentPageRes> getComment(Long id);

    int verifyPass(Long id , Long dynamicId);

    int verifyFail(Long id);

    int callBack(Long id);

    int delete(Long id , Long dynamicId);

}
