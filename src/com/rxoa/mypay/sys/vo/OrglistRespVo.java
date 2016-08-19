package com.rxoa.mypay.sys.vo;

import com.rxoa.mypay.base.BaseEntity;

public class OrglistRespVo extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String oid;
	private String oname;
	private String obref;
	private String oparentid;
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getObref() {
		return obref;
	}
	public void setObref(String obref) {
		this.obref = obref;
	}
	public String getOparentid() {
		return oparentid;
	}
	public void setOparentid(String oparentid) {
		this.oparentid = oparentid;
	}
}
