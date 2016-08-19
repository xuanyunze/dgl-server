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
 * mbil_wf_realname 实体类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Entity(name="MbilWfRealname")
@Table(name="mbil_wf_realname")
@DynamicInsert
@DynamicUpdate

public class MbilWfRealname extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="uuid")
	private String uuid;
	@Column(name="wf_uid")
	private String wfUid;
	@Column(name="wf_realname")
	private String wfRealname;
	@Column(name="wf_idtype")
	private String wfIdtype;
	@Column(name="wf_idno")
	private String wfIdno;
	@Column(name="wf_stat")
	private String wfStat;
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
	public void setWfUid(String wfUid){
		this.wfUid=wfUid;
	}
	public String getWfUid(){
		return wfUid;
	}
	public void setWfRealname(String wfRealname){
		this.wfRealname=wfRealname;
	}
	public String getWfRealname(){
		return wfRealname;
	}
	public void setWfIdtype(String wfIdtype){
		this.wfIdtype=wfIdtype;
	}
	public String getWfIdtype(){
		return wfIdtype;
	}
	public void setWfIdno(String wfIdno){
		this.wfIdno=wfIdno;
	}
	public String getWfIdno(){
		return wfIdno;
	}
	public void setWfStat(String wfStat){
		this.wfStat=wfStat;
	}
	public String getWfStat(){
		return wfStat;
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

