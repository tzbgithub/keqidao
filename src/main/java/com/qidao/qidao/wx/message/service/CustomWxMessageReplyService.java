package com.qidao.qidao.wx.message.service;

import com.qidao.qidao.wx.message.dto.ReplyConfigDto;

import javax.servlet.http.HttpServletRequest;

public interface CustomWxMessageReplyService {

    /**
     * 自动回复文字消息
     *
     * @param request 用户消息请求
     * @return
     */
    String messageReply(HttpServletRequest request);

    /**
     * 配置回复
     * @param replyConfigDto 消息回复配置传输实体
     */
    boolean config(ReplyConfigDto replyConfigDto);

}
