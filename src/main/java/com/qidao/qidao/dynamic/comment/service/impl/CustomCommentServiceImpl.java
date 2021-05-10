package com.qidao.qidao.dynamic.comment.service.impl;

import com.github.pagehelper.Page;
import com.qidao.common.enums.ConstantEnum;
import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.qidao.dynamic.comment.domain.Comment;
import com.qidao.qidao.dynamic.comment.domain.CommentPageRes;
import com.qidao.qidao.dynamic.comment.mapper.CommentMapper;
import com.qidao.qidao.dynamic.comment.mapper.CustomCommentMapper;
import com.qidao.qidao.dynamic.comment.service.CustomCommentService;
import com.qidao.qidao.dynamic.domain.Dynamic;
import com.qidao.qidao.dynamic.mapper.DynamicMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("customCommentService")
public class CustomCommentServiceImpl implements CustomCommentService {

    @Resource
    private CustomCommentMapper customCommentMapper;

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private DynamicMapper dynamicMapper;


    @Override
    public List<CommentPageRes> getComment(Long id) {
        Page<CommentPageRes> res = new Page<>();
        List<CommentPageRes> comments = customCommentMapper.getComment(id);
        res.addAll(comments);
        if (comments instanceof Page){
            res.setTotal(((Page<CommentPageRes>) comments).getTotal());
        }
        return res;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int verifyPass(Long id , Long dynamicId) {
        Dynamic dynamic = dynamicMapper.selectByPrimaryKey(dynamicId);
        dynamicMapper.updateByPrimaryKeySelective(Dynamic.builder().id(dynamic.getId()).commentNum(dynamic.getCommentNum()+1).build());
        return commentMapper.updateByPrimaryKeySelective(Comment.builder().id(id).verifyUserId(ShiroUtils.getUserId()).verifyReason("审核通过").verifyStatus(1).build());
    }

    @Override
    public int verifyFail(Long id) {
        return commentMapper.updateByPrimaryKeySelective(Comment.builder().id(id).verifyUserId(ShiroUtils.getUserId()).verifyReason("未审核通过，如有疑问请联系运营人员").verifyStatus(2).build());
    }

    @Override
    public int callBack(Long id) {
        return commentMapper.updateByPrimaryKeySelective(Comment.builder().id(id).verifyUserId(ShiroUtils.getUserId()).verifyStatus(0).build());
    }

    @Override
    public int delete(Long id, Long dynamicId) {
        Dynamic dynamic = dynamicMapper.selectByPrimaryKey(dynamicId);
        dynamicMapper.updateByPrimaryKeySelective(Dynamic.builder().id(dynamic.getId()).commentNum(dynamic.getCommentNum()-1).build());
        return commentMapper.updateByPrimaryKeySelective(Comment.builder().id(id).delFlag(ConstantEnum.DELETED.getValue()).build());
    }
}
