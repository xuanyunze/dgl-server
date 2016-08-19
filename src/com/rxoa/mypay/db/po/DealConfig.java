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
 * deal_config 实体类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Entity(name="DealConfig")
@Table(name="deal_config")
@DynamicInsert
@DynamicUpdate

public class DealConfig extends AbstractEntity{
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
	@Column(name="cf_code")
	private String cfCode;
	@Column(name="cf_ds0stat")
	private Integer cfDs0stat;
	@Column(name="cf_ds0zone")
	private String cfDs0zone;
	@Column(name="cf_ds0pertran")
	private Double cfDs0pertran;
	@Column(name="cf_ds0perday")
	private Double cfDs0perday;
	@Column(name="cf_dt0stat")
	private Integer cfDt0stat;
	@Column(name="cf_dt0zone")
	private String cfDt0zone;
	@Column(name="cf_dt0pertran")
	private Double cfDt0pertran;
	@Column(name="cf_dt0perday")
	private Double cfDt0perday;
	@Column(name="cf_dt1stat")
	private Integer cfDt1stat;
	@Column(name="cf_dt1zone")
	private String cfDt1zone;
	@Column(name="cf_dt1pertran")
	private Double cfDt1pertran;
	@Column(name="cf_dt1perday")
	private Double cfDt1perday;
	@Column(name="cf_cnstat")
	private Integer cfCnstat;
	@Column(name="cf_cnzone")
	private String cfCnzone;
	@Column(name="cf_cnpertran")
	private Double cfCnpertran;
	@Column(name="cf_cnperday")
	private Double cfCnperday;
	@Column(name="cf_dzerostat")
	private Integer cfDzerostat;
	@Column(name="cf_dzerozone")
	private String cfDzerozone;
	@Column(name="cf_dzeropertran")
	private Double cfDzeropertran;
	@Column(name="cf_dzeroperday")
	private Double cfDzeroperday;
	@Column(name="cf_taket1stat")
	private Integer cfTaket1stat;
	@Column(name="cf_taket1zone")
	private String cfTaket1zone;
	@Column(name="cf_taket1pertran")
	private Double cfTaket1pertran;
	@Column(name="cf_taket1perday")
	private Double cfTaket1perday;
	@Column(name="cf_taket0stat")
	private Integer cfTaket0stat;
	@Column(name="cf_taket0zone")
	private String cfTaket0zone;
	@Column(name="cf_taket0pertran")
	private Double cfTaket0pertran;
	@Column(name="cf_taket0perday")
	private Double cfTaket0perday;

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
	public void setCfCode(String cfCode){
		this.cfCode=cfCode;
	}
	public String getCfCode(){
		return cfCode;
	}
	public void setCfDs0stat(Integer cfDs0stat){
		this.cfDs0stat=cfDs0stat;
	}
	public Integer getCfDs0stat(){
		return cfDs0stat;
	}
	public void setCfDs0zone(String cfDs0zone){
		this.cfDs0zone=cfDs0zone;
	}
	public String getCfDs0zone(){
		return cfDs0zone;
	}
	public void setCfDs0pertran(Double cfDs0pertran){
		this.cfDs0pertran=cfDs0pertran;
	}
	public Double getCfDs0pertran(){
		return cfDs0pertran;
	}
	public void setCfDs0perday(Double cfDs0perday){
		this.cfDs0perday=cfDs0perday;
	}
	public Double getCfDs0perday(){
		return cfDs0perday;
	}
	public void setCfDt0stat(Integer cfDt0stat){
		this.cfDt0stat=cfDt0stat;
	}
	public Integer getCfDt0stat(){
		return cfDt0stat;
	}
	public void setCfDt0zone(String cfDt0zone){
		this.cfDt0zone=cfDt0zone;
	}
	public String getCfDt0zone(){
		return cfDt0zone;
	}
	public void setCfDt0pertran(Double cfDt0pertran){
		this.cfDt0pertran=cfDt0pertran;
	}
	public Double getCfDt0pertran(){
		return cfDt0pertran;
	}
	public void setCfDt0perday(Double cfDt0perday){
		this.cfDt0perday=cfDt0perday;
	}
	public Double getCfDt0perday(){
		return cfDt0perday;
	}
	public void setCfDt1stat(Integer cfDt1stat){
		this.cfDt1stat=cfDt1stat;
	}
	public Integer getCfDt1stat(){
		return cfDt1stat;
	}
	public void setCfDt1zone(String cfDt1zone){
		this.cfDt1zone=cfDt1zone;
	}
	public String getCfDt1zone(){
		return cfDt1zone;
	}
	public void setCfDt1pertran(Double cfDt1pertran){
		this.cfDt1pertran=cfDt1pertran;
	}
	public Double getCfDt1pertran(){
		return cfDt1pertran;
	}
	public void setCfDt1perday(Double cfDt1perday){
		this.cfDt1perday=cfDt1perday;
	}
	public Double getCfDt1perday(){
		return cfDt1perday;
	}
	public void setCfCnstat(Integer cfCnstat){
		this.cfCnstat=cfCnstat;
	}
	public Integer getCfCnstat(){
		return cfCnstat;
	}
	public void setCfCnzone(String cfCnzone){
		this.cfCnzone=cfCnzone;
	}
	public String getCfCnzone(){
		return cfCnzone;
	}
	public void setCfCnpertran(Double cfCnpertran){
		this.cfCnpertran=cfCnpertran;
	}
	public Double getCfCnpertran(){
		return cfCnpertran;
	}
	public void setCfCnperday(Double cfCnperday){
		this.cfCnperday=cfCnperday;
	}
	public Double getCfCnperday(){
		return cfCnperday;
	}
	public void setCfDzerostat(Integer cfDzerostat){
		this.cfDzerostat=cfDzerostat;
	}
	public Integer getCfDzerostat(){
		return cfDzerostat;
	}
	public void setCfDzerozone(String cfDzerozone){
		this.cfDzerozone=cfDzerozone;
	}
	public String getCfDzerozone(){
		return cfDzerozone;
	}
	public void setCfDzeropertran(Double cfDzeropertran){
		this.cfDzeropertran=cfDzeropertran;
	}
	public Double getCfDzeropertran(){
		return cfDzeropertran;
	}
	public void setCfDzeroperday(Double cfDzeroperday){
		this.cfDzeroperday=cfDzeroperday;
	}
	public Double getCfDzeroperday(){
		return cfDzeroperday;
	}
	public void setCfTaket1stat(Integer cfTaket1stat){
		this.cfTaket1stat=cfTaket1stat;
	}
	public Integer getCfTaket1stat(){
		return cfTaket1stat;
	}
	public void setCfTaket1zone(String cfTaket1zone){
		this.cfTaket1zone=cfTaket1zone;
	}
	public String getCfTaket1zone(){
		return cfTaket1zone;
	}
	public void setCfTaket1pertran(Double cfTaket1pertran){
		this.cfTaket1pertran=cfTaket1pertran;
	}
	public Double getCfTaket1pertran(){
		return cfTaket1pertran;
	}
	public void setCfTaket1perday(Double cfTaket1perday){
		this.cfTaket1perday=cfTaket1perday;
	}
	public Double getCfTaket1perday(){
		return cfTaket1perday;
	}
	public void setCfTaket0stat(Integer cfTaket0stat){
		this.cfTaket0stat=cfTaket0stat;
	}
	public Integer getCfTaket0stat(){
		return cfTaket0stat;
	}
	public void setCfTaket0zone(String cfTaket0zone){
		this.cfTaket0zone=cfTaket0zone;
	}
	public String getCfTaket0zone(){
		return cfTaket0zone;
	}
	public void setCfTaket0pertran(Double cfTaket0pertran){
		this.cfTaket0pertran=cfTaket0pertran;
	}
	public Double getCfTaket0pertran(){
		return cfTaket0pertran;
	}
	public void setCfTaket0perday(Double cfTaket0perday){
		this.cfTaket0perday=cfTaket0perday;
	}
	public Double getCfTaket0perday(){
		return cfTaket0perday;
	}
}

