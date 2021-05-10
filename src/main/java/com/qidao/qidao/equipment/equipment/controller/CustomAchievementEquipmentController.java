package com.qidao.qidao.equipment.equipment.controller;

import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.equipment.equipment.domain.*;
import com.qidao.qidao.equipment.equipment.service.CustomAchievementEquipmentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 设备/成果Controller
 *
 * @author autuan
 * @date 2021-02-04
 */
@Controller
@RequestMapping("/equipment/equipment")
public class CustomAchievementEquipmentController extends BaseController {
    private String prefix = "qidao/equipment/equipment";

    @Autowired
    private CustomAchievementEquipmentService customAchievementEquipmentService;


    /**
     * 查询设备/成果列表
     */
    @RequiresPermissions("equipment:equipment:list")
    @PostMapping("/getList")
    @ResponseBody
    public TableDataInfo list(AchievementEquipmentPageReq req) {
        startPage();
        List<AchievementEquipmentPageRes> list = customAchievementEquipmentService.findAllEquipment(req);
        return getDataTable(list);
    }

    @GetMapping("/description/{id}")
    public String description(@PathVariable("id") Long id, ModelMap mmap) {
        AchievementEquipmentDescription achievementEquipment = customAchievementEquipmentService.findEquipmentDescription(id);
        mmap.put("achievementEquipment", achievementEquipment);
        return prefix + "/edit";
    }

    @GetMapping("/verify/{id}")
    public String verify(@PathVariable("id") Long id, ModelMap mmap) {
        AchievementEquipmentDescription achievementEquipment = customAchievementEquipmentService.findEquipmentDescription(id);
        mmap.put("achievementEquipment", achievementEquipment);
        return prefix + "/verify";
    }

    @RequiresPermissions("equipment:equipment:edit")
    @Log(title = "设备/成果", businessType = BusinessType.UPDATE)
    @PostMapping("/verifyPass/{id}/{msg}")
    @ResponseBody
    public AjaxResult verifyPass(@PathVariable("id")Long id ,@PathVariable("msg")String msg ){
        return toAjax(customAchievementEquipmentService.verifyPass(id , msg));
    }

    @RequiresPermissions("equipment:equipment:edit")
    @Log(title = "设备/成果", businessType = BusinessType.UPDATE)
    @PostMapping("/verifyFail/{id}/{msg}")
    @ResponseBody
    public AjaxResult verifyFail(@PathVariable("id")Long id ,@PathVariable("msg")String msg){
        return toAjax(customAchievementEquipmentService.verifyFail(id , msg));
    }

    @RequiresPermissions("equipment:equipment:add")
    @Log(title = "设备/成果", businessType = BusinessType.INSERT)
    @PostMapping("/create")
    @ResponseBody
    public AjaxResult create(AchievementEquipmentAddReq req) {
       return toAjax(customAchievementEquipmentService.create(req));
    }
}
