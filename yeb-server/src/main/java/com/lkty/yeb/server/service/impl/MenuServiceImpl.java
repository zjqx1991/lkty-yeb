package com.lkty.yeb.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkty.yeb.common.pojo.server.MenuEntity;
import com.lkty.yeb.server.dao.IMenuDao;
import com.lkty.yeb.server.service.IMenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends ServiceImpl<IMenuDao, MenuEntity> implements IMenuService {


}
