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
import javax.persistence.GeneratedValue;import java.util.Date;

/**
 * mbil_autosettle_rongbao 实体类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Entity(name="MbilAutosettleRongbao")
@Table(name="mbil_autosettle_rongbao")
@DynamicInsert
@DynamicUpdate

public class MbilAutosettleRongbao extends AbstractEntity{
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
	@Column(name="as_chlid")
	private String asChlid;
	@Column(name="as_srctype")
	private Integer asSrctype;
	@Column(name="as_srcid")
	private String asSrcid;
	@Column(name="as_value")
	private Double asValue;
	@Column(name="as_taraccname")
	private String asTaraccname;
	@Column(name="as_taraccno")
	private String asTaraccno;
	@Column(name="as_tarbankname")
	private String asTarbankname;
	@Column(name="as_tarbankno")
	private String asTarbankno;
	@Column(name="as_exectype")
	private Integer asExectype;
	@Column(name="as_exectime")
	private Date asExectime;
	@Column(name="as_stat")
	private Integer asStat;

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
	public void setAsChlid(String asChlid){
		this.asChlid=asChlid;
	}
	public String getAsChlid(){
		return asChlid;
	}
	public void setAsSrctype(Integer asSrctype){
		this.asSrctype=asSrctype;
	}
	public Integer getAsSrctype(){
		return asSrctype;
	}
	public void setAsSrcid(String asSrcid){
		this.asSrcid=asSrcid;
	}
	public String getAsSrcid(){
		return asSrcid;
	}
	public void setAsValue(Double asValue){
		this.asValue=asValue;
	}
	public Double getAsValue(){
		return asValue;
	}
	public void setAsTaraccname(String asTaraccname){
		this.asTaraccname=asTaraccname;
	}
	public String getAsTaraccname(){
		return asTaraccname;
	}
	public void setAsTaraccno(String asTaraccno){
		this.asTaraccno=asTaraccno;
	}
	public String getAsTaraccno(){
		return asTaraccno;
	}
	public void setAsTarbankname(String asTarbankname){
		this.asTarbankname=asTarbankname;
	}
	public String getAsTarbankname(){
		return asTarbankname;
	}
	public void setAsTarbankno(String asTarbankno){
		this.asTarbankno=asTarbankno;
	}
	public String getAsTarbankno(){
		return asTarbankno;
	}
	public void setAsExectype(Integer asExectype){
		this.asExectype=asExectype;
	}
	public Integer getAsExectype(){
		return asExectype;
	}
	public void setAsExectime(Date asExectime){
		this.asExectime=asExectime;
	}
	public Date getAsExectime(){
		return asExectime;
	}
	public void setAsStat(Integer asStat){
		this.asStat=asStat;
	}
	public Integer getAsStat(){
		return asStat;
	}
}

