package com.qidao.qidao.wx.menu.vo;

import lombok.Getter;

public class MenuButtonName {

    private String firstButtonName;

    /**
     * @param firstSubButtonNames 第一栏的菜单所有子目录的名字的拼接，逗号拼接
     */
    private String firstSubButtonNames;

    private String secondButtonName;
    private String secondSubButtonNames;

    private String thirdButtonName;
    private String thirdSubButtonNames;

    public String getFirstButtonName() {
        return firstButtonName;
    }

    public void setFirstButtonName(String firstButtonName) {
        this.firstButtonName = firstButtonName;
    }

    public String getFirstSubButtonNames() {
        return firstSubButtonNames;
    }

    public void setFirstSubButtonNames(String firstSubButtonNames) {
        this.firstSubButtonNames = firstSubButtonNames;
    }

    public String getSecondButtonName() {
        return secondButtonName;
    }

    public void setSecondButtonName(String secondButtonName) {
        this.secondButtonName = secondButtonName;
    }

    public String getSecondSubButtonNames() {
        return secondSubButtonNames;
    }

    public void setSecondSubButtonNames(String secondSubButtonNames) {
        this.secondSubButtonNames = secondSubButtonNames;
    }

    public String getThirdButtonName() {
        return thirdButtonName;
    }

    public void setThirdButtonName(String thirdButtonName) {
        this.thirdButtonName = thirdButtonName;
    }

    public String getThirdSubButtonNames() {
        return thirdSubButtonNames;
    }

    public void setThirdSubButtonNames(String thirdSubButtonNames) {
        this.thirdSubButtonNames = thirdSubButtonNames;
    }
}
