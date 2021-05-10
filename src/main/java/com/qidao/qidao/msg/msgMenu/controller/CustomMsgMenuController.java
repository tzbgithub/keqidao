package com.qidao.qidao.msg.msgMenu.controller;

import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.msg.msgMenu.domain.MsgMenu;
import com.qidao.qidao.msg.msgMenu.domain.MsgMenuListRes;
import com.qidao.qidao.msg.msgMenu.service.CustomMsgMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/msg/menu")
public class CustomMsgMenuController extends BaseController {

    private String prefix = "qidao/msg/menu" ;

    @Autowired
    private CustomMsgMenuService customMsgMenuService;


    /**
     * 查询消息菜单类型列表供添加消息使用
     */
    @GetMapping("/getList" )
    @ResponseBody
    public List<MsgMenu> getList() {
        return customMsgMenuService.getMsgMenu();
    }

    /**
     * 查询消息菜单类型列表
     */
    @RequiresPermissions("msg:menu:list" )
    @PostMapping("/getList" )
    @ResponseBody
    public TableDataInfo list() {
        startPage();
        List<MsgMenuListRes> list = customMsgMenuService.findMsgMenuList();
        return getDataTable(list);
    }

    /**
     * 上架
     */
    @RequiresPermissions("msg:menu:edit" )
    @Log(title = "消息菜单类型" , businessType = BusinessType.UPDATE)
    @PutMapping("/open/{id}" )
    @ResponseBody
    public AjaxResult open(@PathVariable("id") Long id) {
        return toAjax(customMsgMenuService.open(id));
    }

    /**
     * 下架
     */
    @RequiresPermissions("msg:menu:edit" )
    @Log(title = "消息菜单类型" , businessType = BusinessType.UPDATE)
    @PutMapping("/close/{id}" )
    @ResponseBody
    public AjaxResult close(@PathVariable("id") Long id) {
        return toAjax(customMsgMenuService.close(id));
    }

    /**
     * 查询消息菜单类型列表
     */
    @RequiresPermissions("msg:menu:list" )
    @GetMapping("/getFather/{id}" )
    @ResponseBody
    public List<MsgMenu> getFather(@PathVariable("id")Long id) {
        return customMsgMenuService.findFather(id);

    }

    /**
     * 修改保存消息菜单类型
     */
    @RequiresPermissions("msg:menu:edit" )
    @Log(title = "消息菜单类型" , businessType = BusinessType.UPDATE)
    @PostMapping("/update" )
    @ResponseBody
    public AjaxResult update(MsgMenu msgMenu) {
        return toAjax(customMsgMenuService.update(msgMenu));
    }

    /**
     * 查询消息菜单类型列表
     */
    @RequiresPermissions("msg:menu:list" )
    @PostMapping("/getSonByPid/{pid}" )
    @ResponseBody
    public List<MsgMenu> getSonByPid(@PathVariable("pid")Long pid) {
        return customMsgMenuService.findSonByPid(pid);
    }
}
