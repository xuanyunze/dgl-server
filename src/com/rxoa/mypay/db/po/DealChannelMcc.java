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
 * deal_channel_mcc 实体类
 * Tue Apr 05 11:23:26 CST 2016 baiyu
 */ 

@Entity(name="DealChannelMcc")
@Table(name="deal_channel_mcc")
@DynamicInsert
@DynamicUpdate

public class DealChannelMcc extends AbstractEntity{
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
	@Column(name="cfee_id")
	private String cfeeId;
	@Column(name="cfee_channelid")
	private String cfeeChannelid;
	@Column(name="cfee_name")
	private String cfeeName;
	@Column(name="cfee_istop")
	private Integer cfeeIstop;
	@Column(name="cfee_stop")
	private Double cfeeStop;
	@Column(name="cfee_ptop")
	private Double cfeePtop;
	@Column(name="cfee_smcc")
	private Double cfeeSmcc;
	@Column(name="cfee_pmcc")
	private Double cfeePmcc;
	@Column(name="cfee_spratio")
	private Double cfeeSpratio;
	@Column(name="cfee_stat")
	private Integer cfeeStat;

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
	public void setCfeeId(String cfeeId){
		this.cfeeId=cfeeId;
	}
	public String getCfeeId(){
		return cfeeId;
	}
	public void setCfeeChannelid(String cfeeChannelid){
		this.cfeeChannelid=cfeeChannelid;
	}
	public String getCfeeChannelid(){
		return cfeeChannelid;
	}
	public void setCfeeName(String cfeeName){
		this.cfeeName=cfeeName;
	}
	public String getCfeeName(){
		return cfeeName;
	}
	public void setCfeeIstop(Integer cfeeIstop){
		this.cfeeIstop=cfeeIstop;
	}
	public Integer getCfeeIstop(){
		return cfeeIstop;
	}
	public void setCfeeStop(Double cfeeStop){
		this.cfeeStop=cfeeStop;
	}
	public Double getCfeeStop(){
		return cfeeStop;
	}
	public void setCfeePtop(Double cfeePtop){
		this.cfeePtop=cfeePtop;
	}
	public Double getCfeePtop(){
		return cfeePtop;
	}
	public void setCfeeSmcc(Double cfeeSmcc){
		this.cfeeSmcc=cfeeSmcc;
	}
	public Double getCfeeSmcc(){
		return cfeeSmcc;
	}
	public void setCfeePmcc(Double cfeePmcc){
		this.cfeePmcc=cfeePmcc;
	}
	public Double getCfeePmcc(){
		return cfeePmcc;
	}
	public void setCfeeSpratio(Double cfeeSpratio){
		this.cfeeSpratio=cfeeSpratio;
	}
	public Double getCfeeSpratio(){
		return cfeeSpratio;
	}
	public void setCfeeStat(Integer cfeeStat){
		this.cfeeStat=cfeeStat;
	}
	public Integer getCfeeStat(){
		return cfeeStat;
	}
}

