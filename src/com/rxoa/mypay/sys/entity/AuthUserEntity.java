package com.rxoa.mypay.sys.entity;

import com.rxoa.mypay.base.BaseEntity;

public class AuthUserEntity extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	private String userid;
	private String userName;
	private String userType;
	private String orgId;
	private String topOrgId;
	private String vOrgId;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getTopOrgId() {
		return topOrgId;
	}
	public void setTopOrgId(String topOrgId) {
		this.topOrgId = topOrgId;
	}
	public String getvOrgId() {
		return vOrgId;
	}
	public void setvOrgId(String vOrgId) {
		this.vOrgId = vOrgId;
	}
}
