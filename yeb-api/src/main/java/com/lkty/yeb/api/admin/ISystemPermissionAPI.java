package com.lkty.yeb.api.admin;


import com.lkty.yeb.common.pojo.server.MenuEntity;
import com.lkty.yeb.common.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "系统管理-管理权限（角色 / 菜单）", description = "系统管理-管理权限（角色 / 菜单）")
@RequestMapping("/api/system/basic")
public interface ISystemPermissionAPI {

    @ApiOperation("新增菜单权限")
    @PostMapping("/menu/save")
    R save(@RequestBody MenuEntity menuEntity);

    @ApiOperation("删除菜单权限")
    @PostMapping("/menu/delete")
    R deleteBatchByIds(@RequestBody List<Integer> ids);


    @ApiOperation("更新权限")
    @PostMapping("/menu/update/{id}")
    R update(@RequestBody MenuEntity menuEntity);

    @ApiOperation("获取menu树")
    @GetMapping("/menu/tree")
    R getMenusTree();


}
