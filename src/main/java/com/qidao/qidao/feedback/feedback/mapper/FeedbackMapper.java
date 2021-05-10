package com.qidao.qidao.feedback.feedback.mapper;

import com.qidao.qidao.feedback.feedback.domain.Feedback;
import java.util.List;

/**
 * 反馈Mapper接口
 * 
 * @author autuan
 * @date 2021-01-28
 */
public interface FeedbackMapper {
    /**
     * 查询反馈
     * 
     * @param id 反馈ID
     * @return 反馈
     */
    Feedback selectFeedbackById(Long id);

    /**
     * 查询反馈列表
     * 
     * @param feedback 反馈
     * @return 反馈集合
     */
    List<Feedback> selectFeedbackList(Feedback feedback);

    /**
     * 新增反馈
     * 
     * @param feedback 反馈
     * @return 结果
     */
    int insertFeedback(Feedback feedback);

    /**
     * 修改反馈
     * 
     * @param feedback 反馈
     * @return 结果
     */
    int updateFeedback(Feedback feedback);

    /**
     * 删除反馈
     * 
     * @param id 反馈ID
     * @return 结果
     */
    int deleteFeedbackById(Long id);

    /**
     * 批量删除反馈
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteFeedbackByIds(String[] ids);

                                                                                                                        int logicDelByIds(String[] ids);
                                                                        }
