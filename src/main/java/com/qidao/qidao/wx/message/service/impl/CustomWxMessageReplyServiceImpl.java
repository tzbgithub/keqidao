package com.qidao.qidao.wx.message.service.impl;

import com.qidao.common.utils.StringUtils;
import com.qidao.qidao.wx.message.dto.ReplyConfigDto;
import com.qidao.qidao.wx.message.message.Article;
import com.qidao.qidao.wx.message.message.NewsMessage;
import com.qidao.qidao.wx.message.message.TextMessage;
import com.qidao.qidao.wx.message.service.CustomWxMessageReplyService;
import com.qidao.qidao.wx.message.util.MessageUtil;
import com.qidao.qidao.wx.message.vo.ReplyConfigVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Service
public class CustomWxMessageReplyServiceImpl implements CustomWxMessageReplyService {


    private static final Logger LOGGER = LoggerFactory.getLogger(CustomWxMessageReplyServiceImpl.class);
    @Autowired
    ReplyConfigVo replyConfigVo;

    @Override
    public String messageReply(HttpServletRequest request) {
        String respMessage = null;
        try {
            // xml请求解析
            Map<String, String> requestMap = MessageUtil.xmlToMap(request);
            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName");
            // 公众帐号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");
            // 消息内容
            String content = requestMap.get("Content");
            LOGGER.info("FromUserName is:" + fromUserName + ", ToUserName is:" + toUserName + ", MsgType is:" + msgType);
            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                //这里根据关键字执行相应的逻辑
                /*if(content.equals("xxx")){

                }*/
                //自动回复
                TextMessage text = new TextMessage();
                String replyContent = replyConfigVo.getTextContent();
                if (StringUtils.isEmpty(replyContent)) {
                    text.setContent("服务器暂时未配置回复，请等待该功能开发");
                } else {
                    text.setContent(replyContent);
                }
                text.setToUserName(fromUserName);
                text.setFromUserName(toUserName);
                text.setCreateTime(new Date().getTime());
                text.setMsgType(msgType);
                respMessage = MessageUtil.textMessageToXml(text);
            }
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                String eventType = requestMap.get("Event");// 事件类型
                // 订阅
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    //文本消息
                    /*TextMessage text = new TextMessage();
                    text.setContent("我不管，我最美！！");
                    text.setToUserName(fromUserName);
                    text.setFromUserName(toUserName);
                    text.setCreateTime(new Date().getTime());
                    text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
                    respMessage = MessageUtil.textMessageToXml(text);*/
                }
                // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {// 取消订阅


                }
                // 自定义菜单点击事件
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    String eventKey = requestMap.get("EventKey");// 事件KEY值，与创建自定义菜单时指定的KEY值对应
                    if (eventKey.equals("return_content")) {
                        TextMessage text = new TextMessage();
                        text.setContent("赞赞赞");
                        text.setToUserName(fromUserName);
                        text.setFromUserName(toUserName);
                        text.setCreateTime(new Date().getTime());
                        text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
                        respMessage = MessageUtil.textMessageToXml(text);
                    }
                }
            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                //对图文消息
                NewsMessage newmsg = new NewsMessage();
                newmsg.setToUserName(fromUserName);
                newmsg.setFromUserName(toUserName);
                newmsg.setCreateTime(new Date().getTime());
                newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                newmsg.setFuncFlag(0);
                List<Article> articleList = new ArrayList<>();

                Article article = new Article();
                article.setTitle("我是一个图文");
                article.setDescription("我是描述信息");
                article.setPicUrl("https://sfault-avatar.b0.upaiyun.com/110/007/1100070317-5abcb09d42224_huge256");
                article.setUrl("https://segmentfault.com/u/panzi_5abcaf30a5e6b");
                articleList.add(article);
                // 设置图文消息个数
                newmsg.setArticleCount(articleList.size());
                // 设置图文消息包含的图文集合
                newmsg.setArticles(articleList);
                // 将图文消息对象转换成xml字符串
                respMessage = MessageUtil.newsMessageToXml(newmsg);
            }
        } catch (Exception e) {
            LOGGER.error("error......");
        }
        return respMessage;
    }

    @Override
    public boolean config(ReplyConfigDto replyConfigDto) {
        try {
            replyConfigVo.setTextContent(replyConfigDto.getReplyToText());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
