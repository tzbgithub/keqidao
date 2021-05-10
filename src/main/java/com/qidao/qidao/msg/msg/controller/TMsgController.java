package com.qidao.qidao.msg.msg. controller;

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
import com.qidao.qidao.msg.msg. domain.TMsg;
import com.qidao.qidao.msg.msg. service.ITMsgService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 消息Controller
 *
 * @author yqj
 * @date 2021-02-19
 */
@Controller
@RequestMapping("/msg/msg" )
public class TMsgController extends BaseController {
    private String prefix = "qidao/msg/msg" ;

    @Autowired
    private ITMsgService tMsgService;

    @RequiresPermissions("msg:msg:view" )
    @GetMapping()
    public String msg() {
        return prefix + "/msg" ;
    }

            /**
         * 查询消息列表
         */
        @RequiresPermissions("msg:msg:list" )
        @PostMapping("/list" )
        @ResponseBody
        public TableDataInfo list(TMsg tMsg) {
            startPage();
            List<TMsg> list = tMsgService.selectTMsgList(tMsg);
            return getDataTable(list);
        }
    
    /**
     * 导出消息列表
     */
    @RequiresPermissions("msg:msg:export" )
    @PostMapping("/export" )
    @ResponseBody
    public AjaxResult export(TMsg tMsg) {
        List<TMsg> list = tMsgService.selectTMsgList(tMsg);
        ExcelUtil<TMsg> util = new ExcelUtil<TMsg>(TMsg. class);
        return util.exportExcel(list, "msg" );
    }

            /**
         * 新增消息
         */
        @GetMapping("/add" )
        public String add() {
            return prefix + "/add" ;
        }
    
    /**
     * 新增保存消息
     */
    @RequiresPermissions("msg:msg:add" )
    @Log(title = "消息" , businessType = BusinessType.INSERT)
    @PostMapping("/add" )
    @ResponseBody
    public AjaxResult addSave(TMsg tMsg) {
        return toAjax(tMsgService.insertTMsg(tMsg));
    }

    /**
     * 修改消息
     */
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap mmap) {
        TMsg tMsg =tMsgService.selectTMsgById(id);
        mmap.put("tMsg" , tMsg);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存消息
     */
    @RequiresPermissions("msg:msg:edit" )
    @Log(title = "消息" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(TMsg tMsg) {
        return toAjax(tMsgService.updateTMsg(tMsg));
    }

            /**
         * 删除消息
         */
        @RequiresPermissions("msg:msg:remove" )
        @Log(title = "消息" , businessType = BusinessType.DELETE)
        @PostMapping("/remove" )
        @ResponseBody
        public AjaxResult remove(String ids) {
            return toAjax(tMsgService.deleteTMsgByIds(ids));
        }

                                                                                                                    /**
                 * 逻辑删除消息
                 */
                @RequiresPermissions("msg:msg:logicRemove" )
                @Log(title = "消息" , businessType = BusinessType.LOGIC_DEL)
                @PostMapping("/logicRemove" )
                @ResponseBody
                public AjaxResult logicRemove(String ids) {
                    return toAjax(tMsgService.logicDelByIds(ids));
                }
                                                                                                                                                                                                                                                                                                }
