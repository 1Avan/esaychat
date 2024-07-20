package com.ivan.enums;

import org.apache.commons.lang3.StringUtils;

public enum BeautyAccountStatusEnum {
    NO_USE(0, "未使用"),
    USEED(1, "已使用");
    private Integer status;
    private String desc;

    BeautyAccountStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
    public static BeautyAccountStatusEnum getByStatus (Integer status){
        for(BeautyAccountStatusEnum item : BeautyAccountStatusEnum.values()){
            return item;
        }
        return null;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
