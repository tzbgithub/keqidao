package com.qidao.qidao.config.select.controller;

import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.config.dict.domain.Dict;
import com.qidao.qidao.config.select.domain.CustomSelectConfig;
import com.qidao.qidao.config.select.domain.HotIndustryReq;
import com.qidao.qidao.config.select.domain.SelectConfig;
import com.qidao.qidao.config.select.service.CustomSelectConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/config/select")
public class CustomSelectConfigController extends BaseController {


    @Autowired
    private CustomSelectConfigService selectConfigService;

    @GetMapping("/getAllFather")
    @ResponseBody
    public List<CustomSelectConfig> getAllFather(Integer type){
        return selectConfigService.getAllFather(type);
    }

    @PostMapping("/create")
    @ResponseBody
    public AjaxResult create(CustomSelectConfig selectConfig){
        return toAjax(selectConfigService.create(selectConfig));
    }

    @GetMapping("/updateStatus")
    @ResponseBody
    public int updateStatus(Long id ){
        return selectConfigService.updateStatus(id);
    }

    @GetMapping("/getConfigByType/{type}")
    @ResponseBody
    public List<CustomSelectConfig> getConfigByType(@PathVariable("type") Integer type){
        return selectConfigService.getConfigByType(type);
    }

    @GetMapping("/dict")
    @ResponseBody
    public List<Dict> findDict(){
        return selectConfigService.findDict();
    }

    /**
     * 查询行业列表
     */
    @RequiresPermissions("config:select:list")
    @PostMapping("/hotList")
    @ResponseBody
    public TableDataInfo hotList(HotIndustryReq req) {
        startPage();
        List<CustomSelectConfig> list = selectConfigService.getHotIndustry(req);
        return getDataTable(list);
    }

    @GetMapping("/hot/{id}")
    @ResponseBody
    public int hot(@PathVariable Long id ){
        return selectConfigService.hot(id);
    }

    @GetMapping("/notHot/{id}")
    @ResponseBody
    public int notHot(@PathVariable Long id ){
        return selectConfigService.notHot(id);
    }

}
