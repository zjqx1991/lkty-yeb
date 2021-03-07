package com.lkty.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkty.yeb.common.pojo.server.EmployeeTrainEntity;
import com.lkty.yeb.server.dao.IEmployeeTrainDao;
import com.lkty.yeb.server.service.IEmployeeTrainService;
import org.springframework.stereotype.Service;


@Service
public class EmployeeTrainServiceImpl extends ServiceImpl<IEmployeeTrainDao, EmployeeTrainEntity> implements IEmployeeTrainService {

}
