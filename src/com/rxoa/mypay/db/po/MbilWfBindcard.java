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
 * mbil_wf_bindcard 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilWfBindcard")
@Table(name="mbil_wf_bindcard")
@DynamicInsert
@DynamicUpdate

public class MbilWfBindcard extends AbstractEntity{
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
	@Column(name="wf_province")
	private String wfProvince;
	@Column(name="wf_city")
	private String wfCity;
	@Column(name="wf_accname")
	private String wfAccname;
	@Column(name="wf_accno")
	private String wfAccno;
	@Column(name="wf_vdate")
	private String wfVdate;
	@Column(name="wf_vcode")
	private String wfVcode;
	@Column(name="wf_vphone")
	private String wfVphone;
	@Column(name="wf_cardtyp")
	private String wfCardtyp;
	@Column(name="wf_cardcate")
	private Integer wfCardcate;
	@Column(name="wf_bankname")
	private String wfBankname;
	@Column(name="wf_bankdistr")
	private String wfBankdistr;
	@Column(name="wf_bankbranch")
	private String wfBankbranch;
	@Column(name="wf_bankno")
	private String wfBankno;
	@Column(name="wf_ismaincard")
	private String wfIsmaincard;
	@Column(name="wf_isfastpay")
	private String wfIsfastpay;
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
	public void setWfProvince(String wfProvince){
		this.wfProvince=wfProvince;
	}
	public String getWfProvince(){
		return wfProvince;
	}
	public void setWfCity(String wfCity){
		this.wfCity=wfCity;
	}
	public String getWfCity(){
		return wfCity;
	}
	public void setWfAccname(String wfAccname){
		this.wfAccname=wfAccname;
	}
	public String getWfAccname(){
		return wfAccname;
	}
	public void setWfAccno(String wfAccno){
		this.wfAccno=wfAccno;
	}
	public String getWfAccno(){
		return wfAccno;
	}
	public void setWfVdate(String wfVdate){
		this.wfVdate=wfVdate;
	}
	public String getWfVdate(){
		return wfVdate;
	}
	public void setWfVcode(String wfVcode){
		this.wfVcode=wfVcode;
	}
	public String getWfVcode(){
		return wfVcode;
	}
	public void setWfVphone(String wfVphone){
		this.wfVphone=wfVphone;
	}
	public String getWfVphone(){
		return wfVphone;
	}
	public void setWfCardtyp(String wfCardtyp){
		this.wfCardtyp=wfCardtyp;
	}
	public String getWfCardtyp(){
		return wfCardtyp;
	}
	public void setWfCardcate(Integer wfCardcate){
		this.wfCardcate=wfCardcate;
	}
	public Integer getWfCardcate(){
		return wfCardcate;
	}
	public void setWfBankname(String wfBankname){
		this.wfBankname=wfBankname;
	}
	public String getWfBankname(){
		return wfBankname;
	}
	public void setWfBankdistr(String wfBankdistr){
		this.wfBankdistr=wfBankdistr;
	}
	public String getWfBankdistr(){
		return wfBankdistr;
	}
	public void setWfBankbranch(String wfBankbranch){
		this.wfBankbranch=wfBankbranch;
	}
	public String getWfBankbranch(){
		return wfBankbranch;
	}
	public void setWfBankno(String wfBankno){
		this.wfBankno=wfBankno;
	}
	public String getWfBankno(){
		return wfBankno;
	}
	public void setWfIsmaincard(String wfIsmaincard){
		this.wfIsmaincard=wfIsmaincard;
	}
	public String getWfIsmaincard(){
		return wfIsmaincard;
	}
	public void setWfIsfastpay(String wfIsfastpay){
		this.wfIsfastpay=wfIsfastpay;
	}
	public String getWfIsfastpay(){
		return wfIsfastpay;
	}
	public void setWfStat(String wfStat){
		this.wfStat=wfStat;
	}
	public String getWfStat(){
		return wfStat;
	}
}

