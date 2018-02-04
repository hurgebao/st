package com.none.st.gateway.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.none.api.dto.EntityResponse;
import com.none.st.bosscenter.facade.stub.BcAccountLoginFacade;
import com.none.st.bosscenter.facade.stub.dto.BcAccountDTO;
import com.none.st.bosscenter.facade.stub.dto.BcLoginRequest;
import com.none.st.gateway.facade.stub.GwAccountLoginFacade;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
@Controller
@Api( value = "账户基础功能")
@RequestMapping("/account")
public class GwAccountLoginFacadeImpl implements GwAccountLoginFacade {
	@Autowired
	private BcAccountLoginFacade bcAccountLoginFacade;
	@Override
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ApiResponse(code=0,message="登陆成功")
	@ResponseBody
	@ApiOperation(value="账号登陆",httpMethod="POST",notes="账号登陆")
	public EntityResponse<BcAccountDTO> login(@ApiParam(required=true,value="登陆信息") @RequestBody BcLoginRequest request) {
		EntityResponse<BcAccountDTO> response=new EntityResponse<BcAccountDTO>();
		response=bcAccountLoginFacade.login(request);
		return response;
	}

}
