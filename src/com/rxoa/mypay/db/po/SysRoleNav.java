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
 * sys_role_nav 实体类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Entity(name="SysRoleNav")
@Table(name="sys_role_nav")
@DynamicInsert
@DynamicUpdate

public class SysRoleNav extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="uuid")
	private String uuid;
	@Column(name="nav_roleid")
	private String navRoleid;
	@Column(name="nav_type")
	private String navType;
	@Column(name="nav_cate")
	private String navCate;
	@Column(name="nav_content")
	private String navContent;
	@Column(name="nav_tmpcode")
	private String navTmpcode;
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
	public void setNavRoleid(String navRoleid){
		this.navRoleid=navRoleid;
	}
	public String getNavRoleid(){
		return navRoleid;
	}
	public void setNavType(String navType){
		this.navType=navType;
	}
	public String getNavType(){
		return navType;
	}
	public void setNavCate(String navCate){
		this.navCate=navCate;
	}
	public String getNavCate(){
		return navCate;
	}
	public void setNavContent(String navContent){
		this.navContent=navContent;
	}
	public String getNavContent(){
		return navContent;
	}
	public void setNavTmpcode(String navTmpcode){
		this.navTmpcode=navTmpcode;
	}
	public String getNavTmpcode(){
		return navTmpcode;
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
