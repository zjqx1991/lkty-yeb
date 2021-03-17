package com.lkty.yeb.common.pojo.server;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *	用户与角色 中间表
 */
@Data
@TableName("t_admin_role")
@ApiModel(value="AdminRoleEntity对象", description="用户-角色-中间-对象")
public class AdminRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	@ApiModelProperty("id")
	private Integer id;

	@ApiModelProperty("用户id")
	private Integer adminid;

	@ApiModelProperty("权限id")
	private Integer rid;

}
