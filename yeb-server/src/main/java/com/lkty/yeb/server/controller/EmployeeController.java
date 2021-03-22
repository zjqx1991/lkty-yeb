package com.lkty.yeb.server.controller;


import com.lkty.yeb.api.admin.IEmployeeAPI;
import com.lkty.yeb.common.code.RavenCodeEnum;
import com.lkty.yeb.common.handler.RavenException;
import com.lkty.yeb.common.pojo.server.EmployeeEntity;
import com.lkty.yeb.common.result.R;
import com.lkty.yeb.server.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController implements IEmployeeAPI {

    @Autowired
    private IEmployeeService employeeService;

    @Override
    public R saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
        if (null == employeeEntity || null != employeeEntity.getId()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        employeeEntity = this.employeeService.saveEmployee(employeeEntity);
        return R.ok().put("data", employeeEntity);
    }

    @Override
    public R updateEmployee(@RequestBody EmployeeEntity employeeEntity) {
        if (null == employeeEntity || null == employeeEntity.getId()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        employeeEntity = this.employeeService.updateEmployee(employeeEntity);
        return R.ok().put("data", employeeEntity);
    }

    @Override
    public R deleteByIds(@RequestBody List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        Boolean isDelete = this.employeeService.deleteByIds(ids);
        return R.ok().put("data", isDelete);
    }

    @Override
    public R list() {
        List<EmployeeEntity> list = this.employeeService.list();
        return R.ok().put("data", list);
    }
}
