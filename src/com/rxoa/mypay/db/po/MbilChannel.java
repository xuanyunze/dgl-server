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
 * mbil_channel 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilChannel")
@Table(name="mbil_channel")
@DynamicInsert
@DynamicUpdate

public class MbilChannel extends AbstractEntity{
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
	@Column(name="chl_id")
	private String chlId;
	@Column(name="chl_name")
	private String chlName;
	@Column(name="chl_host")
	private String chlHost;
	@Column(name="chl_port")
	private String chlPort;
	@Column(name="chl_lmkzmk")
	private String chlLmkzmk;
	@Column(name="chl_mrule")
	private Integer chlMrule;
	@Column(name="chl_stat")
	private Integer chlStat;

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
	public void setChlId(String chlId){
		this.chlId=chlId;
	}
	public String getChlId(){
		return chlId;
	}
	public void setChlName(String chlName){
		this.chlName=chlName;
	}
	public String getChlName(){
		return chlName;
	}
	public void setChlHost(String chlHost){
		this.chlHost=chlHost;
	}
	public String getChlHost(){
		return chlHost;
	}
	public void setChlPort(String chlPort){
		this.chlPort=chlPort;
	}
	public String getChlPort(){
		return chlPort;
	}
	public void setChlLmkzmk(String chlLmkzmk){
		this.chlLmkzmk=chlLmkzmk;
	}
	public String getChlLmkzmk(){
		return chlLmkzmk;
	}
	public void setChlMrule(Integer chlMrule){
		this.chlMrule=chlMrule;
	}
	public Integer getChlMrule(){
		return chlMrule;
	}
	public void setChlStat(Integer chlStat){
		this.chlStat=chlStat;
	}
	public Integer getChlStat(){
		return chlStat;
	}
}

