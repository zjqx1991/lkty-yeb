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
 * @date 2021-03-07 22:20:43
 */
@Data
@TableName("t_position")
public class PositionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 职位
	 */
	private String name;
	/**
	 * 创建时间
	 */
	private Date createdate;
	/**
	 * 是否启用
	 */
	private Integer enabled;

}
