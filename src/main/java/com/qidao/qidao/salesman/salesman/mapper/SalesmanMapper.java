package com.qidao.qidao.salesman.salesman.mapper;

import com.qidao.qidao.salesman.salesman.domain.Salesman;

import java.util.List;

/**
 * 销售员Mapper接口
 *
 * @author autuan
 * @date 2020-12-31
 */
public interface SalesmanMapper {
    /**
     * 查询销售员
     *
     * @param id 销售员ID
     * @return 销售员
     */
    Salesman selectSalesmanById(Long id);

    /**
     * 查询销售员列表
     *
     * @param salesman 销售员
     * @return 销售员集合
     */
    List<Salesman> selectSalesmanList(Salesman salesman);

    /**
     * 新增销售员
     *
     * @param salesman 销售员
     * @return 结果
     */
    int insertSalesman(Salesman salesman);

    /**
     * 修改销售员
     *
     * @param salesman 销售员
     * @return 结果
     */
    int updateSalesman(Salesman salesman);

    /**
     * 删除销售员
     *
     * @param id 销售员ID
     * @return 结果
     */
    int deleteSalesmanById(Long id);

    /**
     * 批量删除销售员
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteSalesmanByIds(String[] ids);

    int logicDelByIds(String[] ids);
}
