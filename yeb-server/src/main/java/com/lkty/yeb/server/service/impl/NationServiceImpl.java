package com.lkty.yeb.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkty.yeb.common.pojo.server.NationEntity;
import com.lkty.yeb.server.dao.INationDao;
import com.lkty.yeb.server.service.INationService;
import org.springframework.stereotype.Service;

@Service
public class NationServiceImpl extends ServiceImpl<INationDao, NationEntity> implements INationService {

}
