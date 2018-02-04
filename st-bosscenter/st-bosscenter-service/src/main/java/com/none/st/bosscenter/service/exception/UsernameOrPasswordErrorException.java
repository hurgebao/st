package com.none.st.bosscenter.service.exception;

import java.awt.image.DirectColorModel;

import com.none.api.exception.BaseException;
import com.none.common.constants.ResponseCodeConstants;

/**
 * 用户或密码错误异常类
 * 
 * @author shi
 *
 */
public class UsernameOrPasswordErrorException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsernameOrPasswordErrorException(String msg) {
		super(msg);
	}

	@Override
	public String getCode() {
		return ResponseCodeConstants.USERNAME_PASSWORD_ERROR;
	}

}
