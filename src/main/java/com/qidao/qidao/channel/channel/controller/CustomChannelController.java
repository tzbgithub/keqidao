package com.qidao.qidao.channel.channel.controller;

import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.channel.channel.domain.ChannelListRes;
import com.qidao.qidao.channel.channel.domain.TChannel;
import com.qidao.qidao.channel.channel.service.CustomChannelService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/channel/channel")
public class CustomChannelController extends BaseController {
    private String prefix = "qidao/channel/channel" ;

    @Autowired
    private CustomChannelService customChannelService;

    /**
     * 查询频道列表
     */
    @RequiresPermissions("channel:channel:list" )
    @PostMapping("/getList" )
    @ResponseBody
    public TableDataInfo list() {
        startPage();
        List<ChannelListRes> list = customChannelService.getChannelList();
        return getDataTable(list);
    }

    @RequiresPermissions("channel:channel:edit" )
    @GetMapping("/stockFromSale/{id}" )
    @ResponseBody
    public int stockFromSale(@PathVariable("id")Long id) {
        return customChannelService.stockFromSale(id);
    }

    @RequiresPermissions("channel:channel:edit" )
    @GetMapping("/shelves/{id}" )
    @ResponseBody
    public int shelves(@PathVariable("id")Long id) {
        return customChannelService.shelves(id);
    }
}
