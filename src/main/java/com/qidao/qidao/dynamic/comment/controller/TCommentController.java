package com.qidao.qidao.dynamic.comment. controller;

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
import com.qidao.qidao.dynamic.comment. domain.TComment;
import com.qidao.qidao.dynamic.comment. service.ITCommentService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 评论Controller
 *
 * @author autuan
 * @date 2021-01-29
 */
@Controller
@RequestMapping("/dynamic/comment" )
public class TCommentController extends BaseController {
    private String prefix = "qidao/dynamic/comment" ;

    @Autowired
    private ITCommentService tCommentService;

    @RequiresPermissions("dynamic:comment:view" )
    @GetMapping()
    public String comment() {
        return prefix + "/comment" ;
    }

            /**
         * 查询评论列表
         */
        @RequiresPermissions("dynamic:comment:list" )
        @PostMapping("/list" )
        @ResponseBody
        public TableDataInfo list(TComment tComment) {
            startPage();
            List<TComment> list = tCommentService.selectTCommentList(tComment);
            return getDataTable(list);
        }
    
    /**
     * 导出评论列表
     */
    @RequiresPermissions("dynamic:comment:export" )
    @PostMapping("/export" )
    @ResponseBody
    public AjaxResult export(TComment tComment) {
        List<TComment> list = tCommentService.selectTCommentList(tComment);
        ExcelUtil<TComment> util = new ExcelUtil<TComment>(TComment. class);
        return util.exportExcel(list, "comment" );
    }

            /**
         * 新增评论
         */
        @GetMapping("/add" )
        public String add() {
            return prefix + "/add" ;
        }
    
    /**
     * 新增保存评论
     */
    @RequiresPermissions("dynamic:comment:add" )
    @Log(title = "评论" , businessType = BusinessType.INSERT)
    @PostMapping("/add" )
    @ResponseBody
    public AjaxResult addSave(TComment tComment) {
        return toAjax(tCommentService.insertTComment(tComment));
    }

    /**
     * 修改评论
     */
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap mmap) {
        TComment tComment =tCommentService.selectTCommentById(id);
        mmap.put("tComment" , tComment);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存评论
     */
    @RequiresPermissions("dynamic:comment:edit" )
    @Log(title = "评论" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(TComment tComment) {
        return toAjax(tCommentService.updateTComment(tComment));
    }

            /**
         * 删除评论
         */
        @RequiresPermissions("dynamic:comment:remove" )
        @Log(title = "评论" , businessType = BusinessType.DELETE)
        @PostMapping("/remove" )
        @ResponseBody
        public AjaxResult remove(String ids) {
            return toAjax(tCommentService.deleteTCommentByIds(ids));
        }

                                                                                                                                                                                /**
                 * 逻辑删除评论
                 */
                @RequiresPermissions("dynamic:comment:logicRemove" )
                @Log(title = "评论" , businessType = BusinessType.LOGIC_DEL)
                @PostMapping("/logicRemove" )
                @ResponseBody
                public AjaxResult logicRemove(String ids) {
                    return toAjax(tCommentService.logicDelByIds(ids));
                }
                                                                                                                                }
