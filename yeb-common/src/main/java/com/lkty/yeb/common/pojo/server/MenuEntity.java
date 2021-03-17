package com.lkty.yeb.common.pojo.server;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 菜单
 */
@Data
@TableName("t_menu")
@ApiModel(value="MenuEntity对象", description="菜单对象")
public class MenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	@TableId
	private Integer id;

	@ApiModelProperty(value = "url")
	private String url;

	@ApiModelProperty(value = "path")
	private String path;

	@ApiModelProperty(value = "VUE组件")
	private String component;

	@ApiModelProperty(value = "菜单名")
	private String name;

	@ApiModelProperty(value = "VUE图标")
	private String iconCls;

	@ApiModelProperty(value = "是否保持激活")
	private Integer keepAlive;

	@ApiModelProperty(value = "是否要求权限")
	private Integer requireAuth;

	@ApiModelProperty(value = "菜单父id")
	private Integer parentId;

	@ApiModelProperty(value = "是否启用")
	private Integer enabled;

	@ApiModelProperty(value = "子菜单")
	@TableField(exist = false)
	private List<MenuEntity> children = new ArrayList<>();

	@ApiModelProperty("拥有该菜单的，角色列表")
	@TableField(exist = false)
	private List<RoleEntity> roles = new ArrayList<>();

}
