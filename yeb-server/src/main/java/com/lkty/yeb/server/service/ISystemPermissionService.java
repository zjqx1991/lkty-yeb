package com.lkty.yeb.server.service;

import com.lkty.yeb.common.pojo.server.DepartmentEntity;
import com.lkty.yeb.common.pojo.server.MenuEntity;
import com.lkty.yeb.common.pojo.server.RoleEntity;

import java.util.List;

public interface ISystemPermissionService {

    //************** 权限 - 菜单 - CRUD **************

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



    //************** 权限 - 角色 - CRUD **************

    /**
     * 保存角色
     * @param role
     * @return
     */
    RoleEntity saveRole(RoleEntity role);

    /**
     * 批量删除角色
     * @param ids
     * @return
     */
    Boolean deleteRoleBatchByIds(List<Integer> ids);

    /**
     * 更新角色
     * @param role
     * @return
     */
    Boolean updateRole(RoleEntity role);

    /**
     * 获取角色列表
     */
    List<RoleEntity> getRoleList();


    //************** 权限 - 部门 - CRUD **************

    /**
     * 保存部门
     */
    DepartmentEntity saveDepartment(DepartmentEntity department);

    /**
     * 删除部门
     */
    Boolean deleteDepartmentBatchByIds(List<Integer> ids);

    /**
     * 更新部门
     */
    DepartmentEntity updateDepartment(DepartmentEntity department);

    /**
     * 获取部门树
     */
    List<DepartmentEntity> getDepartmentTree();
}

