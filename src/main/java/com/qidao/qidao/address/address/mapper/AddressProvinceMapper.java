package com.qidao.qidao.address.address.mapper;

import com.qidao.qidao.address.address.domain.AddressProvince;
import com.qidao.qidao.address.address.domain.AddressProvinceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressProvinceMapper {
    long countByExample(AddressProvinceExample example);

    int deleteByExample(AddressProvinceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AddressProvince record);

    int insertSelective(@Param("record") AddressProvince record, @Param("selective") AddressProvince.Column ... selective);

    AddressProvince selectOneByExample(AddressProvinceExample example);

    List<AddressProvince> selectByExample(AddressProvinceExample example);

    AddressProvince selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AddressProvince record, @Param("example") AddressProvinceExample example, @Param("selective") AddressProvince.Column ... selective);

    int updateByExample(@Param("record") AddressProvince record, @Param("example") AddressProvinceExample example);

    int updateByPrimaryKeySelective(@Param("record") AddressProvince record, @Param("selective") AddressProvince.Column ... selective);

    int updateByPrimaryKey(AddressProvince record);

    int batchInsert(@Param("list") List<AddressProvince> list);

    int batchInsertSelective(@Param("list") List<AddressProvince> list, @Param("selective") AddressProvince.Column ... selective);
}