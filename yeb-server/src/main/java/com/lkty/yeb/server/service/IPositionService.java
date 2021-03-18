package com.lkty.yeb.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lkty.yeb.common.pojo.server.PositionEntity;
import com.lkty.yeb.common.request.RequestCondition;

import java.util.List;

public interface IPositionService extends IService<PositionEntity> {

    PositionEntity savePosition(PositionEntity position);

    Boolean deleteById(Integer id);

    Boolean deleteBatchByIds(List<Integer> ids);

    PositionEntity updatePositionById(PositionEntity position);

    Page<PositionEntity> listByCondition(RequestCondition condition);
}

