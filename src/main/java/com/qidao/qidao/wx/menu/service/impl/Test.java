package com.qidao.qidao.wx.menu.service.impl;

import com.qidao.RuoYiApplication;
import com.qidao.qidao.wx.menu.service.CustomWxMenuService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RuoYiApplication.class)


public class Test {
    @Autowired CustomWxMenuServiceImpl customWxMenuServiceImpl;
    @org.junit.Test
    public void testCreateMenu() {
//        customWxMenuServiceImpl.createMenu();
    }
}
