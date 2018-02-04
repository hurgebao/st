package com.none.common.util;

/**
 * 参数校验工具
 * 
 * @author shi
 *
 */
public class ValidateUtils {
	/**
	 * 检测参数列表是否为空
	 * 
	 * @param params
	 * @return
	 */
	public static boolean checkIsNull(Object... params) {
		for (Object obj : params) {
			if (obj == null || "".equals(obj)) {
				return true;
			}
			if (obj instanceof String && "".equals(obj.toString().trim())) {
				return true;
			}
		}
		return false;
	}
}
