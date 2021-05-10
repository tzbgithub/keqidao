package com.qidao.qidao.member.favor.controller;


import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.member.favor.domain.*;
import com.qidao.qidao.member.favor.service.CustomFavorService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/member/favor" )
public class CustomFavorController extends BaseController {

    @Autowired
    private CustomFavorService customFavorService;

    @RequiresPermissions("member:favor:list" )
    @PostMapping("/getList" )
    @ResponseBody
    public TableDataInfo list(FavorPageReq req) {
        startPage();
        List<FavorPageRes> list = customFavorService.getFavorPage(req);
        return getDataTable(list);
    }

    @GetMapping("/getMember")
    @ResponseBody
    public List<FavorMemberRes> getMember(String name){
        return customFavorService.getMember(name);
    }

    @GetMapping("/getDynamic")
    @ResponseBody
    public List<FavorDynamicRes> getDynamic(String title){
        return customFavorService.getDynamic(title);
    }

    @PostMapping("/create" )
    @ResponseBody
    public AjaxResult addSave(CreateReq req) {
        return toAjax(customFavorService.create(req));
    }

}
