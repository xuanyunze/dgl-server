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
 * mbil_device 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilDevice")
@Table(name="mbil_device")
@DynamicInsert
@DynamicUpdate

public class MbilDevice extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="uuid")
	private String uuid;
	@Column(name="de_uid")
	private String deUid;
	@Column(name="de_org")
	private String deOrg;
	@Column(name="de_tid")
	private String deTid;
	@Column(name="de_sn")
	private String deSn;
	@Column(name="de_btname")
	private String deBtname;
	@Column(name="de_type")
	private String deType;
	@Column(name="de_cate")
	private String deCate;
	@Column(name="de_model")
	private String deModel;
	@Column(name="de_producer")
	private String deProducer;
	@Column(name="de_binddate")
	private String deBinddate;
	@Column(name="de_kek")
	private String deKek;
	@Column(name="de_tmkey")
	private String deTmkey;
	@Column(name="de_pinkey")
	private String dePinkey;
	@Column(name="de_trackkey")
	private String deTrackkey;
	@Column(name="de_mackey")
	private String deMackey;
	@Column(name="de_keytype")
	private Integer deKeytype;
	@Column(name="de_describe")
	private String deDescribe;
	@Column(name="de_stat")
	private String deStat;
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

	public void setUuid(String uuid){
		this.uuid=uuid;
	}
	public String getUuid(){
		return uuid;
	}
	public void setDeUid(String deUid){
		this.deUid=deUid;
	}
	public String getDeUid(){
		return deUid;
	}
	public void setDeOrg(String deOrg){
		this.deOrg=deOrg;
	}
	public String getDeOrg(){
		return deOrg;
	}
	public void setDeTid(String deTid){
		this.deTid=deTid;
	}
	public String getDeTid(){
		return deTid;
	}
	public void setDeSn(String deSn){
		this.deSn=deSn;
	}
	public String getDeSn(){
		return deSn;
	}
	public void setDeBtname(String deBtname){
		this.deBtname=deBtname;
	}
	public String getDeBtname(){
		return deBtname;
	}
	public void setDeType(String deType){
		this.deType=deType;
	}
	public String getDeType(){
		return deType;
	}
	public void setDeCate(String deCate){
		this.deCate=deCate;
	}
	public String getDeCate(){
		return deCate;
	}
	public void setDeModel(String deModel){
		this.deModel=deModel;
	}
	public String getDeModel(){
		return deModel;
	}
	public void setDeProducer(String deProducer){
		this.deProducer=deProducer;
	}
	public String getDeProducer(){
		return deProducer;
	}
	public void setDeBinddate(String deBinddate){
		this.deBinddate=deBinddate;
	}
	public String getDeBinddate(){
		return deBinddate;
	}
	public void setDeKek(String deKek){
		this.deKek=deKek;
	}
	public String getDeKek(){
		return deKek;
	}
	public void setDeTmkey(String deTmkey){
		this.deTmkey=deTmkey;
	}
	public String getDeTmkey(){
		return deTmkey;
	}
	public void setDePinkey(String dePinkey){
		this.dePinkey=dePinkey;
	}
	public String getDePinkey(){
		return dePinkey;
	}
	public void setDeTrackkey(String deTrackkey){
		this.deTrackkey=deTrackkey;
	}
	public String getDeTrackkey(){
		return deTrackkey;
	}
	public void setDeMackey(String deMackey){
		this.deMackey=deMackey;
	}
	public String getDeMackey(){
		return deMackey;
	}
	public void setDeKeytype(Integer deKeytype){
		this.deKeytype=deKeytype;
	}
	public Integer getDeKeytype(){
		return deKeytype;
	}
	public void setDeDescribe(String deDescribe){
		this.deDescribe=deDescribe;
	}
	public String getDeDescribe(){
		return deDescribe;
	}
	public void setDeStat(String deStat){
		this.deStat=deStat;
	}
	public String getDeStat(){
		return deStat;
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
}

