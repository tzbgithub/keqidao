package com.qidao.qidao.msg.msgMenu.mapper;

import com.qidao.qidao.msg.msgMenu.domain.MsgMenu;
import com.qidao.qidao.msg.msgMenu.domain.MsgMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MsgMenuMapper {
    long countByExample(MsgMenuExample example);

    int deleteByExample(MsgMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MsgMenu record);

    int insertSelective(@Param("record") MsgMenu record, @Param("selective") MsgMenu.Column ... selective);

    MsgMenu selectOneByExample(MsgMenuExample example);

    List<MsgMenu> selectByExample(MsgMenuExample example);

    MsgMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MsgMenu record, @Param("example") MsgMenuExample example, @Param("selective") MsgMenu.Column ... selective);

    int updateByExample(@Param("record") MsgMenu record, @Param("example") MsgMenuExample example);

    int updateByPrimaryKeySelective(@Param("record") MsgMenu record, @Param("selective") MsgMenu.Column ... selective);

    int updateByPrimaryKey(MsgMenu record);

    int batchInsert(@Param("list") List<MsgMenu> list);

    int batchInsertSelective(@Param("list") List<MsgMenu> list, @Param("selective") MsgMenu.Column ... selective);
}