package com.qidao.qidao.canal.canal.service;

import com.qidao.qidao.canal.canal.domain.Canal;
import com.qidao.qidao.canal.canal.domain.CanalAddReq;
import com.qidao.qidao.canal.canal.domain.CanalListReq;
import com.qidao.qidao.canal.canal.domain.CanalListRes;

import java.util.List;

public interface CustomCanalService {

    List<CanalListRes> findCanalList(CanalListReq req);

    int save(CanalAddReq req);

    int enable (Long id);

    int close(Long id);

    List<Canal> findAllCanal();

}
