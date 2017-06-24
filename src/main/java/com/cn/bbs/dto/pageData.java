package com.cn.bbs.dto;

import java.io.Serializable;
import java.util.List;


public class pageData<T> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 661654663588656909L;
	/**
	 * 
	 */
	private List<T> list;
	private Integer pageNum;                
    private Integer pageSize;                
    private Integer totalPage;              
    private Integer totalRow;
    
    
	public pageData(List<T> list, Integer pageNum, Integer pageSize,Integer totalRow) {
		super();
		this.list = list;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalPage = totalRow%pageSize==0?(totalRow/pageSize):(totalRow/pageSize+1);
		this.totalRow = totalRow;
	}


	public List<T> getList() {
		return list;
	}


	public void setList(List<T> list) {
		this.list = list;
	}


	public Integer getPageNum() {
		return pageNum;
	}


	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}


	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public Integer getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}


	public Integer getTotalRow() {
		return totalRow;
	}


	public void setTotalRow(Integer totalRow) {
		this.totalRow = totalRow;
	}                

	
}
