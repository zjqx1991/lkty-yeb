package com.lkty.yeb.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lkty.yeb.common.pojo.server.MenuEntity;

import java.awt.*;
import java.util.List;

public interface IMenuService extends IService<MenuEntity> {

    List<MenuEntity> getListByUid();
}

