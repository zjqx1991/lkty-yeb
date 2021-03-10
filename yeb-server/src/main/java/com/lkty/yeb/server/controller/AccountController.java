package com.lkty.yeb.server.controller;

import com.lkty.yeb.api.admin.IAccountAPI;
import com.lkty.yeb.common.code.RavenCodeEnum;
import com.lkty.yeb.common.handler.RavenException;
import com.lkty.yeb.common.pojo.account.AccountEntity;
import com.lkty.yeb.common.result.R;
import com.lkty.yeb.server.service.IAccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController implements IAccountAPI {

    @Autowired
    private IAccountService accountService;

    @Override
    public R login(@RequestBody AccountEntity accountEntity) {
        if (StringUtils.isBlank(accountEntity.getUsername()) || StringUtils.isBlank(accountEntity.getPassword())) {
            throw new RavenException(RavenCodeEnum.PHONE_PASSWORD_FAIL);
        }
        String token = this.accountService.login(accountEntity);
        return R.ok().put("data", token);
    }

    @Override
    public R logout() {
        return R.ok();
    }
}
