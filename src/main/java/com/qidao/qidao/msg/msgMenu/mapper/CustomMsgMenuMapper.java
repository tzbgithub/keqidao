package com.qidao.qidao.msg.msgMenu.mapper;

import com.github.pagehelper.Page;
import com.qidao.qidao.msg.msgMenu.domain.MsgMenuListRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomMsgMenuMapper {

    Page<MsgMenuListRes> findMsgMenuList();


}
