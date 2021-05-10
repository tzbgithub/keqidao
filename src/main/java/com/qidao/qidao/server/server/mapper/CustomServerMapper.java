package com.qidao.qidao.server.server.mapper;

import com.github.pagehelper.Page;
import com.qidao.qidao.server.server.domain.ServerDescriptionRes;
import com.qidao.qidao.server.server.domain.ServerListReq;
import com.qidao.qidao.server.server.domain.ServerListRes;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CustomServerMapper {

    Page<ServerListRes> findServer(ServerListReq req);

    //int saveServer(ServerAddReq req);

    ServerDescriptionRes serverDescription(Long id);

}
