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
 * deal_trans_profit 实体类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Entity(name="DealTransProfit")
@Table(name="deal_trans_profit")
@DynamicInsert
@DynamicUpdate

public class DealTransProfit extends AbstractEntity{
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
	@Column(name="dp_transid")
	private String dpTransid;
	@Column(name="db_tranuid")
	private String dbTranuid;
	@Column(name="dp_transorgid")
	private String dpTransorgid;
	@Column(name="dp_transtime")
	private String dpTranstime;
	@Column(name="dp_transtype")
	private String dpTranstype;
	@Column(name="dp_transvalue")
	private String dpTransvalue;
	@Column(name="db_settlerate")
	private String dbSettlerate;
	@Column(name="dp_feevalue")
	private String dpFeevalue;
	@Column(name="dp_feetop")
	private String dpFeetop;
	@Column(name="dp_value")
	private String dpValue;
	@Column(name="dp_orgid")
	private String dpOrgid;
	@Column(name="dp_reltype")
	private String dpReltype;
	@Column(name="dp_relid")
	private String dpRelid;
	@Column(name="dp_stat")
	private String dpStat;

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
	public void setDpTransid(String dpTransid){
		this.dpTransid=dpTransid;
	}
	public String getDpTransid(){
		return dpTransid;
	}
	public void setDbTranuid(String dbTranuid){
		this.dbTranuid=dbTranuid;
	}
	public String getDbTranuid(){
		return dbTranuid;
	}
	public void setDpTransorgid(String dpTransorgid){
		this.dpTransorgid=dpTransorgid;
	}
	public String getDpTransorgid(){
		return dpTransorgid;
	}
	public void setDpTranstime(String dpTranstime){
		this.dpTranstime=dpTranstime;
	}
	public String getDpTranstime(){
		return dpTranstime;
	}
	public void setDpTranstype(String dpTranstype){
		this.dpTranstype=dpTranstype;
	}
	public String getDpTranstype(){
		return dpTranstype;
	}
	public void setDpTransvalue(String dpTransvalue){
		this.dpTransvalue=dpTransvalue;
	}
	public String getDpTransvalue(){
		return dpTransvalue;
	}
	public void setDbSettlerate(String dbSettlerate){
		this.dbSettlerate=dbSettlerate;
	}
	public String getDbSettlerate(){
		return dbSettlerate;
	}
	public void setDpFeevalue(String dpFeevalue){
		this.dpFeevalue=dpFeevalue;
	}
	public String getDpFeevalue(){
		return dpFeevalue;
	}
	public void setDpFeetop(String dpFeetop){
		this.dpFeetop=dpFeetop;
	}
	public String getDpFeetop(){
		return dpFeetop;
	}
	public void setDpValue(String dpValue){
		this.dpValue=dpValue;
	}
	public String getDpValue(){
		return dpValue;
	}
	public void setDpOrgid(String dpOrgid){
		this.dpOrgid=dpOrgid;
	}
	public String getDpOrgid(){
		return dpOrgid;
	}
	public void setDpReltype(String dpReltype){
		this.dpReltype=dpReltype;
	}
	public String getDpReltype(){
		return dpReltype;
	}
	public void setDpRelid(String dpRelid){
		this.dpRelid=dpRelid;
	}
	public String getDpRelid(){
		return dpRelid;
	}
	public void setDpStat(String dpStat){
		this.dpStat=dpStat;
	}
	public String getDpStat(){
		return dpStat;
	}
}

