package com.qidao.qidao.member.subscribe.controller;

import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.member.subscribe.domain.TSubscribe;
import com.qidao.qidao.member.subscribe.service.ISubscribeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 关注Controller
 *
 * @author autuan
 * @date 2020-12-24
 */
@Controller
@RequestMapping("/member/subscribe")
public class TSubscribeController extends BaseController {
    private String prefix = "qidao/member/subscribe" ;

    @Autowired
    private ISubscribeService subscribeService;

    @RequiresPermissions("member:subscribe:view")
    @GetMapping()
    public String subscribe() {
        return prefix + "/subscribe" ;
    }

    /**
     * 查询关注列表
     */
    @RequiresPermissions("member:subscribe:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TSubscribe TSubscribe) {
        startPage();
        List<TSubscribe> list = subscribeService.selectSubscribeList(TSubscribe);
        return getDataTable(list);
    }

    /**
     * 导出关注列表
     */
    @RequiresPermissions("member:subscribe:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TSubscribe TSubscribe) {
        List<TSubscribe> list = subscribeService.selectSubscribeList(TSubscribe);
        ExcelUtil<TSubscribe> util = new ExcelUtil<TSubscribe>(TSubscribe.class);
        return util.exportExcel(list, "subscribe");
    }

    /**
     * 新增关注
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add" ;
    }

    /**
     * 新增保存关注
     */
    @RequiresPermissions("member:subscribe:add")
    @Log(title = "关注", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TSubscribe TSubscribe) {
        return toAjax(subscribeService.insertSubscribe(TSubscribe));
    }

    /**
     * 修改关注
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        TSubscribe TSubscribe = subscribeService.selectSubscribeById(id);
        mmap.put("subscribe", TSubscribe);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存关注
     */
    @RequiresPermissions("member:subscribe:edit")
    @Log(title = "关注", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TSubscribe TSubscribe) {
        return toAjax(subscribeService.updateSubscribe(TSubscribe));
    }

    /**
     * 删除关注
     */
    @RequiresPermissions("member:subscribe:remove")
    @Log(title = "关注", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(subscribeService.deleteSubscribeByIds(ids));
    }

    /**
     * 逻辑删除关注
     */
    @RequiresPermissions("member:subscribe:logicRemove")
    @Log(title = "关注", businessType = BusinessType.LOGIC_DEL)
    @PostMapping("/logicRemove")
    @ResponseBody
    public AjaxResult logicRemove(String ids) {
        return toAjax(subscribeService.logicDelByIds(ids));
    }
}
