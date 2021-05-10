package com.qidao.qidao.dynamic.controller;

import java.util.List;

import com.qidao.qidao.dynamic.domain.TDynamic;
import com.qidao.qidao.dynamic.service.CustomDynamicService;
import com.qidao.qidao.dynamic.service.IDynamicService;
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
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 动态Controller
 *
 * @author yqj
 * @date 2021-01-25
 */
@Controller
@RequestMapping("/dynamic" )
public class DynamicController extends BaseController {
    private String prefix = "qidao/dynamic" ;

    @Autowired
    private IDynamicService dynamicService;

    @Autowired
    private CustomDynamicService customDynamicService;

    @RequiresPermissions("qidao:dynamic:view" )
    @GetMapping()
    public String dynamic( ModelMap map) {
        int all = customDynamicService.allData();
        int yesterdayData = customDynamicService.getYesterdayData();
        int verifyData = customDynamicService.verifyData();
        map.put("all",all);
        map.put("yesterdayData",yesterdayData);
        map.put("verifyData",verifyData);
        return prefix + "/dynamic" ;
    }

            /**
         * 查询动态列表
         */
        @RequiresPermissions("qidao:TDynamic:list" )
        @PostMapping("/list" )
        @ResponseBody
        public TableDataInfo list(TDynamic TDynamic) {
            startPage();
            List<TDynamic> list = dynamicService.selectDynamicList(TDynamic);
            return getDataTable(list);
        }
    
    /**
     * 导出动态列表
     */
    @RequiresPermissions("qidao:TDynamic:export" )
    @PostMapping("/export" )
    @ResponseBody
    public AjaxResult export(TDynamic TDynamic) {
        List<TDynamic> list = dynamicService.selectDynamicList(TDynamic);
        ExcelUtil<TDynamic> util = new ExcelUtil<TDynamic>(TDynamic. class);
        return util.exportExcel(list, "TDynamic" );
    }

            /**
         * 新增动态
         */
        @GetMapping("/add" )
        public String add() {
            return prefix + "/add" ;
        }
    
    /**
     * 新增保存动态
     */
    @RequiresPermissions("qidao:TDynamic:add" )
    @Log(title = "动态" , businessType = BusinessType.INSERT)
    @PostMapping("/add" )
    @ResponseBody
    public AjaxResult addSave(TDynamic TDynamic) {
        return toAjax(dynamicService.insertDynamic(TDynamic));
    }

    /**
     * 修改动态
     */
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap mmap) {
        TDynamic TDynamic =dynamicService.selectDynamicById(id);
        mmap.put("TDynamic" , TDynamic);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存动态
     */
    @RequiresPermissions("qidao:TDynamic:edit" )
    @Log(title = "动态" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(TDynamic TDynamic) {
        return toAjax(dynamicService.updateDynamic(TDynamic));
    }

            /**
         * 删除动态
         */
        @RequiresPermissions("qidao:dynamic:remove" )
        @Log(title = "动态" , businessType = BusinessType.DELETE)
        @PostMapping("/remove" )
        @ResponseBody
        public AjaxResult remove(String ids) {
            return toAjax(dynamicService.deleteDynamicByIds(ids));
        }

                                                                                                                                                                                                                                                                                                                                                                    /**
                 * 逻辑删除动态
                 */
                @RequiresPermissions("qidao:dynamic:logicRemove" )
                @Log(title = "动态" , businessType = BusinessType.LOGIC_DEL)
                @PostMapping("/logicRemove" )
                @ResponseBody
                public AjaxResult logicRemove(String ids) {
                    return toAjax(dynamicService.logicDelByIds(ids));
                }
                                                                                                                                }
