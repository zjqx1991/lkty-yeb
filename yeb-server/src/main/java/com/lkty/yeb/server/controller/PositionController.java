package com.lkty.yeb.server.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkty.yeb.api.admin.IPositionAPI;
import com.lkty.yeb.common.code.RavenCodeEnum;
import com.lkty.yeb.common.handler.RavenException;
import com.lkty.yeb.common.pojo.server.PositionEntity;
import com.lkty.yeb.common.request.RequestCondition;
import com.lkty.yeb.common.result.R;
import com.lkty.yeb.server.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PositionController implements IPositionAPI {

    @Autowired
    private IPositionService positionService;

    @Override
    public R save(@RequestBody PositionEntity position) {
        if (null == position || null != position.getId()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        position = this.positionService.savePosition(position);
        return R.ok().put("data", position);
    }

    @Override
    public R delete(@PathVariable("id") Integer id) {
        if (null == id) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        Boolean isDelete = this.positionService.deleteById(id);
        return R.ok().put("data", isDelete);
    }

    @Override
    public R deleteBatchByIds(@RequestBody List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        Boolean isBatch = this.positionService.deleteBatchByIds(ids);
        return R.ok().put("data", isBatch);
    }

    @Override
    public R update(@RequestBody PositionEntity position) {
        if (null == position || null == position.getId()) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        position = this.positionService.updatePositionById(position);
        return R.ok().put("data", position);
    }

    @Override
    public R list() {
        List<PositionEntity> list = this.positionService.list();
        return R.ok().put("data", list);
    }

    @Override
    public R list(@RequestBody RequestCondition condition) {
        if (null == condition) {
            throw new RavenException(RavenCodeEnum.PARAM_FAIL);
        }
        Page<PositionEntity> page = this.positionService.listByCondition(condition);
        return R.ok().put("data", page);
    }
}
