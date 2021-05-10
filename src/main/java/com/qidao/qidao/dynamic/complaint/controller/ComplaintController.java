package com.qidao.qidao.dynamic.complaint.controller;

import java.util.List;

import com.qidao.qidao.dynamic.complaint.domain.ComplaintRes;
import com.qidao.qidao.dynamic.complaint.service.CustomComplaintService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.qidao.dynamic.complaint.domain.Complaint;
import com.qidao.qidao.dynamic.complaint.service.IComplaintService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 动态投诉Controller
 *
 * @author autuan
 * @date 2021-01-19
 */
@Controller
@Slf4j
@RequestMapping("/dynamic/complaint" )
public class ComplaintController extends BaseController {
    private String prefix = "qidao/dynamic/complaint" ;

    @Autowired
    private IComplaintService complaintService;

    @Autowired
    private CustomComplaintService customComplaintService;

    @RequiresPermissions("dynamic:complaint:view" )
    @GetMapping()
    public String complaint() {
        log.info("ComplaintController -> GET -> complaint -> start");
        log.info("ComplaintController -> GET -> complaint -> end");
        return prefix + "/complaint" ;
    }

    /**
     * 查询动态投诉列表
     */
    @RequiresPermissions("dynamic:complaint:list" )
    @PostMapping("/list" )
    @ResponseBody
    public TableDataInfo list(Complaint complaint) {
        log.info("ComplaintController -> list -> start");
        startPage();
        List<ComplaintRes> list = customComplaintService.selectComplaintList(complaint);
        log.info("ComplaintController -> list -> end");
        return getDataTable(list);
    }
    
    /**
     * 导出动态投诉列表
     */
    @RequiresPermissions("dynamic:complaint:export" )
    @PostMapping("/export" )
    @ResponseBody
    public AjaxResult export(Complaint complaint) {
        log.info("ComplaintController -> export -> start -> complaint : {}", complaint);
        List<Complaint> list = complaintService.selectComplaintList(complaint);
        ExcelUtil<Complaint> util = new ExcelUtil<Complaint>(Complaint. class);
        log.info("ComplaintController -> export -> end");
        return util.exportExcel(list, "complaint" );
    }

    /**
     * 新增动态投诉
     */
    @GetMapping("/add" )
    public String add() {
        log.info("ComplaintController -> GET -> add -> start");
        log.info("ComplaintController -> GET -> add -> end");
        return prefix + "/add" ;
    }
    
    /**
     * 新增保存动态投诉
     */
    @RequiresPermissions("dynamic:complaint:add" )
    @Log(title = "动态投诉" , businessType = BusinessType.INSERT)
    @PostMapping("/add" )
    @ResponseBody
    public AjaxResult addSave(Complaint complaint) {
        log.info("ComplaintController -> addSave -> start -> complaint : {}", complaint);
        log.info("ComplaintController -> addSave -> end");
        return toAjax(complaintService.insertComplaint(complaint));
    }

    /**
     * 修改动态投诉
     */
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap mmap) {
        Complaint complaint =complaintService.selectComplaintById(id);
        mmap.put("complaint" , complaint);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存动态投诉
     */
    @RequiresPermissions("dynamic:complaint:edit" )
    @Log(title = "动态投诉" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(Complaint complaint) {
        log.info("ComplaintController -> editSave -> start -> Complaint : {}", complaint);
        log.info("ComplaintController -> editSave ->end");
        return toAjax(complaintService.updateComplaint(complaint));
    }

    /**
     * 删除动态投诉
     */
    @RequiresPermissions("dynamic:complaint:remove" )
    @Log(title = "动态投诉" , businessType = BusinessType.DELETE)
    @PostMapping("/remove" )
    @ResponseBody
    public AjaxResult remove(String ids) {
        log.info("ComplaintController -> remove -> start -> ids : {}", ids);
        log.info("ComplaintController -> remove -> end");
        return toAjax(complaintService.deleteComplaintByIds(ids));
    }

    /**                                                                                                                                                                                                                  /**
     * 逻辑删除动态投诉
     */
    @RequiresPermissions("dynamic:complaint:logicRemove" )
    @Log(title = "动态投诉" , businessType = BusinessType.LOGIC_DEL)
    @PostMapping("/logicRemove" )
    @ResponseBody
    public AjaxResult logicRemove(String ids) {
        log.info("ComplaintController -> logicRemove -> start -> ids : {}", ids);
        log.info("ComplaintController -> logicRemove -> end");
        return toAjax(complaintService.logicDelByIds(ids));
    }
}
