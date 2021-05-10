package com.qidao.qidao.link.publishContent.mapper;

import com.qidao.qidao.link.publishContent.domain.LinkPublishContent;
import com.qidao.qidao.link.publishContent.domain.LinkPublishContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LinkPublishContentMapper {
    long countByExample(LinkPublishContentExample example);

    int deleteByExample(LinkPublishContentExample example);

    int insert(LinkPublishContent record);

    int insertSelective(@Param("record") LinkPublishContent record, @Param("selective") LinkPublishContent.Column ... selective);

    LinkPublishContent selectOneByExample(LinkPublishContentExample example);

    List<LinkPublishContent> selectByExample(LinkPublishContentExample example);

    int updateByExampleSelective(@Param("record") LinkPublishContent record, @Param("example") LinkPublishContentExample example, @Param("selective") LinkPublishContent.Column ... selective);

    int updateByExample(@Param("record") LinkPublishContent record, @Param("example") LinkPublishContentExample example);

    int batchInsert(@Param("list") List<LinkPublishContent> list);

    int batchInsertSelective(@Param("list") List<LinkPublishContent> list, @Param("selective") LinkPublishContent.Column ... selective);
}