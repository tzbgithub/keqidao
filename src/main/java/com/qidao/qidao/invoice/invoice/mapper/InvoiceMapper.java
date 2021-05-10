package com.qidao.qidao.invoice.invoice.mapper;

import com.qidao.qidao.invoice.invoice.domain.Invoice;
import java.util.List;

/**
 * 发票Mapper接口
 * 
 * @author liule
 * @date 2021-01-19
 */
public interface InvoiceMapper {
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
     * 删除发票
     * 
     * @param id 发票ID
     * @return 结果
     */
    int deleteInvoiceById(Long id);

    /**
     * 批量删除发票
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteInvoiceByIds(String[] ids);

                                                                                                                                    int logicDelByIds(String[] ids);
                                                                        }
