package com.none.st.bosscenter.service.exception;

import com.none.api.exception.BaseException;
import com.none.common.constants.ResponseCodeConstants;

/**
 * 
 * @author shi
 *
 */
public class AccountStatusUnableException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountStatusUnableException(String msg) {
		super(msg);
	}

	@Override
	public String getCode() {
		return ResponseCodeConstants.ACCOUNT_STATUS_UNABLE;
	}

}
