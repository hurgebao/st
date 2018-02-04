package com.none.st.bosscenter.service;

import com.none.st.bosscenter.facade.stub.dto.BcAccountDTO;
import com.none.st.bosscenter.service.exception.AccountStatusUnableException;
import com.none.st.bosscenter.service.exception.UsernameOrPasswordErrorException;

/**
 * 账户信息service
 * 
 * @author shi
 *
 */
public interface AccountService {
	/**
	 * 账户登陆
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws UsernameOrPasswordErrorException
	 *             用户名或密码错误
	 * @throws AccountStatusUnableException
	 *             账户状态异常
	 */
	BcAccountDTO loginByUsername(String username, String password)
			throws UsernameOrPasswordErrorException, AccountStatusUnableException;
}
