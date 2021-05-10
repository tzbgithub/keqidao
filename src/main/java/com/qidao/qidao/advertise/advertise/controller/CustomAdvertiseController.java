package com.qidao.qidao.advertise.advertise.controller;

import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.advertise.advertise.domain.*;
import com.qidao.qidao.advertise.advertise.service.CustomAdvertiseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/advertise/advertise")
public class CustomAdvertiseController extends BaseController {

    private String prefix = "qidao/advertise/advertise" ;

    @Autowired
    private CustomAdvertiseService customAdvertiseService;

    /**
     * 查询广告信息列表
     */
    @RequiresPermissions("advertise:advertise:list" )
    @PostMapping("/getList" )
    @ResponseBody
    public TableDataInfo list(AdvertiseListReq req) {
        startPage();
        List<AdvertiseListRes> list = customAdvertiseService.findAdvertise(req);
        return getDataTable(list);
    }

    /**
     * 新增保存广告信息
     */
    @RequiresPermissions("advertise:advertise:add")
    @Log(title = "广告信息" , businessType = BusinessType.INSERT)
    @PostMapping("/create" )
    @ResponseBody
    public AjaxResult create(AdvertiseAddReq req) {
        return toAjax(customAdvertiseService.create(req));
    }

    /**
     * 修改保存广告信息
     */
    @RequiresPermissions("advertise:advertise:edit" )
    @Log(title = "广告信息" , businessType = BusinessType.UPDATE)
    @PostMapping("/update" )
    @ResponseBody
    public AjaxResult update(AdvertiseEditReq req) {
        return toAjax(customAdvertiseService.edit(req));
    }

    /**
     * 修改广告信息
     */
    @GetMapping("/toUpdate/{id}/{canalId}" )
    public String edit(@PathVariable("id" ) Long id,@PathVariable("canalId" ) Long canalId, ModelMap mmap) {
        AdvertiseDescriptionRes advertiseDescription = customAdvertiseService.findAdvertiseDescription(id , canalId);
        mmap.put("advertise" , advertiseDescription);
        return prefix + "/edit" ;
    }

}
