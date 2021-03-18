package com.lkty.yeb.server.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkty.yeb.common.code.RavenCodeEnum;
import com.lkty.yeb.common.handler.RavenException;
import com.lkty.yeb.common.pojo.server.PositionEntity;
import com.lkty.yeb.common.request.RequestCondition;
import com.lkty.yeb.server.dao.IPositionDao;
import com.lkty.yeb.server.service.IPositionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl extends ServiceImpl<IPositionDao, PositionEntity> implements IPositionService {

    @Override
    public PositionEntity savePosition(PositionEntity position) {
        if (null == position || null != position.getId()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        boolean save = this.save(position);
        if (!save) {
            throw new RavenException(RavenCodeEnum.POSITION_SAVE_FAIL);
        }
        return position;
    }

    @Override
    public Boolean deleteById(Integer id) {
        if (null == id) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        return this.removeById(id);
    }

    @Override
    public Boolean deleteBatchByIds(List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        return this.removeByIds(ids);
    }

    @Override
    public PositionEntity updatePositionById(PositionEntity position) {
        if (null == position || null == position.getId()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        boolean isUpdate = this.updateById(position);
        if (!isUpdate) {
            throw new RavenException(RavenCodeEnum.POSITION_UPDATE_FAIL);
        }
        return position;
    }

    @Override
    public Page<PositionEntity> listByCondition(RequestCondition condition) {
        if (null == condition) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        QueryWrapper<PositionEntity> wrapper = new QueryWrapper<>();
        Page<PositionEntity> page = new Page<>(condition.getPage(), condition.getSize());
        this.page(page, wrapper);
        return page;
    }
}
