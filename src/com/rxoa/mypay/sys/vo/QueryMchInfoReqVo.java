package com.rxoa.mypay.sys.vo;

import com.rxoa.mypay.base.BaseEntity;

public class QueryMchInfoReqVo extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	private String qrStartDate;
	private String qrEndDate;
	private String qrUid;
	private String qrUname;
	private String qrDsn;
	
	public String getQrStartDate() {
		return qrStartDate;
	}
	public void setQrStartDate(String qrStartDate) {
		this.qrStartDate = qrStartDate;
	}
	public String getQrEndDate() {
		return qrEndDate;
	}
	public void setQrEndDate(String qrEndDate) {
		this.qrEndDate = qrEndDate;
	}
	public String getQrUid() {
		return qrUid;
	}
	public void setQrUid(String qrUid) {
		this.qrUid = qrUid;
	}
	public String getQrUname() {
		return qrUname;
	}
	public void setQrUname(String qrUname) {
		this.qrUname = qrUname;
	}
	public String getQrDsn() {
		return qrDsn;
	}
	public void setQrDsn(String qrDsn) {
		this.qrDsn = qrDsn;
	}
}
