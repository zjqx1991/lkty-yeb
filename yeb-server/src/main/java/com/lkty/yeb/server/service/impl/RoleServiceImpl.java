package com.lkty.yeb.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkty.yeb.common.code.RavenCodeEnum;
import com.lkty.yeb.common.handler.RavenException;
import com.lkty.yeb.common.pojo.server.RoleEntity;
import com.lkty.yeb.server.dao.IRoleDao;
import com.lkty.yeb.server.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<IRoleDao, RoleEntity> implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<RoleEntity> getRolesByUid(Integer uid) {
        if (null == uid) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        List<RoleEntity> list = this.roleDao.getRolesByUid(uid);
        return list;
    }
}
