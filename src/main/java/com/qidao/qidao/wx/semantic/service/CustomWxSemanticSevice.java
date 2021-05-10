package com.qidao.qidao.wx.semantic.service;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.semantic.semproxy.SemproxySearch;


public interface CustomWxSemanticSevice {
    /**
     * 发送语义理解请求
     * @param semproxySearch 语义理解请求的参数类
     * @return
     */
    BaseResult semproxySearch(SemproxySearch semproxySearch);

    /**
     *
     * @param lfrom 源语言，zh_CN 或 en_US
     * @param ito 目标语言，zh_CN 或 en_US
     * @param content 需要翻译的内容
     * @return
     */
    BaseResult translatecontent(String lfrom, String ito, String content);


}
