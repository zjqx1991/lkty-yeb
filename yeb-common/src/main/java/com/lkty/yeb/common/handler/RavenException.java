package com.lkty.yeb.common.handler;

import com.lkty.yeb.common.code.RavenCodeEnum;
import lombok.Getter;

@Getter
public class RavenException extends RuntimeException {

    // 异常
    private RavenCodeEnum codeEnum;

    public RavenException(RavenCodeEnum codeEnum) {
        this.codeEnum = codeEnum;
    }
}
