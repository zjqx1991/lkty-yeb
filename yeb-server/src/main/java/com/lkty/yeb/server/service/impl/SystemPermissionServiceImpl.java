package com.lkty.yeb.server.service.impl;


import com.lkty.yeb.common.code.RavenCodeEnum;
import com.lkty.yeb.common.handler.RavenException;
import com.lkty.yeb.common.pojo.server.MenuEntity;
import com.lkty.yeb.server.dao.IMenuDao;
import com.lkty.yeb.server.service.IMenuService;
import com.lkty.yeb.server.service.ISystemPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemPermissionServiceImpl implements ISystemPermissionService {

    @Autowired
    private IMenuService menuService;
    @Autowired
    private IMenuDao menuDao;


    @Override
    public MenuEntity saveMenu(MenuEntity menuEntity) {
        if (null == menuEntity || null != menuEntity.getId()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        boolean isSave = this.menuService.save(menuEntity);
        if (!isSave) {
            return null;
        }
        return menuEntity;
    }

    @Override
    public List<MenuEntity> getMenusTree() {
        List<MenuEntity> menusTree = this.menuDao.getMenusTree();
        return menusTree;
    }

}
