package com.qidao.qidao.msg.msgRecord. controller;

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
import com.qidao.qidao.msg.msgRecord. domain.TMsgRecord;
import com.qidao.qidao.msg.msgRecord. service.ITMsgRecordService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 用户-消息Controller
 *
 * @author yqj
 * @date 2021-02-22
 */
@Controller
@RequestMapping("/msg/msgRecord" )
public class TMsgRecordController extends BaseController {
    private String prefix = "qidao/msg/msgRecord" ;

    @Autowired
    private ITMsgRecordService tMsgRecordService;

    @RequiresPermissions("msg:msgRecord:view" )
    @GetMapping()
    public String msgRecord() {
        return prefix + "/msgRecord" ;
    }

            /**
         * 查询用户-消息列表
         */
        @RequiresPermissions("msg:msgRecord:list" )
        @PostMapping("/list" )
        @ResponseBody
        public TableDataInfo list(TMsgRecord tMsgRecord) {
            startPage();
            List<TMsgRecord> list = tMsgRecordService.selectTMsgRecordList(tMsgRecord);
            return getDataTable(list);
        }
    
    /**
     * 导出用户-消息列表
     */
    @RequiresPermissions("msg:msgRecord:export" )
    @PostMapping("/export" )
    @ResponseBody
    public AjaxResult export(TMsgRecord tMsgRecord) {
        List<TMsgRecord> list = tMsgRecordService.selectTMsgRecordList(tMsgRecord);
        ExcelUtil<TMsgRecord> util = new ExcelUtil<TMsgRecord>(TMsgRecord. class);
        return util.exportExcel(list, "msgRecord" );
    }

            /**
         * 新增用户-消息
         */
        @GetMapping("/add" )
        public String add() {
            return prefix + "/add" ;
        }
    
    /**
     * 新增保存用户-消息
     */
    @RequiresPermissions("msg:msgRecord:add" )
    @Log(title = "用户-消息" , businessType = BusinessType.INSERT)
    @PostMapping("/add" )
    @ResponseBody
    public AjaxResult addSave(TMsgRecord tMsgRecord) {
        return toAjax(tMsgRecordService.insertTMsgRecord(tMsgRecord));
    }

    /**
     * 修改用户-消息
     */
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap mmap) {
        TMsgRecord tMsgRecord =tMsgRecordService.selectTMsgRecordById(id);
        mmap.put("tMsgRecord" , tMsgRecord);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存用户-消息
     */
    @RequiresPermissions("msg:msgRecord:edit" )
    @Log(title = "用户-消息" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(TMsgRecord tMsgRecord) {
        return toAjax(tMsgRecordService.updateTMsgRecord(tMsgRecord));
    }

            /**
         * 删除用户-消息
         */
        @RequiresPermissions("msg:msgRecord:remove" )
        @Log(title = "用户-消息" , businessType = BusinessType.DELETE)
        @PostMapping("/remove" )
        @ResponseBody
        public AjaxResult remove(String ids) {
            return toAjax(tMsgRecordService.deleteTMsgRecordByIds(ids));
        }

                                                                            /**
                 * 逻辑删除用户-消息
                 */
                @RequiresPermissions("msg:msgRecord:logicRemove" )
                @Log(title = "用户-消息" , businessType = BusinessType.LOGIC_DEL)
                @PostMapping("/logicRemove" )
                @ResponseBody
                public AjaxResult logicRemove(String ids) {
                    return toAjax(tMsgRecordService.logicDelByIds(ids));
                }
                                                                                                                                                                                            }
