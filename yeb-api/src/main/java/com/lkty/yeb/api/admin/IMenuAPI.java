package com.lkty.yeb.api.admin;


import com.lkty.yeb.common.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value = "菜单表", description = "菜单表管理，提供增、删、改、查")
@RequestMapping("/sys")
public interface IMenuAPI {

    @ApiOperation("获取全部列表")
    @GetMapping("/cfg")
    R list();

}
