package com.none.api.log;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.aopalliance.intercept.Joinpoint;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 通过Spring AOP来添加系统日志
 */
public class LogAspect extends BaseAction {

	private static final long serialVersionUID = -5063868902693772455L;

	private static String splitParaStr = ",";
	private static String splitNameValueStr = ":";

	@Autowired
	LogServiceImpl logService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doSystemLog(Joinpoint point) throws Throwable {
		Object[] param = point.getArgs();
		Class[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();

		Method method = null;
		String methodName = point.getSignature().getName();

		if (!("set".startsWith(methodName) && !"get".startsWith(methodName) && !"query".startsWith(methodName)
				&& !"sel".startsWith(methodName))) { // 不需要记录日志的方法名
			Class targetClass = point.getTarget().getClass();
			method = targetClass.getMethod(methodName, parameterTypes);
			if (method != null) {
				boolean hasAnnotation = method.isAnnotationPresent(com.util.Log.class);
				if (hasAnnotation) { // 判断是否为log的注解
					com.harmony.lottery.util.Log annotation = method.getAnnotation(com.harmony.lottery.util.Log.class);
					// 验证是否登录
					ActionContext actionContext = ActionContext.getContext();
					if (actionContext == null) {
						return;
					}
					Map session = actionContext.getSession();
					SysUser sysUser = (SysUser) session.get("user");
					if (sysUser != null) {
						com.domain.Log logInfo = new com.domain.Log();
						logInfo.setAddPerson(sysUser.getUserId());
						logInfo.setAddTime(new Date());
						logInfo.setRemark(sysUser.getUserId() + getParamsRemark(annotation, param));// 获得注解参数值
						logService.insert(logInfo);
					}
				}
			}
		}
	}

	/**
	 * 通过java反射来从传入的参数object里取出我们需要记录的id,name等属性， 此处我取出的是id
	 */
	private String getID(Object obj, String param) {
		if (obj instanceof String) {
			return obj.toString();
		}
		PropertyDescriptor pd = null;
		Method method = null;
		String v = "";
		try {
			pd = new PropertyDescriptor(param, obj.getClass());
			method = pd.getReadMethod();
			v = String.valueOf(method.invoke(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}

	private String getParamsRemark(com.harmony.lottery.util.Log annotation, Object[] param) {
		String propertys = annotation.propertys();
		StringBuffer sb = new StringBuffer();
		if (null != propertys && !"".equals(propertys)) {
			String[] propertysRemark = annotation.propertys().split(splitParaStr);
			for (String property : propertysRemark) {// 按参数对象属性，取参数值
				String name = property.split(splitNameValueStr)[0];
				String value = property.split(splitNameValueStr)[1];
				sb.append(name + splitNameValueStr + getID(param[0], value) + splitParaStr);
			}
			return annotation.operation() + sb.toString().substring(0, sb.length() - 1);
		} else {
			String oper = annotation.operation();
			List<String> list = PatternUtil.getList("\\{(\\d*)\\}", oper);// 按参数位置取参数值
			for (int i = 0; i < list.size(); i++) {
				String str = list.get(i);
				Object obj = param[Integer.parseInt(str)];
				oper = PatternUtil.replease("\\{" + Integer.parseInt(str) + "\\}", oper, obj.toString());
			}
			return oper;
		}
	}
}