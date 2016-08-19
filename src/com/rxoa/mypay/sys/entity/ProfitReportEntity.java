package com.rxoa.mypay.sys.entity;

import com.rxoa.mypay.base.BaseEntity;

public class ProfitReportEntity extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String orgId;
	private String orgName;
	private String selfFee;
	private String selfFeeCount;
	private String childFee;
	private String childFeeCount;
	private String totalFee;
	private String totalFeeCount;
	
	private String selfT0;
	private String selfT0Count;
	private String childT0;
	private String childT0Count;
	private String totalT0;
	private String totalT0Count;
	private String totalAll;
	private String totalCount;
	
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getSelfFee() {
		return selfFee;
	}
	public void setSelfFee(String selfFee) {
		this.selfFee = selfFee;
	}
	public String getSelfFeeCount() {
		return selfFeeCount;
	}
	public void setSelfFeeCount(String selfFeeCount) {
		this.selfFeeCount = selfFeeCount;
	}
	public String getChildFee() {
		return childFee;
	}
	public void setChildFee(String childFee) {
		this.childFee = childFee;
	}
	public String getChildFeeCount() {
		return childFeeCount;
	}
	public void setChildFeeCount(String childFeeCount) {
		this.childFeeCount = childFeeCount;
	}
	public String getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}
	public String getTotalFeeCount() {
		return totalFeeCount;
	}
	public void setTotalFeeCount(String totalFeeCount) {
		this.totalFeeCount = totalFeeCount;
	}
	public String getSelfT0() {
		return selfT0;
	}
	public void setSelfT0(String selfT0) {
		this.selfT0 = selfT0;
	}
	public String getSelfT0Count() {
		return selfT0Count;
	}
	public void setSelfT0Count(String selfT0Count) {
		this.selfT0Count = selfT0Count;
	}
	public String getChildT0() {
		return childT0;
	}
	public void setChildT0(String childT0) {
		this.childT0 = childT0;
	}
	public String getChildT0Count() {
		return childT0Count;
	}
	public void setChildT0Count(String childT0Count) {
		this.childT0Count = childT0Count;
	}
	public String getTotalT0() {
		return totalT0;
	}
	public void setTotalT0(String totalT0) {
		this.totalT0 = totalT0;
	}
	public String getTotalT0Count() {
		return totalT0Count;
	}
	public void setTotalT0Count(String totalT0Count) {
		this.totalT0Count = totalT0Count;
	}
	public String getTotalAll() {
		return totalAll;
	}
	public void setTotalAll(String totalAll) {
		this.totalAll = totalAll;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
}
