package com.qidao.qidao.msg.msgMenu.service;

import com.qidao.qidao.msg.msgMenu.domain.MsgMenu;
import com.qidao.qidao.msg.msgMenu.domain.MsgMenuListRes;

import java.util.List;

public interface CustomMsgMenuService {

    List<MsgMenu> getMsgMenu();

    List<MsgMenuListRes> findMsgMenuList();

    int open(Long id);

    int close(Long id);

    List<MsgMenu> findFather(Long id);

    List<MsgMenu> findSonByPid(Long pid);

    int update(MsgMenu msgMenu);

}
