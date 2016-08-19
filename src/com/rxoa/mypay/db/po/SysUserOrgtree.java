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
 * sys_user_orgtree 实体类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Entity(name="SysUserOrgtree")
@Table(name="sys_user_orgtree")
@DynamicInsert
@DynamicUpdate

public class SysUserOrgtree extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="uuid")
	private String uuid;
	@Column(name="otr_userid")
	private String otrUserid;
	@Column(name="otr_type")
	private String otrType;
	@Column(name="otr_cate")
	private String otrCate;
	@Column(name="otr_content")
	private String otrContent;
	@Column(name="otr_stat")
	private String otrStat;
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
	public void setOtrUserid(String otrUserid){
		this.otrUserid=otrUserid;
	}
	public String getOtrUserid(){
		return otrUserid;
	}
	public void setOtrType(String otrType){
		this.otrType=otrType;
	}
	public String getOtrType(){
		return otrType;
	}
	public void setOtrCate(String otrCate){
		this.otrCate=otrCate;
	}
	public String getOtrCate(){
		return otrCate;
	}
	public void setOtrContent(String otrContent){
		this.otrContent=otrContent;
	}
	public String getOtrContent(){
		return otrContent;
	}
	public void setOtrStat(String otrStat){
		this.otrStat=otrStat;
	}
	public String getOtrStat(){
		return otrStat;
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

