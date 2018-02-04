package com.none.api.dto;

/**
 * 实体响应对象
 * 
 * @author shi
 *
 * @param <T>
 *            自定义实体对象
 */
public class EntityResponse<T> extends BasicResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

}
