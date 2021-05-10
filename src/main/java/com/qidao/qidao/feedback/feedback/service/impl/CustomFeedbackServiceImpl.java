package com.qidao.qidao.feedback.feedback.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.Page;
import com.qidao.project.system.user.domain.User;
import com.qidao.project.system.user.mapper.UserMapper;
import com.qidao.qidao.config.select.domain.SelectConfig;
import com.qidao.qidao.config.select.mapper.SelectConfigMapper;
import com.qidao.qidao.feedback.feedback.domain.Feedback;
import com.qidao.qidao.feedback.feedback.domain.FeedbackPageRes;
import com.qidao.qidao.feedback.feedback.domain.FeedbackReq;
import com.qidao.qidao.feedback.feedback.domain.FeedbackRes;
import com.qidao.qidao.feedback.feedback.mapper.CustomFeedbackMapper;
import com.qidao.qidao.feedback.feedback.mapper.FeedbackMapper;
import com.qidao.qidao.feedback.feedback.service.CustomFeedbackService;
import com.qidao.qidao.member.member.domain.TMember;
import com.qidao.qidao.member.member.mapper.TMemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: xinfeng
 * @create: 2021-01-28 10:53
 */
@Service
@Slf4j
public class CustomFeedbackServiceImpl implements CustomFeedbackService {

    @Resource
    private FeedbackMapper feedbackMapper;

    @Resource
    private TMemberMapper tMemberMapper;

    @Resource
    private SelectConfigMapper selectConfigMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private CustomFeedbackMapper customFeedbackMapper;

    /**
     * 查询反馈结果列表
     *
     * @param feedback
     * @return 查询结果
     */
    @Override
    public List<FeedbackRes> selectFeedbackList(Feedback feedback) {
        log.info("CustomFeedbackServiceImpl ->  selectFeedbackList -> start -> feedback : {}", feedback);
        log.info("CustomFeedbackServiceImpl ->  selectFeedbackList -> ObjectUtil.isNotNull(feedback.getReasonId()) : {}", (ObjectUtil.isNotNull(feedback.getReasonId())));
        if(ObjectUtil.isNotNull(feedback.getReasonId())){
            SelectConfig sc = SelectConfig.builder()
                    .sequence(feedback.getReasonId())
                    .type((long) 8)
                    .build();
            List<SelectConfig> scList = selectConfigMapper.selectSelectConfigList(sc);
            log.info("CustomFeedbackServiceImpl ->  selectFeedbackList -> CollUtil.isNotEmpty(scList) : {}", (CollUtil.isNotEmpty(scList)));
            if(CollUtil.isNotEmpty(scList)){
                feedback.setReasonId(Long.valueOf(scList.get(0).getId()));
            }
        }
        List<Feedback> list = feedbackMapper.selectFeedbackList(feedback);
        List<FeedbackRes> respList = new ArrayList<>();
        for(Feedback fb : list){
            TMember tMember = tMemberMapper.selectMemberById(fb.getMemberId().toString());
            String tMemberName = null;
            log.info("CustomFeedbackServiceImpl ->  selectFeedbackList -> ObjectUtil.isNotEmpty(tMember) : {}", (ObjectUtil.isNotEmpty(tMember)));
            if(ObjectUtil.isNotEmpty(tMember)){
                tMemberName = tMember.getName();
            }
            SelectConfig selectConfig = selectConfigMapper.selectSelectConfigById(fb.getReasonId().toString());
            int reasonId = 0;
            log.info("CustomFeedbackServiceImpl ->  selectFeedbackList -> ObjectUtil.isNotEmpty(selectConfig) : {}", (ObjectUtil.isNotEmpty(selectConfig)));
            if(ObjectUtil.isNotEmpty(selectConfig)){
                System.out.println(selectConfig.getSequence());
                reasonId = selectConfig.getSequence().intValue();
            }
            FeedbackRes feedbackRes = FeedbackRes.builder()
                    .id(fb.getId())
                    .level(fb.getLevel())
                    .memberName(tMemberName)
                    .reasonId(reasonId)
                    .description(fb.getDescription())
                    .reply(fb.getReply())
                    .status(fb.getStatus())
                    .replyUserName(fb.getReplyUserName())
                    .build();
            respList.add(feedbackRes);
        }
        log.info("CustomFeedbackServiceImpl ->  selectFeedbackList -> end");
        return respList;
    }

    @Override
    public List<FeedbackPageRes> findFeedbackList(FeedbackReq req) {
        List<FeedbackPageRes> res = customFeedbackMapper.findFeedbackRes(req);
        List<User> verifyUser = userMapper.getVerifyUser();
        Map<Long, String> userMap = verifyUser.stream().collect(Collectors.toMap(User::getUserId, User::getUserName, (oldV, newV) -> newV));
        res.forEach(feedbackRes -> {
            feedbackRes.setCreateByName(userMap.get(feedbackRes.getCreateById()));
        });
        return res;
    }
}
