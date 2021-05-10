package com.qidao.qidao.msg.msg.service;


import com.qidao.qidao.msg.msg.domain.MsgAddReq;
import com.qidao.qidao.msg.msg.domain.MsgDescriptionRes;
import com.qidao.qidao.msg.msg.domain.MsgListReq;
import com.qidao.qidao.msg.msg.domain.MsgListRes;

import java.util.List;

public interface CustomMsgService {

    List<MsgListRes> findMsg(MsgListReq req);

    int save(MsgAddReq req);

    MsgDescriptionRes findMsgDescription(Long id);

    int revoke(Long id);

    int disable(Long id);

}
