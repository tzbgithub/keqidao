package com.qidao.qidao.dynamic.comment. service.impl;

import java.util.List;
                                                                                                                                                                                        import com.qidao.common.utils.security.ShiroUtils;
                            import com.qidao.common.utils.security.ShiroUtils;
                    import java.time.LocalDateTime;
                            import java.time.LocalDateTime;
                                        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.dynamic.comment. mapper.TCommentMapper;
import com.qidao.qidao.dynamic.comment. domain.TComment;
import com.qidao.qidao.dynamic.comment. service.ITCommentService;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;

import javax.annotation.Resource;


/**
 * 评论Service业务层处理
 *
 * @author autuan
 * @date 2021-01-29
 */
@Service
public class TCommentServiceImpl implements ITCommentService {
    @Autowired
    private TCommentMapper tCommentMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;
    /**
     * 查询评论
     *
     * @param id 评论ID
     * @return 评论
     */
    @Override
    public TComment selectTCommentById(Long id) {
        return tCommentMapper.selectTCommentById(id);
    }

    /**
     * 查询评论列表
     *
     * @param tComment 评论
     * @return 评论
     */
    @Override
    public List<TComment> selectTCommentList(TComment tComment) {
        return tCommentMapper.selectTCommentList(tComment);
    }

    /**
     * 新增评论
     *
     * @param tComment 评论
     * @return 结果
     */
    @Override
    public int insertTComment(TComment tComment) {
                                                                                                                                                                                                        tComment.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
                                                                                        tComment.setId(snowflakeIdWorker.nextId());
        return tCommentMapper.insertTComment(tComment);
    }

    /**
     * 修改评论
     *
     * @param tComment 评论
     * @return 结果
     */
    @Override
    public int updateTComment(TComment tComment) {
                    
                    
                    
                    
                    
                    
                    
                    
                            tComment.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));
            
                    
                    
                    
                    
                return tCommentMapper.updateTComment(tComment);
    }

    /**
     * 删除评论对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTCommentByIds(String ids) {
        return tCommentMapper.deleteTCommentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除评论信息
     *
     * @param id 评论ID
     * @return 结果
     */
    @Override
    public int deleteTCommentById(Long id) {
        return tCommentMapper.deleteTCommentById(id);
    }
    


                                                                                                            /**
             * 逻辑删除评论对象
             *
             * @param ids 需要删除的数据ID
             * @return 结果
             */
            @Override
            public int logicDelByIds(String ids) {
                return tCommentMapper.logicDelByIds(Convert.toStrArray(ids));
            }
                                                                        
}
