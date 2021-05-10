package com.qidao.qidao.member.subscribe.controller;

import com.github.pagehelper.Page;
import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.member.member.domain.Member;
import com.qidao.qidao.member.subscribe.domain.*;
import com.qidao.qidao.member.subscribe.service.ICustomSubscribeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 关注Controller
 *
 * @author autuan
 * @date 2020-12-24
 */
@Slf4j
@Controller
@RequestMapping("/member/subscribe")
public class CustomSubscribeController extends BaseController {
    private String prefix = "qidao/member/subscribe" ;

//    @Autowired
    private ICustomSubscribeService customSubscribeService;

    public CustomSubscribeController(@Autowired ICustomSubscribeService customSubscribeService) {
        this.customSubscribeService = customSubscribeService;
    }

    /**
     * 清空指定会员的关注列表(逻辑删除)
     */
    @RequiresPermissions("member:subscribe:empty")
    @Log(title = "关注", businessType = BusinessType.LOGIC_DEL)
    @PutMapping("/custom/empty")
    @ResponseBody
    public AjaxResult logicRemove(String memberId) {
        log.info("CustomSubscribeController -> logicRemove -> String memberId : {}", memberId);
        AjaxResult ajaxResult = toAjax(customSubscribeService.logicDelByMemberId(memberId));
        log.info("CustomSubscribeController -> logicRemove -> Return AjaxResult : {}", ajaxResult);
        return ajaxResult;
    }

    //getSubscribe
    /**
     * 查询关注列表
     */
    @RequiresPermissions("member:subscribe:list")
    @PostMapping("/getList")
    @ResponseBody
    public TableDataInfo getSubscribe(SubscribeListReq req) {
        startPage();
        Page<SubscribeListRes> list = customSubscribeService.getSubscribe(req);
        return getDataTable(list);
    }

    /**
     * 新增保存关注
     */
    @RequiresPermissions("member:subscribe:add")
    @Log(title = "关注", businessType = BusinessType.INSERT)
    @PostMapping("/create")
    @ResponseBody
    public AjaxResult create(SubscribeAddReq req) {
        return toAjax(customSubscribeService.create(req));
    }

    /**
     * 新增保存关注
     */
    @RequiresPermissions("member:subscribe:add")
    @Log(title = "关注", businessType = BusinessType.INSERT)
    @PostMapping("/createOrganization")
    @ResponseBody
    public AjaxResult createOrganization(SubscribeAddReq req) {
        return toAjax(customSubscribeService.createOrganization(req));
    }

    @GetMapping("/getSubscribeMember/{id}")
    @ResponseBody
    public List<Member> getSubscribeMember(@PathVariable("id") Long id){
        return customSubscribeService.getSubscribeMember(id);
    }

    /**
     * 修改关注
     */
    @GetMapping("/toEdit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        SubscribeToEdit TSubscribe = customSubscribeService.getSubscribeById(id);
        mmap.put("subscribe", TSubscribe);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存关注
     */
    @RequiresPermissions("member:subscribe:edit")
    @Log(title = "关注", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(SubscribeUpdateReq req) {
        System.err.println(req);
        return toAjax(customSubscribeService.update(req));
    }

    @GetMapping("/findSubscribeMember")
    @ResponseBody
    public List<Member> findSubscribeMember(QuerySubscribeMemberReq req){
        return customSubscribeService.findSubscribeMember(req);
    }

    /**
     * todo error ! cannot insert into Spring's container (Autuan)[21.4.1.start]
     * @param req
     * @return
     */
    @GetMapping("/searchSubscribeMember")
    @ResponseBody
    @Deprecated
    private List<Member> searchSubscribeMember(SearchSubscribeMemberReq req){
        return customSubscribeService.searchSubscribeMember(req.getId(), req.getCode());
    }

    /**
     * todo error ! cannot insert into Spring's container (Autuan)[21.4.1.start]
     * @param code
     * @return
     */
    @GetMapping("/findMember/1")
    @ResponseBody
    @Deprecated
    private List<Member> findMember( String code){
        return this.customSubscribeService.findMember(code);
    }

    @RequestMapping("/listMember")
    @ResponseBody
    Object listMember( String code) {
        return customSubscribeService.findMember(code);
    }


    @RequestMapping("/listSubscribeMember")
    @ResponseBody
    Object listMember(SearchSubscribeMemberReq req) {
        return customSubscribeService.searchSubscribeMember(req.getId() , req.getCode());
    }

    @RequestMapping("/listOrganization")
    @ResponseBody
    Object listOrganization(SearchSubscribeMemberReq req) {
        return customSubscribeService.listOrganization(req.getId() , req.getCode());
    }

}
