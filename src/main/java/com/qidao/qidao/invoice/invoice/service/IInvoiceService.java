package com.qidao.qidao.invoice.invoice.service;

import com.qidao.qidao.invoice.invoice.domain.Invoice;
import java.util.List;

/**
 * 发票Service接口
 * 
 * @author liule
 * @date 2021-01-19
 */
public interface IInvoiceService {
    /**
     * 查询发票
     * 
     * @param id 发票ID
     * @return 发票
     */
    Invoice selectInvoiceById(Long id);

    /**
     * 查询发票列表
     * 
     * @param invoice 发票
     * @return 发票集合
     */
    List<Invoice> selectInvoiceList(Invoice invoice);

    /**
     * 新增发票
     * 
     * @param invoice 发票
     * @return 结果
     */
    int insertInvoice(Invoice invoice);

    /**
     * 修改发票
     * 
     * @param invoice 发票
     * @return 结果
     */
    int updateInvoice(Invoice invoice);

    /**
     * 批量删除发票
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteInvoiceByIds(String ids);

    /**
     * 删除发票信息
     * 
     * @param id 发票ID
     * @return 结果
     */
    int deleteInvoiceById(Long id);

                                                                                                                        int logicDelByIds(String ids);
                                                                        }
