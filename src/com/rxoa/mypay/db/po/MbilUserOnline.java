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
 * mbil_user_online 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilUserOnline")
@Table(name="mbil_user_online")
@DynamicInsert
@DynamicUpdate

public class MbilUserOnline extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="uuid")
	private String uuid;
	@Column(name="ol_uid")
	private String olUid;
	@Column(name="ol_uip")
	private String olUip;
	@Column(name="ol_appuuid")
	private String olAppuuid;
	@Column(name="ol_logintime")
	private String olLogintime;
	@Column(name="ol_publickey")
	private String olPublickey;
	@Column(name="ol_privatekey")
	private String olPrivatekey;
	@Column(name="ol_phonesn")
	private String olPhonesn;
	@Column(name="ol_devicesn")
	private String olDevicesn;
	@Column(name="ol_token")
	private String olToken;
	@Column(name="ol_lastact")
	private String olLastact;
	@Column(name="ol_lastacttime")
	private String olLastacttime;
	@Column(name="ol_ustat")
	private String olUstat;
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
	public void setOlUid(String olUid){
		this.olUid=olUid;
	}
	public String getOlUid(){
		return olUid;
	}
	public void setOlUip(String olUip){
		this.olUip=olUip;
	}
	public String getOlUip(){
		return olUip;
	}
	public void setOlAppuuid(String olAppuuid){
		this.olAppuuid=olAppuuid;
	}
	public String getOlAppuuid(){
		return olAppuuid;
	}
	public void setOlLogintime(String olLogintime){
		this.olLogintime=olLogintime;
	}
	public String getOlLogintime(){
		return olLogintime;
	}
	public void setOlPublickey(String olPublickey){
		this.olPublickey=olPublickey;
	}
	public String getOlPublickey(){
		return olPublickey;
	}
	public void setOlPrivatekey(String olPrivatekey){
		this.olPrivatekey=olPrivatekey;
	}
	public String getOlPrivatekey(){
		return olPrivatekey;
	}
	public void setOlPhonesn(String olPhonesn){
		this.olPhonesn=olPhonesn;
	}
	public String getOlPhonesn(){
		return olPhonesn;
	}
	public void setOlDevicesn(String olDevicesn){
		this.olDevicesn=olDevicesn;
	}
	public String getOlDevicesn(){
		return olDevicesn;
	}
	public void setOlToken(String olToken){
		this.olToken=olToken;
	}
	public String getOlToken(){
		return olToken;
	}
	public void setOlLastact(String olLastact){
		this.olLastact=olLastact;
	}
	public String getOlLastact(){
		return olLastact;
	}
	public void setOlLastacttime(String olLastacttime){
		this.olLastacttime=olLastacttime;
	}
	public String getOlLastacttime(){
		return olLastacttime;
	}
	public void setOlUstat(String olUstat){
		this.olUstat=olUstat;
	}
	public String getOlUstat(){
		return olUstat;
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

