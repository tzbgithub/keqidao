package com.qidao.qidao.member.favor.mapper;

import com.qidao.qidao.member.favor.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomFavorMapper {

    List<FavorPageRes> getFavorPage(FavorPageReq req);

    List<FavorMemberRes> getMember(@Param(value="name")String name);

    List<FavorDynamicRes> getDynamic(@Param(value="title")String title);

    FavorDynamicInfoRes getDynamicInfo(Long id);
}
