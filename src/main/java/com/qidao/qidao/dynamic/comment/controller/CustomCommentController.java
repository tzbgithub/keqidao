package com.qidao.qidao.dynamic.comment.controller;


import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.dynamic.comment.domain.CommentPageRes;
import com.qidao.qidao.dynamic.comment.domain.TComment;
import com.qidao.qidao.dynamic.comment.service.CustomCommentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 评论Controller
 *
 * @author autuan
 * @date 2021-01-29
 */
@Controller
@RequestMapping("/dynamic/comment" )
public class CustomCommentController extends BaseController {

    @Autowired
    private CustomCommentService customCommentService;

    private String prefix = "qidao/dynamic/comment" ;

    @RequiresPermissions("dynamic:comment:list" )
    @PostMapping("/getList/{id}" )
    @ResponseBody
    public TableDataInfo list(@PathVariable("id")Long id) {
        startPage();
        List<CommentPageRes> list = customCommentService.getComment(id);
        return getDataTable(list);
    }

    /**
     * 审核通过
     */
    @RequiresPermissions("dynamic:comment:edit" )
    @Log(title = "评论" , businessType = BusinessType.UPDATE)
    @PutMapping("/verifyPass/{id}/{dynamicId}" )
    @ResponseBody
    public AjaxResult verifyPass(@PathVariable("id") Long id,@PathVariable("dynamicId") Long dynamicId) {
        return toAjax(customCommentService.verifyPass(id , dynamicId));
    }

    /**
     * 审核失败
     */
    @RequiresPermissions("dynamic:comment:edit" )
    @Log(title = "评论" , businessType = BusinessType.UPDATE)
    @PutMapping("/verifyFail/{id}")
    @ResponseBody
    public AjaxResult verifyFail(@PathVariable("id") Long id) {
        return toAjax(customCommentService.verifyFail(id));
    }

    /**
     * 撤销
     */
    @RequiresPermissions("dynamic:comment:edit" )
    @Log(title = "评论" , businessType = BusinessType.UPDATE)
    @PutMapping("/callBack/{id}" )
    @ResponseBody
    public AjaxResult callBack(@PathVariable("id") Long id) {
        return toAjax(customCommentService.callBack(id));
    }

    /**
     * 删除评论
     */
    @RequiresPermissions("dynamic:comment:remove" )
    @Log(title = "评论" , businessType = BusinessType.DELETE)
    @PostMapping("/delete/{id}/{dynamic}" )
    @ResponseBody
    public AjaxResult delete(@PathVariable("id")Long id , @PathVariable("dynamic")Long dynamic) {
        return toAjax(customCommentService.delete(id , dynamic));
    }

}
