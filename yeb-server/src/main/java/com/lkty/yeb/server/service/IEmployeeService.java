package com.lkty.yeb.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lkty.yeb.common.pojo.server.EmployeeEntity;

import java.util.List;

public interface IEmployeeService extends IService<EmployeeEntity> {

    EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);

    EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);

    Boolean deleteByIds(List<Integer> ids);

}

