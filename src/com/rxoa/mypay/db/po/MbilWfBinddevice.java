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
 * mbil_wf_binddevice 实体类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Entity(name="MbilWfBinddevice")
@Table(name="mbil_wf_binddevice")
@DynamicInsert
@DynamicUpdate

public class MbilWfBinddevice extends AbstractEntity{
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
	@Column(name="wf_uid")
	private String wfUid;
	@Column(name="wf_devicesn")
	private String wfDevicesn;
	@Column(name="wf_devicetype")
	private String wfDevicetype;
	@Column(name="wf_stat")
	private String wfStat;

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
	public void setWfUid(String wfUid){
		this.wfUid=wfUid;
	}
	public String getWfUid(){
		return wfUid;
	}
	public void setWfDevicesn(String wfDevicesn){
		this.wfDevicesn=wfDevicesn;
	}
	public String getWfDevicesn(){
		return wfDevicesn;
	}
	public void setWfDevicetype(String wfDevicetype){
		this.wfDevicetype=wfDevicetype;
	}
	public String getWfDevicetype(){
		return wfDevicetype;
	}
	public void setWfStat(String wfStat){
		this.wfStat=wfStat;
	}
	public String getWfStat(){
		return wfStat;
	}
}

