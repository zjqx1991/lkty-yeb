package com.lkty.yeb.server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lkty.yeb.common.pojo.server.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IRoleDao extends BaseMapper<RoleEntity> {

    @Select("SELECT DISTINCT r.* FROM t_role r, t_admin_role ar WHERE r.id = ar.rid AND ar.adminId = #{uid}")
    List<RoleEntity> getRolesByUid(@Param("uid") Integer uid);

    @Select("SELECT DISTINCT r.* FROM t_menu_role mr, t_role r WHERE mr.rid = r.id AND mr.mid = #{menuId}")
    List<RoleEntity> getRolesByMenuId(@Param("menuId") Integer menuId);

}
