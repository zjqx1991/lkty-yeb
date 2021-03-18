package com.lkty.yeb.common.request;

import lombok.Data;

@Data
public class RequestCondition {
    private Integer page = 1;
    private Integer size = 10;
}
