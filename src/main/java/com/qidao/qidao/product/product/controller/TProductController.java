package com.qidao.qidao.product.product. controller;

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
import com.qidao.qidao.product.product. domain.TProduct;
import com.qidao.qidao.product.product. service.ITProductService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 产品Controller
 *
 * @author yqj
 * @date 2021-02-01
 */
@Controller
@RequestMapping("/product/product" )
public class TProductController extends BaseController {
    private String prefix = "qidao/product/product" ;

    @Autowired
    private ITProductService tProductService;

    @RequiresPermissions("product:product:view" )
    @GetMapping()
    public String product() {
        return prefix + "/product" ;
    }

            /**
         * 查询产品列表
         */
        @RequiresPermissions("product:product:list" )
        @PostMapping("/list" )
        @ResponseBody
        public TableDataInfo list(TProduct tProduct) {
            startPage();
            List<TProduct> list = tProductService.selectTProductList(tProduct);
            return getDataTable(list);
        }
    
    /**
     * 导出产品列表
     */
    @RequiresPermissions("product:product:export" )
    @PostMapping("/export" )
    @ResponseBody
    public AjaxResult export(TProduct tProduct) {
        List<TProduct> list = tProductService.selectTProductList(tProduct);
        ExcelUtil<TProduct> util = new ExcelUtil<TProduct>(TProduct. class);
        return util.exportExcel(list, "product" );
    }

            /**
         * 新增产品
         */
        @GetMapping("/add" )
        public String add() {
            return prefix + "/add" ;
        }
    
    /**
     * 新增保存产品
     */
    @RequiresPermissions("product:product:add" )
    @Log(title = "产品" , businessType = BusinessType.INSERT)
    @PostMapping("/add" )
    @ResponseBody
    public AjaxResult addSave(TProduct tProduct) {
        return toAjax(tProductService.insertTProduct(tProduct));
    }

    /**
     * 修改产品
     */
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap mmap) {
        TProduct tProduct =tProductService.selectTProductById(id);
        mmap.put("tProduct" , tProduct);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存产品
     */
    @RequiresPermissions("product:product:edit" )
    @Log(title = "产品" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(TProduct tProduct) {
        return toAjax(tProductService.updateTProduct(tProduct));
    }

            /**
         * 删除产品
         */
        @RequiresPermissions("product:product:remove" )
        @Log(title = "产品" , businessType = BusinessType.DELETE)
        @PostMapping("/remove" )
        @ResponseBody
        public AjaxResult remove(String ids) {
            return toAjax(tProductService.deleteTProductByIds(ids));
        }

                                                                                                                                                                                                                        /**
                 * 逻辑删除产品
                 */
                @RequiresPermissions("product:product:logicRemove" )
                @Log(title = "产品" , businessType = BusinessType.LOGIC_DEL)
                @PostMapping("/logicRemove" )
                @ResponseBody
                public AjaxResult logicRemove(String ids) {
                    return toAjax(tProductService.logicDelByIds(ids));
                }
                                                                                                                                }
