package com.qidao.qidao.wx.comment.service;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.comment.CommentList;
import weixin.popular.bean.comment.Params;
import weixin.popular.bean.comment.ReplyAdd;

public interface CustomWxCommentService {
    /**
     * 打开已经群发文章评论
     * @param msgDataId 群发返回的msg_data_id
     * @param index 多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @return
     */
    BaseResult open(Long msgDataId, int index);

    /**
     * 关闭已经群发文章评论
     * @param msgDataId 群发返回的msg_data_id
     * @param index 多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @return
     */
    BaseResult close(Long msgDataId, int index);

    /**
     * 查看指定文章的评论数据
     * @param commentList 参数类
     * @return
     */
    BaseResult list( CommentList commentList);

    /**
     * 将评论标记精选
     * @param markelect 参数类
     * @return
     */
    BaseResult marklect( Params markelect);

    /**
     * 将评论取消精选
     * @param unmarkelect 参数类
     * @return
     */
    BaseResult unmarklect( Params unmarkelect);

    /**
     * 删除评论
     * @param delete 参数类
     * @return
     */
    BaseResult delete( Params delete);

    /**
     * 回复评论
     * @param replyAdd 参数类
     * @return
     */
    BaseResult replyAdd( ReplyAdd replyAdd);

    /**
     * 删除回复
     * @param delete 删除需要的参数类
     * @return
     */
    BaseResult replyDelete( Params delete);




}
