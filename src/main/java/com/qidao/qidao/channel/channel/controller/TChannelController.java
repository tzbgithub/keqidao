package com.qidao.qidao.channel.channel.controller;

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
import com.qidao.qidao.channel.channel. domain.TChannel;
import com.qidao.qidao.channel.channel. service.ITChannelService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 频道Controller
 *
 * @author yqj
 * @date 2021-02-03
 */
@Controller
@RequestMapping("/channel/channel" )
public class TChannelController extends BaseController {
    private String prefix = "qidao/channel/channel" ;

    @Autowired
    private ITChannelService tChannelService;

    @RequiresPermissions("channel:channel:view" )
    @GetMapping()
    public String channel() {
        return prefix + "/channel" ;
    }

            /**
         * 查询频道列表
         */
        @RequiresPermissions("channel:channel:list" )
        @PostMapping("/list" )
        @ResponseBody
        public TableDataInfo list(TChannel tChannel) {
            startPage();
            List<TChannel> list = tChannelService.selectTChannelList(tChannel);
            return getDataTable(list);
        }
    
    /**
     * 导出频道列表
     */
    @RequiresPermissions("channel:channel:export" )
    @PostMapping("/export" )
    @ResponseBody
    public AjaxResult export(TChannel tChannel) {
        List<TChannel> list = tChannelService.selectTChannelList(tChannel);
        ExcelUtil<TChannel> util = new ExcelUtil<TChannel>(TChannel. class);
        return util.exportExcel(list, "channel" );
    }

            /**
         * 新增频道
         */
        @GetMapping("/add" )
        public String add() {
            return prefix + "/add" ;
        }
    
    /**
     * 新增保存频道
     */
    @RequiresPermissions("channel:channel:add" )
    @Log(title = "频道" , businessType = BusinessType.INSERT)
    @PostMapping("/add" )
    @ResponseBody
    public AjaxResult addSave(TChannel tChannel) {
        return toAjax(tChannelService.insertTChannel(tChannel));
    }

    /**
     * 修改频道
     */
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap mmap) {
        TChannel tChannel =tChannelService.selectTChannelById(id);
        mmap.put("tChannel" , tChannel);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存频道
     */
    @RequiresPermissions("channel:channel:edit" )
    @Log(title = "频道" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(TChannel tChannel) {
        return toAjax(tChannelService.updateTChannel(tChannel));
    }

            /**
         * 删除频道
         */
        @RequiresPermissions("channel:channel:remove" )
        @Log(title = "频道" , businessType = BusinessType.DELETE)
        @PostMapping("/remove" )
        @ResponseBody
        public AjaxResult remove(String ids) {
            return toAjax(tChannelService.deleteTChannelByIds(ids));
        }

                                                                            /**
                 * 逻辑删除频道
                 */
                @RequiresPermissions("channel:channel:logicRemove" )
                @Log(title = "频道" , businessType = BusinessType.LOGIC_DEL)
                @PostMapping("/logicRemove" )
                @ResponseBody
                public AjaxResult logicRemove(String ids) {
                    return toAjax(tChannelService.logicDelByIds(ids));
                }
                                                                                                                                }
