package com.lkty.yeb.server.service.impl;

import com.lkty.yeb.common.pojo.server.AdminEntity;
import com.lkty.yeb.common.pojo.server.RoleEntity;
import com.lkty.yeb.server.po.User;
import com.lkty.yeb.server.service.IAdminService;
import com.lkty.yeb.server.service.IRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IAdminService adminService;
    @Autowired
    private IRoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminEntity admin = this.adminService.getAdminByUserName(username);
        User user = new User();
        BeanUtils.copyProperties(admin, user);
        // 查询角色
        List<RoleEntity> roles = this.roleService.getRolesByUid(user.getId());
        user.setRoles(roles);
        return user;
    }

}
