package com.lkty.yeb.server.service;

import com.lkty.yeb.common.result.R;



public interface IAccountService {

    R login(String username, String password);

    R getUserInfo();
}

