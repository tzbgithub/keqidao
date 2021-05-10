package com.qidao.qidao.invoice.invoice.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.core.util.ObjectUtil;
import com.qidao.qidao.invoice.invoice.domain.InvoiceRes;
import com.qidao.qidao.invoice.invoice.service.CustomInvoiceService;
import com.qidao.qidao.invoice.invoice.service.InvoiceMemberService;
import com.qidao.qidao.invoice.invoice.service.InvoiceOrderService;
import com.qidao.qidao.member.member.domain.TMember;
import com.qidao.qidao.member.member.service.IMemberService;
import com.qidao.qidao.order.order.domain.TOrder;
import com.qidao.qidao.organization.organization.service.IOrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.qidao.framework.aspectj.lang.annotation.Log;
import com.qidao.framework.aspectj.lang.enums.BusinessType;
import com.qidao.qidao.invoice.invoice. domain.Invoice;
import com.qidao.qidao.invoice.invoice. service.IInvoiceService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 发票Controller
 *
 * @author liule
 * @date 2021-01-19
 */
@Controller
@Slf4j
@RequestMapping("/invoice/invoice" )
public class InvoiceController extends BaseController {
    private String prefix = "qidao/invoice/invoice" ;

    @Autowired
    private IInvoiceService invoiceService;

    @Autowired
    private CustomInvoiceService customInvoiceService;

    @Autowired
    private InvoiceMemberService invoiceMemberService;

    @Autowired
    private InvoiceOrderService invoiceOrderService;

    @Autowired
    private IOrganizationService iOrganizationService;

    @Autowired
    private IMemberService iMemberService;

    @RequiresPermissions("invoice:invoice:view" )
    @GetMapping()
    public String invoice() {
        log.info("InvoiceController -> GET -> start -> invoice");
        log.info("InvoiceController -> GET -> end");
        return prefix + "/invoice" ;
    }

    /**
     * 查询发票列表
     */
    @RequiresPermissions("invoice:invoice:list" )
    @PostMapping("/list" )
    @ResponseBody
    public TableDataInfo list(Invoice invoice) {
        log.info("InvoiceController -> list -> start -> invoice : {}", invoice);
        startPage();
        List<InvoiceRes> list = customInvoiceService.selectInvoiceList(invoice);
        log.info("InvoiceController -> list -> end");
        return getDataTable(list);
    }
    
    /**
     * 导出发票列表
     */
    @RequiresPermissions("invoice:invoice:export" )
    @PostMapping("/export" )
    @ResponseBody
    public AjaxResult export(Invoice invoice) {
        log.info("InvoiceController -> export -> start -> invoice : {}", invoice);
        List<Invoice> list = invoiceService.selectInvoiceList(invoice);
        ExcelUtil<Invoice> util = new ExcelUtil<Invoice>(Invoice. class);
        log.info("InvoiceController -> export -> end");
        return util.exportExcel(list, "invoice" );
    }

    /**
     * 新增发票
     */
    @GetMapping("/add" )
    public String add() {
        log.info("InvoiceController -> GET -> start -> add");
        log.info("InvoiceController -> GET -> add -> end");
        return prefix + "/add" ;
    }
    
    /**
     * 新增保存发票
     */
    @RequiresPermissions("invoice:invoice:add" )
    @Log(title = "发票" , businessType = BusinessType.INSERT)
    @PostMapping("/add" )
    @ResponseBody
    public AjaxResult addSave(Invoice invoice) {
        log.info("InvoiceController -> addSave -> start -> invoice : {}", invoice);
        log.info("InvoiceController -> addSave -> end");
        return toAjax(invoiceService.insertInvoice(invoice));
    }

    /**
     * 修改发票
     */
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap mmap) {
        log.info("InvoiceController -> edit -> start -> id : {}, mmap : {}", id, mmap);
        Invoice invoice =invoiceService.selectInvoiceById(id);
        mmap.put("invoice" , invoice);
        log.info("InvoiceController -> edit -> end");
        return prefix + "/edit" ;
    }

    /**
     * 搜索开票人
     */
    @PostMapping("/searchMemberByNameOrPhone")
    @ResponseBody
    public List<TMember> searchMember(@RequestParam String key, HttpServletRequest request){
        log.info("InvoiceController -> searchMember -> start -> key : {}", key);
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        log.info("InvoiceController -> searchMember -> end ");
        return invoiceMemberService.searchMemberByNameOrPhone(key);
    }

    /**
     *  搜索开票人的未开发票的订单列表
     */
    @PostMapping("/searchOrderIdByMemberId")
    @ResponseBody
    public Map<String, Object> searchOrderByMemberId(String member_id, String keyword){
        log.info("InvoiceController -> searchOrderByMemberId -> start -> member_id : {},  keyword : {}", member_id, keyword);
        List<TOrder> orderList = invoiceOrderService.searchOrderByMemberId(member_id, keyword);
        Map<String, Object> map = new HashMap<>();
        map.put("orderList", orderList);
        log.info("InvoiceController -> searchOrderByMemberId -> end ");
        return map;
    }

    /**
     * 铜鼓开票人ID搜索其所属的组织ID
     */
    @PostMapping("/searchOrganizationIdByMemberId")
    @ResponseBody
    public Map<String, Object> searchOrganizationIdByMemberId(@RequestParam String id){
        log.info("InvoiceController -> searchOrganizationIdByMemberId -> start -> id : {}", id);
        TMember TMember = iMemberService.selectMemberById(id);
        Map<String, Object> map = new HashMap<>();
        log.info("InvoiceController -> searchOrganizationIdByMemberId -> ObjectUtil.isNotEmpty(member) && ObjectUtil.isNotNull(member.getOrganizationId()) : {}", (ObjectUtil.isNotEmpty(TMember) && ObjectUtil.isNotNull(TMember.getOrganizationId())));
        if(ObjectUtil.isNotEmpty(TMember) && ObjectUtil.isNotNull(TMember.getOrganizationId())){
            map.put("organization", iOrganizationService.selectOrganizationById(TMember.getOrganizationId().toString()));
        }else{
            map.put("organization", null);
        }
        log.info("InvoiceController -> searchOrganizationIdByMemberId -> end ");
        return map;
    }

    /**
     * 修改保存发票
     */
    @RequiresPermissions("invoice:invoice:edit" )
    @Log(title = "发票" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(Invoice invoice) {
        log.info("InvoiceController -> editSave -> start -> invoice : {}", invoice);
        log.info("InvoiceController -> editSave -> end");
        return toAjax(invoiceService.updateInvoice(invoice));
    }

    /**
     * 删除发票
     */
    @RequiresPermissions("invoice:invoice:remove" )
    @Log(title = "发票" , businessType = BusinessType.DELETE)
    @PostMapping("/remove" )
    @ResponseBody
    public AjaxResult remove(String ids) {
        log.info("InvoiceController -> remove -> start -> ids : {}", ids);
        log.info("InvoiceController -> remove -> end");
        return toAjax(invoiceService.deleteInvoiceByIds(ids));
    }

    /**
     * 逻辑删除发票
     */
    @RequiresPermissions("invoice:invoice:logicRemove" )
    @Log(title = "发票" , businessType = BusinessType.LOGIC_DEL)
    @PostMapping("/logicRemove" )
    @ResponseBody
    public AjaxResult logicRemove(String ids) {
        log.info("InvoiceController -> logicRemove -> start -> ids : {}", ids);
        log.info("InvoiceController -> logicRemove -> end");
        return toAjax(invoiceService.logicDelByIds(ids));
    }
                                                                                                                    }
