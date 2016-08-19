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
 * sys_user_group 实体类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Entity(name="SysUserGroup")
@Table(name="sys_user_group")
@DynamicInsert
@DynamicUpdate

public class SysUserGroup extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="uuid")
	private String uuid;
	@Column(name="g_id")
	private String gid;
	@Column(name="g_code")
	private String gcode;
	@Column(name="g_name")
	private String gname;
	@Column(name="g_type")
	private String gtype;
	@Column(name="g_cate")
	private String gcate;
	@Column(name="g_content")
	private String gcontent;
	@Column(name="g_describe")
	private String gdescribe;
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
	public void setGid(String gid){
		this.gid=gid;
	}
	public String getGid(){
		return gid;
	}
	public void setGcode(String gcode){
		this.gcode=gcode;
	}
	public String getGcode(){
		return gcode;
	}
	public void setGname(String gname){
		this.gname=gname;
	}
	public String getGname(){
		return gname;
	}
	public void setGtype(String gtype){
		this.gtype=gtype;
	}
	public String getGtype(){
		return gtype;
	}
	public void setGcate(String gcate){
		this.gcate=gcate;
	}
	public String getGcate(){
		return gcate;
	}
	public void setGcontent(String gcontent){
		this.gcontent=gcontent;
	}
	public String getGcontent(){
		return gcontent;
	}
	public void setGdescribe(String gdescribe){
		this.gdescribe=gdescribe;
	}
	public String getGdescribe(){
		return gdescribe;
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

