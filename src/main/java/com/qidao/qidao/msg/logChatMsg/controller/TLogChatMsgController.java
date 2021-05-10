package com.qidao.qidao.msg.logChatMsg.controller;

import java.util.List;

import com.qidao.qidao.msg.logChatMsg.domain.LogChatMsgExcel;
import com.qidao.qidao.msg.logChatMsg.domain.LogChatMsgPageReq;
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
import com.qidao.qidao.msg.logChatMsg.domain.TLogChatMsg;
import com.qidao.qidao.msg.logChatMsg.service.ITLogChatMsgService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 环信聊天记录Controller
 *
 * @author yqj
 * @date 2021-02-27
 */
@Controller
@RequestMapping("/msg/logChatMsg")
public class TLogChatMsgController extends BaseController {
    private String prefix = "qidao/msg/logChatMsg";

    @Autowired
    private ITLogChatMsgService tLogChatMsgService;

    @RequiresPermissions("msg:logChatMsg:view")
    @GetMapping()
    public String logChatMsg() {
        return prefix + "/logChatMsg";
    }

    /**
     * 查询环信聊天记录列表
     */
    @RequiresPermissions("msg:logChatMsg:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LogChatMsgPageReq tLogChatMsg) {
        startPage();
        List<TLogChatMsg> list = tLogChatMsgService.selectTLogChatMsgList(tLogChatMsg);
        return getDataTable(list);
    }

    /**
     * 导出环信聊天记录列表
     */
    @RequiresPermissions("msg:logChatMsg:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LogChatMsgPageReq tLogChatMsg) {
        List<LogChatMsgExcel> list = tLogChatMsgService.findAll();
        ExcelUtil<LogChatMsgExcel> util = new ExcelUtil<LogChatMsgExcel>(LogChatMsgExcel.class);
        return util.exportExcel(list, "logChatMsg");
    }

    /**
     * 新增环信聊天记录
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存环信聊天记录
     */
    @RequiresPermissions("msg:logChatMsg:add")
    @Log(title = "环信聊天记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TLogChatMsg tLogChatMsg) {
        return toAjax(tLogChatMsgService.insertTLogChatMsg(tLogChatMsg));
    }

    /**
     * 修改环信聊天记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        TLogChatMsg tLogChatMsg = tLogChatMsgService.selectTLogChatMsgById(id);
        mmap.put("tLogChatMsg", tLogChatMsg);
        return prefix + "/edit";
    }

    /**
     * 修改保存环信聊天记录
     */
    @RequiresPermissions("msg:logChatMsg:edit")
    @Log(title = "环信聊天记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TLogChatMsg tLogChatMsg) {
        return toAjax(tLogChatMsgService.updateTLogChatMsg(tLogChatMsg));
    }

    /**
     * 删除环信聊天记录
     */
    @RequiresPermissions("msg:logChatMsg:remove")
    @Log(title = "环信聊天记录", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tLogChatMsgService.deleteTLogChatMsgByIds(ids));
    }

    /**
     * 逻辑删除环信聊天记录
     */
    @RequiresPermissions("msg:logChatMsg:logicRemove")
    @Log(title = "环信聊天记录", businessType = BusinessType.LOGIC_DEL)
    @PostMapping("/logicRemove")
    @ResponseBody
    public AjaxResult logicRemove(String ids) {
        return toAjax(tLogChatMsgService.logicDelByIds(ids));
    }
}
