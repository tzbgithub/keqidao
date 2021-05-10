package com.qidao.qidao.feedback.feedback.controller;

import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.project.system.user.domain.User;
import com.qidao.qidao.feedback.feedback.domain.*;
import com.qidao.qidao.feedback.feedback.service.CustomFeedbackService;
import com.qidao.qidao.feedback.feedback.service.IFeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: xinfeng
 * @create: 2021-01-28 13:42
 */
@Controller
@Slf4j
@RequestMapping("/feedback/feedback")
public class CustomFeedbackController extends BaseController {
    private String prefix = "qidao/feedback/feedback";

    @Autowired
    private IFeedbackService iFeedbackService;

    @Autowired
    private CustomFeedbackService customFeedbackService;

    @PostMapping("/reply")
    @Log(title = "反馈回复", businessType = BusinessType.UPDATE)
    @ResponseBody
    public AjaxResult reply(Long id, String reply){
        log.info("CustomFeedbackController -> reply -> start -> id : {}, reply : {}", id, reply);
        Feedback feedback = iFeedbackService.selectFeedbackById(id);
        User user = ShiroUtils.getSysUser();
        feedback.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));
        feedback.setReply(reply);
        feedback.setReplyUserId(ShiroUtils.getUserId());
        feedback.setReplyUserName(user.getUserName());
        feedback.setStatus(FeedbackEnum.PROCESS_STATUS_ED.getValue());
        return toAjax(iFeedbackService.updateFeedback(feedback));
    }

    /**
     * 查询反馈列表
     */
    @RequiresPermissions("feedback:feedback:list")
    @PostMapping("/getList")
    @ResponseBody
    public TableDataInfo list(FeedbackReq req) {
        startPage();
        List<FeedbackPageRes> list = customFeedbackService.findFeedbackList(req);
        return getDataTable(list);
    }

}