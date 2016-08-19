package com.rxoa.mypay.sys.entity;

import com.rxoa.mypay.base.BaseEntity;

public class ProfitQueryEntity extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	private String startDate;
	private String endDate;
	private String withChild;
	private String topOrgid;
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getTopOrgid() {
		return topOrgid;
	}
	public void setTopOrgid(String topOrgid) {
		this.topOrgid = topOrgid;
	}
	public String getWithChild() {
		return withChild;
	}
	public void setWithChild(String withChild) {
		this.withChild = withChild;
	}
}
