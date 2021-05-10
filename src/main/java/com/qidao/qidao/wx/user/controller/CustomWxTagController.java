package com.qidao.qidao.wx.user.controller;

import com.qidao.framework.web.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 微信公众号用户
 * @author tangzhangbin
 * @date 2021/04/15
 */
@Controller
@RequestMapping("/wx/tag")
public class CustomWxTagController extends BaseController {
    private String prefix = "qidao/wx/tag" ;

    @RequiresPermissions("wx:tag:view")
    @GetMapping()
    public String user() {
        return prefix + "/tag-list" ;
    }

}