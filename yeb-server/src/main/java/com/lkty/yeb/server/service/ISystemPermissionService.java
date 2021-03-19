package com.lkty.yeb.server.service;

import com.lkty.yeb.common.pojo.server.MenuEntity;

import java.util.List;

public interface ISystemPermissionService {

    /**
     * 保存菜单
     */
    MenuEntity saveMenu(MenuEntity menuEntity);

    /**
     * 三层菜单列表
     */
    List<MenuEntity> getMenusTree();
}

