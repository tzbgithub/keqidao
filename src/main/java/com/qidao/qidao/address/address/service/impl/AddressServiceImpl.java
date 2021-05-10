package com.qidao.qidao.address.address.service.impl;

import com.qidao.qidao.address.address.domain.*;
import com.qidao.qidao.address.address.mapper.AddressAreaMapper;
import com.qidao.qidao.address.address.mapper.AddressCityMapper;
import com.qidao.qidao.address.address.mapper.AddressProvinceMapper;
import com.qidao.qidao.address.address.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressAreaMapper addressAreaMapper;

    @Resource
    private AddressCityMapper addressCityMapper;

    @Resource
    private AddressProvinceMapper addressProvinceMapper;

    @Override
    public List<AddressProvince> getProvince() {

        return addressProvinceMapper.selectByExample(null);
    }

    @Override
    public List<AddressCity> getCity(String code) {
        AddressCityExample example = new AddressCityExample();
        example.createCriteria().andProvinceCodeEqualTo(code);
        return addressCityMapper.selectByExample(example);
    }

    @Override
    public List<AddressArea> getArea(String code) {
        AddressAreaExample example = new AddressAreaExample();
        example.createCriteria().andCityCodeEqualTo(code);
        return addressAreaMapper.selectByExample(example);
    }
}
