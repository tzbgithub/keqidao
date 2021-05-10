package com.qidao.qidao.salesman.sales.controller;

import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.salesman.sales.domain.*;
import com.qidao.qidao.salesman.sales.service.CustomLinkOrganizationSalesmanService;
import com.qidao.qidao.salesman.sales.service.ILinkOrganizationSalesmanService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: xinfeng
 * @create: 2021-02-01 13:37
 */
@Controller
@Slf4j
@RequestMapping("/salesman/sales")
public class CustomSalesPerformanceController extends BaseController {
    private String prefix = "qidao/salesman/salesman/sales";

    @Autowired
    private CustomLinkOrganizationSalesmanService customLinkOrganizationSalesmanService;

    @Autowired
    private ILinkOrganizationSalesmanService linkOrganizationSalesmanService;

    /**
     * 查询销售关联组织机构列表
     */
    @PostMapping("/getList")
    @ResponseBody
    public TableDataInfo getList(LinkSalesmanQuery linkSalesmanQuery) {
        log.info("CustomSalesPerformanceController -> getList -> start -> linkSalesmanQuery : {}", linkSalesmanQuery);
        startPage();
        List<LinkOrganizationSalesmanRes> list = customLinkOrganizationSalesmanService.getList(linkSalesmanQuery);
        log.info("CustomSalesPerformanceController -> getList -> end ->");
        return getDataTable(list);
    }

    /**
     * 查询销售员的一段时间内的销售业绩
     */
    @RequiresPermissions("salesman:sales:list")
    @PostMapping("/getPerformanceList")
    @ResponseBody
    public TableDataInfo getPerformanceList(LinkSalesmanQuery linkSalesmanQuery) {
        log.info("CustomSalesPerformanceController -> getPerformanceList -> start -> linkSalesmanQuery : {}", linkSalesmanQuery);
        startPage();
        List<SalesPerformanceRes> list = customLinkOrganizationSalesmanService.getPerformanceList(linkSalesmanQuery);
        log.info("CustomSalesPerformanceController -> getPerformanceList -> end");
        return getDataTable(list);
    }

    @GetMapping("/getSalesList/{salesmanId}")
    public String getSalesList(@PathVariable("salesmanId") String salesmanId, ModelMap mmap){
        log.info("CustomSalesPerformanceController -> getSalesList -> GET -> start -> salesmanid : {}, mmap : {}", salesmanId, mmap);
        log.info("CustomSalesPerformanceController -> getSalesList -> GET -> end");
        mmap.put("salesmanId", salesmanId);
        return prefix + "/sales";
    }


    @RequiresPermissions("salesman:sales:view")
    @GetMapping("/power/{id}")
    public String power(@PathVariable Long id,ModelMap map) {
        LinkOrganizationSalesman los = linkOrganizationSalesmanService.selectLinkOrganizationSalesmanById(id);
        map.put("los", los);
        return prefix + "/power";
    }

    @RequiresPermissions("salesman:sales:view")
    @PostMapping("/authorized")
    @ResponseBody
    public AjaxResult authorized( AuthorizedReq req) {
        Integer result = customLinkOrganizationSalesmanService.authorized(req);
//        map.put("los", los);
//        return prefix + "/power";
        return toAjax(result > 0);
    }

    /**
     * 根据销售员ID查询销售员的推广列表
     */
    @PostMapping("/getSalesList")
    @ResponseBody
    public TableDataInfo getSalesList(SalesQuery salesQuery) {
        log.info("CustomSalesPerformanceController -> getSalesList -> start -> salesmanId : {}", salesQuery);
        startPage();
        LinkOrganizationSalesman linkOrganizationSalesman = LinkOrganizationSalesman.builder()
                .salesmanId(Long.valueOf(salesQuery.getSalesmanId()))
                .build();
        List<LinkOrganizationSalesman> list = linkOrganizationSalesmanService.selectLinkOrganizationSalesmanList(linkOrganizationSalesman);
        log.info("CustomSalesPerformanceController -> getSalesList -> end");
        return getDataTable(list);
    }

    /**
     * 导出销售推广列表
     */
    @RequiresPermissions("salesman:sales:export")
    @PostMapping("/exportSales")
    @ResponseBody
    public AjaxResult exportSales(SalesQuery salesQuery) {
        log.info("CustomSalesPerformanceController -> exportSales -> start -> salesQuery : {}", salesQuery);
        List<SalesExcel> list = customLinkOrganizationSalesmanService.export(salesQuery.getSalesmanId());
        ExcelUtil<SalesExcel> util = new ExcelUtil<SalesExcel>(SalesExcel.class);
        log.info("CustomSalesPerformanceController -> exportSales -> end");
        return util.exportExcel(list, "sales");
    }

    /**
     * 导出销售关联组织机构列表
     */
    @RequiresPermissions("salesman:sales:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LinkSalesmanQuery linkSalesmanQuery) {
        log.info("LinkOrganizationSalesmanController -> export -> start -> linkSalesmanQuery : {}", linkSalesmanQuery);
        List<SalesPerformanceRes> list = customLinkOrganizationSalesmanService.getPerformanceList(linkSalesmanQuery);
        ExcelUtil<SalesPerformanceRes> util = new ExcelUtil<SalesPerformanceRes>(SalesPerformanceRes.class);
        log.info("LinkOrganizationSalesmanController -> export -> end");
        return util.exportExcel(list, "performance");
    }
}
