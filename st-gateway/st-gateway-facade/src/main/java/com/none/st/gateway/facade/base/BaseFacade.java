package com.none.st.gateway.facade.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.none.common.constants.ResponseCodeConstants;
/**
 * 异常捕获handler
 * @author shi
 *
 */
public class BaseFacade{
	private Logger logger=LoggerFactory.getLogger(BaseFacade.class);
	@ExceptionHandler
	@ResponseBody
	public ModelMap handleAndReturnJSON(HttpServletRequest request, HttpServletResponse response, Exception e) {
		logger.error("系统异常{}",e);
		ModelMap modelMap=new ModelMap();
		modelMap.addAttribute("returnCode", ResponseCodeConstants.GW_ERROR);
		modelMap.addAttribute("returnMsg", "后台服务繁忙,请稍后再试");
		return modelMap;
	}
}
