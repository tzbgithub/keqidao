package com.qidao.qidao.wx.message.controller;

import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.qidao.wx.message.dto.ReplyConfigDto;
import com.qidao.qidao.wx.message.dto.TemplateSendDto;
import com.qidao.qidao.wx.message.service.CustomWxMessageReplyService;
import com.qidao.qidao.wx.message.util.SignUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/wx/message")
public class CustomWxMessageReplyController extends BaseController {
    private String prefix = "qidao/wx/message";
    private static final Logger LOGGER = LoggerFactory.getLogger(com.qidao.qidao.wx.message.controller.CustomWxMessageReplyController.class);
    @Autowired
    private CustomWxMessageReplyService customWxMessageReplyService;

    @RequestMapping(value = "reply", method = RequestMethod.GET)
    public void get(HttpServletRequest request, HttpServletResponse response) {
        // 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        PrintWriter out = null;
        try {
            out = response.getWriter();
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，否则接入失败
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                out.print(echostr);
            }
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        } finally {
            out.close();
            out = null;
        }
    }

    @GetMapping("/replyConfig")
    public String sendTemplate( ModelMap mmap) {
        return prefix + "/reply_config";
    }

    @RequestMapping(value = "reply", method = RequestMethod.POST)
    public void post(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");

        // 调用核心业务类接收消息、处理消息
        String respMessage = customWxMessageReplyService.messageReply(request);

        // 响应消息
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(respMessage);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        } finally {
            out.close();
            out = null;
        }
    }

    /**
     *
     */
    @RequiresPermissions("wx:message:config")
    @PostMapping("/replyConfig")
    @ResponseBody
    public AjaxResult replyConfig(ReplyConfigDto replyConfigDto) {
        return toAjax(customWxMessageReplyService.config(replyConfigDto));
    }



}

