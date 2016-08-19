package com.rxoa.mypay.sys.vo;

import com.rxoa.mypay.base.BaseEntity;

public class QueryMchInfoRespVo extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String uid;
	private String regTime;
	private String uname;
	private String uidcard;
	private String accName;
	private String accNo;
	private String accBankname;
	private String accBankdistr;
	private String accBankbranch;
	private String accBankcode;
	private String deSn;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUidcard() {
		return uidcard;
	}
	public void setUidcard(String uidcard) {
		this.uidcard = uidcard;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getAccBankname() {
		return accBankname;
	}
	public void setAccBankname(String accBankname) {
		this.accBankname = accBankname;
	}
	public String getAccBankdistr() {
		return accBankdistr;
	}
	public void setAccBankdistr(String accBankdistr) {
		this.accBankdistr = accBankdistr;
	}
	public String getAccBankbranch() {
		return accBankbranch;
	}
	public void setAccBankbranch(String accBankbranch) {
		this.accBankbranch = accBankbranch;
	}
	public String getAccBankcode() {
		return accBankcode;
	}
	public void setAccBankcode(String accBankcode) {
		this.accBankcode = accBankcode;
	}
	public String getDeSn() {
		return deSn;
	}
	public void setDeSn(String deSn) {
		this.deSn = deSn;
	}
}
