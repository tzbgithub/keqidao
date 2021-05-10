package com.qidao.qidao.wx.message.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;
import com.qidao.common.utils.text.Convert;
import com.qidao.qidao.wx.constant.Env;
import com.qidao.qidao.wx.message.dto.TemplateListDto;
import com.qidao.qidao.wx.message.dto.TemplateSendDto;
import com.qidao.qidao.wx.message.service.CustomWxMessageSendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weixin.popular.api.MediaAPI;
import weixin.popular.api.MessageAPI;
import weixin.popular.api.UserAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.media.Media;
import weixin.popular.bean.media.MediaType;
import weixin.popular.bean.message.GetAllPrivateTemplateResult;
import weixin.popular.bean.message.PrivateTemplate;
import weixin.popular.bean.message.message.ImageMessage;
import weixin.popular.bean.message.message.TextMessage;
import weixin.popular.bean.message.message.VideoMessage;
import weixin.popular.bean.message.message.VoiceMessage;
import weixin.popular.bean.message.templatemessage.TemplateMessage;
import weixin.popular.bean.message.templatemessage.TemplateMessageItem;
import weixin.popular.bean.message.templatemessage.TemplateMessageResult;
import weixin.popular.bean.user.FollowResult;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class CustomWxMessageSendServiceImpl implements CustomWxMessageSendService {

    public static final Logger log = LoggerFactory.getLogger(CustomWxMessageSendServiceImpl.class);
    @Autowired
    Env env;

    //    @Override
//    public BaseResult messageCustomSend(String openId) {
//        URI uri = null;
//        try {
//            uri = new URI("https://p.qqan.com/up/2021-3/16164095551737424.jpg");
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        //先上传图片到公众号的后台
//        Media media = MediaAPI.mediaUpload(env.getAccessToken(), MediaType.image, uri);
//        String mediaId = media.getMedia_id();
//        ImageMessage imageMessage = new ImageMessage(openId, mediaId);
//        return MessageAPI.messageCustomSend(env.getAccessToken(), imageMessage);
//    }
    @Override
    public boolean messageCustomSend(String url) {
        URI uri = null;
        try {
             uri = new URI(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        FollowResult.Data data = UserAPI.userGet(env.getAccessToken(), null).getData();
        String[] openidList = data.getOpenid();
        List<String> list = new ArrayList();
        Media media = MediaAPI.mediaUpload(env.getAccessToken(), MediaType.image, uri);
        String mediaId = media.getMedia_id();
        for (String openId : openidList) {
            ImageMessage imageMessage = new ImageMessage(openId, mediaId);
            BaseResult br = MessageAPI.messageCustomSend(env.getAccessToken(), imageMessage);
            if (!br.isSuccess()) {
                log.info("发送给{}失败", openId);
                list.add(openId);
            }
        }
        if (CollectionUtil.isNotEmpty(list)) {
            log.info("发送不成功的人有: {}", list);
            return false;
        } else {
            log.info("图片对所有粉丝发送完毕！！！");
            return true;
        }



        //先上传图片到公众号的后台
//        Media media = MediaAPI.mediaUpload(env.getAccessToken(), MediaType.image, uri);
//        String mediaId = media.getMedia_id();
//
//        ImageMessage imageMessage = new ImageMessage(openId, mediaId);
//        return MessageAPI.messageCustomSend(env.getAccessToken(), imageMessage);
    }

    @Override
    public BaseResult messageCustomSend(String openId,String url) {
        URI uri = null;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //先上传图片到公众号的后台
        Media media = MediaAPI.mediaUpload(env.getAccessToken(), MediaType.image, uri);
        String mediaId = media.getMedia_id();
        ImageMessage imageMessage = new ImageMessage(openId, mediaId);
        return MessageAPI.messageCustomSend(env.getAccessToken(), imageMessage);
    }

    @Override
    public BaseResult textCustomSend( String openId, String content) {
        TextMessage textMessage = new TextMessage(openId, content);
        return MessageAPI.messageCustomSend(env.getAccessToken(), textMessage);
    }

    @Override
    public boolean textCustomSendAll(String content) {

        FollowResult.Data data = UserAPI.userGet(env.getAccessToken(), null).getData();
        String[] openidList = data.getOpenid();
        List<String> list = new ArrayList();
        for (String openId : openidList) {
            TextMessage textMessage = new TextMessage(openId, content);
            BaseResult br = MessageAPI.messageCustomSend(env.getAccessToken(), textMessage);
            if (!br.isSuccess()) {
                log.info("发送给{}失败", openId);
                list.add(openId);
            }
        }
        if (CollectionUtil.isNotEmpty(list)) {
            log.info("发送不成功的人有: {}", list);
            return false;
        } else {
            log.info("微信文字内容对所有粉丝发送完毕！！！");
            return true;
        }

    }

    @Override
    public BaseResult videoCustomSend( String openId, String url) {
        URI uri = null;
        try {
//            uri = new URI("https://media.w3.org/2010/05/sintel/trailer.mp4");  //测试链接
            uri = new URI(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //先上传视频到公众号的后台
        Media media = MediaAPI.mediaUpload(env.getAccessToken(), MediaType.video, uri);
        String mediaId = media.getMedia_id();
        VideoMessage.Video video = new VideoMessage.Video(mediaId, "电影", "欧美动漫电影预告");
        VideoMessage vm = new VideoMessage(openId, video);
        return MessageAPI.messageCustomSend(env.getAccessToken(), vm);
    }

    @Override
    public BaseResult voiceCustomSend( String openId, String url) {
        URI uri = null;
        try {
//            uri = new URI("http://downsc.chinaz.net/Files/DownLoad/sound1/201906/11582.mp3");  //测试链接
            uri = new URI(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //先上传语音到公众号的后台
        Media media = MediaAPI.mediaUpload(env.getAccessToken(), MediaType.voice_mp3, uri);
        String media_id = media.getMedia_id();
        VoiceMessage voiceMessage = new VoiceMessage(openId, media_id);
        return MessageAPI.messageCustomSend(env.getAccessToken(), voiceMessage);
    }

    @Override
    public boolean messageTemplateSend(TemplateSendDto templateSendDto) {
        FollowResult.Data data = UserAPI.userGet(env.getAccessToken(), null).getData();
        String[] openidList = data.getOpenid();
        List<Long> msgIdList = new ArrayList<>();
        List<String> failSendList = new ArrayList<>();

        for (String tourser : openidList) {

            TemplateMessage templateMessage = new TemplateMessage();
            templateMessage.setTouser(tourser);
            templateMessage.setTemplate_id(templateSendDto.getId());
            templateMessage.setUrl(templateSendDto.getUrl());

            LinkedHashMap<String, TemplateMessageItem> map = new LinkedHashMap<>();

            TemplateMessageItem first = new TemplateMessageItem();
            first.setValue(templateSendDto.getFirstValue());
            first.setColor(templateSendDto.getFirstColor());
            map.put("first", first);

            TemplateMessageItem keyword1 = new TemplateMessageItem();
            keyword1.setValue(templateSendDto.getKeyword1Value());
            keyword1.setColor(templateSendDto.getKeyword1Color());
            map.put("keyword1", keyword1);

            TemplateMessageItem keyword2 = new TemplateMessageItem();
            keyword2.setValue(templateSendDto.getKeyword2Value());
            keyword2.setColor(templateSendDto.getKeyword2Color());
            map.put("keyword2", keyword2);

            TemplateMessageItem keyword3 = new TemplateMessageItem();
            keyword3.setValue(templateSendDto.getKeyword3Value());
            keyword3.setColor(templateSendDto.getKeyword3Color());
            map.put("keyword3", keyword3);

            TemplateMessageItem remark = new TemplateMessageItem();
            remark.setValue(templateSendDto.getRemarkValue());
            keyword3.setColor(templateSendDto.getRemarkColor());
            map.put("remark", remark);

            templateMessage.setData(map);
            TemplateMessageResult res = MessageAPI.messageTemplateSend(env.getAccessToken(), templateMessage);
            if (res.isSuccess()) {
                msgIdList.add(res.getMsgid());
            } else {
                failSendList.add(tourser);
            }
        }
        if (CollectionUtil.isEmpty(failSendList)) {
            log.info("成功传输的消息id：{}", JSONUtil.toJsonStr(msgIdList));
            return true;
        } else {
            log.info("模板发送失败的的粉丝：{}", JSONUtil.toJsonStr(failSendList));
            return false;
        }

    }

//    @Override
//    public BaseResult messageTemplateSend() {
//        TemplateMessage templateMessage = new TemplateMessage();
//        templateMessage.setTemplate_id("qjeiHAQlUk59E47QinbR5ByaQ2OriUs0KiZ0z6LPgUs");
//        templateMessage.setUrl("www.baidu.com");
//        templateMessage.setTouser("oCJyZ58vcJpMDj8vl2JYy5qWwY24");
//
//
//        LinkedHashMap<String, TemplateMessageItem> map = new LinkedHashMap<>();
//
//        TemplateMessageItem first = new TemplateMessageItem();
//        first.setColor("#173177");
//        first.setValue("2019年全国XXX业余大赛");
//        map.put("first", first);
//
//        TemplateMessageItem keyword1 = new TemplateMessageItem();
//        keyword1.setColor("#FF0000");
//        keyword1.setValue("2019年XXX业余大赛将于北京举行");
//        map.put("keyword1", keyword1);
//
//        TemplateMessageItem keyword2 = new TemplateMessageItem();
//        keyword2.setColor("#173177");
//        keyword2.setValue("欢迎报名参加");
//        map.put("keyword2", keyword2);
//
//        templateMessage.setData(map);
//        return MessageAPI.messageTemplateSend(env.getAccessToken(), templateMessage);
//    }

//    @Override
//    public BaseResult messageTemplateSend(String templateId,String url) {
//        TemplateMessage templateMessage = new TemplateMessage();
//        templateMessage.setTemplate_id("qjeiHAQlUk59E47QinbR5ByaQ2OriUs0KiZ0z6LPgUs");
//        templateMessage.setUrl("www.baidu.com");
//        templateMessage.setTouser("oCJyZ58vcJpMDj8vl2JYy5qWwY24");
//
//
//        LinkedHashMap<String, TemplateMessageItem> map = new LinkedHashMap<>();
//
//        TemplateMessageItem first = new TemplateMessageItem();
//        first.setColor("#173177");
//        first.setValue("2019年全国XXX业余大赛");
//        map.put("first", first);
//
//        TemplateMessageItem keyword1 = new TemplateMessageItem();
//        keyword1.setColor("#FF0000");
//        keyword1.setValue("2019年XXX业余大赛将于北京举行");
//        map.put("keyword1", keyword1);
//
//        TemplateMessageItem keyword2 = new TemplateMessageItem();
//        keyword2.setColor("#173177");
//        keyword2.setValue("欢迎报名参加");
//        map.put("keyword2", keyword2);
//
//        templateMessage.setData(map);
//        return MessageAPI.messageTemplateSend(env.getAccessToken(), templateMessage);
//    }

    @Override
    public List<TemplateListDto> templateGetAllPrivateTemplate() {
        GetAllPrivateTemplateResult res = MessageAPI.templateGet_all_private_template(env.getAccessToken());
        BaseResult br = res;
        if (br.isSuccess()) {
            log.info("成功获取公众号的所有模板");
            List<PrivateTemplate> list = res.getTemplate_list();
            List<TemplateListDto> resList = new ArrayList<>();
            for (PrivateTemplate pt :
                    list) {
                TemplateListDto tld = new TemplateListDto();
                tld.setContent(pt.getContent());
                tld.setId(pt.getTemplate_id());
                tld.setDeputy_industry(pt.getDeputy_industry());
                tld.setPrimary_industry(pt.getPrimary_industry());
                tld.setTitle(pt.getTitle());
                tld.setExample(pt.getExample());
                resList.add(tld);
            }
            return resList;
        } else {
            log.info("获取公众号的所有模板 - -> 失败");
            return null;
        }
    }

    @Override
    public boolean templateDelPrivateTemplate(String templateIds) {
        String[] ids = Convert.toStrArray(templateIds);
        int count = 0;
        List<String> failedDel = new ArrayList<>();
        for(String templateId : ids) {
            BaseResult br = MessageAPI.templateDel_private_template(env.getAccessToken(), templateId);
            if (br.isSuccess()) {
                count++;
            } else {
                failedDel.add(templateId);
            }
        }
        if (count == ids.length) {
            log.info("全部删除成功");
            return true;
        } else {
            log.info("以下templateId删除失败：{}", failedDel);
            return false;
        }
    }
}
