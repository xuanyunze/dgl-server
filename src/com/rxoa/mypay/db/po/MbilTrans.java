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
 * mbil_trans 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilTrans")
@Table(name="mbil_trans")
@DynamicInsert
@DynamicUpdate

public class MbilTrans extends AbstractEntity{
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
	@Column(name="tran_id")
	private String tranId;
	@Column(name="tran_uid")
	private String tranUid;
	@Column(name="tran_dsn")
	private String tranDsn;
	@Column(name="tran_value")
	private String tranValue;
	@Column(name="tran_busiid")
	private String tranBusiid;
	@Column(name="tran_feecode")
	private String tranFeecode;
	@Column(name="tran_areacode")
	private String tranAreacode;
	@Column(name="tran_settlecate")
	private String tranSettlecate;
	@Column(name="tran_cardnumber")
	private String tranCardnumber;
	@Column(name="tran_rchlid")
	private String tranRchlid;
	@Column(name="tran_rmchid")
	private String tranRmchid;
	@Column(name="tran_rtemid")
	private String tranRtemid;
	@Column(name="tran_rreqmsg")
	private String tranRreqmsg;
	@Column(name="tran_rrespmsg")
	private String tranRrespmsg;
	@Column(name="tran_rcancelnum")
	private Integer tranRcancelnum;
	@Column(name="tran_stat")
	private String tranStat;

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
	public void setTranId(String tranId){
		this.tranId=tranId;
	}
	public String getTranId(){
		return tranId;
	}
	public void setTranUid(String tranUid){
		this.tranUid=tranUid;
	}
	public String getTranUid(){
		return tranUid;
	}
	public void setTranDsn(String tranDsn){
		this.tranDsn=tranDsn;
	}
	public String getTranDsn(){
		return tranDsn;
	}
	public void setTranValue(String tranValue){
		this.tranValue=tranValue;
	}
	public String getTranValue(){
		return tranValue;
	}
	public void setTranBusiid(String tranBusiid){
		this.tranBusiid=tranBusiid;
	}
	public String getTranBusiid(){
		return tranBusiid;
	}
	public void setTranFeecode(String tranFeecode){
		this.tranFeecode=tranFeecode;
	}
	public String getTranFeecode(){
		return tranFeecode;
	}
	public void setTranAreacode(String tranAreacode){
		this.tranAreacode=tranAreacode;
	}
	public String getTranAreacode(){
		return tranAreacode;
	}
	public void setTranSettlecate(String tranSettlecate){
		this.tranSettlecate=tranSettlecate;
	}
	public String getTranSettlecate(){
		return tranSettlecate;
	}
	public void setTranCardnumber(String tranCardnumber){
		this.tranCardnumber=tranCardnumber;
	}
	public String getTranCardnumber(){
		return tranCardnumber;
	}
	public void setTranRchlid(String tranRchlid){
		this.tranRchlid=tranRchlid;
	}
	public String getTranRchlid(){
		return tranRchlid;
	}
	public void setTranRmchid(String tranRmchid){
		this.tranRmchid=tranRmchid;
	}
	public String getTranRmchid(){
		return tranRmchid;
	}
	public void setTranRtemid(String tranRtemid){
		this.tranRtemid=tranRtemid;
	}
	public String getTranRtemid(){
		return tranRtemid;
	}
	public void setTranRreqmsg(String tranRreqmsg){
		this.tranRreqmsg=tranRreqmsg;
	}
	public String getTranRreqmsg(){
		return tranRreqmsg;
	}
	public void setTranRrespmsg(String tranRrespmsg){
		this.tranRrespmsg=tranRrespmsg;
	}
	public String getTranRrespmsg(){
		return tranRrespmsg;
	}
	public void setTranRcancelnum(Integer tranRcancelnum){
		this.tranRcancelnum=tranRcancelnum;
	}
	public Integer getTranRcancelnum(){
		return tranRcancelnum;
	}
	public void setTranStat(String tranStat){
		this.tranStat=tranStat;
	}
	public String getTranStat(){
		return tranStat;
	}
}

