package com.qidao.qidao.order.order. controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qidao.qidao.order.order.domain.*;
import com.qidao.qidao.order.order.service.CustomOrderService;
import io.swagger.models.auth.In;
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
@RequestMapping("/order/customOrder" )
public class CustomOrderController extends BaseController {
    private String prefix = "qidao/order/order" ;

    @Autowired
    private CustomOrderService customOrderService;

    @RequiresPermissions("order:order:view" )
    @GetMapping()
    public String order() {
        return prefix + "/order" ;
    }

    @GetMapping("/getData")
    @ResponseBody
    public Map<String , Integer> getData(){
        Map<String , Integer> map = new HashMap<>();
        int yesterdayData = customOrderService.getYesterdayData();
        int allData = customOrderService.getAllData();
        map.put("yesterdayData" , yesterdayData);
        map.put("allData" , allData);
        return map;
    }

    /**
     * 查询订单列表
     */
    @RequiresPermissions("order:order:list" )
    @PostMapping("/list" )
    @ResponseBody
    public TableDataInfo list(OrderListReq req) {
        startPage();
        List<OrderListRes> list = customOrderService.selectTOrderList(req);
        return getDataTable(list);
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
        return toAjax(customOrderService.insertTOrder(tOrder));
    }

    /**
     * 修改订单
     */
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap mmap) {
        OrderDetails tOrder =customOrderService.selectTOrderById(id);
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
        return toAjax(customOrderService.updateTOrder(tOrder));
    }

    /**
     * 删除订单
     */
    @RequiresPermissions("order:order:remove" )
    @Log(title = "订单" , businessType = BusinessType.DELETE)
    @PostMapping("/remove" )
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(customOrderService.deleteTOrderByIds(ids));
    }

    /**
     * 逻辑删除订单
     */
    @RequiresPermissions("order:order:logicRemove" )
    @Log(title = "订单" , businessType = BusinessType.LOGIC_DEL)
    @PostMapping("/logicRemove" )
    @ResponseBody
    public AjaxResult logicRemove(String ids) {
        return toAjax(customOrderService.logicDelByIds(ids));
    }
}
