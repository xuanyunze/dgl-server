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
 * mbil_order_receivemoney 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilOrderReceivemoney")
@Table(name="mbil_order_receivemoney")
@DynamicInsert
@DynamicUpdate

public class MbilOrderReceivemoney extends AbstractEntity{
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
	@Column(name="od_uid")
	private String odUid;
	@Column(name="od_oid")
	private String odOid;
	@Column(name="od_flowid")
	private String odFlowid;
	@Column(name="od_type")
	private String odType;
	@Column(name="od_value")
	private Double odValue;
	@Column(name="od_paytype")
	private String odPaytype;
	@Column(name="od_payaccname")
	private String odPayaccname;
	@Column(name="od_payaccno")
	private String odPayaccno;
	@Column(name="od_paybankname")
	private String odPaybankname;
	@Column(name="od_paydesn")
	private String odPaydesn;
	@Column(name="od_sigimgid")
	private String odSigimgid;
	@Column(name="od_areacode")
	private String odAreacode;
	@Column(name="od_feecode")
	private String odFeecode;
	@Column(name="od_feerate")
	private Double odFeerate;
	@Column(name="od_istop")
	private Integer odIstop;
	@Column(name="od_chargevalue")
	private Double odChargevalue;
	@Column(name="od_benefit")
	private Double odBenefit;
	@Column(name="od_realvalue")
	private Double odRealvalue;
	@Column(name="od_toprate")
	private Double odToprate;
	@Column(name="od_settletype")
	private String odSettletype;
	@Column(name="od_settledate")
	private String odSettledate;
	@Column(name="od_settlerate")
	private Double odSettlerate;
	@Column(name="od_settlebene")
	private Double odSettlebene;
	@Column(name="od_settlevalue")
	private Double odSettlevalue;
	@Column(name="od_benefitstat")
	private Integer odBenefitstat;
	@Column(name="od_stat")
	private String odStat;

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
	public void setOdUid(String odUid){
		this.odUid=odUid;
	}
	public String getOdUid(){
		return odUid;
	}
	public void setOdOid(String odOid){
		this.odOid=odOid;
	}
	public String getOdOid(){
		return odOid;
	}
	public void setOdFlowid(String odFlowid){
		this.odFlowid=odFlowid;
	}
	public String getOdFlowid(){
		return odFlowid;
	}
	public void setOdType(String odType){
		this.odType=odType;
	}
	public String getOdType(){
		return odType;
	}
	public void setOdValue(Double odValue){
		this.odValue=odValue;
	}
	public Double getOdValue(){
		return odValue;
	}
	public void setOdPaytype(String odPaytype){
		this.odPaytype=odPaytype;
	}
	public String getOdPaytype(){
		return odPaytype;
	}
	public void setOdPayaccname(String odPayaccname){
		this.odPayaccname=odPayaccname;
	}
	public String getOdPayaccname(){
		return odPayaccname;
	}
	public void setOdPayaccno(String odPayaccno){
		this.odPayaccno=odPayaccno;
	}
	public String getOdPayaccno(){
		return odPayaccno;
	}
	public void setOdPaybankname(String odPaybankname){
		this.odPaybankname=odPaybankname;
	}
	public String getOdPaybankname(){
		return odPaybankname;
	}
	public void setOdPaydesn(String odPaydesn){
		this.odPaydesn=odPaydesn;
	}
	public String getOdPaydesn(){
		return odPaydesn;
	}
	public void setOdSigimgid(String odSigimgid){
		this.odSigimgid=odSigimgid;
	}
	public String getOdSigimgid(){
		return odSigimgid;
	}
	public void setOdAreacode(String odAreacode){
		this.odAreacode=odAreacode;
	}
	public String getOdAreacode(){
		return odAreacode;
	}
	public void setOdFeecode(String odFeecode){
		this.odFeecode=odFeecode;
	}
	public String getOdFeecode(){
		return odFeecode;
	}
	public void setOdFeerate(Double odFeerate){
		this.odFeerate=odFeerate;
	}
	public Double getOdFeerate(){
		return odFeerate;
	}
	public void setOdIstop(Integer odIstop){
		this.odIstop=odIstop;
	}
	public Integer getOdIstop(){
		return odIstop;
	}
	public void setOdChargevalue(Double odChargevalue){
		this.odChargevalue=odChargevalue;
	}
	public Double getOdChargevalue(){
		return odChargevalue;
	}
	public void setOdBenefit(Double odBenefit){
		this.odBenefit=odBenefit;
	}
	public Double getOdBenefit(){
		return odBenefit;
	}
	public void setOdRealvalue(Double odRealvalue){
		this.odRealvalue=odRealvalue;
	}
	public Double getOdRealvalue(){
		return odRealvalue;
	}
	public void setOdToprate(Double odToprate){
		this.odToprate=odToprate;
	}
	public Double getOdToprate(){
		return odToprate;
	}
	public void setOdSettletype(String odSettletype){
		this.odSettletype=odSettletype;
	}
	public String getOdSettletype(){
		return odSettletype;
	}
	public void setOdSettledate(String odSettledate){
		this.odSettledate=odSettledate;
	}
	public String getOdSettledate(){
		return odSettledate;
	}
	public void setOdSettlerate(Double odSettlerate){
		this.odSettlerate=odSettlerate;
	}
	public Double getOdSettlerate(){
		return odSettlerate;
	}
	public void setOdSettlebene(Double odSettlebene){
		this.odSettlebene=odSettlebene;
	}
	public Double getOdSettlebene(){
		return odSettlebene;
	}
	public void setOdSettlevalue(Double odSettlevalue){
		this.odSettlevalue=odSettlevalue;
	}
	public Double getOdSettlevalue(){
		return odSettlevalue;
	}
	public void setOdBenefitstat(Integer odBenefitstat){
		this.odBenefitstat=odBenefitstat;
	}
	public Integer getOdBenefitstat(){
		return odBenefitstat;
	}
	public void setOdStat(String odStat){
		this.odStat=odStat;
	}
	public String getOdStat(){
		return odStat;
	}
}

