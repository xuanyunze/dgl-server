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
 * mbil_busi 实体类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Entity(name="MbilBusi")
@Table(name="mbil_busi")
@DynamicInsert
@DynamicUpdate

public class MbilBusi extends AbstractEntity{
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
	@Column(name="busi_id")
	private String busiId;
	@Column(name="busi_name")
	private String busiName;
	@Column(name="busi_feeid")
	private String busiFeeid;
	@Column(name="busi_settleid")
	private String busiSettleid;
	@Column(name="busi_feerate")
	private Double busiFeerate;
	@Column(name="busi_istop")
	private Integer busiIstop;
	@Column(name="busi_toprate")
	private Double busiToprate;
	@Column(name="busi_settlerate")
	private Double busiSettlerate;
	@Column(name="busi_stat")
	private Integer busiStat;

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
	public void setBusiId(String busiId){
		this.busiId=busiId;
	}
	public String getBusiId(){
		return busiId;
	}
	public void setBusiName(String busiName){
		this.busiName=busiName;
	}
	public String getBusiName(){
		return busiName;
	}
	public void setBusiFeeid(String busiFeeid){
		this.busiFeeid=busiFeeid;
	}
	public String getBusiFeeid(){
		return busiFeeid;
	}
	public void setBusiSettleid(String busiSettleid){
		this.busiSettleid=busiSettleid;
	}
	public String getBusiSettleid(){
		return busiSettleid;
	}
	public void setBusiFeerate(Double busiFeerate){
		this.busiFeerate=busiFeerate;
	}
	public Double getBusiFeerate(){
		return busiFeerate;
	}
	public void setBusiIstop(Integer busiIstop){
		this.busiIstop=busiIstop;
	}
	public Integer getBusiIstop(){
		return busiIstop;
	}
	public void setBusiToprate(Double busiToprate){
		this.busiToprate=busiToprate;
	}
	public Double getBusiToprate(){
		return busiToprate;
	}
	public void setBusiSettlerate(Double busiSettlerate){
		this.busiSettlerate=busiSettlerate;
	}
	public Double getBusiSettlerate(){
		return busiSettlerate;
	}
	public void setBusiStat(Integer busiStat){
		this.busiStat=busiStat;
	}
	public Integer getBusiStat(){
		return busiStat;
	}
}

