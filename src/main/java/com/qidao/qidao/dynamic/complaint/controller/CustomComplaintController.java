package com.qidao.qidao.dynamic.complaint.controller;


import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.qidao.config.select.service.ISelectConfigService;
import com.qidao.qidao.dynamic.complaint.domain.Complaint;
import com.qidao.qidao.dynamic.complaint.domain.ComplaintDetails;
import com.qidao.qidao.dynamic.complaint.domain.ComplaintDynamic;
import com.qidao.qidao.dynamic.complaint.service.CustomComplaintService;
import com.qidao.qidao.dynamic.complaint.service.IComplaintService;
import com.qidao.qidao.dynamic.domain.Dynamic;
import com.qidao.qidao.dynamic.domain.TDynamic;
import com.qidao.qidao.dynamic.service.IDynamicService;
import com.qidao.qidao.member.member.service.IMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;

/**
 * @author: xinfeng
 * @create: 2021-01-26 11:11
 */
@Controller
@Slf4j
@RequestMapping("/dynamic/complaint")
public class CustomComplaintController extends BaseController {

    @Autowired
    private IComplaintService iComplaintService;

    @Autowired
    private CustomComplaintService customComplaintService;


    private String prefix = "qidao/dynamic/complaint" ;

    @PostMapping("/reply")
    @Log(title = "动态投诉回复" , businessType = BusinessType.UPDATE)
    @ResponseBody
    public AjaxResult reply(Long id, String reply){
        log.info("CustomComplaintController -> reply -> start -> id : {}, reply : {}", id, reply);
        Complaint complaint = iComplaintService.selectComplaintById(id);
        complaint.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
        complaint.setStatus((long) 2);
        complaint.setReply(reply);
        log.info("CustomComplaintController -> reply -> end");
        return toAjax(iComplaintService.updateComplaint(complaint));
    }

    /**
     * 查看投诉详情
     */
    @GetMapping("/showDetail/{id}" )
    public String showDetail(@PathVariable("id" ) Long id, ModelMap mmap) {
        log.info("CustomComplaintController -> showDetail -> start -> id : {}, mmap : {}", id, mmap);
        ComplaintDetails description = customComplaintService.getDescription(id);
        mmap.put("dynamic" , description);
        log.info("CustomComplaintController -> showDetail -> end");
        return prefix + "/detail" ;
    }
}
