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

    /**
     * 删除菜单
     * @param ids 菜单id列表
     * @return
     */
    Boolean deleteBatchByIds(List<Integer> ids);

    /**
     * 更新菜单
     * @param menuEntity
     * @return
     */
    Boolean update(MenuEntity menuEntity);
}

