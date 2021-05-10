package com.qidao.qidao.msg.msgMenu.controller;

import java.util.List;

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
import com.qidao.qidao.msg.msgMenu.domain.TMsgMenu;
import com.qidao.qidao.msg.msgMenu.service.ITMsgMenuService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 消息菜单类型Controller
 *
 * @author yqj
 * @date 2021-02-19
 */
@Controller
@RequestMapping("/msg/menu")
public class TMsgMenuController extends BaseController {
    private String prefix = "qidao/msg/menu";

    @Autowired
    private ITMsgMenuService tMsgMenuService;

    @RequiresPermissions("msg:menu:view")
    @GetMapping()
    public String menu() {
        return prefix + "/menu";
    }

    /**
     * 查询消息菜单类型列表
     */
    @RequiresPermissions("msg:menu:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TMsgMenu tMsgMenu) {
        startPage();
        List<TMsgMenu> list = tMsgMenuService.selectTMsgMenuList(tMsgMenu);
        return getDataTable(list);
    }

    /**
     * 导出消息菜单类型列表
     */
    @RequiresPermissions("msg:menu:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TMsgMenu tMsgMenu) {
        List<TMsgMenu> list = tMsgMenuService.selectTMsgMenuList(tMsgMenu);
        ExcelUtil<TMsgMenu> util = new ExcelUtil<TMsgMenu>(TMsgMenu.class);
        return util.exportExcel(list, "menu");
    }

    /**
     * 新增消息菜单类型
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存消息菜单类型
     */
    @RequiresPermissions("msg:menu:add")
    @Log(title = "消息菜单类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TMsgMenu tMsgMenu) {
        System.err.println(tMsgMenu);
        return toAjax(tMsgMenuService.insertTMsgMenu(tMsgMenu));
    }

    /**
     * 修改消息菜单类型
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        TMsgMenu tMsgMenu = tMsgMenuService.selectTMsgMenuById(id);
        mmap.put("tMsgMenu", tMsgMenu);
        System.err.println(tMsgMenu);
        return prefix + "/edit";
    }

    /**
     * 修改保存消息菜单类型
     */
    @RequiresPermissions("msg:menu:edit")
    @Log(title = "消息菜单类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TMsgMenu tMsgMenu) {
        return toAjax(tMsgMenuService.updateTMsgMenu(tMsgMenu));
    }

    /**
     * 删除消息菜单类型
     */
    @RequiresPermissions("msg:menu:remove")
    @Log(title = "消息菜单类型", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tMsgMenuService.deleteTMsgMenuByIds(ids));
    }

    /**
     * 逻辑删除消息菜单类型
     */
    @RequiresPermissions("msg:menu:logicRemove")
    @Log(title = "消息菜单类型", businessType = BusinessType.LOGIC_DEL)
    @PostMapping("/logicRemove")
    @ResponseBody
    public AjaxResult logicRemove(String ids) {
        return toAjax(tMsgMenuService.logicDelByIds(ids));
    }
}
