package com.rxoa.mypay.sys.vo;

import com.rxoa.mypay.base.BaseEntity;

public class RmchAddReqVo extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String chlId;
	private String chlMcc;
	private String mchAreacode;
	private String mchName;
	private String mchMid;
	private String mchTid;
	private String mchTsn;
	private String mchStat;
	
	public boolean checkData(){
		try{
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public String getChlId() {
		return chlId;
	}
	public void setChlId(String chlId) {
		this.chlId = chlId;
	}
	public String getChlMcc() {
		return chlMcc;
	}
	public void setChlMcc(String chlMcc) {
		this.chlMcc = chlMcc;
	}
	public String getMchAreacode() {
		return mchAreacode;
	}
	public void setMchAreacode(String mchAreacode) {
		this.mchAreacode = mchAreacode;
	}
	public String getMchName() {
		return mchName;
	}
	public void setMchName(String mchName) {
		this.mchName = mchName;
	}
	public String getMchMid() {
		return mchMid;
	}
	public void setMchMid(String mchMid) {
		this.mchMid = mchMid;
	}
	public String getMchTid() {
		return mchTid;
	}
	public void setMchTid(String mchTid) {
		this.mchTid = mchTid;
	}
	public String getMchTsn() {
		return mchTsn;
	}
	public void setMchTsn(String mchTsn) {
		this.mchTsn = mchTsn;
	}
	public String getMchStat() {
		return mchStat;
	}
	public void setMchStat(String mchStat) {
		this.mchStat = mchStat;
	}
}
