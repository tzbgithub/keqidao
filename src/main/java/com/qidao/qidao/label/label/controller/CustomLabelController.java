package com.qidao.qidao.label.label.controller;

import com.qidao.framework.web.controller.BaseController;
import com.qidao.qidao.label.label.domain.Label;
import com.qidao.qidao.label.label.service.CustomLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("label/label")
public class CustomLabelController extends BaseController {

    @Autowired
    private CustomLabelService customLabelService;

    @GetMapping("/getByMemberId/{memberId}")
    @ResponseBody
    public List<Label> getByMemberId(@PathVariable("memberId") Long memberId){
        return customLabelService.getByMemberId(memberId);
    }

    @GetMapping("/getByOrganizationId/{organizationId}")
    @ResponseBody
    public List<Label> getByOrganizationId(@PathVariable("organizationId") Long organizationId){
        return customLabelService.getByMemberId(organizationId);
    }

}
