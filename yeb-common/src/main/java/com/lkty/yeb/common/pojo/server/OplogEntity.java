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
 * @date 2021-03-07 22:20:45
 */
@Data
@TableName("t_oplog")
public class OplogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 添加日期
	 */
	private Date adddate;
	/**
	 * 操作内容
	 */
	private String operate;
	/**
	 * 操作员ID
	 */
	private Integer adminid;

}
