package com.lkty.yeb.server.service;

import com.lkty.yeb.common.pojo.account.AccountEntity;


public interface IAccountService {


    /**
     * 登录获取token
     */
    String login(AccountEntity accountEntity);
}

