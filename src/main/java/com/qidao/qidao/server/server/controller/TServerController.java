package com.qidao.qidao.server.server. controller;

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
import com.qidao.qidao.server.server. domain.TServer;
import com.qidao.qidao.server.server. service.ITServerService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 服务(需求)Controller
 *
 * @author yqj
 * @date 2021-02-18
 */
@Controller
@RequestMapping("/server/server" )
public class TServerController extends BaseController {
    private String prefix = "qidao/server/server" ;

    @Autowired
    private ITServerService tServerService;

    @RequiresPermissions("server:server:view" )
    @GetMapping()
    public String server() {
        return prefix + "/server" ;
    }

            /**
         * 查询服务(需求)列表
         */
        @RequiresPermissions("server:server:list" )
        @PostMapping("/list" )
        @ResponseBody
        public TableDataInfo list(TServer tServer) {
            startPage();
            List<TServer> list = tServerService.selectTServerList(tServer);
            return getDataTable(list);
        }
    
    /**
     * 导出服务(需求)列表
     */
    @RequiresPermissions("server:server:export" )
    @PostMapping("/export" )
    @ResponseBody
    public AjaxResult export(TServer tServer) {
        List<TServer> list = tServerService.selectTServerList(tServer);
        ExcelUtil<TServer> util = new ExcelUtil<TServer>(TServer. class);
        return util.exportExcel(list, "server" );
    }

            /**
         * 新增服务(需求)
         */
        @GetMapping("/add" )
        public String add() {
            return prefix + "/add" ;
        }
    
    /**
     * 新增保存服务(需求)
     */
    @RequiresPermissions("server:server:add" )
    @Log(title = "服务(需求)" , businessType = BusinessType.INSERT)
    @PostMapping("/add" )
    @ResponseBody
    public AjaxResult addSave(TServer tServer) {
        return toAjax(tServerService.insertTServer(tServer));
    }

    /**
     * 修改服务(需求)
     */
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap mmap) {
        TServer tServer =tServerService.selectTServerById(id);
        mmap.put("tServer" , tServer);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存服务(需求)
     */
    @RequiresPermissions("server:server:edit" )
    @Log(title = "服务(需求)" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(TServer tServer) {
        return toAjax(tServerService.updateTServer(tServer));
    }

            /**
         * 删除服务(需求)
         */
        @RequiresPermissions("server:server:remove" )
        @Log(title = "服务(需求)" , businessType = BusinessType.DELETE)
        @PostMapping("/remove" )
        @ResponseBody
        public AjaxResult remove(String ids) {
            return toAjax(tServerService.deleteTServerByIds(ids));
        }

                                                                                                                                                                                                                                                                                                                                                                                                            /**
                 * 逻辑删除服务(需求)
                 */
                @RequiresPermissions("server:server:logicRemove" )
                @Log(title = "服务(需求)" , businessType = BusinessType.LOGIC_DEL)
                @PostMapping("/logicRemove" )
                @ResponseBody
                public AjaxResult logicRemove(String ids) {
                    return toAjax(tServerService.logicDelByIds(ids));
                }
                                                                                                                                }
