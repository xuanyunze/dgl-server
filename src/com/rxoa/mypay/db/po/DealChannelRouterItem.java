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
 * deal_channel_router_item 实体类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Entity(name="DealChannelRouterItem")
@Table(name="deal_channel_router_item")
@DynamicInsert
@DynamicUpdate

public class DealChannelRouterItem extends AbstractEntity{
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
	@Column(name="chri_chrid")
	private String chriChrid;
	@Column(name="chri_weight")
	private String chriWeight;
	@Column(name="chri_tarchlid")
	private String chriTarchlid;
	@Column(name="chri_stat")
	private String chriStat;

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
	public void setChriChrid(String chriChrid){
		this.chriChrid=chriChrid;
	}
	public String getChriChrid(){
		return chriChrid;
	}
	public void setChriWeight(String chriWeight){
		this.chriWeight=chriWeight;
	}
	public String getChriWeight(){
		return chriWeight;
	}
	public void setChriTarchlid(String chriTarchlid){
		this.chriTarchlid=chriTarchlid;
	}
	public String getChriTarchlid(){
		return chriTarchlid;
	}
	public void setChriStat(String chriStat){
		this.chriStat=chriStat;
	}
	public String getChriStat(){
		return chriStat;
	}
}

