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
 * mbil_busi_fee_org 实体类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Entity(name="MbilBusiFeeOrg")
@Table(name="mbil_busi_fee_org")
@DynamicInsert
@DynamicUpdate

public class MbilBusiFeeOrg extends AbstractEntity{
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
	@Column(name="bsof_oid")
	private String bsofOid;
	@Column(name="bsof_feeid")
	private String bsofFeeid;
	@Column(name="bsof_rate")
	private Double bsofRate;
	@Column(name="bsof_istop")
	private Integer bsofIstop;
	@Column(name="bsof_toprate")
	private Double bsofToprate;
	@Column(name="bsof_annx")
	private Double bsofAnnx;
	@Column(name="bsof_drate")
	private Double bsofDrate;
	@Column(name="bsof_distrack")
	private String bsofDistrack;

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
	public void setBsofOid(String bsofOid){
		this.bsofOid=bsofOid;
	}
	public String getBsofOid(){
		return bsofOid;
	}
	public void setBsofFeeid(String bsofFeeid){
		this.bsofFeeid=bsofFeeid;
	}
	public String getBsofFeeid(){
		return bsofFeeid;
	}
	public void setBsofRate(Double bsofRate){
		this.bsofRate=bsofRate;
	}
	public Double getBsofRate(){
		return bsofRate;
	}
	public void setBsofIstop(Integer bsofIstop){
		this.bsofIstop=bsofIstop;
	}
	public Integer getBsofIstop(){
		return bsofIstop;
	}
	public void setBsofToprate(Double bsofToprate){
		this.bsofToprate=bsofToprate;
	}
	public Double getBsofToprate(){
		return bsofToprate;
	}
	public void setBsofAnnx(Double bsofAnnx){
		this.bsofAnnx=bsofAnnx;
	}
	public Double getBsofAnnx(){
		return bsofAnnx;
	}
	public void setBsofDrate(Double bsofDrate){
		this.bsofDrate=bsofDrate;
	}
	public Double getBsofDrate(){
		return bsofDrate;
	}
	public void setBsofDistrack(String bsofDistrack){
		this.bsofDistrack=bsofDistrack;
	}
	public String getBsofDistrack(){
		return bsofDistrack;
	}
}

