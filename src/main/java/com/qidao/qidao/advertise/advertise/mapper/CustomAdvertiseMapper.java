package com.qidao.qidao.advertise.advertise.mapper;

import com.github.pagehelper.Page;
import com.qidao.qidao.advertise.advertise.domain.AdvertiseDescriptionRes;
import com.qidao.qidao.advertise.advertise.domain.AdvertiseListReq;
import com.qidao.qidao.advertise.advertise.domain.AdvertiseListRes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomAdvertiseMapper {

    Page<AdvertiseListRes> findAdvertise(AdvertiseListReq req);

    AdvertiseDescriptionRes findAdvertiseDescription(Long id , Long canalId);

}
