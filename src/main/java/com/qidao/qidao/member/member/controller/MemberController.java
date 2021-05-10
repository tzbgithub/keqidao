package com.qidao.qidao.member.member.controller;

import java.math.BigDecimal;
import java.util.List;

import com.qidao.qidao.advertise.advertise.service.CustomAdvertiseService;
import com.qidao.qidao.member.member.domain.TMember;
import com.qidao.qidao.member.member.service.CustomMemberService;
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
import com.qidao.qidao.member.member.service.IMemberService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 用户Controller
 *
 * @author autuan
 * @date 2020-12-16
 */
@Controller
@RequestMapping("/member/member")
public class MemberController extends BaseController {
    private String prefix = "qidao/member/member";

    @Autowired
    private IMemberService memberService;

    @Autowired
    private CustomMemberService customMemberService;

    @RequiresPermissions("member:member:view")
    @GetMapping()
    public String member(ModelMap map) {
        int allVip = customMemberService.getAllVip();
        int yesterdayData = customMemberService.getYesterdayData();
        BigDecimal orderPrice = customMemberService.getOrderPrice();
        if (orderPrice == null){
            orderPrice = BigDecimal.valueOf(0);
        }
        map.put("allVip" , allVip);
        map.put("yesterdayData" , yesterdayData);
        map.put("orderPrice" , orderPrice);
        return prefix + "/member";
    }

    /**
     * 查询用户列表
     */
    @RequiresPermissions("member:member:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TMember TMember) {
        startPage();
        List<TMember> list = memberService.selectMemberList(TMember);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @RequiresPermissions("member:member:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TMember TMember) {
        List<TMember> list = memberService.selectMemberList(TMember);
        ExcelUtil<TMember> util = new ExcelUtil<TMember>(TMember.class);
        return util.exportExcel(list, "member");
    }

    /**
     * 新增用户
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存用户
     */
    @RequiresPermissions("member:member:add")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TMember TMember) {
        return toAjax(memberService.insertMember(TMember));
    }

    /**
     * 修改用户
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TMember TMember = memberService.selectMemberById(id);
        mmap.put("member", TMember);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户
     */
    @RequiresPermissions("member:member:edit")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TMember TMember) {
        return toAjax(memberService.updateMember(TMember));
    }

    /**
     * 删除用户
     */
    @RequiresPermissions("member:member:remove")
    @Log(title = "用户", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(memberService.deleteMemberByIds(ids));
    }

    /**
     * 逻辑删除用户
     */
    @RequiresPermissions("member:member:logicRemove")
    @Log(title = "用户", businessType = BusinessType.LOGIC_DEL)
    @PostMapping("/logicRemove")
    @ResponseBody
    public AjaxResult logicRemove(String ids) {
        return toAjax(memberService.logicDelByIds(ids));
    }
}
