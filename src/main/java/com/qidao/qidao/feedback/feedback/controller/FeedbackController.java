package com.qidao.qidao.feedback.feedback.controller;

import java.util.List;

import com.qidao.qidao.feedback.feedback.domain.FeedbackRes;
import com.qidao.qidao.feedback.feedback.service.CustomFeedbackService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.qidao.feedback.feedback.domain.Feedback;
import com.qidao.qidao.feedback.feedback.service.IFeedbackService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 反馈Controller
 *
 * @author autuan
 * @date 2021-01-28
 */
@Controller
@RequestMapping("/feedback/feedback")
public class FeedbackController extends BaseController {
    private String prefix = "qidao/feedback/feedback";

    @Autowired
    private IFeedbackService feedbackService;

    @Autowired
    private CustomFeedbackService customFeedbackService;

    @RequiresPermissions("feedback:feedback:view")
    @GetMapping()
    public String feedback() {
        return prefix + "/feedback";
    }

    /**
     * 查询反馈列表
     */
    @RequiresPermissions("feedback:feedback:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Feedback feedback) {
        startPage();
        List<FeedbackRes> list = customFeedbackService.selectFeedbackList(feedback);
        return getDataTable(list);
    }

    /**
     * 导出反馈列表
     */
    @RequiresPermissions("feedback:feedback:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Feedback feedback) {
        List<Feedback> list = feedbackService.selectFeedbackList(feedback);
        ExcelUtil<Feedback> util = new ExcelUtil<Feedback>(Feedback.class);
        return util.exportExcel(list, "feedback");
    }

    /**
     * 新增反馈
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存反馈
     */
    @RequiresPermissions("feedback:feedback:add")
    @Log(title = "反馈", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Feedback feedback) {
        return toAjax(feedbackService.insertFeedback(feedback));
    }

    /**
     * 修改反馈
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Feedback feedback = feedbackService.selectFeedbackById(id);
        mmap.put("feedback", feedback);
        return prefix + "/edit";
    }

    /**
     * 修改保存反馈
     */
    @RequiresPermissions("feedback:feedback:edit")
    @Log(title = "反馈", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Feedback feedback) {
        return toAjax(feedbackService.updateFeedback(feedback));
    }

    /**
     * 删除反馈
     */
    @RequiresPermissions("feedback:feedback:remove")
    @Log(title = "反馈", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(feedbackService.deleteFeedbackByIds(ids));
    }

    /**
     * 逻辑删除反馈
     */
    @RequiresPermissions("feedback:feedback:logicRemove")
    @Log(title = "反馈", businessType = BusinessType.LOGIC_DEL)
    @PostMapping("/logicRemove")
    @ResponseBody
    public AjaxResult logicRemove(String ids) {
        return toAjax(feedbackService.logicDelByIds(ids));
    }
}
