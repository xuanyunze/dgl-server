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
 * mbil_card 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilCard")
@Table(name="mbil_card")
@DynamicInsert
@DynamicUpdate

public class MbilCard extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="uuid")
	private String uuid;
	@Column(name="cd_uid")
	private String cdUid;
	@Column(name="cd_accname")
	private String cdAccname;
	@Column(name="cd_accno")
	private String cdAccno;
	@Column(name="cd_vdate")
	private String cdVdate;
	@Column(name="cd_vcode")
	private String cdVcode;
	@Column(name="cd_vphone")
	private String cdVphone;
	@Column(name="cd_type")
	private String cdType;
	@Column(name="cd_cate")
	private Integer cdCate;
	@Column(name="cd_province")
	private String cdProvince;
	@Column(name="cd_city")
	private String cdCity;
	@Column(name="cd_bankname")
	private String cdBankname;
	@Column(name="cd_bankno")
	private String cdBankno;
	@Column(name="cd_bankdistr")
	private String cdBankdistr;
	@Column(name="cd_bankcode")
	private String cdBankcode;
	@Column(name="cd_bankbranch")
	private String cdBankbranch;
	@Column(name="cd_ismaincard")
	private String cdIsmaincard;
	@Column(name="cd_notiphone")
	private String cdNotiphone;
	@Column(name="cd_fastpay")
	private String cdFastpay;
	@Column(name="cd_stat")
	private String cdStat;
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
	public void setCdUid(String cdUid){
		this.cdUid=cdUid;
	}
	public String getCdUid(){
		return cdUid;
	}
	public void setCdAccname(String cdAccname){
		this.cdAccname=cdAccname;
	}
	public String getCdAccname(){
		return cdAccname;
	}
	public void setCdAccno(String cdAccno){
		this.cdAccno=cdAccno;
	}
	public String getCdAccno(){
		return cdAccno;
	}
	public void setCdVdate(String cdVdate){
		this.cdVdate=cdVdate;
	}
	public String getCdVdate(){
		return cdVdate;
	}
	public void setCdVcode(String cdVcode){
		this.cdVcode=cdVcode;
	}
	public String getCdVcode(){
		return cdVcode;
	}
	public void setCdVphone(String cdVphone){
		this.cdVphone=cdVphone;
	}
	public String getCdVphone(){
		return cdVphone;
	}
	public void setCdType(String cdType){
		this.cdType=cdType;
	}
	public String getCdType(){
		return cdType;
	}
	public void setCdCate(Integer cdCate){
		this.cdCate=cdCate;
	}
	public Integer getCdCate(){
		return cdCate;
	}
	public void setCdProvince(String cdProvince){
		this.cdProvince=cdProvince;
	}
	public String getCdProvince(){
		return cdProvince;
	}
	public void setCdCity(String cdCity){
		this.cdCity=cdCity;
	}
	public String getCdCity(){
		return cdCity;
	}
	public void setCdBankname(String cdBankname){
		this.cdBankname=cdBankname;
	}
	public String getCdBankname(){
		return cdBankname;
	}
	public void setCdBankno(String cdBankno){
		this.cdBankno=cdBankno;
	}
	public String getCdBankno(){
		return cdBankno;
	}
	public void setCdBankdistr(String cdBankdistr){
		this.cdBankdistr=cdBankdistr;
	}
	public String getCdBankdistr(){
		return cdBankdistr;
	}
	public void setCdBankcode(String cdBankcode){
		this.cdBankcode=cdBankcode;
	}
	public String getCdBankcode(){
		return cdBankcode;
	}
	public void setCdBankbranch(String cdBankbranch){
		this.cdBankbranch=cdBankbranch;
	}
	public String getCdBankbranch(){
		return cdBankbranch;
	}
	public void setCdIsmaincard(String cdIsmaincard){
		this.cdIsmaincard=cdIsmaincard;
	}
	public String getCdIsmaincard(){
		return cdIsmaincard;
	}
	public void setCdNotiphone(String cdNotiphone){
		this.cdNotiphone=cdNotiphone;
	}
	public String getCdNotiphone(){
		return cdNotiphone;
	}
	public void setCdFastpay(String cdFastpay){
		this.cdFastpay=cdFastpay;
	}
	public String getCdFastpay(){
		return cdFastpay;
	}
	public void setCdStat(String cdStat){
		this.cdStat=cdStat;
	}
	public String getCdStat(){
		return cdStat;
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

