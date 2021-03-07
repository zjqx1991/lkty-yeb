package com.lkty.yeb.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkty.yeb.common.pojo.server.PositionEntity;
import com.lkty.yeb.server.dao.IPositionDao;
import com.lkty.yeb.server.service.IPositionService;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl extends ServiceImpl<IPositionDao, PositionEntity> implements IPositionService {

}
