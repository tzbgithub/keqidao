package com.qidao.qidao.member.member.controller;

import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.member.member.domain.*;
import com.qidao.qidao.member.member.service.CustomMemberService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/member/member" )
public class CustomMemberController extends BaseController {

    private String prefix = "qidao/member/member" ;

    @Autowired
    private CustomMemberService customMemberService;

    /**
     * 查询用户列表
     */
    @RequiresPermissions("member:member:list" )
    @PostMapping("/getList" )
    @ResponseBody
    public TableDataInfo list(MemberListReq req) {
        startPage();
        List<MemberListRes> list = customMemberService.getMember(req);
        return getDataTable( list);
    }

    @GetMapping("/toDetails/{id}" )
    public String details(@PathVariable("id") Long id, ModelMap mmap) {
        MemberDetails details = customMemberService.getDetails(id);
        mmap.put("member" , details);
        return prefix + "/details" ;
    }

    @GetMapping("/verify/{id}" )
    public String verify(@PathVariable("id") Long id, ModelMap mmap) {
        MemberDetails details = customMemberService.getDetails(id);
        mmap.put("member" , details);
        return prefix + "/verify" ;
    }

    //resetPassword
    @RequiresPermissions("member:member:edit")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping("/resetPassword")
    @ResponseBody
    public AjaxResult resetPassword(String id) {
        return toAjax(customMemberService.resetPassword(id));
    }

    @RequiresPermissions("member:member:edit")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping("/disable")
    @ResponseBody
    public AjaxResult disable(String id) {
        return toAjax(customMemberService.disable(id));
    }

    @RequiresPermissions("member:member:list" )
    @GetMapping("/getMemberByName" )
    @ResponseBody
    public List<Member> list(SubscribeMemberReq  req) {
        return customMemberService.getMemberByName(req);
    }


    @RequiresPermissions("member:member:edit")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PostMapping("/verifyPass/{id}/{msg}")
    @ResponseBody
    public AjaxResult verifyPass(@PathVariable("id")Long id , @PathVariable("msg")String  msg) {
        return toAjax(customMemberService.verifyPass(id , msg));
    }

    @RequiresPermissions("member:member:edit")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping("/verifyDeft/{id}/{msg}")
    @ResponseBody
    public AjaxResult verifyDeft(@PathVariable("id")Long id , @PathVariable("msg")String  msg) {
        return toAjax(customMemberService.verifyDeft(id , msg));
    }

    @RequiresPermissions("member:member:list" )
    @GetMapping("/findMemberByName" )
    @ResponseBody
    public List<Member> findMemberByName(FindMemberReq req) {
        return customMemberService.findMemberByName(req);
    }

    @RequiresPermissions("member:member:edit")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PostMapping("/editVip")
    @ResponseBody
    public AjaxResult editVip(MemberAddVipReq req) {
        return toAjax(customMemberService.editMemberVip(req));
    }


    @GetMapping("/getSalesmanMember")
    @ResponseBody
    public List<Member> getSalesmanMember(Long salesmanId){
        return customMemberService.getSalesmanMember(salesmanId);
    }

}
