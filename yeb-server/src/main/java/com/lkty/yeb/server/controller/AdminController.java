package com.lkty.yeb.server.controller;

import com.lkty.yeb.api.admin.IAdminAPI;
import com.lkty.yeb.common.pojo.server.AdminEntity;
import com.lkty.yeb.common.result.R;
import com.lkty.yeb.server.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController implements IAdminAPI {

    @Autowired
    private IAdminService adminService;

    @Override
    public R saveAddUpdate(@RequestBody AdminEntity adminEntity) {
        AdminEntity admin = this.adminService.saveAddUpdate(adminEntity);
        return R.ok().put("data", admin);
    }

    @Override
    public R delete(@PathVariable("adminId") Integer adminId) {
        boolean bol = this.adminService.removeById(adminId);
        return R.ok().put("data", bol);
    }

    @Override
    public R list() {
        List<AdminEntity> list = this.adminService.list();
        return R.ok().put("data", list);
    }
}
