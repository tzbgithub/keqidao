package com.qidao.qidao.wx.test;

import com.qidao.qidao.wx.constant.Env;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {
    @Autowired
    Env env;
    @Test
    public void testMethod() {
        String res = env.getAccessToken();
        System.out.println(res);
    }
}

