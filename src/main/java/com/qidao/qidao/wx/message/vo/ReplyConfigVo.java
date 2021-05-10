package com.qidao.qidao.wx.message.vo;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ReplyConfigVo {
    private String textContent;

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
}
