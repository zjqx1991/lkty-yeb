package com.lkty.yeb.server.service.impl;


import com.lkty.yeb.common.code.RavenCodeEnum;
import com.lkty.yeb.common.handler.RavenException;
import com.lkty.yeb.common.pojo.server.MenuEntity;
import com.lkty.yeb.common.pojo.server.RoleEntity;
import com.lkty.yeb.server.dao.IMenuDao;
import com.lkty.yeb.server.service.IMenuService;
import com.lkty.yeb.server.service.IRoleService;
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
    @Autowired
    private IRoleService roleService;


    //************** 权限 - 菜单 - CRUD **************

    @Override
    public MenuEntity saveMenu(MenuEntity menuEntity) {
        if (null == menuEntity || null != menuEntity.getId()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        boolean isSave = this.menuService.save(menuEntity);
        if (!isSave) {
            throw new RavenException(RavenCodeEnum.MENU_SAVE_FAIL);
        }
        return menuEntity;
    }

    @Override
    public Boolean deleteBatchByIds(List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        boolean isDelete = this.menuService.removeByIds(ids);
        if (!isDelete) {
            throw new RavenException(RavenCodeEnum.MENU_DELETE_FAIL);
        }
        return isDelete;
    }

    @Override
    public Boolean update(MenuEntity menuEntity) {
        if (null == menuEntity || null == menuEntity.getId()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        boolean isUpdate = this.menuService.updateById(menuEntity);
        if (!isUpdate) {
            throw new RavenException(RavenCodeEnum.MENU_UPDATE_FAIL);
        }
        return isUpdate;
    }

    @Override
    public List<MenuEntity> getMenusTree() {
        List<MenuEntity> menusTree = this.menuDao.getMenusTree();
        return menusTree;
    }


    //************** 权限 - 角色 - CRUD **************

    @Override
    public RoleEntity saveRole(RoleEntity role) {
        if (null == role || null != role.getId()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        // 判断角色名是否以 ROLE_ 开头
        if (!role.getName().startsWith("ROLE_")) {
             role.setName("ROLE_" + role.getName());
        }
        boolean isSave = this.roleService.save(role);
        if (!isSave) {
            throw new RavenException(RavenCodeEnum.ROLE_SAVE_FAIL);
        }
        return role;
    }

    @Override
    public Boolean deleteRoleBatchByIds(List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            throw new RavenException(RavenCodeEnum.FAIL);
        }
        boolean isDelete = this.roleService.removeByIds(ids);
        if (!isDelete) {
            throw new RavenException(RavenCodeEnum.ROLE_DELETE_FAIL);
        }
        return isDelete;
    }

    @Override
    public Boolean updateRole(RoleEntity role) {
        if (null == role || role.getId() == null) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        boolean isUpdate = this.roleService.updateById(role);
        if (!isUpdate) {
            throw new RavenException(RavenCodeEnum.ROLE_UPDATE_FAIL);
        }
        return isUpdate;
    }

    @Override
    public List<RoleEntity> getRoleList() {
        return this.roleService.list();
    }
}
