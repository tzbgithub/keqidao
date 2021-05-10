package com.qidao.qidao.wx.comment.service.impl;


import com.qidao.qidao.wx.comment.service.CustomWxCommentService;
import com.qidao.qidao.wx.constant.Env;
import org.springframework.beans.factory.annotation.Autowired;
import weixin.popular.api.CommentAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.comment.CommentList;
import weixin.popular.bean.comment.Params;
import weixin.popular.bean.comment.ReplyAdd;

public class CustomWxCommentServiceImpl implements CustomWxCommentService {
    @Autowired
    Env env;

    @Override
    public BaseResult open(Long msgDataId, int index) {
        return CommentAPI.open(env.getAccessToken(), msgDataId, index);
    }

    @Override
    public BaseResult close(Long msgDataId, int index) {
        return CommentAPI.close(env.getAccessToken(), msgDataId, index);
    }

    @Override
    public BaseResult list(CommentList commentList) {
        return CommentAPI.list(env.getAccessToken(), commentList);
    }

    @Override
    public BaseResult marklect(Params markelect) {
        return CommentAPI.markelect(env.getAccessToken(), markelect);
    }

    @Override
    public BaseResult unmarklect(Params unmarkelect) {
        return CommentAPI.unmarkelect(env.getAccessToken(), unmarkelect);
    }

    @Override
    public BaseResult delete(Params delete) {
        return CommentAPI.delete(env.getAccessToken(), delete);
    }

    @Override
    public BaseResult replyAdd(ReplyAdd replyAdd) {
        return CommentAPI.replyAdd(env.getAccessToken(), replyAdd);
    }

    @Override
    public BaseResult replyDelete(Params delete) {
        return CommentAPI.replyDelete(env.getAccessToken(), delete);
    }

}
