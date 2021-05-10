package com.qidao.qidao.contract.contract.controller;

import java.util.List;

import com.qidao.qidao.contract.contract.domain.ContractDetailRes;
import com.qidao.qidao.contract.contract.domain.ContractExportRes;
import com.qidao.qidao.contract.contract.domain.ContractRes;
import com.qidao.qidao.contract.contract.service.CustomContractService;
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
import com.qidao.qidao.contract.contract.domain.Contract;
import com.qidao.qidao.contract.contract.service.IContractService;
import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.common.utils.poi.ExcelUtil;
import com.qidao.framework.web.page.TableDataInfo;

/**
 * 合同Controller
 *
 * @author autuan
 * @date 2021-03-02
 */
@Controller
@RequestMapping("/contract/contract")
public class ContractController extends BaseController {
    private String prefix = "qidao/contract/contract";

    @Autowired
    private IContractService contractService;
    @Autowired
    private CustomContractService customContractService;

    @RequiresPermissions("contract:contract:view")
    @GetMapping()
    public String contract(ModelMap map) {
        int all = customContractService.allData();
        int yesterdayData = customContractService.getYesterdayData();
        int allMoney = customContractService.allMoney();
        map.put("all", all);
        map.put("yesterdayData", yesterdayData);
        map.put("allMoney", allMoney);
        return prefix + "/contract";
    }

    /**
     * 查询合同列表
     */
    @RequiresPermissions("contract:contract:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Contract contract) {
        startPage();
        List<Contract> list = contractService.selectContractList(contract);
        return getDataTable(list);
    }

    /**
     * 导出合同列表
     */
    @RequiresPermissions("contract:contract:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Contract contract) {
        List<ContractExportRes> list = customContractService.exportContract(contract);
        ExcelUtil<ContractExportRes> util = new ExcelUtil<ContractExportRes>(ContractExportRes.class);
        return util.exportExcel(list, "contract");
    }

    /**
     * 新增合同
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存合同
     */
    @RequiresPermissions("contract:contract:add")
    @Log(title = "合同", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Contract contract) {
        return toAjax(contractService.insertContract(contract));
    }

    /**
     * 修改合同
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        ContractDetailRes contractDetailRes = customContractService.selectContractDetailById(id);
        mmap.put("contract", contractDetailRes);
        return prefix + "/edit";
    }

    /**
     * 修改保存合同
     */
    @RequiresPermissions("contract:contract:edit")
    @Log(title = "合同", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Contract contract) {
        return toAjax(contractService.updateContract(contract));
    }

    /**
     * 删除合同
     */
    @RequiresPermissions("contract:contract:remove")
    @Log(title = "合同", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(contractService.deleteContractByIds(ids));
    }

    /**
     * 逻辑删除合同
     */
    @RequiresPermissions("contract:contract:logicRemove")
    @Log(title = "合同", businessType = BusinessType.LOGIC_DEL)
    @PostMapping("/logicRemove")
    @ResponseBody
    public AjaxResult logicRemove(String ids) {
        return toAjax(contractService.logicDelByIds(ids));
    }
}
