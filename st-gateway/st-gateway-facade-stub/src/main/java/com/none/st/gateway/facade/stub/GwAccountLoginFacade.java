package com.none.st.gateway.facade.stub;

import com.none.api.dto.EntityResponse;
import com.none.st.bosscenter.facade.stub.dto.BcAccountDTO;
import com.none.st.bosscenter.facade.stub.dto.BcLoginRequest;

/**
 * 账户登陆
 * @author shi
 *
 */
public interface GwAccountLoginFacade {
	/**
	 * 账户登陆
	 * @param request  登陆请求信息
	 * @return 账户信息
	 */
	EntityResponse<BcAccountDTO> login(BcLoginRequest request);
}
