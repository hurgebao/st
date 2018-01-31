package com.none.api.dto;

import javax.validation.constraints.NotNull;
/**
 * 基础请求类
 * @author shi
 *
 */
public class BasicRequest extends BaseDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 原系统代码
	 * @return
	 */
	@NotNull(message="原系统代码不能为空")
	private String sourceSysCode;
	/**
	 * 业务id
	 */
	private String tid;
	/**
	 * 原系统代码
	 * @return
	 */
	public String getSourceSysCode() {
		return sourceSysCode;
	}
	/**
	 * 原系统代码
	 * @param sourceSysCode
	 */
	public void setSourceSysCode(String sourceSysCode) {
		this.sourceSysCode = sourceSysCode;
	}
	/**
	 * 
	 * @return 业务id
	 */
	public String getTid() {
		return tid;
	}
	/**
	 * 
	 * @param tid 业务id
	 */
	public void setTid(String tid) {
		this.tid = tid;
	}
}
