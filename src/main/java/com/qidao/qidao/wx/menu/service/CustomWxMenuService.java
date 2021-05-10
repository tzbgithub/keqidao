package com.qidao.qidao.wx.menu.service;

import com.qidao.qidao.wx.menu.dto.MenuCreateForm;
import com.qidao.qidao.wx.menu.vo.MenuButtonName;
import weixin.popular.bean.BaseResult;

import java.util.List;

public interface CustomWxMenuService {
    /**
     * 创建自定义菜单
     * @return
     */

    BaseResult createMenu(MenuCreateForm menuCreateForm);

    /**
     * 删除自定义菜单
     * @return
     */

    boolean deleteMenu();

    /**
     * 查询菜单
     * @return
     */
    BaseResult getMenu();

    /**
     * 查询菜单
     * @return
     */
    List<MenuButtonName> getMenuName();



    /**
     * 查询当前使用的自定义菜单的配置
     * @return
     */
    BaseResult getCurrentSelfMenuInfo();

    /**
     * 创建个性化菜单(根据用户信息创建专属用户的个性菜单)
     * @return
     */
    BaseResult addconditionalMenu();

    /**
     * 删除个性化菜单
     * @param menuId 菜单id
     * @return
     */
    BaseResult deleteconditionalMenu(String menuId);

    /**
     * 测试个性化菜单匹配结果
     * @param userId 用户id
     * @return
     */
    BaseResult tryMatchMenu(String userId);
}
