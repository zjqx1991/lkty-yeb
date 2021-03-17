package com.lkty.yeb.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkty.yeb.common.pojo.server.AdminEntity;
import com.lkty.yeb.common.pojo.server.MenuEntity;
import com.lkty.yeb.server.dao.IMenuDao;
import com.lkty.yeb.server.po.User;
import com.lkty.yeb.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<IMenuDao, MenuEntity> implements IMenuService {

    @Autowired
    private IMenuDao menuDao;

    @Override
    public List<MenuEntity> getListByUid() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<MenuEntity> list = this.menuDao.getListByUid(user.getId());
        return list;
    }
}
