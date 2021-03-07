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
@TableName("t_sys_msg")
public class SysMsgEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 消息id
	 */
	private Integer mid;
	/**
	 * 0表示群发消息
	 */
	private Integer type;
	/**
	 * 这条消息是给谁的
	 */
	private Integer adminid;
	/**
	 * 0 未读 1 已读
	 */
	private Integer state;

}
