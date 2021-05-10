package com.qidao.qidao.product.product.service.impl;

import java.util.Arrays;
import java.util.List;

import com.qidao.common.utils.StringUtils;
import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.common.utils.security.ShiroUtils;

import java.time.LocalDateTime;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.product.product.mapper.TProductMapper;
import com.qidao.qidao.product.product.domain.TProduct;
import com.qidao.qidao.product.product.service.ITProductService;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;

import javax.annotation.Resource;


/**
 * 产品Service业务层处理
 *
 * @author yqj
 * @date 2021-02-01
 */
@Service
public class TProductServiceImpl implements ITProductService {
    @Autowired
    private TProductMapper tProductMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;

    /**
     * 查询产品
     *
     * @param id 产品ID
     * @return 产品
     */
    @Override
    public TProduct selectTProductById(Long id) {
        TProduct tProduct = tProductMapper.selectTProductById(id);
        if (StringUtils.isNotEmpty(tProduct.getExtra())){
            List<String> list = Arrays.asList(tProduct.getExtra().replace("hot","1").replace("sale","2").split(","));
            tProduct.setExtras(list);
        }
        return tProduct;
    }

    /**
     * 查询产品列表
     *
     * @param tProduct 产品
     * @return 产品
     */
    @Override
    public List<TProduct> selectTProductList(TProduct tProduct) {
        return tProductMapper.selectTProductList(tProduct);
    }

    /**
     * 新增产品
     *
     * @param tProduct 产品
     * @return 结果
     */
    @Override
    public int insertTProduct(TProduct tProduct) {
        tProduct.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
        tProduct.setId(snowflakeIdWorker.nextId());
        return tProductMapper.insertTProduct(tProduct);
    }

    /**
     * 修改产品
     *
     * @param tProduct 产品
     * @return 结果
     */
    @Override
    public int updateTProduct(TProduct tProduct) {


        tProduct.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));


        return tProductMapper.updateTProduct(tProduct);
    }

    /**
     * 删除产品对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTProductByIds(String ids) {
        return tProductMapper.deleteTProductByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品信息
     *
     * @param id 产品ID
     * @return 结果
     */
    @Override
    public int deleteTProductById(Long id) {
        return tProductMapper.deleteTProductById(id);
    }


    /**
     * 逻辑删除产品对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int logicDelByIds(String ids) {
        return tProductMapper.logicDelByIds(Convert.toStrArray(ids));
    }

}
