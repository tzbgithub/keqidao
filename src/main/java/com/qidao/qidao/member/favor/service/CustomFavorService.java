package com.qidao.qidao.member.favor.service;

import com.qidao.qidao.member.favor.domain.*;

import java.util.List;

public interface CustomFavorService {

    List<FavorPageRes> getFavorPage(FavorPageReq req);

    List<FavorMemberRes> getMember(String name);

    List<FavorDynamicRes> getDynamic(String title);

    int create(CreateReq req);

}
