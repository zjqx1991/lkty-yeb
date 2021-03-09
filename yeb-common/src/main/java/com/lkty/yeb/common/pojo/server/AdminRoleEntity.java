package com.lkty.yeb.common.pojo.server;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *	用户与角色 中间表
 */
@Data
@TableName("t_admin_role")
public class AdminRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 用户id
	 */
	private Integer adminid;
	/**
	 * 权限id
	 */
	private Integer rid;

}
