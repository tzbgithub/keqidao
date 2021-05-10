package com.qidao.qidao.product.product.controller;

import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.product.product.domain.*;
import com.qidao.qidao.product.product.service.CustomProductService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product/product" )
public class ProductController extends BaseController {

    private String prefix = "qidao/product/product" ;

    @Autowired
    private CustomProductService customProductService;

    /**
     * 查询产品列表
     */
    @RequiresPermissions("product:product:list" )
    @PostMapping("/getList" )
    @ResponseBody
    public TableDataInfo list(ProductReq req) {
        startPage();
        List<ProductRes> list = customProductService.getProduct(req);
        return getDataTable(list);
    }

    @GetMapping("/shelves/{id}" )
    @ResponseBody
    public int shelves(@PathVariable("id" ) Long id) {
        return customProductService.shelves(id);
    }

    @GetMapping("/stockFromSale/{id}" )
    @ResponseBody
    public int stockFromSale(@PathVariable("id" ) Long id) {
        return customProductService.stockFromSale(id);
    }

    /**
     * 新增保存产品
     */
    @RequiresPermissions("product:product:add" )
    @Log(title = "产品" , businessType = BusinessType.INSERT)
    @PostMapping("/create" )
    @ResponseBody
    public AjaxResult create(ProductInsertReq req) {
        return toAjax(customProductService.create(req));
    }

    /**
     * 修改保存产品
     */
    @RequiresPermissions("product:product:edit" )
    @Log(title = "产品" , businessType = BusinessType.UPDATE)
    @PostMapping("/editSave" )
    @ResponseBody
    public AjaxResult editSave(ProductUpdateReq req) {
        return toAjax(customProductService.updateProduct(req));
    }

}
