package com.lkty.yeb.server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lkty.yeb.common.pojo.server.MailLogEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMailLogDao extends BaseMapper<MailLogEntity> {

}
