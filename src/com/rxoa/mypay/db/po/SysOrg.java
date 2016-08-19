package com.rxoa.mypay.db.po;

import java.util.Date;
import com.rxoa.mypay.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.GeneratedValue;
/**
 * sys_org 实体类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Entity(name="SysOrg")
@Table(name="sys_org")
@DynamicInsert
@DynamicUpdate

public class SysOrg extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="uuid")
	private String uuid;
	@Column(name="o_parentid")
	private String oparentid;
	@Column(name="o_id")
	private String oid;
	@Column(name="o_code")
	private String ocode;
	@Column(name="o_name")
	private String oname;
	@Column(name="o_namebref")
	private String onamebref;
	@Column(name="o_type")
	private String otype;
	@Column(name="o_relform")
	private String orelform;
	@Column(name="o_relid")
	private String orelid;
	@Column(name="o_level")
	private String olevel;
	@Column(name="o_weight")
	private String oweight;
	@Column(name="o_pathtrack")
	private String opathtrack;
	@Column(name="o_pathname")
	private String opathname;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cre_time",updatable=false)
	private Date creTime;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="mod_time",columnDefinition="DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date modTime;
	@Column(name="cre_author")
	private String creAuthor;
	@Column(name="mod_author")
	private String modAuthor;
	@Column(name="stat")
	private Integer stat;

	public void setUuid(String uuid){
		this.uuid=uuid;
	}
	public String getUuid(){
		return uuid;
	}
	public void setOparentid(String oparentid){
		this.oparentid=oparentid;
	}
	public String getOparentid(){
		return oparentid;
	}
	public void setOid(String oid){
		this.oid=oid;
	}
	public String getOid(){
		return oid;
	}
	public void setOcode(String ocode){
		this.ocode=ocode;
	}
	public String getOcode(){
		return ocode;
	}
	public void setOname(String oname){
		this.oname=oname;
	}
	public String getOname(){
		return oname;
	}
	public void setOnamebref(String onamebref){
		this.onamebref=onamebref;
	}
	public String getOnamebref(){
		return onamebref;
	}
	public void setOtype(String otype){
		this.otype=otype;
	}
	public String getOtype(){
		return otype;
	}
	public void setOrelform(String orelform){
		this.orelform=orelform;
	}
	public String getOrelform(){
		return orelform;
	}
	public void setOrelid(String orelid){
		this.orelid=orelid;
	}
	public String getOrelid(){
		return orelid;
	}
	public void setOlevel(String olevel){
		this.olevel=olevel;
	}
	public String getOlevel(){
		return olevel;
	}
	public void setOweight(String oweight){
		this.oweight=oweight;
	}
	public String getOweight(){
		return oweight;
	}
	public void setOpathtrack(String opathtrack){
		this.opathtrack=opathtrack;
	}
	public String getOpathtrack(){
		return opathtrack;
	}
	public void setOpathname(String opathname){
		this.opathname=opathname;
	}
	public String getOpathname(){
		return opathname;
	}
	public void setCreTime(Date creTime){
		this.creTime=creTime;
	}
	public Date getCreTime(){
		return creTime;
	}
	public void setModTime(Date modTime){
		this.modTime=modTime;
	}
	public Date getModTime(){
		return modTime;
	}
	public void setCreAuthor(String creAuthor){
		this.creAuthor=creAuthor;
	}
	public String getCreAuthor(){
		return creAuthor;
	}
	public void setModAuthor(String modAuthor){
		this.modAuthor=modAuthor;
	}
	public String getModAuthor(){
		return modAuthor;
	}
	public void setStat(Integer stat){
		this.stat=stat;
	}
	public Integer getStat(){
		return stat;
	}
}

