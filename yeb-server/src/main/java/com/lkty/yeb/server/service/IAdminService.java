package com.lkty.yeb.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lkty.yeb.common.pojo.server.AdminEntity;


public interface IAdminService extends IService<AdminEntity> {

    /**
     * 保存或更新
     */
    AdminEntity saveAddUpdate(AdminEntity adminEntity);
}

