package com.qidao.qidao.salesman.salesman.controller;

import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.qidao.salesman.salesman.domain.Salesman;
import com.qidao.qidao.salesman.salesman.service.ICustomSalesmanService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2020/12/30 10:41 AM
 */
@Slf4j
@Controller
@RequestMapping("/salesman/salesman")
public class CustomSalesmanController extends BaseController {
    private String prefix = "qidao/salesman/salesman";

    @Autowired
    private ICustomSalesmanService iCustomSalesmanService;

    /**
     * 新增销售员
     */
    @GetMapping("/custom/add")
    public String customAdd() {
        return prefix + "/custom/add";
    }

    /**
     * 新增保存销售员
     */
    @RequiresPermissions("salesman:salesman:add")
    @Log(title = "销售员", businessType = BusinessType.INSERT)
    @PostMapping("/custom/add")
    @ResponseBody
    public AjaxResult customAddSave(Salesman salesman) {
        log.info("CustomSalesmanController -> customAddSave -> Salesman salesman : {}", salesman);
        AjaxResult ajaxResult = toAjax(iCustomSalesmanService.insertSalesman(salesman));
        log.info("CustomSalesmanController -> customAddSave -> Return AjaxResult : {}", ajaxResult);
        return ajaxResult;
    }

    /**
     * 重置密码为123456
     */
    @RequiresPermissions("salesman:salesman:resetPassword")
    @Log(title = "销售员", businessType = BusinessType.UPDATE)
    @PutMapping("/custom/resetPassword")
    @ResponseBody
    public AjaxResult resetPassword(String ids) {
        log.info("CustomSalesmanController -> resetPassword -> String ids : {}", ids);
        AjaxResult ajaxResult = toAjax(iCustomSalesmanService.resetPasswordSalesmanByIds(ids));
        log.info("CustomSalesmanController -> resetPassword -> Return AjaxResult : {}", ajaxResult);
        return ajaxResult;
    }

    @GetMapping("/getListSalesman")
    @ResponseBody
     Object getListSalesman(String code){
        return iCustomSalesmanService.getSalesman(code);
    }

}
