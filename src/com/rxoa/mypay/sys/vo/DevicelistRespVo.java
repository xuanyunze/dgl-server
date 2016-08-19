package com.rxoa.mypay.sys.vo;

import com.rxoa.mypay.base.BaseEntity;

public class DevicelistRespVo extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	private String deSn;
	private String deId;
	private String deType;
	private String deCate;
	private String deModel;
	private String deUid;
	private String deUname;
	private String deoPath;
	private String deoPathname;
	private String deCretime;
	private String deStat;
	
	public String getDeSn() {
		return deSn;
	}
	public void setDeSn(String deSn) {
		this.deSn = deSn;
	}
	public String getDeId() {
		return deId;
	}
	public void setDeId(String deId) {
		this.deId = deId;
	}
	public String getDeType() {
		return deType;
	}
	public void setDeType(String deType) {
		this.deType = deType;
	}
	public String getDeCate() {
		return deCate;
	}
	public void setDeCate(String deCate) {
		this.deCate = deCate;
	}
	public String getDeModel() {
		return deModel;
	}
	public void setDeModel(String deModel) {
		this.deModel = deModel;
	}
	public String getDeUid() {
		return deUid;
	}
	public void setDeUid(String deUid) {
		this.deUid = deUid;
	}
	public String getDeUname() {
		return deUname;
	}
	public void setDeUname(String deUname) {
		this.deUname = deUname;
	}
	public String getDeoPath() {
		return deoPath;
	}
	public void setDeoPath(String deoPath) {
		this.deoPath = deoPath;
	}
	public String getDeoPathname() {
		return deoPathname;
	}
	public void setDeoPathname(String deoPathname) {
		this.deoPathname = deoPathname;
	}
	public String getDeCretime() {
		return deCretime;
	}
	public void setDeCretime(String deCretime) {
		this.deCretime = deCretime;
	}
	public String getDeStat() {
		return deStat;
	}
	public void setDeStat(String deStat) {
		this.deStat = deStat;
	}
}
