package com.none.st.bossweb.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.none.api.dto.EntityResponse;
import com.none.st.bosscenter.facade.stub.BcAccountLoginFacade;
import com.none.st.bosscenter.facade.stub.dto.BcAccountDTO;
import com.none.st.bosscenter.facade.stub.dto.BcLoginRequest;

@Controller
@RequestMapping("sys")
public class LoginController {
	@Autowired
	private BcAccountLoginFacade bcAccountLoginFacade;

	@ResponseBody
	@RequestMapping("login")
	public EntityResponse<BcAccountDTO> login(String username, String password) {
		System.out.println("username=" + username + ",password=" + password);
		BcLoginRequest request = new BcLoginRequest();
		request.setSourceSysCode("BOSSWEB");
		request.setTid(UUID.randomUUID().toString());
		request.setUsername(username);
		request.setPassword(password);
		EntityResponse<BcAccountDTO> response = bcAccountLoginFacade.login(request);
		return response;
	}
}
