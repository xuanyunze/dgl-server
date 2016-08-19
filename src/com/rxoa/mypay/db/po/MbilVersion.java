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
 * mbil_version 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilVersion")
@Table(name="mbil_version")
@DynamicInsert
@DynamicUpdate

public class MbilVersion extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="uuid")
	private String uuid;
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
	@Column(name="mv_cate")
	private String mvCate;
	@Column(name="mv_code")
	private String mvCode;
	@Column(name="mv_version")
	private String mvVersion;
	@Column(name="mv_url")
	private String mvUrl;
	@Column(name="mv_describe")
	private String mvDescribe;
	@Column(name="mv_isforce")
	private Integer mvIsforce;

	public void setUuid(String uuid){
		this.uuid=uuid;
	}
	public String getUuid(){
		return uuid;
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
	public void setMvCate(String mvCate){
		this.mvCate=mvCate;
	}
	public String getMvCate(){
		return mvCate;
	}
	public void setMvCode(String mvCode){
		this.mvCode=mvCode;
	}
	public String getMvCode(){
		return mvCode;
	}
	public void setMvVersion(String mvVersion){
		this.mvVersion=mvVersion;
	}
	public String getMvVersion(){
		return mvVersion;
	}
	public void setMvUrl(String mvUrl){
		this.mvUrl=mvUrl;
	}
	public String getMvUrl(){
		return mvUrl;
	}
	public void setMvDescribe(String mvDescribe){
		this.mvDescribe=mvDescribe;
	}
	public String getMvDescribe(){
		return mvDescribe;
	}
	public void setMvIsforce(Integer mvIsforce){
		this.mvIsforce=mvIsforce;
	}
	public Integer getMvIsforce(){
		return mvIsforce;
	}
}

