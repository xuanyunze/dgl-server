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
 * mbil_feecode 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilFeecode")
@Table(name="mbil_feecode")
@DynamicInsert
@DynamicUpdate

public class MbilFeecode extends AbstractEntity{
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
	@Column(name="fc_id")
	private String fcId;
	@Column(name="fc_name")
	private String fcName;
	@Column(name="fc_rate")
	private Double fcRate;
	@Column(name="fc_istop")
	private Integer fcIstop;
	@Column(name="fc_topvalue")
	private Double fcTopvalue;
	@Column(name="fc_minvalue")
	private Double fcMinvalue;
	@Column(name="fc_maxvalue")
	private Double fcMaxvalue;
	@Column(name="fc_annxvalue")
	private Double fcAnnxvalue;
	@Column(name="fc_stat")
	private Integer fcStat;

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
	public void setFcId(String fcId){
		this.fcId=fcId;
	}
	public String getFcId(){
		return fcId;
	}
	public void setFcName(String fcName){
		this.fcName=fcName;
	}
	public String getFcName(){
		return fcName;
	}
	public void setFcRate(Double fcRate){
		this.fcRate=fcRate;
	}
	public Double getFcRate(){
		return fcRate;
	}
	public void setFcIstop(Integer fcIstop){
		this.fcIstop=fcIstop;
	}
	public Integer getFcIstop(){
		return fcIstop;
	}
	public void setFcTopvalue(Double fcTopvalue){
		this.fcTopvalue=fcTopvalue;
	}
	public Double getFcTopvalue(){
		return fcTopvalue;
	}
	public void setFcMinvalue(Double fcMinvalue){
		this.fcMinvalue=fcMinvalue;
	}
	public Double getFcMinvalue(){
		return fcMinvalue;
	}
	public void setFcMaxvalue(Double fcMaxvalue){
		this.fcMaxvalue=fcMaxvalue;
	}
	public Double getFcMaxvalue(){
		return fcMaxvalue;
	}
	public void setFcAnnxvalue(Double fcAnnxvalue){
		this.fcAnnxvalue=fcAnnxvalue;
	}
	public Double getFcAnnxvalue(){
		return fcAnnxvalue;
	}
	public void setFcStat(Integer fcStat){
		this.fcStat=fcStat;
	}
	public Integer getFcStat(){
		return fcStat;
	}
}

