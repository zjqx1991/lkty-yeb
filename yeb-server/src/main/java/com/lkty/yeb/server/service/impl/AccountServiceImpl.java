package com.lkty.yeb.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import com.lkty.yeb.common.code.RavenCodeEnum;
import com.lkty.yeb.common.handler.RavenException;
import com.lkty.yeb.common.pojo.account.AccountEntity;
import com.lkty.yeb.common.pojo.server.AdminEntity;
import com.lkty.yeb.server.service.IAccountService;
import com.lkty.yeb.server.service.IAdminService;
import com.lkty.yeb.server.utils.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sun.tools.jstat.Token;


@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAdminService adminService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Override
    public String login(AccountEntity accountEntity) {
        if (StringUtils.isBlank(accountEntity.getUsername()) || StringUtils.isBlank(accountEntity.getPassword())) {
            return RavenCodeEnum.PHONE_PASSWORD_FAIL.getMessage();
        }
        QueryWrapper<AdminEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("phone", accountEntity.getUsername());
        AdminEntity admin = this.adminService.getOne(wrapper);
        boolean matches = this.passwordEncoder.matches(accountEntity.getPassword(), admin.getPassword());
        if (!matches) {
            return RavenCodeEnum.PHONE_PASSWORD_FAIL.getMessage();
        }
        String token = this.jwtTokenUtil.generateToken(accountEntity.getUsername());
        return token;
    }

}
