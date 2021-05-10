package com.qidao.qidao.salesman.salesman.service;

import com.qidao.qidao.salesman.salesman.domain.Salesman;

import java.util.List;

/**
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2020/12/30 10:45 AM
 */
public interface ICustomSalesmanService {
    /**
     * 新增销售员
     *
     * @param salesman 销售员
     * @return 结果
     */
    int insertSalesman(Salesman salesman);

    /**
     * 批量重置销售员密码为123456
     *
     * @param ids 需要重置密码的销售员ID
     * @return 结果
     */
    int resetPasswordSalesmanByIds(String ids);

    List<Salesman> getSalesman(String code);
}
