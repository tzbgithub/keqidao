package com.qidao.qidao.canal.canal.controller;

import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.canal.canal.domain.*;
import com.qidao.qidao.canal.canal.service.CustomCanalService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/canal/canal" )
public class CustomCanalController extends BaseController {

    private String prefix = "qidao/canal/canal" ;

    @Autowired
    private CustomCanalService customCanalService;

    /**
     * 查询各包分发渠道列表
     */
    @RequiresPermissions("canal:canal:list" )
    @PostMapping("/getList" )
    @ResponseBody
    public TableDataInfo list(CanalListReq req) {
        startPage();
        List<CanalListRes> list = customCanalService.findCanalList(req);
        return getDataTable(list);
    }

    /**
     * 修改保存各包分发渠道
     */
    @RequiresPermissions("canal:canal:edit" )
    @Log(title = "各包分发渠道" , businessType = BusinessType.UPDATE)
    @GetMapping("/enable/{id}" )
    @ResponseBody
    public int enable(@PathVariable("id")Long id) {
        return customCanalService.enable(id);
    }


    /**
     * 修改保存各包分发渠道
     */
    @RequiresPermissions("canal:canal:edit" )
    @Log(title = "各包分发渠道" , businessType = BusinessType.UPDATE)
    @GetMapping("/close/{id}" )
    @ResponseBody
    public int close(@PathVariable("id")Long id) {
        return customCanalService.close(id);
    }

    /**
     * 新增保存各包分发渠道
     */
    @RequiresPermissions("canal:canal:add" )
    @Log(title = "各包分发渠道" , businessType = BusinessType.INSERT)
    @PostMapping("/save" )
    @ResponseBody
    public AjaxResult save(CanalAddReq req) {
        System.err.println(req);
        return toAjax(customCanalService.save(req));
    }

    /**
     * 查询各包分发渠道列表
     */
    @GetMapping("/findAllCanal" )
    @ResponseBody
    public List<Canal> findAll() {
        return customCanalService.findAllCanal();
    }

}
