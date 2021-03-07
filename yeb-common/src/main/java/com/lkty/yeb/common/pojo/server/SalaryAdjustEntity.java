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
 * @date 2021-03-07 22:20:44
 */
@Data
@TableName("t_salary_adjust")
public class SalaryAdjustEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 员工ID
	 */
	private Integer eid;
	/**
	 * 调薪日期
	 */
	private Date asdate;
	/**
	 * 调前薪资
	 */
	private Integer beforesalary;
	/**
	 * 调后薪资
	 */
	private Integer aftersalary;
	/**
	 * 调薪原因
	 */
	private String reason;
	/**
	 * 备注
	 */
	private String remark;

}
