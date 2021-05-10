package com.qidao.qidao.equipment.equipment.controller;

import java.util.List;

import com.qidao.qidao.equipment.equipment.domain.TAchievementEquipment;
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
import com.qidao.qidao.equipment.equipment.service.IAchievementEquipmentService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 设备/成果Controller
 *
 * @author autuan
 * @date 2021-02-04
 */
@Controller
@RequestMapping("/equipment/equipment")
public class AchievementEquipmentController extends BaseController {
    private String prefix = "qidao/equipment/equipment";

    @Autowired
    private IAchievementEquipmentService achievementEquipmentService;

    @RequiresPermissions("equipment:equipment:view")
    @GetMapping()
    public String equipment() {
        return prefix + "/equipment";
    }

    /**
     * 查询设备/成果列表
     */
    @RequiresPermissions("equipment:equipment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TAchievementEquipment TAchievementEquipment) {
        startPage();
        List<TAchievementEquipment> list = achievementEquipmentService.selectAchievementEquipmentList(TAchievementEquipment);
        return getDataTable(list);
    }

    /**
     * 导出设备/成果列表
     */
    @RequiresPermissions("equipment:equipment:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TAchievementEquipment TAchievementEquipment) {
        List<TAchievementEquipment> list = achievementEquipmentService.selectAchievementEquipmentList(TAchievementEquipment);
        ExcelUtil<TAchievementEquipment> util = new ExcelUtil<TAchievementEquipment>(TAchievementEquipment.class);
        return util.exportExcel(list, "equipment");
    }

    /**
     * 新增设备/成果
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存设备/成果
     */
    @RequiresPermissions("equipment:equipment:add")
    @Log(title = "设备/成果", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TAchievementEquipment TAchievementEquipment) {
        return toAjax(achievementEquipmentService.insertAchievementEquipment(TAchievementEquipment));
    }

    /**
     * 修改设备/成果
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        TAchievementEquipment TAchievementEquipment = achievementEquipmentService.selectAchievementEquipmentById(id);
        mmap.put("achievementEquipment", TAchievementEquipment);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备/成果
     */
    @RequiresPermissions("equipment:equipment:edit")
    @Log(title = "设备/成果", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TAchievementEquipment TAchievementEquipment) {
        return toAjax(achievementEquipmentService.updateAchievementEquipment(TAchievementEquipment));
    }

    /**
     * 删除设备/成果
     */
    @RequiresPermissions("equipment:equipment:remove")
    @Log(title = "设备/成果", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(achievementEquipmentService.deleteAchievementEquipmentByIds(ids));
    }

    /**
     * 逻辑删除设备/成果
     */
    @RequiresPermissions("equipment:equipment:logicRemove")
    @Log(title = "设备/成果", businessType = BusinessType.LOGIC_DEL)
    @PostMapping("/logicRemove")
    @ResponseBody
    public AjaxResult logicRemove(String ids) {
        return toAjax(achievementEquipmentService.logicDelByIds(ids));
    }
}
