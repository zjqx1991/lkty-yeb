package com.lkty.yeb.api.admin;


import com.lkty.yeb.common.pojo.server.DepartmentEntity;
import com.lkty.yeb.common.pojo.server.MenuEntity;
import com.lkty.yeb.common.pojo.server.RoleEntity;
import com.lkty.yeb.common.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(value = "系统管理-管理权限（角色 / 菜单）", description = "系统管理-管理权限（角色 / 菜单）")
@RequestMapping("/api/system/basic")
public interface ISystemPermissionAPI {

    //************** 权限 - 菜单 - CRUD **************

    @ApiOperation("新增菜单权限")
    @PostMapping("/menu/save")
    R saveMenu(@RequestBody MenuEntity menuEntity);

    @ApiOperation("删除菜单权限")
    @PostMapping("/menu/delete")
    R deleteMenuBatchByIds(@RequestBody List<Integer> ids);


    @ApiOperation("更新权限")
    @PostMapping("/menu/update/{id}")
    R updateMenu(@RequestBody MenuEntity menuEntity);

    @ApiOperation("获取menu树")
    @GetMapping("/menu/tree")
    R getMenusTree();

    //************** 权限 - 角色 - CRUD **************

    @ApiOperation("新增角色权限")
    @PostMapping("/role/save")
    R saveRole(@RequestBody RoleEntity role);

    @ApiOperation("删除角色权限")
    @PostMapping("/role/delete")
    R deleteRoleBatchByIds(@RequestBody List<Integer> ids);


    @ApiOperation("更新角色权限")
    @PostMapping("/role/update/{id}")
    R updateRole(@RequestBody RoleEntity role);

    @ApiOperation("获取角色列表")
    @GetMapping("/role")
    R getRoleList();


    //************** 权限 - 部门 - CRUD **************

    @ApiOperation("新增部门")
    @PostMapping("/department/save")
    R saveDepartment(@RequestBody DepartmentEntity department);

    @ApiOperation("删除部门")
    @PostMapping("/department/delete")
    R deleteDepartmentBatchByIds(@RequestBody List<Integer> ids);


    @ApiOperation("更新部门")
    @PostMapping("/department/update/{id}")
    R updateDepartment(@RequestBody DepartmentEntity department);

    @ApiOperation("获取部门树")
    @GetMapping("/department")
    R getDepartmentTree();
}
