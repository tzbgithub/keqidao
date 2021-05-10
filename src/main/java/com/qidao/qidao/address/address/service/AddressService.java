package com.qidao.qidao.address.address.service;

import com.qidao.qidao.address.address.domain.AddressArea;
import com.qidao.qidao.address.address.domain.AddressCity;
import com.qidao.qidao.address.address.domain.AddressProvince;

import java.util.List;

public interface AddressService {

    List<AddressProvince> getProvince();
    List<AddressCity> getCity(String code);
    List<AddressArea> getArea(String code);

}
