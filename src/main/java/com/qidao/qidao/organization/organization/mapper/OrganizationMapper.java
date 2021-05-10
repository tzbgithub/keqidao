package com.qidao.qidao.organization.organization.mapper;

import com.qidao.qidao.organization.organization.domain.Organization;
import com.qidao.qidao.organization.organization.domain.OrganizationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrganizationMapper {
    long countByExample(OrganizationExample example);

    int deleteByExample(OrganizationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Organization record);

    int insertSelective(@Param("record") Organization record, @Param("selective") Organization.Column ... selective);

    Organization selectOneByExample(OrganizationExample example);

    List<Organization> selectByExample(OrganizationExample example);

    Organization selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Organization record, @Param("example") OrganizationExample example, @Param("selective") Organization.Column ... selective);

    int updateByExample(@Param("record") Organization record, @Param("example") OrganizationExample example);

    int updateByPrimaryKeySelective(@Param("record") Organization record, @Param("selective") Organization.Column ... selective);

    int updateByPrimaryKey(Organization record);

    int batchInsert(@Param("list") List<Organization> list);

    int batchInsertSelective(@Param("list") List<Organization> list, @Param("selective") Organization.Column ... selective);
}