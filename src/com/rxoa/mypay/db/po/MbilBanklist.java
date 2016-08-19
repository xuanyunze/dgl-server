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
 * mbil_banklist 实体类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Entity(name="MbilBanklist")
@Table(name="mbil_banklist")
@DynamicInsert
@DynamicUpdate

public class MbilBanklist extends AbstractEntity{
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
	@Column(name="bank_code")
	private String bankCode;
	@Column(name="bank_name")
	private String bankName;
	@Column(name="bank_branch")
	private String bankBranch;
	@Column(name="bank_codebref")
	private String bankCodebref;
	@Column(name="bank_province")
	private String bankProvince;
	@Column(name="bank_city")
	private String bankCity;
	@Column(name="bank_area")
	private String bankArea;
	@Column(name="bank_stat")
	private Integer bankStat;

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
	public void setBankCode(String bankCode){
		this.bankCode=bankCode;
	}
	public String getBankCode(){
		return bankCode;
	}
	public void setBankName(String bankName){
		this.bankName=bankName;
	}
	public String getBankName(){
		return bankName;
	}
	public void setBankBranch(String bankBranch){
		this.bankBranch=bankBranch;
	}
	public String getBankBranch(){
		return bankBranch;
	}
	public void setBankCodebref(String bankCodebref){
		this.bankCodebref=bankCodebref;
	}
	public String getBankCodebref(){
		return bankCodebref;
	}
	public void setBankProvince(String bankProvince){
		this.bankProvince=bankProvince;
	}
	public String getBankProvince(){
		return bankProvince;
	}
	public void setBankCity(String bankCity){
		this.bankCity=bankCity;
	}
	public String getBankCity(){
		return bankCity;
	}
	public void setBankArea(String bankArea){
		this.bankArea=bankArea;
	}
	public String getBankArea(){
		return bankArea;
	}
	public void setBankStat(Integer bankStat){
		this.bankStat=bankStat;
	}
	public Integer getBankStat(){
		return bankStat;
	}
}

