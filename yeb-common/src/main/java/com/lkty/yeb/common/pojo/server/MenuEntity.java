package com.lkty.yeb.common.pojo.server;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-03-07 22:20:46
 */
@Data
@TableName("t_menu")
public class MenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * url
	 */
	private String url;
	/**
	 * path
	 */
	private String path;
	/**
	 * 组件
	 */
	private String component;
	/**
	 * 菜单名
	 */
	private String name;
	/**
	 * 图标
	 */
	private String iconcls;
	/**
	 * 是否保持激活
	 */
	private Integer keepalive;
	/**
	 * 是否要求权限
	 */
	private Integer requireauth;
	/**
	 * 父id
	 */
	private Integer parentid;
	/**
	 * 是否启用
	 */
	private Integer enabled;

}
