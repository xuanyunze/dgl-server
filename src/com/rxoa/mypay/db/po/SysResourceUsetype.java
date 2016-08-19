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
 * sys_resource_usetype 实体类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Entity(name="SysResourceUsetype")
@Table(name="sys_resource_usetype")
@DynamicInsert
@DynamicUpdate

public class SysResourceUsetype extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="uuid")
	private String uuid;
	@Column(name="rt_resourceid")
	private String rtResourceid;
	@Column(name="rt_code")
	private String rtCode;
	@Column(name="rt_name")
	private String rtName;
	@Column(name="rt_level")
	private Integer rtLevel;
	@Column(name="rt_stat")
	private String rtStat;
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
	public void setRtResourceid(String rtResourceid){
		this.rtResourceid=rtResourceid;
	}
	public String getRtResourceid(){
		return rtResourceid;
	}
	public void setRtCode(String rtCode){
		this.rtCode=rtCode;
	}
	public String getRtCode(){
		return rtCode;
	}
	public void setRtName(String rtName){
		this.rtName=rtName;
	}
	public String getRtName(){
		return rtName;
	}
	public void setRtLevel(Integer rtLevel){
		this.rtLevel=rtLevel;
	}
	public Integer getRtLevel(){
		return rtLevel;
	}
	public void setRtStat(String rtStat){
		this.rtStat=rtStat;
	}
	public String getRtStat(){
		return rtStat;
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
