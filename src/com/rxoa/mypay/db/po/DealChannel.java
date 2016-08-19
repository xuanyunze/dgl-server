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
 * deal_channel 实体类
 * Tue Apr 05 11:23:26 CST 2016 baiyu
 */ 

@Entity(name="DealChannel")
@Table(name="deal_channel")
@DynamicInsert
@DynamicUpdate

public class DealChannel extends AbstractEntity{
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
	@Column(name="chl_ip")
	private String chlIp;
	@Column(name="chl_port")
	private Integer chlPort;
	@Column(name="chl_timeout")
	private Integer chlTimeout;
	@Column(name="chl_zmk")
	private String chlZmk;
	@Column(name="chl_tmk")
	private String chlTmk;
	@Column(name="chl_pik")
	private String chlPik;
	@Column(name="chl_tdk")
	private String chlTdk;
	@Column(name="chl_mak")
	private String chlMak;
	@Column(name="chl_keystat")
	private Integer chlKeystat;
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
	public void setChlIp(String chlIp){
		this.chlIp=chlIp;
	}
	public String getChlIp(){
		return chlIp;
	}
	public void setChlPort(Integer chlPort){
		this.chlPort=chlPort;
	}
	public Integer getChlPort(){
		return chlPort;
	}
	public void setChlTimeout(Integer chlTimeout){
		this.chlTimeout=chlTimeout;
	}
	public Integer getChlTimeout(){
		return chlTimeout;
	}
	public void setChlZmk(String chlZmk){
		this.chlZmk=chlZmk;
	}
	public String getChlZmk(){
		return chlZmk;
	}
	public void setChlTmk(String chlTmk){
		this.chlTmk=chlTmk;
	}
	public String getChlTmk(){
		return chlTmk;
	}
	public void setChlPik(String chlPik){
		this.chlPik=chlPik;
	}
	public String getChlPik(){
		return chlPik;
	}
	public void setChlTdk(String chlTdk){
		this.chlTdk=chlTdk;
	}
	public String getChlTdk(){
		return chlTdk;
	}
	public void setChlMak(String chlMak){
		this.chlMak=chlMak;
	}
	public String getChlMak(){
		return chlMak;
	}
	public void setChlKeystat(Integer chlKeystat){
		this.chlKeystat=chlKeystat;
	}
	public Integer getChlKeystat(){
		return chlKeystat;
	}
	public void setChlStat(Integer chlStat){
		this.chlStat=chlStat;
	}
	public Integer getChlStat(){
		return chlStat;
	}
}

