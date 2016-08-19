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
 * mbil_sms_record 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilSmsRecord")
@Table(name="mbil_sms_record")
@DynamicInsert
@DynamicUpdate

public class MbilSmsRecord extends AbstractEntity{
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
	@Column(name="sms_reqid")
	private String smsReqid;
	@Column(name="sms_reqtype")
	private String smsReqtype;
	@Column(name="sms_reqphone")
	private String smsReqphone;
	@Column(name="sms_value")
	private String smsValue;
	@Column(name="sms_reqtime")
	private String smsReqtime;
	@Column(name="sms_sendtime")
	private String smsSendtime;
	@Column(name="sms_stat")
	private String smsStat;

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
	public void setSmsReqid(String smsReqid){
		this.smsReqid=smsReqid;
	}
	public String getSmsReqid(){
		return smsReqid;
	}
	public void setSmsReqtype(String smsReqtype){
		this.smsReqtype=smsReqtype;
	}
	public String getSmsReqtype(){
		return smsReqtype;
	}
	public void setSmsReqphone(String smsReqphone){
		this.smsReqphone=smsReqphone;
	}
	public String getSmsReqphone(){
		return smsReqphone;
	}
	public void setSmsValue(String smsValue){
		this.smsValue=smsValue;
	}
	public String getSmsValue(){
		return smsValue;
	}
	public void setSmsReqtime(String smsReqtime){
		this.smsReqtime=smsReqtime;
	}
	public String getSmsReqtime(){
		return smsReqtime;
	}
	public void setSmsSendtime(String smsSendtime){
		this.smsSendtime=smsSendtime;
	}
	public String getSmsSendtime(){
		return smsSendtime;
	}
	public void setSmsStat(String smsStat){
		this.smsStat=smsStat;
	}
	public String getSmsStat(){
		return smsStat;
	}
}

