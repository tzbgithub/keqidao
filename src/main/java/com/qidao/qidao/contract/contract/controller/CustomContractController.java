package com.qidao.qidao.contract.contract.controller;

import com.qidao.framework.web.controller.BaseController;
import com.qidao.framework.web.page.TableDataInfo;
import com.qidao.qidao.contract.contract.domain.Contract;
import com.qidao.qidao.contract.contract.domain.ContractRes;
import com.qidao.qidao.contract.contract.service.CustomContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: xinfeng
 * @create: 2021-03-02 14:58
 */
@Controller
@RequestMapping("/contract/contract")
public class CustomContractController extends BaseController {

    @Autowired
    private CustomContractService customContractService;

    @PostMapping("/getList")
    @ResponseBody
    public TableDataInfo list(Contract contract) {
        startPage();
        List<ContractRes> list = customContractService.selectContractList(contract);
        return getDataTable(list);
    }
}
