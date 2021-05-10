package com.qidao.qidao.msg.msg.mapper;

import com.github.pagehelper.Page;
import com.qidao.qidao.msg.msg.domain.MsgDescriptionRes;
import com.qidao.qidao.msg.msg.domain.MsgListReq;
import com.qidao.qidao.msg.msg.domain.MsgListRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomMsgMapper {

    Page<MsgListRes> findMsg(MsgListReq req);

    MsgDescriptionRes findMsgDescription(Long id);

}
