package com.none.st.bosscenter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.none.common.constants.DictConstants;
import com.none.st.bosscenter.dao.client.AccountMapper;
import com.none.st.bosscenter.facade.stub.dto.BcAccountDTO;
import com.none.st.bosscenter.service.AccountService;
import com.none.st.bosscenter.service.exception.AccountStatusUnableException;
import com.none.st.bosscenter.service.exception.UsernameOrPasswordErrorException;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountMapper accountMapper;

	@Override
	public BcAccountDTO loginByUsername(String username, String password)
			throws UsernameOrPasswordErrorException, AccountStatusUnableException {
		BcAccountDTO accountDTO = accountMapper.selectByUsername(username);
		if (accountDTO == null || !password.equals(accountDTO.getPassword())) {
			throw new UsernameOrPasswordErrorException("用戶名或者密碼錯誤");
		}
		if (!DictConstants.ACCOUNT_STATUS_OK.equals(accountDTO.getAccountStatus())) {
			throw new AccountStatusUnableException("交易账户状态异常");
		}
		return accountDTO;
	}
}
