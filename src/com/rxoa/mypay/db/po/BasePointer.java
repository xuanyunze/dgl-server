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
 * base_pointer 实体类
 * Tue Apr 05 11:23:26 CST 2016 baiyu
 */ 

@Entity(name="BasePointer")
@Table(name="base_pointer")
@DynamicInsert
@DynamicUpdate

public class BasePointer extends AbstractEntity{
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
	@Column(name="pt_name")
	private String ptName;
	@Column(name="pt_value")
	private String ptValue;
	@Column(name="pt_step")
	private String ptStep;
	@Column(name="pt_remark")
	private String ptRemark;

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
	public void setPtName(String ptName){
		this.ptName=ptName;
	}
	public String getPtName(){
		return ptName;
	}
	public void setPtValue(String ptValue){
		this.ptValue=ptValue;
	}
	public String getPtValue(){
		return ptValue;
	}
	public void setPtStep(String ptStep){
		this.ptStep=ptStep;
	}
	public String getPtStep(){
		return ptStep;
	}
	public void setPtRemark(String ptRemark){
		this.ptRemark=ptRemark;
	}
	public String getPtRemark(){
		return ptRemark;
	}
}

