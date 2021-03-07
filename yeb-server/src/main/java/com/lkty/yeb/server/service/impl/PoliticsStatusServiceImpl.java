package com.lkty.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkty.yeb.common.pojo.server.PoliticsStatusEntity;
import com.lkty.yeb.server.dao.IPoliticsStatusDao;
import com.lkty.yeb.server.service.IPoliticsStatusService;
import org.springframework.stereotype.Service;


@Service
public class PoliticsStatusServiceImpl extends ServiceImpl<IPoliticsStatusDao, PoliticsStatusEntity> implements IPoliticsStatusService {

}
