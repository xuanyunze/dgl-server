package com.rxoa.mypay.sys.vo;

import com.rxoa.mypay.base.BaseEntity;

public class DeviceBatchReqVo extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String inType;
	private String deType;
	private String deOrg;
	private String deOrgNew;
	private String startSn;
	private String endSn;
	private String anySn;
	private String preSn;
	private String snNum;
	
	public String getInType() {
		return inType;
	}
	public void setInType(String inType) {
		this.inType = inType;
	}
	public String getDeType() {
		return deType;
	}
	public void setDeType(String deType) {
		this.deType = deType;
	}
	public String getDeOrg() {
		return deOrg;
	}
	public void setDeOrg(String deOrg) {
		this.deOrg = deOrg;
	}
	public String getDeOrgNew() {
		return deOrgNew;
	}
	public void setDeOrgNew(String deOrgNew) {
		this.deOrgNew = deOrgNew;
	}
	public String getStartSn() {
		return startSn;
	}
	public void setStartSn(String startSn) {
		this.startSn = startSn;
	}
	public String getEndSn() {
		return endSn;
	}
	public void setEndSn(String endSn) {
		this.endSn = endSn;
	}
	public String getAnySn() {
		return anySn;
	}
	public void setAnySn(String anySn) {
		this.anySn = anySn;
	}
	public String getPreSn() {
		return preSn;
	}
	public void setPreSn(String preSn) {
		this.preSn = preSn;
	}
	public String getSnNum() {
		return snNum;
	}
	public void setSnNum(String snNum) {
		this.snNum = snNum;
	}
	
}
