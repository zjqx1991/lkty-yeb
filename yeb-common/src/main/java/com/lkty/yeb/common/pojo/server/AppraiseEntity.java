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
 * @date 2021-03-07 22:20:47
 */
@Data
@TableName("t_appraise")
public class AppraiseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 员工id
	 */
	private Integer eid;
	/**
	 * 考评日期
	 */
	private Date appdate;
	/**
	 * 考评结果
	 */
	private String appresult;
	/**
	 * 考评内容
	 */
	private String appcontent;
	/**
	 * 备注
	 */
	private String remark;

}
