package com.qidao.qidao.dynamic.comment.mapper;

import com.qidao.qidao.dynamic.comment.domain.CommentPageRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomCommentMapper {

    List<CommentPageRes> getComment(Long id);

}
