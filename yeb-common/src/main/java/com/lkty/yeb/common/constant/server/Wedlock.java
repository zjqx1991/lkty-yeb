package com.lkty.yeb.common.constant.server;

import lombok.Getter;

@Getter
public enum Wedlock {

    MARRIED("已婚"),
    SINGLE("单身"),
    DIVORCED("离异"),
    ;
    private String name;
    Wedlock(String name) {
        this.name = name;
    }
}
