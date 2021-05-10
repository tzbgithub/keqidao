package com.qidao.qidao.wx.user.controller;

import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.wx.user.service.CustomWxUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import weixin.popular.bean.user.User;

import java.util.List;

/**
 * 微信公众号用户
 *
 * @author tangzhangbin
 * @date 2021/04/15
 */
@Controller
@RequestMapping("/wx/user")
public class CustomWxUserController extends BaseController {

    private String prefix = "qidao/wx/user";

    @Autowired
    CustomWxUserService customWxUserService;

    @RequiresPermissions("wx:user:view" )
    @GetMapping()
    public String user(ModelMap map) {
        int userTotal = customWxUserService.getUserTotal();
        map.put("userTotal", userTotal);
        return prefix + "/user" ;
    }

    /**
     * 查询公众号的用户列表
     * (因为要用到获取用户列表的接口，测试号每天只能调500次，后期建议将用户信息存到数据库，需要同步的时候才同步)
     */
    @RequiresPermissions("wx:user:view")
    @PostMapping("/getList")
    @ResponseBody
    public TableDataInfo list() {
        startPage();
        List<User> list = customWxUserService.userInfoBatchget();
        return getDataTable(list);
    }

}