package com.kandee.page;

import java.io.Serializable;

public class PageCountBean implements Serializable {
	private static final long serialVersionUID = 6152242003898081994L;
	public static final int DEFAULT_SIZE = 5;
	private int pageSize = DEFAULT_SIZE; // 分页大小
	private int pageNumber; // 当前分页编号
	private int total; // 记录总数
	private int pageCount; // 分页数
	private int start; // 开始索引
	private int end;// 结束索引

	public PageCountBean() {
		this(0);
	}

	public PageCountBean(int total) {
		this(total, 1);
	}

	public PageCountBean(int total, int pageNumber) {
		this(total, pageNumber, DEFAULT_SIZE);
	}

	public PageCountBean(int total, int pageNumber, int pageSize) {
		this.total = total;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}

	public int getPageSize() {
		computePageInfo();
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		computePageInfo();
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageCount() {
		computePageInfo();
		return pageCount;
	}

	public int getStart() {
		computePageInfo();
		return start;
	}

	public int getEnd() {
		computePageInfo();
		return end;
	}

	private void computePageInfo() {
		// 特殊情况处理
		if (total <= 0) {
			pageCount = 0;
			pageNumber = 1;
			start = 0;
			end = 0;
			return;
		}
		// 处理分页大小
		pageSize = pageSize < 1 ? DEFAULT_SIZE : pageSize;
		// 计算分页总数
		pageCount = total / pageSize;
		pageCount = total % pageSize == 0 ? pageCount : pageCount + 1;
		// 计算当前分页号码
		pageNumber = pageNumber < 1 ? 1 : pageNumber;
		pageNumber = pageNumber > pageCount ? pageCount : pageNumber;
		// 计算开始索引
		start = (pageNumber - 1) * pageSize;
		// 计算结束索引
		end = start + pageSize - 1;
		if (end > total) {
			end = total-1;
		}
		

	}

	@Override
	public String toString() {
		return String.format("total:%s,pageCount:%s,pageNumber:%s,pageSize:%s",
				total, pageCount, pageNumber, pageSize);
	}

	
	public static void main(String[] args) {
		
		PageCountBean bean = new PageCountBean();
		System.out.println(bean.getPageCount());
		
		bean.setTotal(82);
		bean.setPageSize(10);
		
		bean.setPageNumber(1);
		System.out.printf("%d:%d%n", bean.getStart(), bean.getEnd());
		bean.setPageNumber(2);
		System.out.printf("%d:%d%n", bean.getStart(), bean.getEnd());
		bean.setPageNumber(50);
		System.out.printf("%d:%d%n", bean.getStart(), bean.getEnd());

	}
}
