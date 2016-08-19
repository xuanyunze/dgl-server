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
 * deal_mch_chlmap 实体类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Entity(name="DealMchChlmap")
@Table(name="deal_mch_chlmap")
@DynamicInsert
@DynamicUpdate

public class DealMchChlmap extends AbstractEntity{
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
	@Column(name="mchm_chlid")
	private String mchmChlid;
	@Column(name="mchm_type")
	private String mchmType;
	@Column(name="mchm_rmid")
	private String mchmRmid;
	@Column(name="mchm_rtid")
	private String mchmRtid;
	@Column(name="mchm_gid")
	private String mchmGid;
	@Column(name="mchm_stat")
	private String mchmStat;

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
	public void setMchmChlid(String mchmChlid){
		this.mchmChlid=mchmChlid;
	}
	public String getMchmChlid(){
		return mchmChlid;
	}
	public void setMchmType(String mchmType){
		this.mchmType=mchmType;
	}
	public String getMchmType(){
		return mchmType;
	}
	public void setMchmRmid(String mchmRmid){
		this.mchmRmid=mchmRmid;
	}
	public String getMchmRmid(){
		return mchmRmid;
	}
	public void setMchmRtid(String mchmRtid){
		this.mchmRtid=mchmRtid;
	}
	public String getMchmRtid(){
		return mchmRtid;
	}
	public void setMchmGid(String mchmGid){
		this.mchmGid=mchmGid;
	}
	public String getMchmGid(){
		return mchmGid;
	}
	public void setMchmStat(String mchmStat){
		this.mchmStat=mchmStat;
	}
	public String getMchmStat(){
		return mchmStat;
	}
}

