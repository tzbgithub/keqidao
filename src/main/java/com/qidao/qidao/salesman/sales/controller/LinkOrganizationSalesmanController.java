package com.qidao.qidao.salesman.sales.controller;

import java.util.List;

import com.qidao.qidao.salesman.sales.domain.LinkSalesmanQuery;
import com.qidao.qidao.salesman.sales.domain.SalesPerformanceRes;
import lombok.extern.slf4j.Slf4j;
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
import com.qidao.qidao.salesman.sales.domain.LinkOrganizationSalesman;
import com.qidao.qidao.salesman.sales.service.ILinkOrganizationSalesmanService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 销售关联组织机构Controller
 *
 * @author autuan
 * @date 2021-02-01
 */
@Controller
@Slf4j
@RequestMapping("/salesman/sales")
public class LinkOrganizationSalesmanController extends BaseController {
    private String prefix = "qidao/salesman/salesman/sales";

    @Autowired
    private ILinkOrganizationSalesmanService linkOrganizationSalesmanService;

    @RequiresPermissions("salesman:sales:view")
    @GetMapping()
    public String sales() {
        log.info("LinkOrganizationSalesmanController -> sales ->GET -> start");
        log.info("LinkOrganizationSalesmanController -> sales ->GET -> end");
        return prefix + "/performance";
    }

    /**
     * 查询销售关联组织机构列表
     */
    @RequiresPermissions("salesman:sales:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LinkOrganizationSalesman linkOrganizationSalesman) {
        log.info("LinkOrganizationSalesmanController -> list -> start -> linkOrganizationSalesman : {}", linkOrganizationSalesman);
        startPage();
        List<LinkOrganizationSalesman> list = linkOrganizationSalesmanService.selectLinkOrganizationSalesmanList(linkOrganizationSalesman);
        log.info("LinkOrganizationSalesmanController -> list -> end");
        return getDataTable(list);
    }

    /**
     * 新增销售关联组织机构
     */
    @GetMapping("/add")
    public String add() {
        log.info("LinkOrganizationSalesmanController -> add -> GET -> start");
        log.info("LinkOrganizationSalesmanController -> add -> GET -> end");
        return prefix + "/add";
    }

    /**
     * 新增保存销售关联组织机构
     */
    @RequiresPermissions("salesman:sales:add")
    @Log(title = "销售关联组织机构", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LinkOrganizationSalesman linkOrganizationSalesman) {
        log.info("LinkOrganizationSalesmanController -> addSave -> start -> linkOrganizationSalesman : {}", linkOrganizationSalesman);
        log.info("LinkOrganizationSalesmanController -> addSave -> end");
        return toAjax(linkOrganizationSalesmanService.insertLinkOrganizationSalesman(linkOrganizationSalesman));
    }

    /**
     * 修改销售关联组织机构
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        log.info("LinkOrganizationSalesmanController -> edit -> start -> id : {}, mmap : {}", id, mmap);
        LinkOrganizationSalesman linkOrganizationSalesman = linkOrganizationSalesmanService.selectLinkOrganizationSalesmanById(id);
        mmap.put("linkOrganizationSalesman", linkOrganizationSalesman);
        log.info("LinkOrganizationSalesmanController -> edit -> end");
        return prefix + "/edit";
    }

    /**
     * 修改保存销售关联组织机构
     */
    @RequiresPermissions("salesman:sales:edit")
    @Log(title = "销售关联组织机构", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LinkOrganizationSalesman linkOrganizationSalesman) {
        log.info("LinkOrganizationSalesmanController -> editSave -> start ->  linkOrganizationSalesman : {}", linkOrganizationSalesman);
        log.info("LinkOrganizationSalesmanController -> editSave -> end");
        return toAjax(linkOrganizationSalesmanService.updateLinkOrganizationSalesman(linkOrganizationSalesman));
    }

    /**
     * 删除销售关联组织机构
     */
    @RequiresPermissions("salesman:sales:remove")
    @Log(title = "销售关联组织机构", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        log.info("LinkOrganizationSalesmanController -> remove -> start ->  ids : {}", ids);
        log.info("LinkOrganizationSalesmanController -> remove -> end");
        return toAjax(linkOrganizationSalesmanService.deleteLinkOrganizationSalesmanByIds(ids));
    }

    /**
     * 逻辑删除销售关联组织机构
     */
    @RequiresPermissions("salesman:sales:logicRemove")
    @Log(title = "销售关联组织机构", businessType = BusinessType.LOGIC_DEL)
    @PostMapping("/logicRemove")
    @ResponseBody
    public AjaxResult logicRemove(String ids) {
        log.info("LinkOrganizationSalesmanController -> logicRemove -> start ->  ids : {}", ids);
        log.info("LinkOrganizationSalesmanController -> logicRemove -> end");
        return toAjax(linkOrganizationSalesmanService.logicDelByIds(ids));
    }
}
