package com.lkty.yeb.api.admin;


import com.lkty.yeb.common.pojo.account.AccountEntity;
import com.lkty.yeb.common.pojo.server.AdminEntity;
import com.lkty.yeb.common.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value = "用户登录/退出", description = "用户登录/退出")
@RequestMapping("/api/account")
public interface IAccountAPI {

    @ApiOperation("登录")
    @PostMapping("/login")
    R login(@RequestBody AccountEntity accountEntity);

    @ApiOperation("退出")
    @PostMapping("/logout")
    R logout();
}
