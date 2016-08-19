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
 * deal_trans 实体类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Entity(name="DealTrans")
@Table(name="deal_trans")
@DynamicInsert
@DynamicUpdate

public class DealTrans extends AbstractEntity{
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
	@Column(name="tr_orderid")
	private String trOrderid;
	@Column(name="tr_flowid")
	private String trFlowid;
	@Column(name="tr_rel_flowid")
	private String trRelFlowid;
	@Column(name="tr_uid")
	private String trUid;
	@Column(name="tr_orgid")
	private String trOrgid;
	@Column(name="tr_devicesn")
	private String trDevicesn;
	@Column(name="tr_chlid")
	private String trChlid;
	@Column(name="tr_rmchname")
	private String trRmchname;
	@Column(name="tr_rmid")
	private String trRmid;
	@Column(name="tr_rtid")
	private String trRtid;
	@Column(name="tr_tflowid")
	private String trTflowid;
	@Column(name="tr_type")
	private String trType;
	@Column(name="tr_cardno")
	private String trCardno;
	@Column(name="tr_cardtype")
	private String trCardtype;
	@Column(name="tr_value")
	private String trValue;
	@Column(name="tr_stat")
	private String trStat;
	@Column(name="tr_areacode")
	private String trAreacode;
	@Column(name="tr_checkvalue")
	private String trCheckvalue;
	@Column(name="tr_settledate")
	private Date trSettledate;
	@Column(name="tr_settlestat")
	private Integer trSettlestat;
	@Column(name="tr_sendtime")
	private String trSendtime;
	@Column(name="tr_resptime")
	private String trResptime;
	@Column(name="tr_senddata")
	private String trSenddata;
	@Column(name="tr_respdata")
	private String trRespdata;
	@Column(name="tr_respcode")
	private String trRespcode;
	@Column(name="tr_flushcount")
	private Integer trFlushcount;
	@Column(name="tr_rfeecode")
	private String trRfeecode;
	@Column(name="tr_rfeerate")
	private Double trRfeerate;
	@Column(name="tr_ristop")
	private Integer trRistop;
	@Column(name="tr_rtopvalue")
	private Double trRtopvalue;
	@Column(name="tr_rbenefit")
	private Double trRbenefit;
	@Column(name="tr_rsplitratio")
	private Double trRsplitratio;

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
	public void setTrOrderid(String trOrderid){
		this.trOrderid=trOrderid;
	}
	public String getTrOrderid(){
		return trOrderid;
	}
	public void setTrFlowid(String trFlowid){
		this.trFlowid=trFlowid;
	}
	public String getTrFlowid(){
		return trFlowid;
	}
	public void setTrRelFlowid(String trRelFlowid){
		this.trRelFlowid=trRelFlowid;
	}
	public String getTrRelFlowid(){
		return trRelFlowid;
	}
	public void setTrUid(String trUid){
		this.trUid=trUid;
	}
	public String getTrUid(){
		return trUid;
	}
	public void setTrOrgid(String trOrgid){
		this.trOrgid=trOrgid;
	}
	public String getTrOrgid(){
		return trOrgid;
	}
	public void setTrDevicesn(String trDevicesn){
		this.trDevicesn=trDevicesn;
	}
	public String getTrDevicesn(){
		return trDevicesn;
	}
	public void setTrChlid(String trChlid){
		this.trChlid=trChlid;
	}
	public String getTrChlid(){
		return trChlid;
	}
	public void setTrRmchname(String trRmchname){
		this.trRmchname=trRmchname;
	}
	public String getTrRmchname(){
		return trRmchname;
	}
	public void setTrRmid(String trRmid){
		this.trRmid=trRmid;
	}
	public String getTrRmid(){
		return trRmid;
	}
	public void setTrRtid(String trRtid){
		this.trRtid=trRtid;
	}
	public String getTrRtid(){
		return trRtid;
	}
	public void setTrTflowid(String trTflowid){
		this.trTflowid=trTflowid;
	}
	public String getTrTflowid(){
		return trTflowid;
	}
	public void setTrType(String trType){
		this.trType=trType;
	}
	public String getTrType(){
		return trType;
	}
	public void setTrCardno(String trCardno){
		this.trCardno=trCardno;
	}
	public String getTrCardno(){
		return trCardno;
	}
	public void setTrCardtype(String trCardtype){
		this.trCardtype=trCardtype;
	}
	public String getTrCardtype(){
		return trCardtype;
	}
	public void setTrValue(String trValue){
		this.trValue=trValue;
	}
	public String getTrValue(){
		return trValue;
	}
	public void setTrStat(String trStat){
		this.trStat=trStat;
	}
	public String getTrStat(){
		return trStat;
	}
	public void setTrAreacode(String trAreacode){
		this.trAreacode=trAreacode;
	}
	public String getTrAreacode(){
		return trAreacode;
	}
	public void setTrCheckvalue(String trCheckvalue){
		this.trCheckvalue=trCheckvalue;
	}
	public String getTrCheckvalue(){
		return trCheckvalue;
	}
	public void setTrSettledate(Date trSettledate){
		this.trSettledate=trSettledate;
	}
	public Date getTrSettledate(){
		return trSettledate;
	}
	public void setTrSettlestat(Integer trSettlestat){
		this.trSettlestat=trSettlestat;
	}
	public Integer getTrSettlestat(){
		return trSettlestat;
	}
	public void setTrSendtime(String trSendtime){
		this.trSendtime=trSendtime;
	}
	public String getTrSendtime(){
		return trSendtime;
	}
	public void setTrResptime(String trResptime){
		this.trResptime=trResptime;
	}
	public String getTrResptime(){
		return trResptime;
	}
	public void setTrSenddata(String trSenddata){
		this.trSenddata=trSenddata;
	}
	public String getTrSenddata(){
		return trSenddata;
	}
	public void setTrRespdata(String trRespdata){
		this.trRespdata=trRespdata;
	}
	public String getTrRespdata(){
		return trRespdata;
	}
	public void setTrRespcode(String trRespcode){
		this.trRespcode=trRespcode;
	}
	public String getTrRespcode(){
		return trRespcode;
	}
	public void setTrFlushcount(Integer trFlushcount){
		this.trFlushcount=trFlushcount;
	}
	public Integer getTrFlushcount(){
		return trFlushcount;
	}
	public void setTrRfeecode(String trRfeecode){
		this.trRfeecode=trRfeecode;
	}
	public String getTrRfeecode(){
		return trRfeecode;
	}
	public void setTrRfeerate(Double trRfeerate){
		this.trRfeerate=trRfeerate;
	}
	public Double getTrRfeerate(){
		return trRfeerate;
	}
	public void setTrRistop(Integer trRistop){
		this.trRistop=trRistop;
	}
	public Integer getTrRistop(){
		return trRistop;
	}
	public void setTrRtopvalue(Double trRtopvalue){
		this.trRtopvalue=trRtopvalue;
	}
	public Double getTrRtopvalue(){
		return trRtopvalue;
	}
	public void setTrRbenefit(Double trRbenefit){
		this.trRbenefit=trRbenefit;
	}
	public Double getTrRbenefit(){
		return trRbenefit;
	}
	public void setTrRsplitratio(Double trRsplitratio){
		this.trRsplitratio=trRsplitratio;
	}
	public Double getTrRsplitratio(){
		return trRsplitratio;
	}
}

