package com.qidao.qidao.organization.organization.controller;

import java.util.List;

import com.qidao.qidao.organization.organization.domain.TOrganization;
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
import com.qidao.qidao.organization.organization. service.IOrganizationService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 组织机构Controller
 *
 * @author autuan
 * @date 2020-12-17
 */
@Controller
@RequestMapping("/organization/organization" )
public class OrganizationController extends BaseController {
    private String prefix = "qidao/organization/organization" ;

    @Autowired
    private IOrganizationService organizationService;

    @RequiresPermissions("organization:organization:view" )
    @GetMapping()
    public String organization() {
        return prefix + "/organization" ;
    }

            /**
         * 查询组织机构列表
         */
        @RequiresPermissions("organization:organization:list" )
        @PostMapping("/list" )
        @ResponseBody
        public TableDataInfo list(TOrganization TOrganization) {
            startPage();
            List<TOrganization> list = organizationService.selectOrganizationList(TOrganization);
            return getDataTable(list);
        }
    
    /**
     * 导出组织机构列表
     */
    @RequiresPermissions("organization:organization:export" )
    @PostMapping("/export" )
    @ResponseBody
    public AjaxResult export(TOrganization TOrganization) {
        List<TOrganization> list = organizationService.selectOrganizationList(TOrganization);
        ExcelUtil<TOrganization> util = new ExcelUtil<TOrganization>(TOrganization. class);
        return util.exportExcel(list, "organization" );
    }

            /**
         * 新增组织机构
         */
        @GetMapping("/add" )
        public String add() {
            return prefix + "/add" ;
        }
    
    /**
     * 新增保存组织机构
     */
    @RequiresPermissions("organization:organization:add" )
    @Log(title = "组织机构" , businessType = BusinessType.INSERT)
    @PostMapping("/add" )
    @ResponseBody
    public AjaxResult addSave(TOrganization TOrganization) {
        return toAjax(organizationService.insertOrganization(TOrganization));
    }

    /**
     * 修改组织机构
     */
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) String id, ModelMap mmap) {
        TOrganization TOrganization =organizationService.selectOrganizationById(id);
        mmap.put("organization" , TOrganization);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存组织机构
     */
    @RequiresPermissions("organization:organization:edit" )
    @Log(title = "组织机构" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(TOrganization TOrganization) {
        return toAjax(organizationService.updateOrganization(TOrganization));
    }

            /**
         * 删除组织机构
         */
        @RequiresPermissions("organization:organization:remove" )
        @Log(title = "组织机构" , businessType = BusinessType.DELETE)
        @PostMapping("/remove" )
        @ResponseBody
        public AjaxResult remove(String ids) {
            return toAjax(organizationService.deleteOrganizationByIds(ids));
        }

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        /**
                 * 逻辑删除组织机构
                 */
                @RequiresPermissions("organization:organization:logicRemove" )
                @Log(title = "组织机构" , businessType = BusinessType.LOGIC_DEL)
                @PostMapping("/logicRemove" )
                @ResponseBody
                public AjaxResult logicRemove(String ids) {
                    return toAjax(organizationService.logicDelByIds(ids));
                }
                                                                                                                                }
