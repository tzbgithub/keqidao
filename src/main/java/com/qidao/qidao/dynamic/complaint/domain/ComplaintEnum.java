package com.qidao.qidao.dynamic.complaint.domain;

import lombok.Getter;

@Getter
public enum ComplaintEnum{

    /**
     *
     * LEVEL_ 用户等级 0-普通用户 1-VIP用户
     *
     * STATUS_ 处理状态 0-未处理 1-处理中 2-已处理
     *
     */

    LEVEL_ORDINARY(0, "普通用户"),
    LEVEL_VIP(1, "VIP用户"),

    STATUS_UN_PROCESS(0, "未处理"),
    STATUS_ING_PROCESS(1, "处理中"),
    STATUS_ED_PROCESS(2, "已处理")
    ;
    private final int code;

    private final String message;

    ComplaintEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public static class getStatus{
        public String getStatus(Long status){
            if (status == 0){
                return "未处理";
            }else if(status == 1){
                return "处理中";
            }else{
                return "已处理";
            }
        }
    }

    public static class getLevel {
        public String getLevel(Long level) {
            if (level == 0){
                return "普通用户";
            }else {
                return "VIP用户";
            }
        }
    }
}
