package com.lkty.yeb.server.service.impl;

import com.lkty.yeb.common.pojo.server.AdminEntity;
import com.lkty.yeb.server.dao.IAdminDao;
import com.lkty.yeb.server.po.User;
import com.lkty.yeb.server.service.IAdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IAdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminEntity admin = this.adminService.getAdminByUserName(username);
        User user = new User();
        BeanUtils.copyProperties(admin, user);
        return user;
    }

}
