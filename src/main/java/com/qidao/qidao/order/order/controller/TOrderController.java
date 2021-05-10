package com.qidao.qidao.order.order. controller;

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
import com.qidao.qidao.order.order. domain.TOrder;
import com.qidao.qidao.order.order. service.ITOrderService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 订单Controller
 *
 * @author yqj
 * @date 2021-02-02
 */
@Controller
@RequestMapping("/order/order" )
public class TOrderController extends BaseController {
    private String prefix = "qidao/order/order" ;

    @Autowired
    private ITOrderService tOrderService;

    @RequiresPermissions("order:order:view" )
    @GetMapping()
    public String order() {
        return prefix + "/order" ;
    }

            /**
         * 查询订单列表
         */
        @RequiresPermissions("order:order:list" )
        @PostMapping("/list" )
        @ResponseBody
        public TableDataInfo list(TOrder tOrder) {
            startPage();
            List<TOrder> list = tOrderService.selectTOrderList(tOrder);
            return getDataTable(list);
        }
    
    /**
     * 导出订单列表
     */
    @RequiresPermissions("order:order:export" )
    @PostMapping("/export" )
    @ResponseBody
    public AjaxResult export(TOrder tOrder) {
        List<TOrder> list = tOrderService.selectTOrderList(tOrder);
        ExcelUtil<TOrder> util = new ExcelUtil<TOrder>(TOrder. class);
        return util.exportExcel(list, "order" );
    }

            /**
         * 新增订单
         */
        @GetMapping("/add" )
        public String add() {
            return prefix + "/add" ;
        }
    
    /**
     * 新增保存订单
     */
    @RequiresPermissions("order:order:add" )
    @Log(title = "订单" , businessType = BusinessType.INSERT)
    @PostMapping("/add" )
    @ResponseBody
    public AjaxResult addSave(TOrder tOrder) {
        return toAjax(tOrderService.insertTOrder(tOrder));
    }

    /**
     * 修改订单
     */
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap mmap) {
        TOrder tOrder =tOrderService.selectTOrderById(id);
        mmap.put("tOrder" , tOrder);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存订单
     */
    @RequiresPermissions("order:order:edit" )
    @Log(title = "订单" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(TOrder tOrder) {
        return toAjax(tOrderService.updateTOrder(tOrder));
    }

            /**
         * 删除订单
         */
        @RequiresPermissions("order:order:remove" )
        @Log(title = "订单" , businessType = BusinessType.DELETE)
        @PostMapping("/remove" )
        @ResponseBody
        public AjaxResult remove(String ids) {
            return toAjax(tOrderService.deleteTOrderByIds(ids));
        }

                                                                                                                                                                                                                        /**
                 * 逻辑删除订单
                 */
                @RequiresPermissions("order:order:logicRemove" )
                @Log(title = "订单" , businessType = BusinessType.LOGIC_DEL)
                @PostMapping("/logicRemove" )
                @ResponseBody
                public AjaxResult logicRemove(String ids) {
                    return toAjax(tOrderService.logicDelByIds(ids));
                }
                                                                                                                                }
