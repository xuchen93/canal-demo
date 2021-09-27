package com.github.xuchen93.canaldemo.entity;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author xuchen.wang
 * @date 2021/9/27
 */
@Data
public class OperateLog {
	private Integer id;
	private String method;
	@Column(name = "operate_user")
	private String operateUser;
	@Column(name = "request_uri")
	private String requestUri;
	@Column(name = "cost_time")
	private Integer costTime;
	@Column(name = "operate_time")
	private Date operateTime;
	@Column(name = "request_param")
	private String requestParam;
	@Column(name = "response_body")
	private String responseBody;
}
