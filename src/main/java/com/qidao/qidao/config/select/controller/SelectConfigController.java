package com.qidao.qidao.config.select.controller;

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
import com.qidao.qidao.config.select.domain.SelectConfig;
import com.qidao.qidao.config.select.service.ISelectConfigService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 选择配置Controller
 *
 * @author autuan
 * @date 2020-12-16
 */
@Controller
@RequestMapping("/config/select")
public class SelectConfigController extends BaseController {
    private String prefix = "qidao/config/select" ;

    @Autowired
    private ISelectConfigService selectConfigService;

    @RequiresPermissions("config:select:view")
    @GetMapping()
    public String select() {
        return prefix + "/select" ;
    }

    @RequiresPermissions("config:select:view")
    @GetMapping("/hotConfig")
    public String hotConfig() {
        return prefix + "/hotIndustry" ;
    }

    /**
     * 查询选择配置列表
     */
    @RequiresPermissions("config:select:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SelectConfig selectConfig) {
        startPage();
        List<SelectConfig> list = selectConfigService.selectSelectConfigList(selectConfig);
        return getDataTable(list);
    }

    /**
     * 导出选择配置列表
     */
    @RequiresPermissions("config:select:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SelectConfig selectConfig) {
        List<SelectConfig> list = selectConfigService.selectSelectConfigList(selectConfig);
        ExcelUtil<SelectConfig> util = new ExcelUtil<SelectConfig>(SelectConfig.class);
        return util.exportExcel(list, "select");
    }

    /**
     * 新增选择配置
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add" ;
    }

    /**
     * 新增保存选择配置
     */
    @RequiresPermissions("config:select:add")
    @Log(title = "选择配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SelectConfig selectConfig) {
        return toAjax(selectConfigService.insertSelectConfig(selectConfig));
    }

    /**
     * 修改选择配置
     */
    @GetMapping("/edit/{id}/{typeName}")
    public String edit(@PathVariable("id") String id,@PathVariable("typeName") String typeName ,ModelMap mmap) {
        SelectConfig selectConfig = selectConfigService.selectSelectConfigById(id);
        selectConfig.setTypeName(typeName);
        mmap.put("selectConfig", selectConfig);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存选择配置
     */
    @RequiresPermissions("config:select:edit")
    @Log(title = "选择配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SelectConfig selectConfig) {
        return toAjax(selectConfigService.updateSelectConfig(selectConfig));
    }

    /**
     * 删除选择配置
     */
    @RequiresPermissions("config:select:remove")
    @Log(title = "选择配置", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(selectConfigService.deleteSelectConfigByIds(ids));
    }

    /**
     * 逻辑删除选择配置
     */
    @RequiresPermissions("config:select:logicRemove")
    @Log(title = "选择配置", businessType = BusinessType.LOGIC_DEL)
    @PostMapping("/logicRemove")
    @ResponseBody
    public AjaxResult logicRemove(String ids) {
        return toAjax(selectConfigService.logicDelByIds(ids));
    }
}
