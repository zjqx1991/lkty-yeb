package com.lkty.yeb.api.admin;


import com.lkty.yeb.common.pojo.server.PositionEntity;
import com.lkty.yeb.common.request.RequestCondition;
import com.lkty.yeb.common.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "职位表", description = "职位表管理，提供增、删、改、查")
@RequestMapping("/api/system/basic/position")
public interface IPositionAPI {

    @ApiOperation("新增职位")
    @PostMapping("/save")
    R save(@RequestBody PositionEntity position);

    @ApiOperation("使用职位id删除")
    @PostMapping("/delete/{id}")
    R delete(@PathVariable("id") Integer id);

    @ApiOperation("根据职位批量删除")
    @PostMapping("/delete")
    R deleteBatchByIds(@RequestBody List<Integer> ids);

    @ApiOperation("更新职位")
    @PostMapping("/update")
    R update(@RequestBody PositionEntity position);

    @ApiOperation("职位列表")
    @GetMapping("/list")
    R list();

    @ApiOperation("条件查询职位列表")
    @PostMapping("/list")
    R list(@RequestBody RequestCondition condition);

}
