package com.none.api.dto;

/**
 * 分页查询请求
 * 
 * @author shi
 *
 * @param <T>
 */
public class PageRequest<T> extends BasicRequest {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 查询起始记录数
	 */
	private Integer beginIndex;
	/**
	 * 每页记录数量
	 */
	private Integer pageSize;
	/**
	 * 查询起始日期
	 */
	private String beginDate;
	/**
	 * 查询截止日期
	 */
	private String endDate;
	/**
	 * 排序字段
	 */
	private String sort;
	/**
	 * 升序降序 asc 升序 desc 降序
	 */
	private String order;
	/**
	 * 业务请求参数
	 */
	private T t;

	/**
	 * 
	 * @return
	 */
	public Integer getBeginIndex() {
		return beginIndex;
	}

	/**
	 * 
	 * @param beginIndex
	 */
	public void setBeginIndex(Integer beginIndex) {
		this.beginIndex = beginIndex;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * 
	 * @param pageSize
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 
	 * @return
	 */
	public String getBeginDate() {
		return beginDate;
	}

	/**
	 * 
	 * @param beginDate
	 */
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	/**
	 * 
	 * @return
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * 
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * 
	 * @return
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * 
	 * @param sort
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * 
	 * @return
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * 
	 * @param order
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * 业务请求参数
	 * 
	 * @return
	 */
	public T getT() {
		return t;
	}

	/**
	 * 业务请求参数
	 * 
	 * @param t
	 */
	public void setT(T t) {
		this.t = t;
	}

}
