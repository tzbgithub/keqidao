package com.qidao.qidao.msg.msgMenu.mapper;

import com.qidao.qidao.msg.msgMenu.domain.TMsgMenu;
import java.util.List;

/**
 * 消息菜单类型Mapper接口
 * 
 * @author yqj
 * @date 2021-02-19
 */
public interface TMsgMenuMapper {
    /**
     * 查询消息菜单类型
     * 
     * @param id 消息菜单类型ID
     * @return 消息菜单类型
     */
    TMsgMenu selectTMsgMenuById(Long id);

    /**
     * 查询消息菜单类型列表
     * 
     * @param tMsgMenu 消息菜单类型
     * @return 消息菜单类型集合
     */
    List<TMsgMenu> selectTMsgMenuList(TMsgMenu tMsgMenu);

    /**
     * 新增消息菜单类型
     * 
     * @param tMsgMenu 消息菜单类型
     * @return 结果
     */
    int insertTMsgMenu(TMsgMenu tMsgMenu);

    /**
     * 修改消息菜单类型
     * 
     * @param tMsgMenu 消息菜单类型
     * @return 结果
     */
    int updateTMsgMenu(TMsgMenu tMsgMenu);

    /**
     * 删除消息菜单类型
     * 
     * @param id 消息菜单类型ID
     * @return 结果
     */
    int deleteTMsgMenuById(Long id);

    /**
     * 批量删除消息菜单类型
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTMsgMenuByIds(String[] ids);

                        int logicDelByIds(String[] ids);
                                                                                                                        }
