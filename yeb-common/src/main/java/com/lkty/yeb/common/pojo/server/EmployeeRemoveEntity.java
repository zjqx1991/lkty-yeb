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
@TableName("t_employee_remove")
public class EmployeeRemoveEntity implements Serializable {
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
	 * 调动后部门
	 */
	private Integer afterdepid;
	/**
	 * 调动后职位
	 */
	private Integer afterjobid;
	/**
	 * 调动日期
	 */
	private Date removedate;
	/**
	 * 调动原因
	 */
	private String reason;
	/**
	 * 备注
	 */
	private String remark;

}
