package com.lkty.yeb.api.admin;


import com.lkty.yeb.common.pojo.account.AccountEntity;
import com.lkty.yeb.common.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "用户登录/退出", description = "用户登录/退出")
@RequestMapping("/api/account")
public interface IAccountAPI {


    @ApiOperation("验证码")
    @GetMapping(value = "/code", produces = "image/jpeg")
    R code(HttpServletRequest request, HttpServletResponse response);

    @ApiOperation("登录")
    @PostMapping("/login")
    R login(@RequestBody AccountEntity accountEntity);

    @ApiOperation("退出")
    @PostMapping("/logout")
    R logout();


    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    R getUserInfo();
}
