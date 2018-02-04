package com.none.st.bossweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// HttpSession session=request.getSession();
		// Object obj=session.getAttribute("account");
		// String contextPath=request.getContextPath();
		// if(obj==null || "".equals(obj)){
		// response.sendRedirect(contextPath+"/sys/toLogin");
		// return false;
		// }
		return super.preHandle(request, response, handler);
	}
}
