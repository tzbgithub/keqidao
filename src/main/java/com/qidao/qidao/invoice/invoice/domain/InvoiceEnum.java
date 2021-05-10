package com.qidao.qidao.invoice.invoice.domain;

import lombok.Getter;

@Getter
public enum InvoiceEnum {
    /**
     *
     * TYPE_ 发票类别 0-企业发票 1-个人发票
     *
     * STATUS_ 处理状态 0-申请中 1-已开票
     *
     */

    TYPE_ENTERPRISE(0, "企业发票"),
    TYPE_PERSONAL(1, "个人发票"),

    STATUS_ING_PROCESS(0, "申请中"),
    STATUS_ED_PROCESS(1, "已开票")
            ;
    private final int code;

    private final String message;

    InvoiceEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public static class GetStatus{
        public String getStatus(Long status){
            if (status == 0){
                return "申请中";
            }else{
                return "已开票";
            }
        }
    }

    public static class GetType {
        public String getType(Long level) {
            if (level == 0) {
                return "企业发票";
            } else {
                return "个人发票";
            }
        }
    }
    }
