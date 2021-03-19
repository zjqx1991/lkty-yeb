package com.lkty.yeb.server.controller;

import com.lkty.yeb.api.admin.ISystemPermissionAPI;
import com.lkty.yeb.common.code.RavenCodeEnum;
import com.lkty.yeb.common.handler.RavenException;
import com.lkty.yeb.common.pojo.server.MenuEntity;
import com.lkty.yeb.common.pojo.server.RoleEntity;
import com.lkty.yeb.common.result.R;
import com.lkty.yeb.server.service.ISystemPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class SystemPermissionController implements ISystemPermissionAPI {

    @Autowired
    private ISystemPermissionService permissionService;


    //************** 权限 - 菜单 - CRUD **************

    @Override
    public R saveMenu(@RequestBody MenuEntity menuEntity) {
        if (null == menuEntity || null != menuEntity.getId()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        MenuEntity menu = this.permissionService.saveMenu(menuEntity);
        return R.ok().put("data", menu);
    }

    @Override
    public R deleteMenuBatchByIds(@RequestBody List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        Boolean isDeleteBatch = this.permissionService.deleteBatchByIds(ids);
        return R.ok().put("data", isDeleteBatch);
    }

    @Override
    public R updateMenu(@RequestBody MenuEntity menuEntity) {
        if (null == menuEntity || null == menuEntity.getId()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        Boolean isUpdate = this.permissionService.update(menuEntity);
        return R.ok().put("data", isUpdate);
    }

    @Override
    public R getMenusTree() {
        List<MenuEntity> menuTree = this.permissionService.getMenusTree();
        return R.ok().put("data", menuTree);
    }



    //************** 权限 - 角色 - CRUD **************

    @Override
    public R saveRole(@RequestBody RoleEntity role) {
        if (null == role || null != role.getId()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        role = this.permissionService.saveRole(role);
        return R.ok().put("data", role);
    }

    @Override
    public R deleteRoleBatchByIds(@RequestBody List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        Boolean isDelete = this.permissionService.deleteRoleBatchByIds(ids);
        return R.ok().put("data", isDelete);
    }

    @Override
    public R updateRole(@RequestBody RoleEntity role) {
        if (null == role || null == role.getId()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        Boolean isUpdate = this.permissionService.updateRole(role);
        return R.ok().put("data", isUpdate);
    }

    @Override
    public R getRoleList() {
        List<RoleEntity> list = this.permissionService.getRoleList();
        return R.ok().put("data", list);
    }
}
