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
 * sys_org_config 实体类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Entity(name="SysOrgConfig")
@Table(name="sys_org_config")
@DynamicInsert
@DynamicUpdate

public class SysOrgConfig extends AbstractEntity{
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
	@Column(name="oc_oid")
	private String ocOid;
	@Column(name="oc_name")
	private String ocName;
	@Column(name="oc_logourl")
	private String ocLogourl;
	@Column(name="oc_mail")
	private String ocMail;
	@Column(name="oc_website")
	private String ocWebsite;
	@Column(name="oc_stat")
	private Integer ocStat;
	@Column(name="oc_fld1")
	private String ocFld1;
	@Column(name="oc_fld2")
	private String ocFld2;
	@Column(name="oc_fld3")
	private String ocFld3;
	@Column(name="oc_fld4")
	private String ocFld4;
	@Column(name="oc_fld5")
	private String ocFld5;

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
	public void setOcOid(String ocOid){
		this.ocOid=ocOid;
	}
	public String getOcOid(){
		return ocOid;
	}
	public void setOcName(String ocName){
		this.ocName=ocName;
	}
	public String getOcName(){
		return ocName;
	}
	public void setOcLogourl(String ocLogourl){
		this.ocLogourl=ocLogourl;
	}
	public String getOcLogourl(){
		return ocLogourl;
	}
	public void setOcMail(String ocMail){
		this.ocMail=ocMail;
	}
	public String getOcMail(){
		return ocMail;
	}
	public void setOcWebsite(String ocWebsite){
		this.ocWebsite=ocWebsite;
	}
	public String getOcWebsite(){
		return ocWebsite;
	}
	public void setOcStat(Integer ocStat){
		this.ocStat=ocStat;
	}
	public Integer getOcStat(){
		return ocStat;
	}
	public void setOcFld1(String ocFld1){
		this.ocFld1=ocFld1;
	}
	public String getOcFld1(){
		return ocFld1;
	}
	public void setOcFld2(String ocFld2){
		this.ocFld2=ocFld2;
	}
	public String getOcFld2(){
		return ocFld2;
	}
	public void setOcFld3(String ocFld3){
		this.ocFld3=ocFld3;
	}
	public String getOcFld3(){
		return ocFld3;
	}
	public void setOcFld4(String ocFld4){
		this.ocFld4=ocFld4;
	}
	public String getOcFld4(){
		return ocFld4;
	}
	public void setOcFld5(String ocFld5){
		this.ocFld5=ocFld5;
	}
	public String getOcFld5(){
		return ocFld5;
	}
}

