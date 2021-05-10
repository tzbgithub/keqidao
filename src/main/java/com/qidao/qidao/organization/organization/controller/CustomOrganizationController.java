package com.qidao.qidao.organization.organization.controller;

import com.github.pagehelper.Page;
import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.member.member.domain.Member;
import com.qidao.qidao.organization.organization.domain.*;
import com.qidao.qidao.organization.organization.service.CustomOrganizationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/organization/organization")
public class CustomOrganizationController extends BaseController {

    private String prefix = "qidao/organization/organization" ;

    @Autowired
    private CustomOrganizationService customOrganizationService;

    /**
     * 查询组织机构列表
     */
    @RequiresPermissions("organization:organization:list" )
    @PostMapping("/getList" )
    @ResponseBody
    public TableDataInfo list(OrganizationListReq req) {
        startPage();
        Page<OrganizationListRes> list = customOrganizationService.getOrganizationList(req);
        return getDataTable(list);
    }

    /**
     * 新增保存组织机构
     */
    @RequiresPermissions("organization:organization:add" )
    @Log(title = "组织机构" , businessType = BusinessType.INSERT)
    @PostMapping("/createOrgan" )
    @ResponseBody
    public AjaxResult createOrgan(OrganizationAddReq req) {
        return toAjax(customOrganizationService.saveOrgan(req));
    }

    /**
     * 新增组织机构
     */
    @GetMapping("/addEnterprise" )
    public String addEnterprise() {
        return prefix + "/addEnterprise" ;
    }

    /**
     * 修改组织机构
     */
    @GetMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")Long id, ModelMap mmap) {
        Organization organization = customOrganizationService.toUpdate(id);
        mmap.put("organization" , organization);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存组织机构
     */
    @RequiresPermissions("organization:organization:edit")
    @Log(title = "组织机构" , businessType = BusinessType.UPDATE)
    @PostMapping("/update" )
    @ResponseBody
    public AjaxResult edit(OrganizationUpdateReq req) {
        return toAjax(customOrganizationService.update(req));
    }

    @GetMapping("/getOrganMember/{id}")
    @ResponseBody
    public List<Member> getOrganMember(@PathVariable("id") Long id){
        return customOrganizationService.getOrganMember(id);
    }

    @GetMapping("/findByName")
    @ResponseBody
    public List<Organization> findByName(String name){
        return customOrganizationService.findByName(name);
    }



}
