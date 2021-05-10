package com.qidao.qidao.msg.msg.controller;

import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.msg.msg.domain.*;
import com.qidao.qidao.msg.msg.service.CustomMsgService;
import com.qidao.qidao.msg.msg.service.ITMsgService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/msg/msg")
public class CustomMsgController extends BaseController {

    private String prefix = "qidao/msg/msg" ;

    @Autowired
    private CustomMsgService customMsgService;


    /**
     * 查询消息列表
     */
    @RequiresPermissions("msg:msg:list" )
    @PostMapping("/getList" )
    @ResponseBody
    public TableDataInfo list(MsgListReq req) {
        startPage();
        List<MsgListRes> list = customMsgService.findMsg(req);
        return getDataTable(list);
    }

    /**
     * 新增保存消息
     */
    @RequiresPermissions("msg:msg:add" )
    @Log(title = "消息" , businessType = BusinessType.INSERT)
    @PostMapping("/save" )
    @ResponseBody
    public AjaxResult addSave(MsgAddReq req) {
        return toAjax(customMsgService.save(req));
    }

    /**
     * 修改消息
     */
    @GetMapping("/toEdit/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap mmap) {
        MsgDescriptionRes tMsg =customMsgService.findMsgDescription(id);
        mmap.put("msg" , tMsg);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存消息
     */
    @RequiresPermissions("msg:msg:edit" )
    @Log(title = "消息" , businessType = BusinessType.UPDATE)
    @PostMapping("/revoke/{id}" )
    @ResponseBody
    public AjaxResult editSave(@PathVariable("id") Long id) {
        return toAjax(customMsgService.revoke(id));
    }

    /**
     * 修改保存消息
     */
    @RequiresPermissions("msg:msg:edit" )
    @Log(title = "消息" , businessType = BusinessType.UPDATE)
    @PutMapping("/disable/{id}" )
    @ResponseBody
    public AjaxResult disable(@PathVariable("id") Long id) {
        return toAjax(customMsgService.disable(id));
    }

}
