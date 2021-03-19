package com.lkty.yeb.api.admin;


import com.lkty.yeb.common.pojo.server.AdminRoleEntity;
import com.lkty.yeb.common.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value = "用户与角色表", description = "用户与角色表管理，提供增、删、改、查")
@RequestMapping("/api/adminRole")
public interface IAppraiseAPI {

    /**
     * 增加
     */
    @ApiOperation("增加")
    @PostMapping("/save")
    R save(@RequestBody AdminRoleEntity adminRoleEntity);

    /**
     * 根据 id 删除
     */
    @ApiOperation("根据 id 删除")
    @PostMapping("/delete/{id}")
    R delete(@PathVariable("id") Integer id);

    @ApiOperation("获取全部列表")
    @GetMapping("/list")
    R list();


}
