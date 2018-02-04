package com.none.st.bosscenter.dao.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.none.st.bosscenter.facade.stub.dto.BcAccountDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-bosscenter-dao.xml" })
public class AccountMapperTest {
	@Autowired
	private AccountMapper accountMapper;

	@Test
	public void testSelectByUsername() {
		BcAccountDTO account = accountMapper.selectByUsername("zhangsan");
		System.out.println(account);
	}

}
