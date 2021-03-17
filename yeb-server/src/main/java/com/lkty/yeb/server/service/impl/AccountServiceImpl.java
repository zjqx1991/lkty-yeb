package com.lkty.yeb.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import com.lkty.yeb.common.code.RavenCodeEnum;
import com.lkty.yeb.common.handler.RavenException;
import com.lkty.yeb.common.pojo.account.AccountEntity;
import com.lkty.yeb.common.pojo.server.AdminEntity;
import com.lkty.yeb.common.pojo.server.RoleEntity;
import com.lkty.yeb.common.result.R;
import com.lkty.yeb.server.config.security.JWTProperties;
import com.lkty.yeb.server.po.User;
import com.lkty.yeb.server.service.IAccountService;
import com.lkty.yeb.server.service.IAdminService;
import com.lkty.yeb.server.service.IRoleService;
import com.lkty.yeb.server.utils.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sun.tools.jstat.Token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JWTProperties jwtProperties;
    @Autowired
    private IAdminService adminService;
    @Autowired
    private IRoleService roleService;


    @Override
    public R login(String username, String password) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
        if (null == userDetails || !this.passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new RavenException(RavenCodeEnum.PHONE_PASSWORD_FAIL);
        }
        // 账号禁用
        if (!userDetails.isEnabled()) {
            throw new RavenException(RavenCodeEnum.ACCOUNT_DISENABLED);
        }
        // 更新 security 登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // 生成token
        String token = this.jwtTokenUtil.generateToken(userDetails);
        Map<String, Object> map = new HashMap<>();
        map.put("tokenHead", this.jwtProperties.getTokenHead());
        map.put("token", token);
        return R.ok().put("data", map);
    }

    @Override
    public R getUserInfo() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (null == user) {
            throw new RavenException(RavenCodeEnum.LOGIN_NOT);
        }
        AdminEntity admin = this.adminService.getAdminByUserName(user.getUsername());
        admin.setPassword(null);
        List<RoleEntity> roles = this.roleService.getRolesByUid(admin.getId());
        admin.setRoles(roles);
        return R.ok().put("data", admin);
    }
}
