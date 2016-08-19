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
 * mbil_sms_counter 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilSmsCounter")
@Table(name="mbil_sms_counter")
@DynamicInsert
@DynamicUpdate

public class MbilSmsCounter extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="uuid")
	private String uuid;
	@Column(name="sms_phone")
	private String smsPhone;
	@Column(name="sms_ip")
	private String smsIp;
	@Column(name="sms_count_ip")
	private String smsCountIp;
	@Column(name="sms_count_phone")
	private String smsCountPhone;
	@Column(name="sms_lastreq")
	private String smsLastreq;
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
	public void setSmsPhone(String smsPhone){
		this.smsPhone=smsPhone;
	}
	public String getSmsPhone(){
		return smsPhone;
	}
	public void setSmsIp(String smsIp){
		this.smsIp=smsIp;
	}
	public String getSmsIp(){
		return smsIp;
	}
	public void setSmsCountIp(String smsCountIp){
		this.smsCountIp=smsCountIp;
	}
	public String getSmsCountIp(){
		return smsCountIp;
	}
	public void setSmsCountPhone(String smsCountPhone){
		this.smsCountPhone=smsCountPhone;
	}
	public String getSmsCountPhone(){
		return smsCountPhone;
	}
	public void setSmsLastreq(String smsLastreq){
		this.smsLastreq=smsLastreq;
	}
	public String getSmsLastreq(){
		return smsLastreq;
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

