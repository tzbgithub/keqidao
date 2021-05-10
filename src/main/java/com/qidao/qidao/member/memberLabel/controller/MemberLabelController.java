package com.qidao.qidao.member.memberLabel.controller;

import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.member.member.domain.TMember;
import com.qidao.qidao.member.memberLabel.domain.MemberLabelDescriptionReq;
import com.qidao.qidao.member.memberLabel.domain.MemberLabelDescriptionRes;
import com.qidao.qidao.member.memberLabel.domain.MemberLabelListReq;
import com.qidao.qidao.member.memberLabel.domain.MemberLabelListRes;
import com.qidao.qidao.member.memberLabel.service.MemberLabelService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/member/label")
public class MemberLabelController extends BaseController {

    private String prefix = "qidao/member/memberLabel";

    @Autowired
    private MemberLabelService memberLabelService;

    @RequiresPermissions("member:label:view")
    @GetMapping()
    public String member() {
        return prefix + "/memberLabel";
    }

    /**
     * 查询用户标签列表
     */
    @RequiresPermissions("member:label:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MemberLabelListReq req) {
        startPage();
        List<MemberLabelListRes> list = memberLabelService.findLabel(req);
        return getDataTable(list);
    }

    /**
     * 查看用户
     */
    @GetMapping("/look/{id}/{labelId}")
    public String look(@PathVariable("id")Long id , @PathVariable("labelId")String labelId ,  ModelMap mmap) {
        MemberLabelDescriptionRes member = memberLabelService.findLabelById(id , labelId);
        mmap.put("member", member);
        return prefix + "/edit";
    }

}
