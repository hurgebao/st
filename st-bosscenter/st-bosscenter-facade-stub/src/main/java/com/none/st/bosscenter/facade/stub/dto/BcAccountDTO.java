package com.none.st.bosscenter.facade.stub.dto;

import com.none.api.dto.BaseDTO;

/**
 * 账户信息实体类
 * 
 * @author shi
 *
 */
public class BcAccountDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private int id;
	/**
	 * 账户编号
	 */
	private String accountNo;
	/**
	 * 账户名称
	 */
	private String accountName;
	/**
	 * 登陆名
	 */
	private String username;
	/**
	 * 登陆密码
	 */
	private String password;
	/**
	 * 用户所属机构编号
	 */
	private String orgNo;
	/**
	 * 用户手机号
	 */
	private String mobile;
	/**
	 * 交易账户状态
	 */
	private String accountStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

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

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
}
