package com.lkty.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkty.yeb.common.pojo.server.DepartmentEntity;
import com.lkty.yeb.server.dao.IDepartmentDao;
import com.lkty.yeb.server.service.IDepartmentService;
import org.springframework.stereotype.Service;


@Service
public class DepartmentServiceImpl extends ServiceImpl<IDepartmentDao, DepartmentEntity> implements IDepartmentService {

}
