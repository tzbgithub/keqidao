package com.qidao.qidao.member.subscribe.service.impl;

import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;
import com.qidao.qidao.member.subscribe.domain.TSubscribe;
import com.qidao.qidao.member.subscribe.mapper.TSubscribeMapper;
import com.qidao.qidao.member.subscribe.service.ISubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 关注Service业务层处理
 *
 * @author autuan
 * @date 2020-12-24
 */
@Service
public class TSubscribeServiceImpl implements ISubscribeService {
    @Autowired
    private TSubscribeMapper TSubscribeMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;

    /**
     * 查询关注
     *
     * @param id 关注ID
     * @return 关注
     */
    @Override
    public TSubscribe selectSubscribeById(Long id) {
        return TSubscribeMapper.selectSubscribeById(id);
    }

    /**
     * 查询关注列表
     *
     * @param TSubscribe 关注
     * @return 关注
     */
    @Override
    public List<TSubscribe> selectSubscribeList(TSubscribe TSubscribe) {
        return TSubscribeMapper.selectSubscribeList(TSubscribe);
    }

    /**
     * 新增关注
     *
     * @param TSubscribe 关注
     * @return 结果
     */
    @Override
    public int insertSubscribe(TSubscribe TSubscribe) {
        TSubscribe.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
        TSubscribe.setId(snowflakeIdWorker.nextId());
        return TSubscribeMapper.insertSubscribe(TSubscribe);
    }

    /**
     * 修改关注
     *
     * @param TSubscribe 关注
     * @return 结果
     */
    @Override
    public int updateSubscribe(TSubscribe TSubscribe) {
        TSubscribe.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));
        return TSubscribeMapper.updateSubscribe(TSubscribe);
    }

    /**
     * 删除关注对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSubscribeByIds(String ids) {
        return TSubscribeMapper.deleteSubscribeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除关注信息
     *
     * @param id 关注ID
     * @return 结果
     */
    @Override
    public int deleteSubscribeById(Long id) {
        return TSubscribeMapper.deleteSubscribeById(id);
    }


    /**
     * 逻辑删除关注对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int logicDelByIds(String ids) {
        return TSubscribeMapper.logicDelByIds(Convert.toStrArray(ids));
    }

}
