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
 * mbil_active_code 实体类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Entity(name="MbilActiveCode")
@Table(name="mbil_active_code")
@DynamicInsert
@DynamicUpdate

public class MbilActiveCode extends AbstractEntity{
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
	@Column(name="ac_code")
	private String acCode;
	@Column(name="ac_orgid")
	private String acOrgid;
	@Column(name="ac_deviceid")
	private String acDeviceid;
	@Column(name="ac_gendate")
	private String acGendate;
	@Column(name="ac_usedate")
	private String acUsedate;
	@Column(name="ac_useid")
	private String acUseid;
	@Column(name="ac_stat")
	private String acStat;

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
	public void setAcCode(String acCode){
		this.acCode=acCode;
	}
	public String getAcCode(){
		return acCode;
	}
	public void setAcOrgid(String acOrgid){
		this.acOrgid=acOrgid;
	}
	public String getAcOrgid(){
		return acOrgid;
	}
	public void setAcDeviceid(String acDeviceid){
		this.acDeviceid=acDeviceid;
	}
	public String getAcDeviceid(){
		return acDeviceid;
	}
	public void setAcGendate(String acGendate){
		this.acGendate=acGendate;
	}
	public String getAcGendate(){
		return acGendate;
	}
	public void setAcUsedate(String acUsedate){
		this.acUsedate=acUsedate;
	}
	public String getAcUsedate(){
		return acUsedate;
	}
	public void setAcUseid(String acUseid){
		this.acUseid=acUseid;
	}
	public String getAcUseid(){
		return acUseid;
	}
	public void setAcStat(String acStat){
		this.acStat=acStat;
	}
	public String getAcStat(){
		return acStat;
	}
}

