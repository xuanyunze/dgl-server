package com.rxoa.mypay.sys.combx;

import java.util.List;

import com.rxoa.mypay.base.BaseEntity;
import com.rxoa.mypay.db.po.SysOrg;

public class OrgTreeEntity extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	private String orgId;
	private String parentId;
	private String orgName;
	private String orgNameBref;
	private List<OrgTreeEntity> subNode;
	
	public OrgTreeEntity initFromSysOrg(SysOrg org){
		try{
			this.setOrgId(org.getOid());
			this.setOrgName(org.getOname());
			this.setOrgNameBref(org.getOnamebref());
			this.setParentId(org.getOparentid());
		}catch(Exception e){
			e.printStackTrace();
		}
		return this;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgNameBref() {
		return orgNameBref;
	}
	public void setOrgNameBref(String orgNameBref) {
		this.orgNameBref = orgNameBref;
	}
	public List<OrgTreeEntity> getSubNode() {
		return subNode;
	}
	public void setSubNode(List<OrgTreeEntity> subNode) {
		this.subNode = subNode;
	}
}
