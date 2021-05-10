package com.qidao.project.system.page.controller;

import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.project.system.page.service.IPageService;
import com.qidao.qidao.config.other.domain.IndexCountRes;
import com.qidao.qidao.config.other.domain.IndexLineChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller
@RequestMapping("/system/main")
public class PageController extends BaseController {
    @Autowired
    private IPageService pageService;

    /**
     * 首页跳转
     * @return
     */
    @GetMapping("")
    public ModelAndView main(ModelAndView mav) {
        mav.setViewName("main");

        LocalDate yesterday = LocalDate.now().minusDays(1L);
        LocalDateTime yesterdayBegin = LocalDateTime.of(yesterday, LocalTime.MIN);
        LocalDateTime yesterdayEnd = LocalDateTime.of(yesterday, LocalTime.MAX);

        IndexCountRes yesterdayCount = pageService.indexCount(yesterdayBegin, yesterdayEnd);

        IndexLineChart chart = pageService.indexLineChart(30);

        mav.addObject("yesterdayCount", yesterdayCount);
        mav.addObject("chart", chart);

        return mav;
    }

    @PostMapping("/indexLineChart")
    @ResponseBody
    public AjaxResult indexLineChart(@RequestBody Integer recentDay){
        IndexLineChart chart = pageService.indexLineChart(30);
        return AjaxResult.success(chart);
    }
}
