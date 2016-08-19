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
 * deal_channel_mchgroup 实体类
 * Tue Apr 05 11:23:26 CST 2016 baiyu
 */ 

@Entity(name="DealChannelMchgroup")
@Table(name="deal_channel_mchgroup")
@DynamicInsert
@DynamicUpdate

public class DealChannelMchgroup extends AbstractEntity{
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
	@Column(name="mchrg_chlid")
	private String mchrgChlid;
	@Column(name="mchg_gid")
	private String mchgGid;
	@Column(name="mchg_rmchids")
	private String mchgRmchids;
	@Column(name="mchg_stat")
	private String mchgStat;

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
	public void setMchrgChlid(String mchrgChlid){
		this.mchrgChlid=mchrgChlid;
	}
	public String getMchrgChlid(){
		return mchrgChlid;
	}
	public void setMchgGid(String mchgGid){
		this.mchgGid=mchgGid;
	}
	public String getMchgGid(){
		return mchgGid;
	}
	public void setMchgRmchids(String mchgRmchids){
		this.mchgRmchids=mchgRmchids;
	}
	public String getMchgRmchids(){
		return mchgRmchids;
	}
	public void setMchgStat(String mchgStat){
		this.mchgStat=mchgStat;
	}
	public String getMchgStat(){
		return mchgStat;
	}
}

