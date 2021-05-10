package com.qidao.qidao.wx.message.service;

import com.qidao.qidao.wx.message.dto.TemplateListDto;
import com.qidao.qidao.wx.message.dto.TemplateSendDto;
import weixin.popular.api.MessageAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.message.PrivateTemplate;

import java.util.List;

public interface CustomWxMessageSendService {
    /**
     * 发送图片给用户
     * @param openId 公众号用户唯一标识
     * @param url 图片的腾讯云url地址
     * @return
     */
    BaseResult messageCustomSend(String openId, String url);

    /**
     * 发送图片给所有用户
     * @param url 图片的腾讯云url地址
     * @return
     */
    boolean messageCustomSend(String url);

    /**
     * 发送文本给某个用户
     * @param openId 公众号用户唯一标识
     * @param content 需要发送的文本内容
     * @return
     */
    BaseResult textCustomSend( String openId, String content);

    /**
     * 发送文本给所有用户
     * @param content 需要发送的文本内容
     * @return
     */
    boolean textCustomSendAll(String content);

    /**
     *
     * @param openId 公众号用户唯一标识
     * @param url 需要发送的在线视频链接
     * @return
     */
    BaseResult videoCustomSend( String openId, String url);

    /**
     * 发送语音给用户
     * @param openId 公众号用户唯一标识
     * @param url 需要发送的在线视频链接
     * @return
     */
    BaseResult voiceCustomSend( String openId, String url);

//    /**
//     * 发送模板消息给用户
//     * @return
//     */
//    BaseResult messageTemplateSend();

    /**
     * 发送模板消息给用户
     * @return
     */
    boolean messageTemplateSend(TemplateSendDto templateSendDto);


    /**
     * 获取已添加至帐号下所有模板列表
     * @return
     */
    List<TemplateListDto> templateGetAllPrivateTemplate();

    /**
     * 删除模板
     *
     * @param
     */
    boolean templateDelPrivateTemplate(String templateId);

}

//class Test {
//    public static void main(String[] args) {
//        MessageAPI.templateDel_private_template()
//    }
//}

