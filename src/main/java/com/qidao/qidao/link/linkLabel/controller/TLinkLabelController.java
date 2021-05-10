package com.qidao.qidao.link.linkLabel.controller;

import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.qidao.link.linkLabel.domain.TLinkLabel;
import com.qidao.qidao.link.linkLabel.service.TLinkLabelService;
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
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;

import java.util.List;

/**
 * 标签中间Controller
 *
 * @author autuan
 * @date 2020-12-28
 */
@Controller
@RequestMapping("/qidao/label")
public class TLinkLabelController extends BaseController {
    private String prefix = "qidao/qidao/label";

    @Autowired
    private TLinkLabelService linkLabelService;

    @RequiresPermissions("qidao:label:view")
    @GetMapping()
    public String label() {
        return prefix + "/label";
    }

    /**
     * 查询标签中间列表
     */
    @RequiresPermissions("qidao:label:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TLinkLabel TLinkLabel) {
        startPage();
        List<TLinkLabel> list = linkLabelService.selectLinkLabelList(TLinkLabel);
        return getDataTable(list);
    }

    /**
     * 导出标签中间列表
     */
    @RequiresPermissions("qidao:label:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TLinkLabel TLinkLabel) {
        List<TLinkLabel> list = linkLabelService.selectLinkLabelList(TLinkLabel);
        ExcelUtil<TLinkLabel> util = new ExcelUtil<TLinkLabel>(TLinkLabel.class);
        return util.exportExcel(list, "label");
    }

    /**
     * 新增标签中间
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存标签中间
     */
    @RequiresPermissions("qidao:label:add")
    @Log(title = "标签中间", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TLinkLabel TLinkLabel) {
        return toAjax(linkLabelService.insertLinkLabel(TLinkLabel));
    }

    /**
     * 修改标签中间
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        TLinkLabel TLinkLabel = linkLabelService.selectLinkLabelById(id);
        mmap.put("TLinkLabel", TLinkLabel);
        return prefix + "/edit";
    }

    /**
     * 修改保存标签中间
     */
    @RequiresPermissions("qidao:label:edit")
    @Log(title = "标签中间", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TLinkLabel TLinkLabel) {
        return toAjax(linkLabelService.updateLinkLabel(TLinkLabel));
    }

    /**
     * 删除标签中间
     */
    @RequiresPermissions("qidao:label:remove")
    @Log(title = "标签中间", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(linkLabelService.deleteLinkLabelByIds(ids));
    }

    /**
     * 逻辑删除标签中间
     */
    @RequiresPermissions("qidao:label:logicRemove")
    @Log(title = "标签中间", businessType = BusinessType.LOGIC_DEL)
    @PostMapping("/logicRemove")
    @ResponseBody
    public AjaxResult logicRemove(String ids) {
        return toAjax(linkLabelService.logicDelByIds(ids));
    }
}
