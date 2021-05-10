package com.qidao.qidao.server.server.controller;

import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.server.server.domain.*;
import com.qidao.qidao.server.server.service.CustomServerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/server/server")
public class CustomServerController extends BaseController {
    private String prefix = "qidao/server/server" ;

    @Autowired
    private CustomServerService customServerService;

    @PostMapping("/getList")
    @ResponseBody
    public TableDataInfo getList(ServerListReq req) {
        startPage();
        List<ServerListRes> server = customServerService.findServer(req);
        return getDataTable(server);
    }

    /**
     * 撤销服务(需求)
     */
    @RequiresPermissions("server:server:edit" )
    @Log(title = "服务(需求)" , businessType = BusinessType.UPDATE)
    @PutMapping("/revoke/{id}" )
    @ResponseBody
    public AjaxResult revoke(@PathVariable("id")Long id) {
        return toAjax(customServerService.revoke(id));
    }

    /**
     * 新增保存服务(需求)
     */
    @RequiresPermissions("server:server:add" )
    @Log(title = "服务(需求)" , businessType = BusinessType.INSERT)
    @PostMapping("/save" )
    @ResponseBody
    public AjaxResult save(ServerAddReq req) {
        return toAjax(customServerService.saveServer(req));
    }

    /**
     * 查看服务(需求)
     */
    @GetMapping("/look/{id}" )
    public String look(@PathVariable("id" ) Long id, ModelMap mmap) {
        ServerDescriptionRes res = customServerService.serverDescription(id);
        mmap.put("server" , res);
        return prefix + "/description" ;
    }

}
