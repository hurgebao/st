package com.none.st.bosscenter.dao.client;

import org.apache.ibatis.annotations.Param;

import com.none.st.bosscenter.facade.stub.dto.BcAccountDTO;

/**
 * 账户信息表操作mapper
 * 
 * @author shi
 *
 */
public interface AccountMapper {
	/**
	 * 根据登陆名查询账户信息
	 * 
	 * @param username
	 * @return
	 */
	BcAccountDTO selectByUsername(@Param("username") String username);
}
