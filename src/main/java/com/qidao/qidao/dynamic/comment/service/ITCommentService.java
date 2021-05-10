package com.qidao.qidao.dynamic.comment.service;

import com.qidao.qidao.dynamic.comment.domain.TComment;
import java.util.List;

/**
 * 评论Service接口
 * 
 * @author autuan
 * @date 2021-01-29
 */
public interface ITCommentService {
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
     * 批量删除评论
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTCommentByIds(String ids);

    /**
     * 删除评论信息
     * 
     * @param id 评论ID
     * @return 结果
     */
    int deleteTCommentById(Long id);

                                                                                                int logicDelByIds(String ids);
                                                                        }
