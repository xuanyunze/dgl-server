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
 * mbil_order_phonecharge 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilOrderPhonecharge")
@Table(name="mbil_order_phonecharge")
@DynamicInsert
@DynamicUpdate

public class MbilOrderPhonecharge extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="uuid")
	private String uuid;
	@Column(name="od_uid")
	private String odUid;
	@Column(name="od_flowid")
	private String odFlowid;
	@Column(name="od_type")
	private String odType;
	@Column(name="od_value")
	private String odValue;
	@Column(name="od_phoneno")
	private String odPhoneno;
	@Column(name="od_paytype")
	private String odPaytype;
	@Column(name="od_payaccname")
	private String odPayaccname;
	@Column(name="od_payaccno")
	private String odPayaccno;
	@Column(name="od_paybankname")
	private String odPaybankname;
	@Column(name="od_stat")
	private String odStat;
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
	@Column(name="od_sigimgid")
	private String odSigimgid;

	public void setUuid(String uuid){
		this.uuid=uuid;
	}
	public String getUuid(){
		return uuid;
	}
	public void setOdUid(String odUid){
		this.odUid=odUid;
	}
	public String getOdUid(){
		return odUid;
	}
	public void setOdFlowid(String odFlowid){
		this.odFlowid=odFlowid;
	}
	public String getOdFlowid(){
		return odFlowid;
	}
	public void setOdType(String odType){
		this.odType=odType;
	}
	public String getOdType(){
		return odType;
	}
	public void setOdValue(String odValue){
		this.odValue=odValue;
	}
	public String getOdValue(){
		return odValue;
	}
	public void setOdPhoneno(String odPhoneno){
		this.odPhoneno=odPhoneno;
	}
	public String getOdPhoneno(){
		return odPhoneno;
	}
	public void setOdPaytype(String odPaytype){
		this.odPaytype=odPaytype;
	}
	public String getOdPaytype(){
		return odPaytype;
	}
	public void setOdPayaccname(String odPayaccname){
		this.odPayaccname=odPayaccname;
	}
	public String getOdPayaccname(){
		return odPayaccname;
	}
	public void setOdPayaccno(String odPayaccno){
		this.odPayaccno=odPayaccno;
	}
	public String getOdPayaccno(){
		return odPayaccno;
	}
	public void setOdPaybankname(String odPaybankname){
		this.odPaybankname=odPaybankname;
	}
	public String getOdPaybankname(){
		return odPaybankname;
	}
	public void setOdStat(String odStat){
		this.odStat=odStat;
	}
	public String getOdStat(){
		return odStat;
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
	public void setOdSigimgid(String odSigimgid){
		this.odSigimgid=odSigimgid;
	}
	public String getOdSigimgid(){
		return odSigimgid;
	}
}

