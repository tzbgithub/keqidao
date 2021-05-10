package com.qidao.qidao.invoice.invoice.controller;

import com.qidao.framework.web.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequestMapping("/invoice/invoice")
public class CustomInvoiceController extends BaseController {

    /**
     * 重新发送邮件
     */
    @GetMapping("/resendEmail")
    public void resendEmail(String id){
        log.info("InvoiceController -> resendEmail -> start -> id : {}", id);
        log.info("InvoiceController -> resendEmail -> end");
    }
}
