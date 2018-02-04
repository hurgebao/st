package com.none.api.dto;

import javax.validation.constraints.NotNull;

/**
 * 基础响应类
 * 
 * @author shi
 *
 */
public class BasicResponse extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 返回码
	 */
	@NotNull(message = "返回码不能为空")
	private String returnCode;
	/**
	 * 返回信息
	 */
	@NotNull(message = "返回信息不能为空")
	private String returnMsg;

	/**
	 * 
	 * @return 返回码
	 */
	public String getReturnCode() {
		return returnCode;
	}

	/**
	 * 
	 * @param returnCode
	 *            返回码
	 */
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	/**
	 * 
	 * @return 返回信息
	 */
	public String getReturnMsg() {
		return returnMsg;
	}

	/**
	 * 
	 * @param returnMsg
	 *            返回信息
	 */
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

}
