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
 * sys_navigation 实体类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Entity(name="SysNavigation")
@Table(name="sys_navigation")
@DynamicInsert
@DynamicUpdate

public class SysNavigation extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="uuid")
	private String uuid;
	@Column(name="nav_id")
	private String navId;
	@Column(name="nav_code")
	private String navCode;
	@Column(name="nav_cate")
	private String navCate;
	@Column(name="nav_subcate")
	private String navSubcate;
	@Column(name="nav_level")
	private String navLevel;
	@Column(name="nav_url")
	private String navUrl;
	@Column(name="nav_stat")
	private String navStat;
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
	public void setNavId(String navId){
		this.navId=navId;
	}
	public String getNavId(){
		return navId;
	}
	public void setNavCode(String navCode){
		this.navCode=navCode;
	}
	public String getNavCode(){
		return navCode;
	}
	public void setNavCate(String navCate){
		this.navCate=navCate;
	}
	public String getNavCate(){
		return navCate;
	}
	public void setNavSubcate(String navSubcate){
		this.navSubcate=navSubcate;
	}
	public String getNavSubcate(){
		return navSubcate;
	}
	public void setNavLevel(String navLevel){
		this.navLevel=navLevel;
	}
	public String getNavLevel(){
		return navLevel;
	}
	public void setNavUrl(String navUrl){
		this.navUrl=navUrl;
	}
	public String getNavUrl(){
		return navUrl;
	}
	public void setNavStat(String navStat){
		this.navStat=navStat;
	}
	public String getNavStat(){
		return navStat;
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

