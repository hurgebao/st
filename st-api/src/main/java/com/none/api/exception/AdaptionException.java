package com.none.api.exception;

/**
 * 自适应异常，按场景设置返回码和返回信息
 * 
 * @author shi
 *
 */
public class AdaptionException extends BaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 异常代码
	 */
	private String code;

	/**
	 * 有参构造方法，创建异常时必须明确提示信息
	 * 
	 * @param msg
	 */
	public AdaptionException(String msg) {
		super(msg);
	}

	/**
	 * 有参构造方法，创建异常时必须明确异常代码和提示信息
	 * 
	 * @param code
	 *            异常代码
	 * @param msg
	 *            提示信息
	 */
	public AdaptionException(String code, String msg) {
		super(msg);
		this.code = code;
	}

	@Override
	public String getCode() {
		return code;
	}
}
