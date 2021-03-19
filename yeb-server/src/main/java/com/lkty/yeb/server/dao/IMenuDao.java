package com.lkty.yeb.server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lkty.yeb.common.pojo.server.MenuEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IMenuDao extends BaseMapper<MenuEntity> {


    @Select("SELECT DISTINCT m1.* FROM t_menu m1, t_menu m2, t_menu_role mr, t_role r, t_admin_role ar WHERE m1.id = m2.parentId AND m2.id = mr.mid AND mr.rid = r.id AND r.id = ar.rid AND ar.adminId = #{uId}")
    @Results(id = "tree", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "url", column = "url"),
            @Result(property = "path", column = "path"),
            @Result(property = "component", column = "component"),
            @Result(property = "name", column = "name"),
            @Result(property = "iconCls", column = "iconCls"),
            @Result(property = "keepAlive", column = "keepAlive"),
            @Result(property = "requireAuth", column = "requireAuth"),
            @Result(property = "parentId", column = "parentId"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "children", column = "id", many = @Many(select = "getTreeByParentId")),
    })
    List<MenuEntity> getListByUid(@Param("uId") Integer uId);

    @Select("select * from t_menu where parentId = #{parentId}")
    @ResultMap("tree")
    List<MenuEntity> getTreeByParentId(Integer parentId);




    @Select("SELECT DISTINCT m.* FROM t_menu m, t_menu_role mr, t_role r WHERE m.id = mr.mid AND mr.rid = r.id")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "url", column = "url"),
            @Result(property = "path", column = "path"),
            @Result(property = "component", column = "component"),
            @Result(property = "name", column = "name"),
            @Result(property = "iconCls", column = "iconCls"),
            @Result(property = "keepAlive", column = "keepAlive"),
            @Result(property = "requireAuth", column = "requireAuth"),
            @Result(property = "parentId", column = "parentId"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "roles", column = "id", many = @Many(select = "com.lkty.yeb.server.dao.IRoleDao.getRolesByMenuId")),
    })
    List<MenuEntity> getMenuWithRoles();


    @Select("SELECT DISTINCT m1.* FROM t_menu m1, t_menu m2, t_menu m3 WHERE m1.id = m2.parentId AND m2.id = m3.parentId")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "url", column = "url"),
            @Result(property = "path", column = "path"),
            @Result(property = "component", column = "component"),
            @Result(property = "name", column = "name"),
            @Result(property = "iconCls", column = "iconCls"),
            @Result(property = "keepAlive", column = "keepAlive"),
            @Result(property = "requireAuth", column = "requireAuth"),
            @Result(property = "parentId", column = "parentId"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "children", column = "id", many = @Many(select = "getMenusTree2")),
    })
    List<MenuEntity> getMenusTree();


    @Select("select * from t_menu where parentId = #{parentId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "url", column = "url"),
            @Result(property = "path", column = "path"),
            @Result(property = "component", column = "component"),
            @Result(property = "name", column = "name"),
            @Result(property = "iconCls", column = "iconCls"),
            @Result(property = "keepAlive", column = "keepAlive"),
            @Result(property = "requireAuth", column = "requireAuth"),
            @Result(property = "parentId", column = "parentId"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "children", column = "id", many = @Many(select = "getMenusTree3")),
    })
    List<MenuEntity> getMenusTree2(@Param("parentId") Integer parentId);

    @Select("select * from t_menu where parentId = #{parentId}")
    List<MenuEntity> getMenusTree3(@Param("parentId") Integer parentId);
}
