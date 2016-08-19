package com.rxoa.mypay.sys.vo;

import com.rxoa.mypay.base.BaseEntity;

public class QuerySettlelogReqVo extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String startDate;
	private String endDate;
	private String slUid;
	private String slUname;
	private String slUaccno;
	private String slStat;
	
	
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
	public String getSlUid() {
		return slUid;
	}
	public void setSlUid(String slUid) {
		this.slUid = slUid;
	}
	public String getSlUname() {
		return slUname;
	}
	public void setSlUname(String slUname) {
		this.slUname = slUname;
	}
	public String getSlUaccno() {
		return slUaccno;
	}
	public void setSlUaccno(String slUaccno) {
		this.slUaccno = slUaccno;
	}
	public String getSlStat() {
		return slStat;
	}
	public void setSlStat(String slStat) {
		this.slStat = slStat;
	}
}
