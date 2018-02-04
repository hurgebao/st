package com.none.st.bosscenter.facade.stub.dto;

import com.none.api.dto.BasicRequest;

/**
 * 登陆请求
 * 
 * @author shi
 *
 */
public class BcLoginRequest extends BasicRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 登陆用户名
	 */
	private String username;
	/**
	 * 登陆密码
	 */
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
