package com.lkty.yeb.api.admin;


import com.lkty.yeb.common.pojo.server.EmployeeEntity;
import com.lkty.yeb.common.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "员工表", description = "员工表管理，提供增、删、改、查")
@RequestMapping("/api/employee/basic")
public interface IEmployeeAPI {

    @ApiOperation("增加")
    @PostMapping("/save")
    R saveEmployee(@RequestBody EmployeeEntity employeeEntity);


    @ApiOperation("更新修改")
    @PostMapping("/update")
    R updateEmployee(@RequestBody EmployeeEntity employeeEntity);

    @ApiOperation("根据 id 删除")
    @PostMapping("/delete")
    R deleteByIds(@RequestBody List<Integer> ids);

    @ApiOperation("获取全部列表")
    @GetMapping("/list")
    R list();

}
