package com.lkty.yeb.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkty.yeb.common.pojo.server.EmployeeEntity;
import com.lkty.yeb.server.dao.IEmployeeDao;
import com.lkty.yeb.server.service.IEmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<IEmployeeDao, EmployeeEntity> implements IEmployeeService {

}
