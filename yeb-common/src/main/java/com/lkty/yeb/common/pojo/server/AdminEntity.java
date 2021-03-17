package com.lkty.yeb.common.pojo.server;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 用户
 */
@Data
@TableName("t_admin")
@ApiModel(value="AdminEntity对象", description="用户对象")
public class AdminEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("id")
	@TableId
	private Integer id;

	@ApiModelProperty("姓名")
	private String name;

	@ApiModelProperty("手机号码")
	private String phone;

	@ApiModelProperty("住宅电话")
	private String telephone;

	@ApiModelProperty("联系地址")
	private String address;

	@ApiModelProperty("是否启用")
	private Integer enabled;

	@ApiModelProperty("用户名")
	private String username;

	@ApiModelProperty("密码")
	private String password;

	@ApiModelProperty("用户头像")
	private String userface;

	@ApiModelProperty("备注")
	private String remark;

}
