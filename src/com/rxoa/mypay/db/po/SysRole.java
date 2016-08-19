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
 * sys_role 实体类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Entity(name="SysRole")
@Table(name="sys_role")
@DynamicInsert
@DynamicUpdate

public class SysRole extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="uuid")
	private String uuid;
	@Column(name="ro_id")
	private String roId;
	@Column(name="ro_code")
	private String roCode;
	@Column(name="ro_name")
	private String roName;
	@Column(name="ro_type")
	private String roType;
	@Column(name="ro_cate")
	private String roCate;
	@Column(name="ro_weight")
	private String roWeight;
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

	public void setUuid(String uuid){
		this.uuid=uuid;
	}
	public String getUuid(){
		return uuid;
	}
	public void setRoId(String roId){
		this.roId=roId;
	}
	public String getRoId(){
		return roId;
	}
	public void setRoCode(String roCode){
		this.roCode=roCode;
	}
	public String getRoCode(){
		return roCode;
	}
	public void setRoName(String roName){
		this.roName=roName;
	}
	public String getRoName(){
		return roName;
	}
	public void setRoType(String roType){
		this.roType=roType;
	}
	public String getRoType(){
		return roType;
	}
	public void setRoCate(String roCate){
		this.roCate=roCate;
	}
	public String getRoCate(){
		return roCate;
	}
	public void setRoWeight(String roWeight){
		this.roWeight=roWeight;
	}
	public String getRoWeight(){
		return roWeight;
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
}

