package com.lkty.yeb.api.admin;


import com.lkty.yeb.common.pojo.server.AdminEntity;
import com.lkty.yeb.common.pojo.server.DepartmentEntity;
import com.lkty.yeb.common.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value = "部门表", description = "部门表管理，提供增、删、改、查")
@RequestMapping("/api/department")
public interface IDepartmentAPI {

    /**
     * 增加或修改
     */
    @ApiOperation("增加或修改")
    @PostMapping("/saveOrUpdate")
    R saveAddUpdate(@RequestBody DepartmentEntity departmentEntity);

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
