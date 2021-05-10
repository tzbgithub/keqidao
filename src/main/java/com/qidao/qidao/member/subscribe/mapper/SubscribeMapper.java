package com.qidao.qidao.member.subscribe.mapper;

import com.qidao.qidao.member.subscribe.domain.Subscribe;
import com.qidao.qidao.member.subscribe.domain.SubscribeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubscribeMapper {
    long countByExample(SubscribeExample example);

    int deleteByExample(SubscribeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Subscribe record);

    int insertSelective(@Param("record") Subscribe record, @Param("selective") Subscribe.Column ... selective);

    Subscribe selectOneByExample(SubscribeExample example);

    List<Subscribe> selectByExample(SubscribeExample example);

    Subscribe selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Subscribe record, @Param("example") SubscribeExample example, @Param("selective") Subscribe.Column ... selective);

    int updateByExample(@Param("record") Subscribe record, @Param("example") SubscribeExample example);

    int updateByPrimaryKeySelective(@Param("record") Subscribe record, @Param("selective") Subscribe.Column ... selective);

    int updateByPrimaryKey(Subscribe record);

    int batchInsert(@Param("list") List<Subscribe> list);

    int batchInsertSelective(@Param("list") List<Subscribe> list, @Param("selective") Subscribe.Column ... selective);
}