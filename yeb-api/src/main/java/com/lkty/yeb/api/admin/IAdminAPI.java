package com.lkty.yeb.api.admin;


import com.lkty.yeb.common.pojo.server.AdminEntity;
import com.lkty.yeb.common.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value = "用户表", description = "用户表管理，提供增、删、改、查")
@RequestMapping("/admin")
public interface IAdminAPI {

    /**
     * 增加或修改
     */
    @ApiOperation("增加或修改")
    @PostMapping("/saveOrUpdate")
    R saveAddUpdate(@RequestBody AdminEntity adminEntity);

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
