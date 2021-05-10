package com.qidao.qidao.invoice.invoice.service.impl;

import java.util.List;
import com.qidao.common.utils.security.ShiroUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.invoice.invoice.mapper.InvoiceMapper;
import com.qidao.qidao.invoice.invoice.domain.Invoice;
import com.qidao.qidao.invoice.invoice.service.IInvoiceService;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;

import javax.annotation.Resource;


/**
 * 发票Service业务层处理
 *
 * @date 2021-01-19
 */
@Service
@Slf4j
public class InvoiceServiceImpl implements IInvoiceService {
    @Autowired
    private InvoiceMapper invoiceMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;
    /**
     * 查询发票
     *
     * @param id 发票ID
     * @return 发票
     */
    @Override
    public Invoice selectInvoiceById(Long id) {
        log.info("InvoiceServiceImpl -> selectInvoiceById -> start -> id : {}", id);
        log.info("InvoiceServiceImpl -> selectInvoiceById -> end");
        return invoiceMapper.selectInvoiceById(id);
    }

    /**
     * 查询发票列表
     *
     * @param invoice 发票
     * @return 发票
     */
    @Override
    public List<Invoice> selectInvoiceList(Invoice invoice) {
        log.info("InvoiceServiceImpl -> selectInvoiceList -> start -> invoice : {}", invoice);
        log.info("InvoiceServiceImpl -> selectInvoiceList -> end");
        return invoiceMapper.selectInvoiceList(invoice);
    }

    /**
     * 新增发票
     *
     * @param invoice 发票
     * @return 结果
     */
    @Override
    public int insertInvoice(Invoice invoice) {
        log.info("InvoiceServiceImpl -> insertInvoice -> start -> invoice : {}", invoice);
        invoice.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
        invoice.setId(snowflakeIdWorker.nextId());
        log.info("InvoiceServiceImpl -> insertInvoice -> end");
        return invoiceMapper.insertInvoice(invoice);
    }

    /**
     * 修改发票
     *
     * @param invoice 发票
     * @return 结果
     */
    @Override
    public int updateInvoice(Invoice invoice) {
        log.info("InvoiceServiceImpl -> updateInvoice -> start -> invoice : {}", invoice);
        invoice.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));
        log.info("InvoiceServiceImpl -> updateInvoice -> end");
        return invoiceMapper.updateInvoice(invoice);
    }

    /**
     * 删除发票对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteInvoiceByIds(String ids) {
        log.info("InvoiceServiceImpl -> deleteInvoiceByIds -> start -> ids : {}", ids);
        log.info("InvoiceServiceImpl -> deleteInvoiceByIds -> end");
        return invoiceMapper.deleteInvoiceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除发票信息
     *
     * @param id 发票ID
     * @return 结果
     */
    @Override
    public int deleteInvoiceById(Long id) {
        log.info("InvoiceServiceImpl -> deleteInvoiceById -> start -> id : {}", id);
        log.info("InvoiceServiceImpl -> deleteInvoiceById -> end");
        return invoiceMapper.deleteInvoiceById(id);
    }
    
    /**
     * 逻辑删除发票对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int logicDelByIds(String ids) {
        log.info("InvoiceServiceImpl -> logicDelByIds -> start -> ids : {}", ids);
        log.info("InvoiceServiceImpl -> logicDelByIds -> end");
        return invoiceMapper.logicDelByIds(Convert.toStrArray(ids));
    }
}
