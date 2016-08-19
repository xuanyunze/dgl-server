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
 * deal_channel_feemodel 实体类
 * Tue Apr 05 11:23:26 CST 2016 baiyu
 */ 

@Entity(name="DealChannelFeemodel")
@Table(name="deal_channel_feemodel")
@DynamicInsert
@DynamicUpdate

public class DealChannelFeemodel extends AbstractEntity{
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
	@Column(name="fm_id")
	private String fmId;
	@Column(name="fm_istop")
	private String fmIstop;
	@Column(name="fm_drate")
	private String fmDrate;
	@Column(name="fm_crate")
	private String fmCrate;
	@Column(name="fm_dtop")
	private String fmDtop;
	@Column(name="fm_ctop")
	private String fmCtop;
	@Column(name="fm_mcccode")
	private String fmMcccode;
	@Column(name="fm_indcate")
	private String fmIndcate;
	@Column(name="fm_indcode")
	private String fmIndcode;
	@Column(name="fm_stat")
	private String fmStat;

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
	public void setFmId(String fmId){
		this.fmId=fmId;
	}
	public String getFmId(){
		return fmId;
	}
	public void setFmIstop(String fmIstop){
		this.fmIstop=fmIstop;
	}
	public String getFmIstop(){
		return fmIstop;
	}
	public void setFmDrate(String fmDrate){
		this.fmDrate=fmDrate;
	}
	public String getFmDrate(){
		return fmDrate;
	}
	public void setFmCrate(String fmCrate){
		this.fmCrate=fmCrate;
	}
	public String getFmCrate(){
		return fmCrate;
	}
	public void setFmDtop(String fmDtop){
		this.fmDtop=fmDtop;
	}
	public String getFmDtop(){
		return fmDtop;
	}
	public void setFmCtop(String fmCtop){
		this.fmCtop=fmCtop;
	}
	public String getFmCtop(){
		return fmCtop;
	}
	public void setFmMcccode(String fmMcccode){
		this.fmMcccode=fmMcccode;
	}
	public String getFmMcccode(){
		return fmMcccode;
	}
	public void setFmIndcate(String fmIndcate){
		this.fmIndcate=fmIndcate;
	}
	public String getFmIndcate(){
		return fmIndcate;
	}
	public void setFmIndcode(String fmIndcode){
		this.fmIndcode=fmIndcode;
	}
	public String getFmIndcode(){
		return fmIndcode;
	}
	public void setFmStat(String fmStat){
		this.fmStat=fmStat;
	}
	public String getFmStat(){
		return fmStat;
	}
}

