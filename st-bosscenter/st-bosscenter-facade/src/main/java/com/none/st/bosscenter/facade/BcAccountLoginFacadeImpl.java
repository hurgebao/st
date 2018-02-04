package com.none.st.bosscenter.facade;

import org.springframework.beans.factory.annotation.Autowired;

import com.none.api.dto.EntityResponse;
import com.none.common.constants.ResponseCodeConstants;
import com.none.common.util.ValidateUtils;
import com.none.st.bosscenter.facade.stub.BcAccountLoginFacade;
import com.none.st.bosscenter.facade.stub.dto.BcAccountDTO;
import com.none.st.bosscenter.facade.stub.dto.BcLoginRequest;
import com.none.st.bosscenter.service.AccountService;
import com.none.st.bosscenter.service.exception.AccountStatusUnableException;
import com.none.st.bosscenter.service.exception.UsernameOrPasswordErrorException;

/**
 * 交易账户登陆
 * 
 * @author shi
 *
 */
public class BcAccountLoginFacadeImpl implements BcAccountLoginFacade {
	@Autowired
	private AccountService accountService;

	@Override
	public EntityResponse<BcAccountDTO> login(BcLoginRequest request) {
		EntityResponse<BcAccountDTO> response = new EntityResponse<BcAccountDTO>();
		if (ValidateUtils.checkIsNull(request.getUsername(), request.getPassword())) {
			response.setReturnCode(ResponseCodeConstants.USERNAME_PASSWORD_IS_NULL);
			response.setReturnMsg("用户名和密码不能为空");
			return response;
		}
		try {
			BcAccountDTO account = accountService.loginByUsername(request.getUsername(), request.getPassword());
			response.setT(account);
			response.setReturnCode(ResponseCodeConstants.SUCCESS);
			response.setReturnMsg("登陸成功");
		} catch (UsernameOrPasswordErrorException | AccountStatusUnableException e) {
			response.setReturnCode(e.getCode());
			response.setReturnMsg(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			response.setReturnCode(ResponseCodeConstants.BC_ERROR);
			response.setReturnMsg("后台服务繁忙,请稍后再试");
		}
		return response;
	}
}
