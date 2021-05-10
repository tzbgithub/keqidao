package com.qidao.qidao.salesman.salesman.mapper;

import com.qidao.qidao.salesman.salesman.domain.Salesman;
import com.qidao.qidao.salesman.salesman.domain.SalesmanDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 销售员Mapper接口
 *
 * @author autuan
 * @date 2020-12-23
 */
public interface CustomSalesmanMapper {

    /**
     * 批量重置销售员密码为123456
     *
     * @param salesmanDO 销售员包装类
     * @return 结果
     */
    int resetPasswordSalesmanByIds(SalesmanDO salesmanDO);

    Salesman getSalesmanByName(String name);

    List<Salesman> getSalesman(@Param("code") String code);

}
