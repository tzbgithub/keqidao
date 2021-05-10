package com.qidao.qidao.msg.msgMenu.service.impl;

import java.util.List;

import cn.hutool.core.collection.CollUtil;
import com.qidao.common.exception.BusinessException;
import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.common.utils.security.ShiroUtils;

import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.qidao.qidao.msg.msgMenu.domain.MsgMenu;
import com.qidao.qidao.msg.msgMenu.domain.MsgMenuExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.msg.msgMenu.mapper.TMsgMenuMapper;
import com.qidao.qidao.msg.msgMenu.domain.TMsgMenu;
import com.qidao.qidao.msg.msgMenu.service.ITMsgMenuService;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;

import javax.annotation.Resource;


/**
 * 消息菜单类型Service业务层处理
 *
 * @author yqj
 * @date 2021-02-19
 */
@Service
public class TMsgMenuServiceImpl implements ITMsgMenuService {
    @Autowired
    private TMsgMenuMapper tMsgMenuMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;

    /**
     * 查询消息菜单类型
     *
     * @param id 消息菜单类型ID
     * @return 消息菜单类型
     */
    @Override
    public TMsgMenu selectTMsgMenuById(Long id) {
        return tMsgMenuMapper.selectTMsgMenuById(id);
    }

    /**
     * 查询消息菜单类型列表
     *
     * @param tMsgMenu 消息菜单类型
     * @return 消息菜单类型
     */
    @Override
    public List<TMsgMenu> selectTMsgMenuList(TMsgMenu tMsgMenu) {
        return tMsgMenuMapper.selectTMsgMenuList(tMsgMenu);
    }

    /**
     * 新增消息菜单类型
     *
     * @param tMsgMenu 消息菜单类型
     * @return 结果
     */
    @Override
    public int insertTMsgMenu(TMsgMenu tMsgMenu) {
        tMsgMenu.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
        tMsgMenu.setName(tMsgMenu.getName().replace(" " , ""));
        tMsgMenu.setId(snowflakeIdWorker.nextId());
        return tMsgMenuMapper.insertTMsgMenu(tMsgMenu);
    }

    /**
     * 修改消息菜单类型
     *
     * @param tMsgMenu 消息菜单类型
     * @return 结果
     */
    @Override
    public int updateTMsgMenu(TMsgMenu tMsgMenu) {

        tMsgMenu.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));

        return tMsgMenuMapper.updateTMsgMenu(tMsgMenu);
    }

    /**
     * 删除消息菜单类型对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTMsgMenuByIds(String ids) {
        return tMsgMenuMapper.deleteTMsgMenuByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除消息菜单类型信息
     *
     * @param id 消息菜单类型ID
     * @return 结果
     */
    @Override
    public int deleteTMsgMenuById(Long id) {
        return tMsgMenuMapper.deleteTMsgMenuById(id);
    }


    /**
     * 逻辑删除消息菜单类型对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int logicDelByIds(String ids) {
        return tMsgMenuMapper.logicDelByIds(Convert.toStrArray(ids));
    }

}
