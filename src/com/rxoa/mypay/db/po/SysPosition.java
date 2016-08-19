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
 * sys_position 实体类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Entity(name="SysPosition")
@Table(name="sys_position")
@DynamicInsert
@DynamicUpdate

public class SysPosition extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="uuid")
	private String uuid;
	@Column(name="p_id")
	private String pid;
	@Column(name="p_code")
	private String pcode;
	@Column(name="p_name")
	private String pname;
	@Column(name="p_namebref")
	private String pnamebref;
	@Column(name="p_titlename")
	private String ptitlename;
	@Column(name="p_wigname")
	private String pwigname;
	@Column(name="p_weight")
	private String pweight;
	@Column(name="p_orgid")
	private String porgid;
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
	public void setPid(String pid){
		this.pid=pid;
	}
	public String getPid(){
		return pid;
	}
	public void setPcode(String pcode){
		this.pcode=pcode;
	}
	public String getPcode(){
		return pcode;
	}
	public void setPname(String pname){
		this.pname=pname;
	}
	public String getPname(){
		return pname;
	}
	public void setPnamebref(String pnamebref){
		this.pnamebref=pnamebref;
	}
	public String getPnamebref(){
		return pnamebref;
	}
	public void setPtitlename(String ptitlename){
		this.ptitlename=ptitlename;
	}
	public String getPtitlename(){
		return ptitlename;
	}
	public void setPwigname(String pwigname){
		this.pwigname=pwigname;
	}
	public String getPwigname(){
		return pwigname;
	}
	public void setPweight(String pweight){
		this.pweight=pweight;
	}
	public String getPweight(){
		return pweight;
	}
	public void setPorgid(String porgid){
		this.porgid=porgid;
	}
	public String getPorgid(){
		return porgid;
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

