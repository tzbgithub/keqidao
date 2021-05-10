package com.qidao.qidao.salesman.salesman.controller;

import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.salesman.salesman.domain.Salesman;
import com.qidao.qidao.salesman.salesman.service.ISalesmanService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 销售员Controller
 *
 * @author autuan
 * @date 2020-12-31
 */
@Controller
@RequestMapping("/salesman/salesman")
public class SalesmanController extends BaseController {
    private String prefix = "qidao/salesman/salesman";

    @Autowired
    private ISalesmanService salesmanService;

    @RequiresPermissions("salesman:salesman:view")
    @GetMapping()
    public String salesman() {
        return prefix + "/salesman";
    }

    /**
     * 查询销售员列表
     */
    @RequiresPermissions("salesman:salesman:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Salesman salesman) {
        startPage();
        List<Salesman> list = salesmanService.selectSalesmanList(salesman);
        return getDataTable(list);
    }

    /**
     * 导出销售员列表
     */
    @RequiresPermissions("salesman:salesman:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Salesman salesman) {
        List<Salesman> list = salesmanService.selectSalesmanList(salesman);
        ExcelUtil<Salesman> util = new ExcelUtil<Salesman>(Salesman.class);
        return util.exportExcel(list, "salesman");
    }

    /**
     * 新增销售员
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存销售员
     */
    @RequiresPermissions("salesman:salesman:add")
    @Log(title = "销售员", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Salesman salesman) {
        return toAjax(salesmanService.insertSalesman(salesman));
    }

    /**
     * 修改销售员
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Salesman salesman = salesmanService.selectSalesmanById(id);
        mmap.put("salesman", salesman);
        return prefix + "/edit";
    }

    /**
     * 修改保存销售员
     */
    @RequiresPermissions("salesman:salesman:edit")
    @Log(title = "销售员", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Salesman salesman) {
        return toAjax(salesmanService.updateSalesman(salesman));
    }

    /**
     * 删除销售员
     */
    @RequiresPermissions("salesman:salesman:remove")
    @Log(title = "销售员", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(salesmanService.deleteSalesmanByIds(ids));
    }

    /**
     * 逻辑删除销售员
     */
    @RequiresPermissions("salesman:salesman:logicRemove")
    @Log(title = "销售员", businessType = BusinessType.LOGIC_DEL)
    @PostMapping("/logicRemove")
    @ResponseBody
    public AjaxResult logicRemove(String ids) {
        return toAjax(salesmanService.logicDelByIds(ids));
    }
}
