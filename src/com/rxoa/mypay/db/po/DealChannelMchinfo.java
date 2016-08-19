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
 * deal_channel_mchinfo 实体类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Entity(name="DealChannelMchinfo")
@Table(name="deal_channel_mchinfo")
@DynamicInsert
@DynamicUpdate

public class DealChannelMchinfo extends AbstractEntity{
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
	@Column(name="nscm_chlid")
	private String nscmChlid;
	@Column(name="nscm_areacode")
	private String nscmAreacode;
	@Column(name="nscm_rfeecode")
	private String nscmRfeecode;
	@Column(name="nscm_rareacode")
	private String nscmRareacode;
	@Column(name="nscm_rmid")
	private String nscmRmid;
	@Column(name="nscm_rmchname")
	private String nscmRmchname;
	@Column(name="nscm_rtid")
	private String nscmRtid;
	@Column(name="nscm_rtsn")
	private String nscmRtsn;
	@Column(name="nscm_mcc")
	private String nscmMcc;
	@Column(name="nscm_rtmkey")
	private String nscmRtmkey;
	@Column(name="nscm_rpinkey")
	private String nscmRpinkey;
	@Column(name="nscm_rtrackkey")
	private String nscmRtrackkey;
	@Column(name="nscm_rmackey")
	private String nscmRmackey;
	@Column(name="nscm_rsigntime")
	private String nscmRsigntime;
	@Column(name="nscm_rsignstat")
	private String nscmRsignstat;
	@Column(name="nscm_rflowid")
	private String nscmRflowid;
	@Column(name="nscm_routercate")
	private Integer nscmRoutercate;
	@Column(name="nscm_stat")
	private Integer nscmStat;
	@Column(name="nscm_feecode")
	private String nscmFeecode;

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
	public void setNscmChlid(String nscmChlid){
		this.nscmChlid=nscmChlid;
	}
	public String getNscmChlid(){
		return nscmChlid;
	}
	public void setNscmAreacode(String nscmAreacode){
		this.nscmAreacode=nscmAreacode;
	}
	public String getNscmAreacode(){
		return nscmAreacode;
	}
	public void setNscmRfeecode(String nscmRfeecode){
		this.nscmRfeecode=nscmRfeecode;
	}
	public String getNscmRfeecode(){
		return nscmRfeecode;
	}
	public void setNscmRareacode(String nscmRareacode){
		this.nscmRareacode=nscmRareacode;
	}
	public String getNscmRareacode(){
		return nscmRareacode;
	}
	public void setNscmRmid(String nscmRmid){
		this.nscmRmid=nscmRmid;
	}
	public String getNscmRmid(){
		return nscmRmid;
	}
	public void setNscmRmchname(String nscmRmchname){
		this.nscmRmchname=nscmRmchname;
	}
	public String getNscmRmchname(){
		return nscmRmchname;
	}
	public void setNscmRtid(String nscmRtid){
		this.nscmRtid=nscmRtid;
	}
	public String getNscmRtid(){
		return nscmRtid;
	}
	public void setNscmRtsn(String nscmRtsn){
		this.nscmRtsn=nscmRtsn;
	}
	public String getNscmRtsn(){
		return nscmRtsn;
	}
	public void setNscmMcc(String nscmMcc){
		this.nscmMcc=nscmMcc;
	}
	public String getNscmMcc(){
		return nscmMcc;
	}
	public void setNscmRtmkey(String nscmRtmkey){
		this.nscmRtmkey=nscmRtmkey;
	}
	public String getNscmRtmkey(){
		return nscmRtmkey;
	}
	public void setNscmRpinkey(String nscmRpinkey){
		this.nscmRpinkey=nscmRpinkey;
	}
	public String getNscmRpinkey(){
		return nscmRpinkey;
	}
	public void setNscmRtrackkey(String nscmRtrackkey){
		this.nscmRtrackkey=nscmRtrackkey;
	}
	public String getNscmRtrackkey(){
		return nscmRtrackkey;
	}
	public void setNscmRmackey(String nscmRmackey){
		this.nscmRmackey=nscmRmackey;
	}
	public String getNscmRmackey(){
		return nscmRmackey;
	}
	public void setNscmRsigntime(String nscmRsigntime){
		this.nscmRsigntime=nscmRsigntime;
	}
	public String getNscmRsigntime(){
		return nscmRsigntime;
	}
	public void setNscmRsignstat(String nscmRsignstat){
		this.nscmRsignstat=nscmRsignstat;
	}
	public String getNscmRsignstat(){
		return nscmRsignstat;
	}
	public void setNscmRflowid(String nscmRflowid){
		this.nscmRflowid=nscmRflowid;
	}
	public String getNscmRflowid(){
		return nscmRflowid;
	}
	public void setNscmRoutercate(Integer nscmRoutercate){
		this.nscmRoutercate=nscmRoutercate;
	}
	public Integer getNscmRoutercate(){
		return nscmRoutercate;
	}
	public void setNscmStat(Integer nscmStat){
		this.nscmStat=nscmStat;
	}
	public Integer getNscmStat(){
		return nscmStat;
	}
	public void setNscmFeecode(String nscmFeecode){
		this.nscmFeecode=nscmFeecode;
	}
	public String getNscmFeecode(){
		return nscmFeecode;
	}
}

