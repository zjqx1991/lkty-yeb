package com.lkty.yeb.common.pojo.server;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("t_position")
@ApiModel("职位 对象")
public class PositionEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	@ApiModelProperty("自增主键id")
	@TableId
	private Integer id;

	@ApiModelProperty("职位")
	private String name;

	@ApiModelProperty("创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
	private Date createdate;

	@ApiModelProperty("是否启用")
	private Integer enabled;

}
