package com.qidao.qidao.link.organizationSalesman.mapper;

import com.qidao.qidao.link.organizationSalesman.domain.ILinkOrganizationSalesman;
import com.qidao.qidao.link.organizationSalesman.domain.ILinkOrganizationSalesmanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ILinkOrganizationSalesmanMapper {
    long countByExample(ILinkOrganizationSalesmanExample example);

    int deleteByExample(ILinkOrganizationSalesmanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ILinkOrganizationSalesman record);

    int insertSelective(@Param("record") ILinkOrganizationSalesman record, @Param("selective") ILinkOrganizationSalesman.Column ... selective);

    ILinkOrganizationSalesman selectOneByExample(ILinkOrganizationSalesmanExample example);

    List<ILinkOrganizationSalesman> selectByExample(ILinkOrganizationSalesmanExample example);

    ILinkOrganizationSalesman selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ILinkOrganizationSalesman record, @Param("example") ILinkOrganizationSalesmanExample example, @Param("selective") ILinkOrganizationSalesman.Column ... selective);

    int updateByExample(@Param("record") ILinkOrganizationSalesman record, @Param("example") ILinkOrganizationSalesmanExample example);

    int updateByPrimaryKeySelective(@Param("record") ILinkOrganizationSalesman record, @Param("selective") ILinkOrganizationSalesman.Column ... selective);

    int updateByPrimaryKey(ILinkOrganizationSalesman record);

    int batchInsert(@Param("list") List<ILinkOrganizationSalesman> list);

    int batchInsertSelective(@Param("list") List<ILinkOrganizationSalesman> list, @Param("selective") ILinkOrganizationSalesman.Column ... selective);
}