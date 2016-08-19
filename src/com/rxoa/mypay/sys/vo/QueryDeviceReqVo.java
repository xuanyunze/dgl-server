package com.rxoa.mypay.sys.vo;

import com.rxoa.mypay.base.BaseEntity;

public class QueryDeviceReqVo extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String startDate;
	private String endDate;
	private String deSn;
	private String uid;
	private String deStat;
	private String orgName;
	private String deType;
	private String deModel;
	
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
	public String getDeSn() {
		return deSn;
	}
	public void setDeSn(String deSn) {
		this.deSn = deSn;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getDeStat() {
		return deStat;
	}
	public void setDeStat(String deStat) {
		this.deStat = deStat;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getDeType() {
		return deType;
	}
	public void setDeType(String deType) {
		this.deType = deType;
	}
	public String getDeModel() {
		return deModel;
	}
	public void setDeModel(String deModel) {
		this.deModel = deModel;
	}
}
