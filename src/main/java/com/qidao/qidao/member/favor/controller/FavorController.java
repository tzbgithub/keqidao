package com.qidao.qidao.member.favor. controller;

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
import com.qidao.qidao.member.favor. domain.Favor;
import com.qidao.qidao.member.favor. service.IFavorService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 收藏Controller
 *
 * @author autuan
 * @date 2020-12-24
 */
@Controller
@RequestMapping("/member/favor" )
public class FavorController extends BaseController {
    private String prefix = "qidao/member/favor" ;

    @Autowired
    private IFavorService favorService;

    @RequiresPermissions("member:favor:view" )
    @GetMapping()
    public String favor() {
        return prefix + "/favor" ;
    }

            /**
         * 查询收藏列表
         */
        @RequiresPermissions("member:favor:list" )
        @PostMapping("/list" )
        @ResponseBody
        public TableDataInfo list(Favor favor) {
            startPage();
            List<Favor> list = favorService.selectFavorList(favor);
            return getDataTable(list);
        }
    
    /**
     * 导出收藏列表
     */
    @RequiresPermissions("member:favor:export" )
    @PostMapping("/export" )
    @ResponseBody
    public AjaxResult export(Favor favor) {
        List<Favor> list = favorService.selectFavorList(favor);
        ExcelUtil<Favor> util = new ExcelUtil<Favor>(Favor. class);
        return util.exportExcel(list, "favor" );
    }

            /**
         * 新增收藏
         */
        @GetMapping("/add" )
        public String add() {
            return prefix + "/add" ;
        }
    
    /**
     * 新增保存收藏
     */
    @RequiresPermissions("member:favor:add" )
    @Log(title = "收藏" , businessType = BusinessType.INSERT)
    @PostMapping("/add" )
    @ResponseBody
    public AjaxResult addSave(Favor favor) {
        return toAjax(favorService.insertFavor(favor));
    }

    /**
     * 修改收藏
     */
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap mmap) {
        Favor favor =favorService.selectFavorById(id);
        mmap.put("favor" , favor);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存收藏
     */
    @RequiresPermissions("member:favor:edit" )
    @Log(title = "收藏" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(Favor favor) {
        return toAjax(favorService.updateFavor(favor));
    }

            /**
         * 删除收藏
         */
        @RequiresPermissions("member:favor:remove" )
        @Log(title = "收藏" , businessType = BusinessType.DELETE)
        @PostMapping("/remove" )
        @ResponseBody
        public AjaxResult remove(String ids) {
            return toAjax(favorService.deleteFavorByIds(ids));
        }

                                                                                                                                                                                                                                            /**
                 * 逻辑删除收藏
                 */
                @RequiresPermissions("member:favor:logicRemove" )
                @Log(title = "收藏" , businessType = BusinessType.LOGIC_DEL)
                @PostMapping("/logicRemove" )
                @ResponseBody
                public AjaxResult logicRemove(String ids) {
                    return toAjax(favorService.logicDelByIds(ids));
                }
                                                                                                                                }
