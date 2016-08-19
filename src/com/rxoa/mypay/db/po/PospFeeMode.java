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
 * posp_fee_mode 实体类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Entity(name="PospFeeMode")
@Table(name="posp_fee_mode")
@DynamicInsert
@DynamicUpdate

public class PospFeeMode extends AbstractEntity{
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
	@Column(name="mcc_code")
	private String mccCode;
	@Column(name="mcc_name")
	private String mccName;
	@Column(name="mcc_text")
	private String mccText;
	@Column(name="mcc_dfvalue")
	private String mccDfvalue;
	@Column(name="mcc_istop")
	private String mccIstop;
	@Column(name="mcc_topvalue")
	private String mccTopvalue;

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
	public void setMccCode(String mccCode){
		this.mccCode=mccCode;
	}
	public String getMccCode(){
		return mccCode;
	}
	public void setMccName(String mccName){
		this.mccName=mccName;
	}
	public String getMccName(){
		return mccName;
	}
	public void setMccText(String mccText){
		this.mccText=mccText;
	}
	public String getMccText(){
		return mccText;
	}
	public void setMccDfvalue(String mccDfvalue){
		this.mccDfvalue=mccDfvalue;
	}
	public String getMccDfvalue(){
		return mccDfvalue;
	}
	public void setMccIstop(String mccIstop){
		this.mccIstop=mccIstop;
	}
	public String getMccIstop(){
		return mccIstop;
	}
	public void setMccTopvalue(String mccTopvalue){
		this.mccTopvalue=mccTopvalue;
	}
	public String getMccTopvalue(){
		return mccTopvalue;
	}
}

