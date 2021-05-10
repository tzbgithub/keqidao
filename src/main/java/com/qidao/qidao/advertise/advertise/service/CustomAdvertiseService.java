package com.qidao.qidao.advertise.advertise.service;

import com.qidao.qidao.advertise.advertise.domain.*;

import java.util.List;

public interface CustomAdvertiseService {

    List<AdvertiseListRes> findAdvertise(AdvertiseListReq req);

    int create(AdvertiseAddReq req);

    int edit(AdvertiseEditReq req);

    AdvertiseDescriptionRes findAdvertiseDescription(Long id,Long canalId);
}
