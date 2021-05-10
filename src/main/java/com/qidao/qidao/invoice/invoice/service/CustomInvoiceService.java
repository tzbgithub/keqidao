package com.qidao.qidao.invoice.invoice.service;


import com.qidao.qidao.invoice.invoice.domain.Invoice;
import com.qidao.qidao.invoice.invoice.domain.InvoiceRes;

import java.util.List;

public interface CustomInvoiceService {

    /**
     * 查询发票列表
     *
     * @param invoice
     * @return 查询结果
     */
    List<InvoiceRes> selectInvoiceList(Invoice invoice);
}
