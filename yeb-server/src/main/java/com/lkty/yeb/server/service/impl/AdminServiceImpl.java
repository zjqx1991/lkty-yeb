package com.lkty.yeb.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lkty.yeb.common.code.RavenCodeEnum;
import com.lkty.yeb.common.handler.RavenException;
import com.lkty.yeb.common.pojo.server.AdminEntity;
import com.lkty.yeb.server.dao.IAdminDao;
import com.lkty.yeb.server.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.management.Query;


@Service
public class AdminServiceImpl extends ServiceImpl<IAdminDao, AdminEntity> implements IAdminService {

    @Override
    public AdminEntity saveAddUpdate(AdminEntity adminEntity) {
        return null;
    }

    @Override
    public AdminEntity getAdminByUserName(String username) {
        QueryWrapper<AdminEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.eq("enabled", 1);
        AdminEntity admin = this.getOne(wrapper);
        if (admin == null) {
            throw new RavenException(RavenCodeEnum.USERNAME_INVALID);
        }
        return admin;
    }


}
