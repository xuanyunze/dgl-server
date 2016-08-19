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
 * mbil_busi_router 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilBusiRouter")
@Table(name="mbil_busi_router")
@DynamicInsert
@DynamicUpdate

public class MbilBusiRouter extends AbstractEntity{
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
	@Column(name="br_lbcate")
	private String brLbcate;
	@Column(name="br_lbusiid")
	private String brLbusiid;
	@Column(name="br_minvalue")
	private Double brMinvalue;
	@Column(name="br_maxvalue")
	private Double brMaxvalue;
	@Column(name="br_chlid")
	private String brChlid;
	@Column(name="br_cbusiid")
	private String brCbusiid;
	@Column(name="br_level")
	private Integer brLevel;
	@Column(name="br_stat")
	private Integer brStat;

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
	public void setBrLbcate(String brLbcate){
		this.brLbcate=brLbcate;
	}
	public String getBrLbcate(){
		return brLbcate;
	}
	public void setBrLbusiid(String brLbusiid){
		this.brLbusiid=brLbusiid;
	}
	public String getBrLbusiid(){
		return brLbusiid;
	}
	public void setBrMinvalue(Double brMinvalue){
		this.brMinvalue=brMinvalue;
	}
	public Double getBrMinvalue(){
		return brMinvalue;
	}
	public void setBrMaxvalue(Double brMaxvalue){
		this.brMaxvalue=brMaxvalue;
	}
	public Double getBrMaxvalue(){
		return brMaxvalue;
	}
	public void setBrChlid(String brChlid){
		this.brChlid=brChlid;
	}
	public String getBrChlid(){
		return brChlid;
	}
	public void setBrCbusiid(String brCbusiid){
		this.brCbusiid=brCbusiid;
	}
	public String getBrCbusiid(){
		return brCbusiid;
	}
	public void setBrLevel(Integer brLevel){
		this.brLevel=brLevel;
	}
	public Integer getBrLevel(){
		return brLevel;
	}
	public void setBrStat(Integer brStat){
		this.brStat=brStat;
	}
	public Integer getBrStat(){
		return brStat;
	}
}

