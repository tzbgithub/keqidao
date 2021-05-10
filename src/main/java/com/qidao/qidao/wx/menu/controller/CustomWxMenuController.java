package com.qidao.qidao.wx.menu.controller;

import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.channel.channel.domain.TChannel;
import com.qidao.qidao.wx.menu.dto.MenuCreateForm;
import com.qidao.qidao.wx.menu.service.CustomWxMenuService;
import com.qidao.qidao.wx.menu.vo.MenuButtonName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import weixin.popular.bean.BaseResult;

import java.util.List;

/**
 * 微信公众号菜单
 * @author tangzhangbin
 * @date 2021/04/15
 */
@Controller
@RequestMapping("/wx/menu")
public class CustomWxMenuController extends BaseController {
    private String prefix = "qidao/wx/menu" ;

    @Autowired
    CustomWxMenuService customWxMenuService;
    @RequiresPermissions("wx:menu:view")
    @GetMapping()
    public String menu(ModelMap map) {
        return prefix + "/menu" ;
    }
    /**
     * 查询菜单
     */
    @PostMapping("/showMenu")
    @ResponseBody
    public TableDataInfo list() {
        startPage();
        List<MenuButtonName> list = customWxMenuService.getMenuName();
        return getDataTable(list);
    }

    /**
     * 新增频道
     */
    @GetMapping("/add" )
    public String add() {
        return prefix + "/add" ;
    }

    /**
     * 新增保存频道
     */
    @RequiresPermissions("wx:menu:add")
    @Log(title = "菜单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MenuCreateForm menuCreateForm) {
        BaseResult result = customWxMenuService.createMenu(menuCreateForm);
        boolean flag;
        if (result.isSuccess()) {
            flag = true;
        } else {
            flag = false;
        }
        return toAjax(flag);
    }

    /**
     * 删除频道
     */
    @RequiresPermissions("wx:menu:remove" )
    @Log(title = "菜单" , businessType = BusinessType.DELETE)
    @PostMapping("/remove" )
    @ResponseBody
    public AjaxResult remove() {
        return toAjax(customWxMenuService.deleteMenu());
    }


}
