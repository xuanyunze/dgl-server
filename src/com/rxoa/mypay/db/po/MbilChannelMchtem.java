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
 * mbil_channel_mchtem 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilChannelMchtem")
@Table(name="mbil_channel_mchtem")
@DynamicInsert
@DynamicUpdate

public class MbilChannelMchtem extends AbstractEntity{
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
	@Column(name="mch_id")
	private String mchId;
	@Column(name="mch_temid")
	private String mchTemid;
	@Column(name="mch_temsn")
	private String mchTemsn;
	@Column(name="mch_chlid")
	private String mchChlid;
	@Column(name="mch_name")
	private String mchName;
	@Column(name="mch_areacode")
	private String mchAreacode;
	@Column(name="mch_feecode")
	private String mchFeecode;
	@Column(name="mch_mcc")
	private String mchMcc;
	@Column(name="mch_tmk")
	private String mchTmk;
	@Column(name="mch_pik")
	private String mchPik;
	@Column(name="mch_mak")
	private String mchMak;
	@Column(name="mch_tdk")
	private String mchTdk;
	@Column(name="mch_sek")
	private String mchSek;
	@Column(name="mch_needresign")
	private Integer mchNeedresign;
	@Column(name="mch_signtime")
	private String mchSigntime;
	@Column(name="mch_stat")
	private Integer mchStat;

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
	public void setMchId(String mchId){
		this.mchId=mchId;
	}
	public String getMchId(){
		return mchId;
	}
	public void setMchTemid(String mchTemid){
		this.mchTemid=mchTemid;
	}
	public String getMchTemid(){
		return mchTemid;
	}
	public void setMchTemsn(String mchTemsn){
		this.mchTemsn=mchTemsn;
	}
	public String getMchTemsn(){
		return mchTemsn;
	}
	public void setMchChlid(String mchChlid){
		this.mchChlid=mchChlid;
	}
	public String getMchChlid(){
		return mchChlid;
	}
	public void setMchName(String mchName){
		this.mchName=mchName;
	}
	public String getMchName(){
		return mchName;
	}
	public void setMchAreacode(String mchAreacode){
		this.mchAreacode=mchAreacode;
	}
	public String getMchAreacode(){
		return mchAreacode;
	}
	public void setMchFeecode(String mchFeecode){
		this.mchFeecode=mchFeecode;
	}
	public String getMchFeecode(){
		return mchFeecode;
	}
	public void setMchMcc(String mchMcc){
		this.mchMcc=mchMcc;
	}
	public String getMchMcc(){
		return mchMcc;
	}
	public void setMchTmk(String mchTmk){
		this.mchTmk=mchTmk;
	}
	public String getMchTmk(){
		return mchTmk;
	}
	public void setMchPik(String mchPik){
		this.mchPik=mchPik;
	}
	public String getMchPik(){
		return mchPik;
	}
	public void setMchMak(String mchMak){
		this.mchMak=mchMak;
	}
	public String getMchMak(){
		return mchMak;
	}
	public void setMchTdk(String mchTdk){
		this.mchTdk=mchTdk;
	}
	public String getMchTdk(){
		return mchTdk;
	}
	public void setMchSek(String mchSek){
		this.mchSek=mchSek;
	}
	public String getMchSek(){
		return mchSek;
	}
	public void setMchNeedresign(Integer mchNeedresign){
		this.mchNeedresign=mchNeedresign;
	}
	public Integer getMchNeedresign(){
		return mchNeedresign;
	}
	public void setMchSigntime(String mchSigntime){
		this.mchSigntime=mchSigntime;
	}
	public String getMchSigntime(){
		return mchSigntime;
	}
	public void setMchStat(Integer mchStat){
		this.mchStat=mchStat;
	}
	public Integer getMchStat(){
		return mchStat;
	}
}

