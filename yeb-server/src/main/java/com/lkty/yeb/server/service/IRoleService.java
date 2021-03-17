package com.lkty.yeb.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lkty.yeb.common.pojo.server.RoleEntity;

import java.util.List;

public interface IRoleService extends IService<RoleEntity> {

    List<RoleEntity> getRolesByUid(Integer uid);
}

