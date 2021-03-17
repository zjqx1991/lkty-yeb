package com.lkty.yeb.server.controller;

import com.lkty.yeb.api.admin.IMenuAPI;
import com.lkty.yeb.common.pojo.server.MenuEntity;
import com.lkty.yeb.common.result.R;
import com.lkty.yeb.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;


@RestController
public class MenuController implements IMenuAPI {

    @Autowired
    private IMenuService menuService;

    @Override
    public R list() {
        List<MenuEntity> list = this.menuService.getListByUid();
        return R.ok().put("data", list);
    }
}
