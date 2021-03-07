package com.lkty.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkty.yeb.common.pojo.server.OplogEntity;
import com.lkty.yeb.server.dao.IOplogDao;
import com.lkty.yeb.server.service.IOplogService;
import org.springframework.stereotype.Service;


@Service
public class OplogServiceImpl extends ServiceImpl<IOplogDao, OplogEntity> implements IOplogService {


}
