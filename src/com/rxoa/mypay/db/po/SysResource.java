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
 * sys_resource 实体类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Entity(name="SysResource")
@Table(name="sys_resource")
@DynamicInsert
@DynamicUpdate

public class SysResource extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="uuid")
	private String uuid;
	@Column(name="re_id")
	private String reId;
	@Column(name="re_code")
	private String reCode;
	@Column(name="re_name")
	private String reName;
	@Column(name="re_path")
	private String rePath;
	@Column(name="re_type")
	private String reType;
	@Column(name="re_subtype")
	private String reSubtype;
	@Column(name="re_cate")
	private String reCate;
	@Column(name="re_subcate")
	private String reSubcate;
	@Column(name="re_weight")
	private String reWeight;
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
	public void setReId(String reId){
		this.reId=reId;
	}
	public String getReId(){
		return reId;
	}
	public void setReCode(String reCode){
		this.reCode=reCode;
	}
	public String getReCode(){
		return reCode;
	}
	public void setReName(String reName){
		this.reName=reName;
	}
	public String getReName(){
		return reName;
	}
	public void setRePath(String rePath){
		this.rePath=rePath;
	}
	public String getRePath(){
		return rePath;
	}
	public void setReType(String reType){
		this.reType=reType;
	}
	public String getReType(){
		return reType;
	}
	public void setReSubtype(String reSubtype){
		this.reSubtype=reSubtype;
	}
	public String getReSubtype(){
		return reSubtype;
	}
	public void setReCate(String reCate){
		this.reCate=reCate;
	}
	public String getReCate(){
		return reCate;
	}
	public void setReSubcate(String reSubcate){
		this.reSubcate=reSubcate;
	}
	public String getReSubcate(){
		return reSubcate;
	}
	public void setReWeight(String reWeight){
		this.reWeight=reWeight;
	}
	public String getReWeight(){
		return reWeight;
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

