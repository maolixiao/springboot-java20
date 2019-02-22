package com.accp.domain;

import com.github.pagehelper.Page;

public class MyPage<E> extends Page<E>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8931301142802327535L;
	private Integer nextPage;
	private Integer prevPage;
	public MyPage(Integer nextPage, Integer prevPage) {
		super();
		this.nextPage = super.getPageNum()+1;
		this.prevPage = super.getPageNum()-1;
	}
	
	public MyPage() {
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(Integer prevPage) {
		this.prevPage = prevPage;
	}
	
	
	
	

}
