package com.qidao.qidao.canal.canal. controller;

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
import com.qidao.qidao.canal.canal. domain.TCanal;
import com.qidao.qidao.canal.canal. service.ITCanalService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 各包分发渠道Controller
 *
 * @author yqj
 * @date 2021-02-18
 */
@Controller
@RequestMapping("/canal/canal" )
public class TCanalController extends BaseController {
    private String prefix = "qidao/canal/canal" ;

    @Autowired
    private ITCanalService tCanalService;

    @RequiresPermissions("canal:canal:view" )
    @GetMapping()
    public String canal() {
        return prefix + "/canal" ;
    }

            /**
         * 查询各包分发渠道列表
         */
        @RequiresPermissions("canal:canal:list" )
        @PostMapping("/list" )
        @ResponseBody
        public TableDataInfo list(TCanal tCanal) {
            startPage();
            List<TCanal> list = tCanalService.selectTCanalList(tCanal);
            return getDataTable(list);
        }
    
    /**
     * 导出各包分发渠道列表
     */
    @RequiresPermissions("canal:canal:export" )
    @PostMapping("/export" )
    @ResponseBody
    public AjaxResult export(TCanal tCanal) {
        List<TCanal> list = tCanalService.selectTCanalList(tCanal);
        ExcelUtil<TCanal> util = new ExcelUtil<TCanal>(TCanal. class);
        return util.exportExcel(list, "canal" );
    }

            /**
         * 新增各包分发渠道
         */
        @GetMapping("/add" )
        public String add() {
            return prefix + "/add" ;
        }
    
    /**
     * 新增保存各包分发渠道
     */
    @RequiresPermissions("canal:canal:add" )
    @Log(title = "各包分发渠道" , businessType = BusinessType.INSERT)
    @PostMapping("/add" )
    @ResponseBody
    public AjaxResult addSave(TCanal tCanal) {
        return toAjax(tCanalService.insertTCanal(tCanal));
    }

    /**
     * 修改各包分发渠道
     */
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap mmap) {
        TCanal tCanal =tCanalService.selectTCanalById(id);
        mmap.put("tCanal" , tCanal);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存各包分发渠道
     */
    @RequiresPermissions("canal:canal:edit" )
    @Log(title = "各包分发渠道" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(TCanal tCanal) {
        return toAjax(tCanalService.updateTCanal(tCanal));
    }

            /**
         * 删除各包分发渠道
         */
        @RequiresPermissions("canal:canal:remove" )
        @Log(title = "各包分发渠道" , businessType = BusinessType.DELETE)
        @PostMapping("/remove" )
        @ResponseBody
        public AjaxResult remove(String ids) {
            return toAjax(tCanalService.deleteTCanalByIds(ids));
        }

                                                                                                /**
                 * 逻辑删除各包分发渠道
                 */
                @RequiresPermissions("canal:canal:logicRemove" )
                @Log(title = "各包分发渠道" , businessType = BusinessType.LOGIC_DEL)
                @PostMapping("/logicRemove" )
                @ResponseBody
                public AjaxResult logicRemove(String ids) {
                    return toAjax(tCanalService.logicDelByIds(ids));
                }
                                                                                                                                }
