package com.lkty.yeb.server.controller;

import com.lkty.yeb.api.admin.ISystemPermissionAPI;
import com.lkty.yeb.common.code.RavenCodeEnum;
import com.lkty.yeb.common.handler.RavenException;
import com.lkty.yeb.common.pojo.server.MenuEntity;
import com.lkty.yeb.common.result.R;
import com.lkty.yeb.server.service.ISystemPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class SystemPermissionController implements ISystemPermissionAPI {

    @Autowired
    private ISystemPermissionService permissionService;

    @Override
    public R save(@RequestBody MenuEntity menuEntity) {
        if (null == menuEntity || null != menuEntity.getId()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        MenuEntity menu = this.permissionService.saveMenu(menuEntity);
        return R.ok().put("data", menu);
    }

    @Override
    public R deleteBatchByIds(@RequestBody List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        Boolean isDeleteBatch = this.permissionService.deleteBatchByIds(ids);
        return R.ok().put("data", isDeleteBatch);
    }

    @Override
    public R update(@RequestBody MenuEntity menuEntity) {
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
}
