package com.qidao.qidao.address.address.controller;

import com.qidao.qidao.address.address.domain.AddressArea;
import com.qidao.qidao.address.address.domain.AddressCity;
import com.qidao.qidao.address.address.domain.AddressProvince;
import com.qidao.qidao.address.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/getProvince")
    public List<AddressProvince> getProvince() {
        return addressService.getProvince();
    }

    @GetMapping("/getCity/{code}")
    public List<AddressCity> getCity(@PathVariable("code") String code) {
        return addressService.getCity(code);
    }

    @GetMapping("/getArea/{code}")
    public List<AddressArea> getArea(@PathVariable("code") String code) {
        return addressService.getArea(code);
    }

}
