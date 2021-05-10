package com.qidao.qidao.label.label.mapper;

import com.qidao.qidao.label.label.domain.Label;
import com.qidao.qidao.label.label.domain.LabelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LabelMapper {
    long countByExample(LabelExample example);

    int deleteByExample(LabelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Label record);

    int insertSelective(@Param("record") Label record, @Param("selective") Label.Column... selective);

    Label selectOneByExample(LabelExample example);

    List<Label> selectByExample(LabelExample example);

    Label selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Label record, @Param("example") LabelExample example, @Param("selective") Label.Column... selective);

    int updateByExample(@Param("record") Label record, @Param("example") LabelExample example);

    int updateByPrimaryKeySelective(@Param("record") Label record, @Param("selective") Label.Column... selective);

    int updateByPrimaryKey(Label record);

    int batchInsert(@Param("list") List<Label> list);

    int batchInsertSelective(@Param("list") List<Label> list, @Param("selective") Label.Column... selective);
}