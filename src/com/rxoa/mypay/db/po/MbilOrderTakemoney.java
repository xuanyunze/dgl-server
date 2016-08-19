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
 * mbil_order_takemoney 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilOrderTakemoney")
@Table(name="mbil_order_takemoney")
@DynamicInsert
@DynamicUpdate

public class MbilOrderTakemoney extends AbstractEntity{
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
	@Column(name="od_arrivetype")
	private String odArrivetype;
	@Column(name="od_arrivedate")
	private String odArrivedate;
	@Column(name="od_arrivevalue")
	private Double odArrivevalue;
	@Column(name="od_benefitvalue")
	private Double odBenefitvalue;
	@Column(name="od_arriveaccname")
	private String odArriveaccname;
	@Column(name="od_arriveaccno")
	private String odArriveaccno;
	@Column(name="od_arrivebankname")
	private String odArrivebankname;
	@Column(name="od_sigimgid")
	private String odSigimgid;
	@Column(name="od_distrinfo")
	private String odDistrinfo;
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
	public void setOdArrivetype(String odArrivetype){
		this.odArrivetype=odArrivetype;
	}
	public String getOdArrivetype(){
		return odArrivetype;
	}
	public void setOdArrivedate(String odArrivedate){
		this.odArrivedate=odArrivedate;
	}
	public String getOdArrivedate(){
		return odArrivedate;
	}
	public void setOdArrivevalue(Double odArrivevalue){
		this.odArrivevalue=odArrivevalue;
	}
	public Double getOdArrivevalue(){
		return odArrivevalue;
	}
	public void setOdBenefitvalue(Double odBenefitvalue){
		this.odBenefitvalue=odBenefitvalue;
	}
	public Double getOdBenefitvalue(){
		return odBenefitvalue;
	}
	public void setOdArriveaccname(String odArriveaccname){
		this.odArriveaccname=odArriveaccname;
	}
	public String getOdArriveaccname(){
		return odArriveaccname;
	}
	public void setOdArriveaccno(String odArriveaccno){
		this.odArriveaccno=odArriveaccno;
	}
	public String getOdArriveaccno(){
		return odArriveaccno;
	}
	public void setOdArrivebankname(String odArrivebankname){
		this.odArrivebankname=odArrivebankname;
	}
	public String getOdArrivebankname(){
		return odArrivebankname;
	}
	public void setOdSigimgid(String odSigimgid){
		this.odSigimgid=odSigimgid;
	}
	public String getOdSigimgid(){
		return odSigimgid;
	}
	public void setOdDistrinfo(String odDistrinfo){
		this.odDistrinfo=odDistrinfo;
	}
	public String getOdDistrinfo(){
		return odDistrinfo;
	}
	public void setOdStat(String odStat){
		this.odStat=odStat;
	}
	public String getOdStat(){
		return odStat;
	}
}

