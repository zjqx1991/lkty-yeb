package com.lkty.yeb.common.pojo.server;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("部门")
@TableName("t_department")
public class DepartmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	@ApiModelProperty("自增主键id")
	@TableId
	private Integer id;

	@ApiModelProperty("部门名称")
	private String name;

	@ApiModelProperty("部门父id")
	private Integer parentid;

	@ApiModelProperty("路径")
	private String deppath;

	@ApiModelProperty("是否启用")
	private Integer enabled;

	@ApiModelProperty("是否上级")
	private Integer isparent;

}
