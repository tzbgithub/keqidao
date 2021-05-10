package com.qidao.qidao.dynamic.comment.mapper;

import com.qidao.qidao.dynamic.comment.domain.TComment;
import java.util.List;

/**
 * 评论Mapper接口
 * 
 * @author autuan
 * @date 2021-01-29
 */
public interface TCommentMapper {
    /**
     * 查询评论
     * 
     * @param id 评论ID
     * @return 评论
     */
    TComment selectTCommentById(Long id);

    /**
     * 查询评论列表
     * 
     * @param tComment 评论
     * @return 评论集合
     */
    List<TComment> selectTCommentList(TComment tComment);

    /**
     * 新增评论
     * 
     * @param tComment 评论
     * @return 结果
     */
    int insertTComment(TComment tComment);

    /**
     * 修改评论
     * 
     * @param tComment 评论
     * @return 结果
     */
    int updateTComment(TComment tComment);

    /**
     * 删除评论
     * 
     * @param id 评论ID
     * @return 结果
     */
    int deleteTCommentById(Long id);

    /**
     * 批量删除评论
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTCommentByIds(String[] ids);

                                                                                                            int logicDelByIds(String[] ids);
                                                                        }
