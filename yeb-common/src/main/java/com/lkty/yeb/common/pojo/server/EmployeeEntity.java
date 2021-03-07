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
@TableName("t_employee")
public class EmployeeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 员工编号
	 */
	@TableId
	private Integer id;
	/**
	 * 员工姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 出生日期
	 */
	private Date birthday;
	/**
	 * 身份证号
	 */
	private String idcard;
	/**
	 * 婚姻状况
	 */
	private Enum wedlock;
	/**
	 * 民族
	 */
	private Integer nationid;
	/**
	 * 籍贯
	 */
	private String nativeplace;
	/**
	 * 政治面貌
	 */
	private Integer politicid;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 电话号码
	 */
	private String phone;
	/**
	 * 联系地址
	 */
	private String address;
	/**
	 * 所属部门
	 */
	private Integer departmentid;
	/**
	 * 职称ID
	 */
	private Integer joblevelid;
	/**
	 * 职位ID
	 */
	private Integer posid;
	/**
	 * 聘用形式
	 */
	private String engageform;
	/**
	 * 最高学历
	 */
	private Enum tiptopdegree;
	/**
	 * 所属专业
	 */
	private String specialty;
	/**
	 * 毕业院校
	 */
	private String school;
	/**
	 * 入职日期
	 */
	private Date begindate;
	/**
	 * 在职状态
	 */
	private Enum workstate;
	/**
	 * 工号
	 */
	private String workid;
	/**
	 * 合同期限
	 */
	private Double contractterm;
	/**
	 * 转正日期
	 */
	private Date conversiontime;
	/**
	 * 离职日期
	 */
	private Date notworkdate;
	/**
	 * 合同起始日期
	 */
	private Date begincontract;
	/**
	 * 合同终止日期
	 */
	private Date endcontract;
	/**
	 * 工龄
	 */
	private Integer workage;
	/**
	 * 工资账套ID
	 */
	private Integer salaryid;

}
