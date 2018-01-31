package com.none.api.exception;
/**
 * 异常基类 所有自定义异常必须继承本类
 * @author shi
 *
 */
public abstract class BaseException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 有参构造方法，创建异常时必须明确提示信息
	 * @param msg
	 */
	public BaseException(String msg) {
		super(msg);
	}
	/**
	 * 获取本异常的错误代码
	 * @return
	 */
	public abstract String getCode();
}
