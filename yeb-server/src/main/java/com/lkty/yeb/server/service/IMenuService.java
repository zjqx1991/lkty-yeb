package com.lkty.yeb.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lkty.yeb.common.pojo.server.MenuEntity;

import java.awt.*;
import java.util.List;

public interface IMenuService extends IService<MenuEntity> {

    List<MenuEntity> getListByUid();

    /**
     * 获取 Menu - Roles 关系
     * 获取 url 包含的 Roles
     */
    List<MenuEntity> getMenuWithRoles();

    /**
     * 三层菜单列表
     */
    List<MenuEntity> getMenusTree();
}

