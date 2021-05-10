package com.qidao.qidao.salesman.salesman.service.impl;

import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;
import com.qidao.qidao.salesman.salesman.domain.Salesman;
import com.qidao.qidao.salesman.salesman.mapper.SalesmanMapper;
import com.qidao.qidao.salesman.salesman.service.ISalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 销售员Service业务层处理
 *
 * @author autuan
 * @date 2020-12-31
 */
@Service
public class SalesmanServiceImpl implements ISalesmanService {
    @Autowired
    private SalesmanMapper salesmanMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;

    /**
     * 查询销售员
     *
     * @param id 销售员ID
     * @return 销售员
     */
    @Override
    public Salesman selectSalesmanById(Long id) {
        return salesmanMapper.selectSalesmanById(id);
    }

    /**
     * 查询销售员列表
     *
     * @param salesman 销售员
     * @return 销售员
     */
    @Override
    public List<Salesman> selectSalesmanList(Salesman salesman) {
        return salesmanMapper.selectSalesmanList(salesman);
    }

    /**
     * 新增销售员
     *
     * @param salesman 销售员
     * @return 结果
     */
    @Override
    public int insertSalesman(Salesman salesman) {
        salesman.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
        salesman.setId(snowflakeIdWorker.nextId());
        return salesmanMapper.insertSalesman(salesman);
    }

    /**
     * 修改销售员
     *
     * @param salesman 销售员
     * @return 结果
     */
    @Override
    public int updateSalesman(Salesman salesman) {


        salesman.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));


        return salesmanMapper.updateSalesman(salesman);
    }

    /**
     * 删除销售员对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSalesmanByIds(String ids) {
        return salesmanMapper.deleteSalesmanByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除销售员信息
     *
     * @param id 销售员ID
     * @return 结果
     */
    @Override
    public int deleteSalesmanById(Long id) {
        return salesmanMapper.deleteSalesmanById(id);
    }


    /**
     * 逻辑删除销售员对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int logicDelByIds(String ids) {
        return salesmanMapper.logicDelByIds(Convert.toStrArray(ids));
    }

}
