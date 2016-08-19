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
 * mbil_settlecate 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilSettlecate")
@Table(name="mbil_settlecate")
@DynamicInsert
@DynamicUpdate

public class MbilSettlecate extends AbstractEntity{
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
	@Column(name="sc_id")
	private String scId;
	@Column(name="sc_code")
	private String scCode;
	@Column(name="sc_name")
	private String scName;
	@Column(name="sc_rate")
	private Double scRate;
	@Column(name="sc_istop")
	private Integer scIstop;
	@Column(name="sc_topvalue")
	private Double scTopvalue;
	@Column(name="sc_minvalue")
	private Double scMinvalue;
	@Column(name="sc_maxvalue")
	private Double scMaxvalue;
	@Column(name="sc_annxvalue")
	private Double scAnnxvalue;
	@Column(name="sc_stat")
	private Integer scStat;

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
	public void setScId(String scId){
		this.scId=scId;
	}
	public String getScId(){
		return scId;
	}
	public void setScCode(String scCode){
		this.scCode=scCode;
	}
	public String getScCode(){
		return scCode;
	}
	public void setScName(String scName){
		this.scName=scName;
	}
	public String getScName(){
		return scName;
	}
	public void setScRate(Double scRate){
		this.scRate=scRate;
	}
	public Double getScRate(){
		return scRate;
	}
	public void setScIstop(Integer scIstop){
		this.scIstop=scIstop;
	}
	public Integer getScIstop(){
		return scIstop;
	}
	public void setScTopvalue(Double scTopvalue){
		this.scTopvalue=scTopvalue;
	}
	public Double getScTopvalue(){
		return scTopvalue;
	}
	public void setScMinvalue(Double scMinvalue){
		this.scMinvalue=scMinvalue;
	}
	public Double getScMinvalue(){
		return scMinvalue;
	}
	public void setScMaxvalue(Double scMaxvalue){
		this.scMaxvalue=scMaxvalue;
	}
	public Double getScMaxvalue(){
		return scMaxvalue;
	}
	public void setScAnnxvalue(Double scAnnxvalue){
		this.scAnnxvalue=scAnnxvalue;
	}
	public Double getScAnnxvalue(){
		return scAnnxvalue;
	}
	public void setScStat(Integer scStat){
		this.scStat=scStat;
	}
	public Integer getScStat(){
		return scStat;
	}
}

