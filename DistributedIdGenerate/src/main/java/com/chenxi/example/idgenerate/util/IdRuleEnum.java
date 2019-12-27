package com.chenxi.example.idgenerate.util;

/**
 * Created by tukun on 2017/12/1.
 */
public enum IdRuleEnum {
    /**
     * elasticSearch 渠道
     */
    ES_ID_RULE(1,"elasticSearch系统"),
    ACTIVITYORDER_ID_RULE(2,"助力活动订单");

    private Integer code;
    private String info;

    private IdRuleEnum(Integer code, String info) {
        this.code = code;
        this.info = info;
    }

    public Integer getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
