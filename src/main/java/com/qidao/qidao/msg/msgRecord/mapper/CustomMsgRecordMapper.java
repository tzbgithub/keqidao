package com.qidao.qidao.msg.msgRecord.mapper;

import com.github.pagehelper.Page;
import com.qidao.qidao.msg.msgRecord.domain.MsgRecordListReq;
import com.qidao.qidao.msg.msgRecord.domain.MsgRecordListRes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomMsgRecordMapper {

    Page<MsgRecordListRes> findRecord(MsgRecordListReq req);

}
