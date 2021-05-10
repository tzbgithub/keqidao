package com.qidao.qidao.advertise.advertise. controller;

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
import com.qidao.qidao.advertise.advertise. domain.TAdvertise;
import com.qidao.qidao.advertise.advertise. service.ITAdvertiseService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 广告信息Controller
 *
 * @author autuan
 * @date 2021-02-23
 */
@Controller
@RequestMapping("/advertise/advertise" )
public class TAdvertiseController extends BaseController {
    private String prefix = "qidao/advertise/advertise" ;

    @Autowired
    private ITAdvertiseService tAdvertiseService;

    @RequiresPermissions("advertise:advertise:view" )
    @GetMapping()
    public String advertise() {
        return prefix + "/advertise" ;
    }

            /**
         * 查询广告信息列表
         */
        @RequiresPermissions("advertise:advertise:list" )
        @PostMapping("/list" )
        @ResponseBody
        public TableDataInfo list(TAdvertise tAdvertise) {
            startPage();
            List<TAdvertise> list = tAdvertiseService.selectTAdvertiseList(tAdvertise);
            return getDataTable(list);
        }
    
    /**
     * 导出广告信息列表
     */
    @RequiresPermissions("advertise:advertise:export" )
    @PostMapping("/export" )
    @ResponseBody
    public AjaxResult export(TAdvertise tAdvertise) {
        List<TAdvertise> list = tAdvertiseService.selectTAdvertiseList(tAdvertise);
        ExcelUtil<TAdvertise> util = new ExcelUtil<TAdvertise>(TAdvertise. class);
        return util.exportExcel(list, "advertise" );
    }

            /**
         * 新增广告信息
         */
        @GetMapping("/add" )
        public String add() {
            return prefix + "/add" ;
        }
    
    /**
     * 新增保存广告信息
     */
    @RequiresPermissions("advertise:advertise:add" )
    @Log(title = "广告信息" , businessType = BusinessType.INSERT)
    @PostMapping("/add" )
    @ResponseBody
    public AjaxResult addSave(TAdvertise tAdvertise) {
        return toAjax(tAdvertiseService.insertTAdvertise(tAdvertise));
    }

    /**
     * 修改广告信息
     */
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap mmap) {
        TAdvertise tAdvertise =tAdvertiseService.selectTAdvertiseById(id);
        mmap.put("tAdvertise" , tAdvertise);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存广告信息
     */
    @RequiresPermissions("advertise:advertise:edit" )
    @Log(title = "广告信息" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(TAdvertise tAdvertise) {
        return toAjax(tAdvertiseService.updateTAdvertise(tAdvertise));
    }

            /**
         * 删除广告信息
         */
        @RequiresPermissions("advertise:advertise:remove" )
        @Log(title = "广告信息" , businessType = BusinessType.DELETE)
        @PostMapping("/remove" )
        @ResponseBody
        public AjaxResult remove(String ids) {
            return toAjax(tAdvertiseService.deleteTAdvertiseByIds(ids));
        }

                                    /**
                 * 逻辑删除广告信息
                 */
                @RequiresPermissions("advertise:advertise:logicRemove" )
                @Log(title = "广告信息" , businessType = BusinessType.LOGIC_DEL)
                @PostMapping("/logicRemove" )
                @ResponseBody
                public AjaxResult logicRemove(String ids) {
                    return toAjax(tAdvertiseService.logicDelByIds(ids));
                }
                                                                                                                                                                                                                                                                                                }
