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
 * mbil_user_blance 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilUserBlance")
@Table(name="mbil_user_blance")
@DynamicInsert
@DynamicUpdate

public class MbilUserBlance extends AbstractEntity{
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
	@Column(name="ub_uid")
	private String ubUid;
	@Column(name="ub_receive")
	private Double ubReceive;
	@Column(name="ub_zeroreceive")
	private Double ubZeroreceive;
	@Column(name="ub_charge")
	private Double ubCharge;
	@Column(name="ub_unclear")
	private Double ubUnclear;
	@Column(name="ub_value")
	private Double ubValue;
	@Column(name="ub_takevalue")
	private Double ubTakevalue;
	@Column(name="ub_dflow")
	private Double ubDflow;
	@Column(name="ub_t0flow")
	private Double ubT0flow;
	@Column(name="ub_dlimit")
	private Double ubDlimit;
	@Column(name="ub_plimit")
	private Double ubPlimit;
	@Column(name="ub_t0limit")
	private Double ubT0limit;
	@Column(name="ub_dlimit_give")
	private Double ubDlimitGive;
	@Column(name="ub_t0limit_give")
	private Double ubT0limitGive;
	@Column(name="ub_points")
	private Integer ubPoints;
	@Column(name="ub_benefit")
	private Double ubBenefit;

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
	public void setUbUid(String ubUid){
		this.ubUid=ubUid;
	}
	public String getUbUid(){
		return ubUid;
	}
	public void setUbReceive(Double ubReceive){
		this.ubReceive=ubReceive;
	}
	public Double getUbReceive(){
		return ubReceive;
	}
	public void setUbZeroreceive(Double ubZeroreceive){
		this.ubZeroreceive=ubZeroreceive;
	}
	public Double getUbZeroreceive(){
		return ubZeroreceive;
	}
	public void setUbCharge(Double ubCharge){
		this.ubCharge=ubCharge;
	}
	public Double getUbCharge(){
		return ubCharge;
	}
	public void setUbUnclear(Double ubUnclear){
		this.ubUnclear=ubUnclear;
	}
	public Double getUbUnclear(){
		return ubUnclear;
	}
	public void setUbValue(Double ubValue){
		this.ubValue=ubValue;
	}
	public Double getUbValue(){
		return ubValue;
	}
	public void setUbTakevalue(Double ubTakevalue){
		this.ubTakevalue=ubTakevalue;
	}
	public Double getUbTakevalue(){
		return ubTakevalue;
	}
	public void setUbDflow(Double ubDflow){
		this.ubDflow=ubDflow;
	}
	public Double getUbDflow(){
		return ubDflow;
	}
	public void setUbT0flow(Double ubT0flow){
		this.ubT0flow=ubT0flow;
	}
	public Double getUbT0flow(){
		return ubT0flow;
	}
	public void setUbDlimit(Double ubDlimit){
		this.ubDlimit=ubDlimit;
	}
	public Double getUbDlimit(){
		return ubDlimit;
	}
	public void setUbPlimit(Double ubPlimit){
		this.ubPlimit=ubPlimit;
	}
	public Double getUbPlimit(){
		return ubPlimit;
	}
	public void setUbT0limit(Double ubT0limit){
		this.ubT0limit=ubT0limit;
	}
	public Double getUbT0limit(){
		return ubT0limit;
	}
	public void setUbDlimitGive(Double ubDlimitGive){
		this.ubDlimitGive=ubDlimitGive;
	}
	public Double getUbDlimitGive(){
		return ubDlimitGive;
	}
	public void setUbT0limitGive(Double ubT0limitGive){
		this.ubT0limitGive=ubT0limitGive;
	}
	public Double getUbT0limitGive(){
		return ubT0limitGive;
	}
	public void setUbPoints(Integer ubPoints){
		this.ubPoints=ubPoints;
	}
	public Integer getUbPoints(){
		return ubPoints;
	}
	public void setUbBenefit(Double ubBenefit){
		this.ubBenefit=ubBenefit;
	}
	public Double getUbBenefit(){
		return ubBenefit;
	}
}

