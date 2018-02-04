package com.none.st.gateway.facade.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/**
 * session拦截器
 * @author shi
 *
 */
public class SessionInterceptor  extends HandlerInterceptorAdapter{
	private static Logger logger=org.slf4j.LoggerFactory.getLogger(SessionInterceptor.class);
	private static ThreadLocal<Long> tl= new ThreadLocal<Long>();
	/**
	 * 校验token
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri=request.getRequestURI();
		String token=request.getHeader("token");
//		if(token==null || !TokenUtil.checkToken(token)){
//			response.setContentType("application/json;charset=utf-8");
//			response.setCharacterEncoding("utf-8");
//			ServletOutputStream sos=response.getOutputStream();
//			Map<String,Object> map=new HashMap<String,Object>();
//			map.put("returnCode", ResponseConstants.RETURN_CODE_CTRADECLIENT_ERROR);
//			map.put("returnMsg", "请您登录");
//			String res=JSON.toJSONString(map);
//			sos.write(res.getBytes("utf-8"));
//			sos.flush();
//			sos.close();
//			return false;
//		}
		tl.set(System.currentTimeMillis());
		return super.preHandle(request, response, handler);
	}
	/**
	 * 打印请求时间
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		Long startTime=tl.get();
		Long endTime=System.currentTimeMillis();
		String uri=request.getRequestURI();
		String s=request.getQueryString();
		if(logger.isInfoEnabled()){
			logger.info("uri:{},cost:{}ms",uri,endTime-startTime,s);
		}
		super.afterCompletion(request, response, handler, ex);
	}
}
