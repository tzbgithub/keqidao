package com.qidao.qidao.wx.message.controller;

import com.qidao.common.utils.StringUtils;
import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.project.common.service.ICosTencentService;
import com.qidao.qidao.wx.message.dto.MessageSendDto;
import com.qidao.qidao.wx.message.dto.TemplateListDto;
import com.qidao.qidao.wx.message.dto.TemplateSendDto;
import com.qidao.qidao.wx.message.service.CustomWxMessageSendService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * 微信公众号消息管理
 *
 * @author tangzhangbin
 * @date 2021/04/15
 */
@Controller
@RequestMapping("/wx/message")
public class CustomWxMessageSendController extends BaseController {
    private String prefix = "qidao/wx/message";

    @Autowired
    CustomWxMessageSendService customWxMessageSendService;

    @Value("${cos.imageBucketName}")
    String imageBucketName;

    @Autowired
    private ICosTencentService cosTencentService;
    @RequiresPermissions("wx:message:view")
    @GetMapping()
    public String menu(ModelMap map) {
        return prefix + "/message";
    }


    @GetMapping("/send")
    public String send() {
        return prefix + "/send";
    }

    @GetMapping("/sendTemplate/{id}")
    public String sendTemplate(@PathVariable("id") String id,ModelMap mmap) {
        mmap.put("id", id);
        return prefix + "/send_template";
    }


    /**
     * 查询模板消息
     */
    @PostMapping("/getTemplateList")
    @ResponseBody
    public TableDataInfo list() {
        startPage();
        List<TemplateListDto> list = customWxMessageSendService.templateGetAllPrivateTemplate();
        return getDataTable(list);
    }





    /**
     * 发送消息(发送文本信息或者发送图片)
     */
    @RequiresPermissions("wx:message:send")
    @PostMapping("/send")
    @ResponseBody
    public AjaxResult sendSave(MessageSendDto messageSendDto) throws IOException {
        boolean hasImg;
        if (StringUtils.isNotEmpty(messageSendDto.getText())) {
            return toAjax(customWxMessageSendService.textCustomSendAll(messageSendDto.getText()));
        }
        //判断文本内容是否为空，如果为空，就发送图片信息
        else if ((hasImg = StringUtils.isNotEmpty(messageSendDto.getImg())) == true) {
            String fileName = messageSendDto.getImg();
            String url = cosTencentService.getDownPath(imageBucketName) + fileName;
            return toAjax(customWxMessageSendService.messageCustomSend(url));
        }
        return null;
    }

    /**
     * 添加模板页面
     */
    @GetMapping("/addTemplateMessage")
    public String addTemplateMessage() {
        return prefix + "/addTemplateMessage";
    }

    /**
     * 添加模板消息接口
     */
    @RequiresPermissions("wx:message:add")
    @Log(title = "模板消息" , businessType = BusinessType.INSERT)
    @PostMapping("/addTemplateMessage")
    @ResponseBody
    public AjaxResult addTemplateMessageSave(MessageSendDto messageSendDto) {
        return null;
    }

    /**
     * 删除模板
     */
    @RequiresPermissions("wx:message:remove" )
    @Log(title = "模板消息" , businessType = BusinessType.DELETE)
    @PostMapping("/removeTemplate" )
    @ResponseBody
    public AjaxResult removeTemplate(String ids) {
        return toAjax(customWxMessageSendService.templateDelPrivateTemplate(ids));
    }

    /**
     * 发送模板
     */
    @RequiresPermissions("wx:message:add")
    @PostMapping("/sendTemplate")
    @ResponseBody
    public AjaxResult sendTemplate(TemplateSendDto templateSendDto) {
        return toAjax(customWxMessageSendService.messageTemplateSend(templateSendDto));
    }


}
