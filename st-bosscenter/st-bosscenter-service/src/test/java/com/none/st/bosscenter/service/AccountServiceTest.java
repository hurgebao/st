package com.none.st.bosscenter.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.none.st.bosscenter.facade.stub.dto.BcAccountDTO;
import com.none.st.bosscenter.service.exception.AccountStatusUnableException;
import com.none.st.bosscenter.service.exception.UsernameOrPasswordErrorException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-bosscenter-service.xml" })
public class AccountServiceTest {
	@Autowired
	private AccountService accountService;

	@Test
	public void testLoginByUsername() {
		try {
			BcAccountDTO account = accountService.loginByUsername("zhangsan", "1234561");
			System.out.println("account" + account);
		} catch (UsernameOrPasswordErrorException | AccountStatusUnableException e) {
			e.printStackTrace();
		}
	}

}
