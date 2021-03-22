package com.lkty.yeb.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkty.yeb.common.code.RavenCodeEnum;
import com.lkty.yeb.common.handler.RavenException;
import com.lkty.yeb.common.pojo.server.EmployeeEntity;
import com.lkty.yeb.server.dao.IEmployeeDao;
import com.lkty.yeb.server.service.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl extends ServiceImpl<IEmployeeDao, EmployeeEntity> implements IEmployeeService {

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        if (null == employeeEntity || null != employeeEntity.getId()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        boolean isSave = this.save(employeeEntity);
        if (!isSave) {
            throw new RavenException(RavenCodeEnum.EMPLOYEE_SAVE_FAIL);
        }
        return employeeEntity;
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        if (null == employeeEntity || null == employeeEntity.getId()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        boolean isUpdate = this.updateById(employeeEntity);
        if (!isUpdate) {
            throw new RavenException(RavenCodeEnum.EMPLOYEE_UPDATE_FAIL);
        }
        return employeeEntity;
    }

    @Override
    public Boolean deleteByIds(List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        boolean idRmove = this.removeByIds(ids);
        if (!idRmove) {
            throw new RavenException(RavenCodeEnum.EMPLOYEE_DELETE_FAIL);
        }
        return idRmove;
    }
}
