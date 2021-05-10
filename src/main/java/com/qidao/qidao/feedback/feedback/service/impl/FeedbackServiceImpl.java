package com.qidao.qidao.feedback.feedback.service.impl;

import java.util.List;

import com.qidao.common.utils.security.ShiroUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.feedback.feedback.mapper.FeedbackMapper;
import com.qidao.qidao.feedback.feedback.domain.Feedback;
import com.qidao.qidao.feedback.feedback.service.IFeedbackService;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;

import javax.annotation.Resource;


/**
 * 反馈Service业务层处理
 *
 * @author autuan
 * @date 2021-01-28
 */
@Service
public class FeedbackServiceImpl implements IFeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;

    /**
     * 查询反馈
     *
     * @param id 反馈ID
     * @return 反馈
     */
    @Override
    public Feedback selectFeedbackById(Long id) {
        return feedbackMapper.selectFeedbackById(id);
    }

    /**
     * 查询反馈列表
     *
     * @param feedback 反馈
     * @return 反馈
     */
    @Override
    public List<Feedback> selectFeedbackList(Feedback feedback) {
        return feedbackMapper.selectFeedbackList(feedback);
    }

    /**
     * 新增反馈
     *
     * @param feedback 反馈
     * @return 结果
     */
    @Override
    public int insertFeedback(Feedback feedback) {
        feedback.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
        feedback.setId(snowflakeIdWorker.nextId());
        return feedbackMapper.insertFeedback(feedback);
    }

    /**
     * 修改反馈
     *
     * @param feedback 反馈
     * @return 结果
     */
    @Override
    public int updateFeedback(Feedback feedback) {
        feedback.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));
        return feedbackMapper.updateFeedback(feedback);
    }

    /**
     * 删除反馈对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFeedbackByIds(String ids) {
        return feedbackMapper.deleteFeedbackByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除反馈信息
     *
     * @param id 反馈ID
     * @return 结果
     */
    @Override
    public int deleteFeedbackById(Long id) {
        return feedbackMapper.deleteFeedbackById(id);
    }


    /**
     * 逻辑删除反馈对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int logicDelByIds(String ids) {
        return feedbackMapper.logicDelByIds(Convert.toStrArray(ids));
    }

}
