package com.qidao.qidao.wx.menu.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.qidao.common.utils.StringUtils;
import com.qidao.qidao.wx.constant.Env;
import com.qidao.qidao.wx.menu.dto.MenuCreateForm;
import com.qidao.qidao.wx.menu.service.CustomWxMenuService;
import com.qidao.qidao.wx.menu.vo.MenuButtonName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weixin.popular.api.MenuAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.menu.Button;
import weixin.popular.bean.menu.Matchrule;
import weixin.popular.bean.menu.Menu;
import weixin.popular.bean.menu.MenuButtons;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomWxMenuServiceImpl implements CustomWxMenuService {
    public static final Logger log = LoggerFactory.getLogger(CustomWxMenuServiceImpl.class);

    @Autowired
    Env env;

//    @Override
//    public BaseResult createMenu() {
//        //定义第一列的竖着的子按键
//        Button sub11 = new Button();
//        sub11.setName("企岛简介");
//        sub11.setType("view");
//        sub11.setUrl("https://baidu.com");
//
//        Button sub12 = new Button();
//        sub12.setName("实验室");
//        sub12.setType("view");
//        sub12.setUrl("https://baidu.com");
//
//        Button sub13 = new Button();
//        sub13.setName("高校");
//        sub13.setType("view");
//        sub13.setUrl("https://baidu.com");
//
//        //定义第一个按键
//        Button sub1 = new Button();
//        sub1.setType("view");
//        sub1.setName("我是谁");
//
//        List<Button> subButtonList = new ArrayList<>();
//        subButtonList.add(sub11);
//        subButtonList.add(sub12);
//        subButtonList.add(sub13);
//
//        sub1.setSub_button(subButtonList);
//
//        //定义第二个按键
//        Button sub2 = new Button();
//        sub2.setType("click");
//        sub2.setName("Click");
//        sub2.setKey("return_content");
//
////        //定义第三个按键
////        Button sub3 = new Button();
////        sub3.setType("pic_weixin");
////        sub3.setName("PIC");
////        sub3.setKey("click-02");
//
//        MenuButtons btn1 = new MenuButtons();
//        btn1.setButton(new Button[]{sub1, sub2, null});
//
//        return MenuAPI.menuCreate(env.getAccessToken(), btn1);
//
//    }

    @Override
    public BaseResult createMenu(MenuCreateForm mcf) {
        //定义第1列菜单
        //如果没有名字就跳过
        Button b1 = null;
        if (!StringUtils.isEmpty(mcf.getFirstColumnMenuName())) {
            b1 = new Button();
            String type1 = mcf.getFirstColumnMenuType();
            b1.setType(type1);
            b1.setName(mcf.getFirstColumnMenuName());
            if (StringUtils.isNotEmpty(mcf.getFirstColumnSubMenus())) {
                List<Button> sub1 = getSubList(mcf.getFirstColumnSubMenus());
                b1.setSub_button(sub1);
            } else {
                if (StringUtils.equals(type1, "view")) {
                    b1.setUrl(mcf.getFirstColumnMenuContent());
                }
                if (StringUtils.equals(type1, "click")) {
                    b1.setKey(mcf.getFirstColumnMenuContent());
                }
            }
        }

        //定义第2列菜单
        Button b2 = null;
        if (!StringUtils.isEmpty(mcf.getSecondColumnMenuName())) {
            b2 = new Button();
            String type2 = mcf.getSecondColumnMenuType();
            b2.setType(type2);
            b2.setName(mcf.getSecondColumnMenuName());
            if (StringUtils.isNotEmpty(mcf.getSecondColumnSubMenus())) {
                List<Button> sub2 = getSubList(mcf.getSecondColumnSubMenus());
                b2.setSub_button(sub2);
            } else {
                if (StringUtils.equals(type2, "view")) {
                    b2.setUrl(mcf.getSecondColumnMenuContent());
                }
                if (StringUtils.equals(type2, "click")) {
                    b2.setKey(mcf.getSecondColumnMenuContent());
                }
            }
        }
        //定义第3列菜单
        Button b3 = null;
        if (!StringUtils.isEmpty(mcf.getThirdColumnMenuName())) {
            b3 = new Button();
            String type3 = mcf.getThirdColumnMenuType();
            b3.setType(type3);
            b3.setName(mcf.getThirdColumnMenuName());
            if (StringUtils.isNotEmpty(mcf.getThirdColumnSubMenus())) {
                List<Button> sub3 = getSubList(mcf.getThirdColumnSubMenus());
                b3.setSub_button(sub3);
            } else {
                if (StringUtils.equals(type3, "view")) {
                    b3.setUrl(mcf.getThirdColumnMenuContent());
                }
                if (StringUtils.equals(type3, "click")) {
                    b3.setKey(mcf.getThirdColumnMenuContent());
                }
            }
        }
        MenuButtons menu = new MenuButtons();
        menu.setButton(new Button[]{b1, b2, b3});
        return MenuAPI.menuCreate(env.getAccessToken(), menu);
    }

    public List<Button> getSubList(String subMenusString) {
        List<Button> sub = new ArrayList<>();
        //按分号分割
        String[] subMenus = subMenusString.split("\r\n");
        //遍历
        for (int i = 0; i < subMenus.length; i++) {
            String[] split = subMenus[i].split(" ");
            Button tempSubButtom = new Button();
            for (int j = 0; j < split.length; j++) {
                tempSubButtom.setName(split[0]);
                if (StringUtils.equals(split[1], "click")) {
                    tempSubButtom.setType("view");
                    tempSubButtom.setKey(split[2]);
                }
                if (StringUtils.equals(split[1], "view")) {
                    tempSubButtom.setType("view");
                    tempSubButtom.setUrl(split[2]);
                }
                //还有其他类型，以后扩展
            }
            sub.add(tempSubButtom);
        }
        return sub;
    }

    @Override
    public boolean deleteMenu() {
        BaseResult br = null;
        try {
            br = MenuAPI.menuDelete(env.getAccessToken());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (br.isSuccess()) {
            log.info("成功删除自定义菜单！");
            return true;
        } else {
            log.info("删除自定义菜单失败");
            return false;
        }
    }

    @Override
    public BaseResult getMenu() {
        return MenuAPI.menuGet(env.getAccessToken());
    }

    @Override
    public List<MenuButtonName> getMenuName() {
        List<MenuButtonName> list = new ArrayList<>();
        Menu menu = MenuAPI.menuGet(env.getAccessToken());
        MenuButtons menuButtons = menu.getMenu();
        if (ObjectUtil.isNotEmpty(menuButtons)) {
            Button[] button = menuButtons.getButton();
            //列表第一个name为一级标题
            MenuButtonName menuButtonName = new MenuButtonName();
            for (int i = 0; i < button.length; i++) {
                if (i == 0) {
                    menuButtonName.setFirstButtonName(button[i].getName());
                    List<Button> firstSubButtonList = button[i].getSub_button();
                    //是否有子菜单
                    if (CollectionUtil.isNotEmpty(firstSubButtonList)) {
                        String fisrtAllSubButtonName = getAllSubButtonName(firstSubButtonList);
                        menuButtonName.setFirstSubButtonNames(fisrtAllSubButtonName);
                    }
                }
                if (i == 1) {
                    menuButtonName.setSecondButtonName(button[i].getName());
                    List<Button> secondSubButtonList = button[i].getSub_button();
                    //是否有子菜单
                    if (CollectionUtil.isNotEmpty(secondSubButtonList)) {
                        String secondAllSubButtonName = getAllSubButtonName(secondSubButtonList);
                        menuButtonName.setSecondSubButtonNames(secondAllSubButtonName);
                    }
                }
                if (i == 2) {
                    menuButtonName.setThirdButtonName(button[i].getName());
                    List<Button> thirdSubButtonList = button[i].getSub_button();
                    //是否有子菜单
                    if (CollectionUtil.isNotEmpty(thirdSubButtonList)) {
                        String thirdAllSubButtonName = getAllSubButtonName(thirdSubButtonList);
                        menuButtonName.setThirdSubButtonNames(thirdAllSubButtonName);
                    }
                }
            }
            list.add(menuButtonName);
        } else {
            log.info("菜单为空！！！请创建菜单");
        }

        return list;
    }

    private String getAllSubButtonName(List<Button> subButonList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < subButonList.size(); i++) {
            sb.append(subButonList.get(i).getName());
            if (i == subButonList.size() - 1) {
                break;
            }
            sb.append(",");
        }
        return sb.toString();
    }



    @Override
    public BaseResult getCurrentSelfMenuInfo() {
        return MenuAPI.get_current_selfmenu_info(env.getAccessToken());
    }

    @Override
    public BaseResult addconditionalMenu() {
        //定义第一列的竖着的子按键
        Button sub11 = new Button();
        sub11.setName("企岛简介");
        sub11.setType("view");
        sub11.setUrl("https://baidu.com");

        Button sub12 = new Button();
        sub12.setName("实验室");
        sub12.setType("view");
        sub12.setUrl("https://baidu.com");

        Button sub13 = new Button();
        sub13.setName("高校");
        sub13.setType("view");
        sub13.setUrl("https://baidu.com");

        //定义第一个按键
        Button sub1 = new Button();
        sub1.setType("view");
        sub1.setName("我是谁");

        List<Button> subButtonList = new ArrayList<>();
        subButtonList.add(sub11);
        subButtonList.add(sub12);
        subButtonList.add(sub13);

        sub1.setSub_button(subButtonList);

        //定义第二个按键
        Button sub2 = new Button();
        sub2.setType("click");
        sub2.setName("Click");
        sub2.setKey("return_content");

        //定义第三个按键
        Button sub3 = new Button();
        sub3.setType("pic_weixin");
        sub3.setName("PIC");
        sub3.setKey("click-02");

        MenuButtons btn1 = new MenuButtons();
        btn1.setButton(new Button[]{sub1, sub2, sub3});
        //设置菜单匹配用户的规则
        Matchrule mr = new Matchrule();
        mr.setSex(1);//男 1 女 2
        mr.setProvince("上海");
        mr.setCountry("中国");
        mr.setLanguage("zh_CN");
        mr.setClient_platform_type("1"); //ios 1 androd 2 others 3
        btn1.setMatchrule(mr);
        return MenuAPI.menuAddconditional(env.getAccessToken(),btn1);
    }

    @Override
    public BaseResult deleteconditionalMenu(String menuId) {
        return MenuAPI.menuDelconditional(env.getAccessToken(),menuId);
    }

    @Override
    public BaseResult tryMatchMenu(String userId) {
        return MenuAPI.menuTrymatch(env.getAccessToken(), userId);
    }


}



