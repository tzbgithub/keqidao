package com.qidao.qidao.dynamic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.dynamic.domain.*;
import com.qidao.qidao.dynamic.service.CustomDynamicService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/dynamic" )
public class CustomDynamicController extends BaseController {

    private String prefix = "qidao/dynamic" ;

    @Autowired
    private CustomDynamicService customDynamicService;

    @RequiresPermissions("qidao:dynamic:list" )
    @PostMapping("/getList" )
    @ResponseBody
    public TableDataInfo list(DynamicPageReq req) {
        startPage();
        List<DynamicPageRes> list = customDynamicService.getDynamic(req);
        return getDataTable(list);
    }

    @GetMapping("/toVerify/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap mmap) {
        DynamicDetails dynamic =customDynamicService.getDynamicById(id);
        mmap.put("dynamic" , dynamic);
        return "qidao/dynamic/verify" ;
    }

    @GetMapping("/toRecheck/{id}" )
    public String toRecheck(@PathVariable("id" ) Long id, ModelMap mmap) {
        DynamicDetails dynamic =customDynamicService.getDynamicById(id);
        mmap.put("dynamic" , dynamic);
        return "qidao/dynamic/recheck" ;
    }

    @GetMapping("/getChannel")
    @ResponseBody
    public List<DynamicChannel> getChannel(){
        return customDynamicService.getChannel();
    }

    /**
     * 审核通过
     * @param req
     * @return
     */
    @RequiresPermissions("dynamic:dynamic:verify" )
    @PostMapping("/verifyDynamicPass")
    @ResponseBody
    public AjaxResult verifyDynamicPass(VerifyReq req){
        return toAjax(customDynamicService.verifyDynamicPass(req));
    }

    /**
     * 审核拒绝
     * @param id
     * @return
     */
    @RequiresPermissions("dynamic:dynamic:verify" )
    @PutMapping("/verifyDynamicFailed/{id}")
    @ResponseBody
    public AjaxResult verifyDynamicFailed(@PathVariable("id") Long id){
        return toAjax(customDynamicService.verifyDynamicFailed(id)) ;
    }

    /**
     * 核准通过
     * @param req
     * @return
     */
    @RequiresPermissions("dynamic:dynamic:recheck" )
    @PostMapping("/approvalDynamicPass")
    @ResponseBody
    public AjaxResult approvalDynamicPass(VerifyReq req){
        return toAjax(customDynamicService.approvalDynamicPass(req)) ;
    }

    /**
     * 核准拒绝
     * @param id
     * @return
     */
    @RequiresPermissions("dynamic:dynamic:recheck" )
    @PutMapping("/approvalDynamicFailed/{id}")
    @ResponseBody
    public AjaxResult approvalDynamicFailed(@PathVariable("id") Long id){
        return toAjax(customDynamicService.approvalDynamicFailed(id)) ;
    }

    @PutMapping("/checkPending/{id}")
    @ResponseBody
    public int checkPending(@PathVariable("id") Long id){
        return customDynamicService.checkPending(id);
    }

    @GetMapping("/toAdd")
    public String toAdd(){
        return "qidao/dynamic/add";
    }

    @RequiresPermissions("qidao:dynamic:add" )
    @Log(title = "动态" , businessType = BusinessType.INSERT)
    @PostMapping("/create" )
    @ResponseBody
    public AjaxResult create(DynamicInsertReq req) {
        return toAjax(customDynamicService.create(req));
    }

    @GetMapping("/toComment/{id}")
    public String toComment(@PathVariable("id")Long id , ModelMap mmap){
        DynamicDetails dynamic =customDynamicService.getDynamicById(id);
        mmap.put("dynamic" , dynamic);
        return "qidao/dynamic/comment/comment";
    }

    @RequiresPermissions("qidao:dynamic:edit" )
    @PostMapping("/updateChannel")
    @ResponseBody
    public AjaxResult updateChannel(VerifyReq req){
        return toAjax(customDynamicService.updateChannel(req));
    }

    @GetMapping("/getMember")
    @ResponseBody
    public List<MemberInfo> getMember(String name){
        return customDynamicService.getMember(name);
    }
}
