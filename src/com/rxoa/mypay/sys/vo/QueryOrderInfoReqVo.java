package com.rxoa.mypay.sys.vo;

import com.rxoa.mypay.base.BaseEntity;

public class QueryOrderInfoReqVo extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String startDate;
	private String endDate;
	private String userId;
	private String userName;
	private String deSn;
	private String cardNo;
	private String dealStat;
	
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDeSn() {
		return deSn;
	}
	public void setDeSn(String deSn) {
		this.deSn = deSn;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getDealStat() {
		return dealStat;
	}
	public void setDealStat(String dealStat) {
		this.dealStat = dealStat;
	}
}
