package com.lkty.yeb.server.service;

import com.lkty.yeb.common.pojo.account.AccountEntity;
import com.lkty.yeb.common.result.R;


public interface IAccountService {


    /**
     * 登录获取token
     */
    R login(String username, String password);
}

