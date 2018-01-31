package com.none.api.dto;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
/**
 * 基本类  本系统所有类必须继承本类
 * @author shi
 *
 */
public class BaseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
