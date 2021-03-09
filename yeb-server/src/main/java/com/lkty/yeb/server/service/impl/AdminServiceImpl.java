package com.lkty.yeb.server.service.impl;

import com.lkty.yeb.common.pojo.server.AdminEntity;
import com.lkty.yeb.server.dao.IAdminDao;
import com.lkty.yeb.server.service.IAdminService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service
public class AdminServiceImpl extends ServiceImpl<IAdminDao, AdminEntity> implements IAdminService {


    @Override
    public AdminEntity saveAddUpdate(AdminEntity adminEntity) {
        return null;
    }

}
