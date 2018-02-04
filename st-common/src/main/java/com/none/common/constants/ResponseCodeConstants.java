package com.none.common.constants;

/**
 * 返回码常量类
 * 
 * @author shi
 *
 */
public class ResponseCodeConstants {
	/**
	 * 交易成功
	 */
	public static final String SUCCESS = "000000";
	/**
	 * bc系統內部異常
	 */
	public static final String BC_ERROR = "100000";
	/**
	 * 用戶名或者密碼錯誤
	 */
	public static final String USERNAME_PASSWORD_ERROR = "100001";
	/**
	 * 账户状态异常
	 */
	public static final String ACCOUNT_STATUS_UNABLE = "100002";
	/**
	 * 用戶名或者密碼不能为空
	 */
	public static final String USERNAME_PASSWORD_IS_NULL = "100003";
}
