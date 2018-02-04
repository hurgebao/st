package com.none.api.dto;

import java.util.List;

/**
 * 分页查询响应
 * 
 * @author shi
 *
 * @param <T>
 */
public class PageResponse<T> extends BasicResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 总记录数
	 */
	private Integer totalNum;
	/**
	 * 当页所有记录
	 */
	private List<T> rows;

	/**
	 * 总记录数
	 * 
	 * @return
	 */
	public Integer getTotalNum() {
		return totalNum;
	}

	/**
	 * 
	 * @param totalNum
	 *            总记录数
	 */
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	/**
	 * 
	 * @return 总记录数
	 */
	public List<T> getRows() {
		return rows;
	}

	/**
	 * 
	 * @param rows
	 *            总记录数
	 */
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
