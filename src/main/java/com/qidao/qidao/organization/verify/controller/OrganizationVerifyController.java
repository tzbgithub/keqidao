package com.qidao.qidao.organization.verify.controller;

import com.github.pagehelper.Page;
import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.organization.organization.domain.OrganizationListReq;
import com.qidao.qidao.organization.organization.domain.OrganizationListRes;
import com.qidao.qidao.organization.organization.domain.TOrganization;
import com.qidao.qidao.organization.verify.domain.VerifyListReq;
import com.qidao.qidao.organization.verify.domain.VerifyListRes;
import com.qidao.qidao.organization.verify.service.OrganizationVerifyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/organization/verify")
public class OrganizationVerifyController extends BaseController {

    private String prefix = "qidao/organization/verify" ;

    @Autowired
    private OrganizationVerifyService organizationVerifyService;


    @RequiresPermissions("organization:verify:view" )
    @GetMapping()
    public String verify() {
        return prefix + "/verify" ;
    }

    /**
     * 查询列表
     */
    @RequiresPermissions("organization:verify:list" )
    @PostMapping("/getList" )
    @ResponseBody
    public TableDataInfo list(VerifyListReq req) {
        startPage();
        List<VerifyListRes> list = organizationVerifyService.findVerifyList(req);
        return getDataTable(list);
    }

    /**
     * 审核通过
     */
    @RequiresPermissions("organization:verify:verify" )
    @Log(title = "组织机构审核通过" , businessType = BusinessType.UPDATE)
    @PutMapping("/verifyPass/{id}/{msg}" )
    @ResponseBody
    public AjaxResult verifyPass(@PathVariable("id" ) Long id, @PathVariable("msg" ) String msg) {
        return toAjax(organizationVerifyService.verifyPass(id , msg));
    }
    /**
     * 核准通过
     */
    @RequiresPermissions("organization:verify:approval" )
    @Log(title = "组织机构核准通过" , businessType = BusinessType.UPDATE)
    @PutMapping("/recheckPass/{id}/{msg}" )
    @ResponseBody
    public AjaxResult recheckPass(@PathVariable("id" ) Long id, @PathVariable("msg" ) String msg) {
        return toAjax(organizationVerifyService.recheckPass(id , msg));
    }
    /**
     * 审核驳回
     */
    @RequiresPermissions("organization:verify:verify" )
    @Log(title = "组织机构审核驳回" , businessType = BusinessType.UPDATE)
    @PutMapping("/verifyReject/{id}/{msg}" )
    @ResponseBody
    public AjaxResult verifyReject(@PathVariable("id" ) Long id, @PathVariable("msg" ) String msg) {
        return toAjax(organizationVerifyService.verifyReject(id , msg));
    }
    /**
     * 核准驳回
     */
    @RequiresPermissions("organization:verify:approval" )
    @Log(title = "组织机构核准驳回" , businessType = BusinessType.UPDATE)
    @PutMapping("/recheckReject/{id}/{msg}" )
    @ResponseBody
    public AjaxResult recheckReject(@PathVariable("id" ) Long id, @PathVariable("msg" ) String msg) {
        return toAjax(organizationVerifyService.recheckReject(id , msg));
    }
}
