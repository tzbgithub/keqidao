package com.qidao.qidao.server.server.service;

import com.qidao.qidao.server.server.domain.ServerAddReq;
import com.qidao.qidao.server.server.domain.ServerDescriptionRes;
import com.qidao.qidao.server.server.domain.ServerListReq;
import com.qidao.qidao.server.server.domain.ServerListRes;

import java.util.List;

public interface CustomServerService {

    List<ServerListRes> findServer(ServerListReq req);

    int saveServer(ServerAddReq req);

    ServerDescriptionRes serverDescription(Long id);

    int revoke(Long id);

}
