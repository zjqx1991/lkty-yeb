package com.lkty.yeb.common.handler;

import com.lkty.ihrm.common.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    //1 对所有的异常进行相同的处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        log.error(e.getMessage());
        return R.error(e.getMessage());
    }


    //3 自定义异常
    @ExceptionHandler(RavenException.class)
    @ResponseBody
    public R error(RavenException e) {
        e.printStackTrace();
        log.error(e.getCodeEnum().getCode() + " --- " + e.getCodeEnum().getMessage());
        return R.error(e.getCodeEnum().getCode(), e.getCodeEnum().getMessage());
    }
}
