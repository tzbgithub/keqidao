package com.qidao.qidao.product.product.service;

import com.qidao.qidao.product.product.domain.TProduct;
import java.util.List;

/**
 * 产品Service接口
 * 
 * @author yqj
 * @date 2021-02-01
 */
public interface ITProductService {
    /**
     * 查询产品
     * 
     * @param id 产品ID
     * @return 产品
     */
    TProduct selectTProductById(Long id);

    /**
     * 查询产品列表
     * 
     * @param tProduct 产品
     * @return 产品集合
     */
    List<TProduct> selectTProductList(TProduct tProduct);

    /**
     * 新增产品
     * 
     * @param tProduct 产品
     * @return 结果
     */
    int insertTProduct(TProduct tProduct);

    /**
     * 修改产品
     * 
     * @param tProduct 产品
     * @return 结果
     */
    int updateTProduct(TProduct tProduct);

    /**
     * 批量删除产品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTProductByIds(String ids);

    /**
     * 删除产品信息
     * 
     * @param id 产品ID
     * @return 结果
     */
    int deleteTProductById(Long id);

                                                                                                                        int logicDelByIds(String ids);
                                                                        }
