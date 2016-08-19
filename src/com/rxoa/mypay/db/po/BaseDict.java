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
 * base_dict 实体类
 * Tue Apr 05 11:23:26 CST 2016 baiyu
 */ 

@Entity(name="BaseDict")
@Table(name="base_dict")
@DynamicInsert
@DynamicUpdate

public class BaseDict extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="uuid")
	private String uuid;
	@Column(name="dc_type")
	private String dcType;
	@Column(name="dc_subtype")
	private String dcSubtype;
	@Column(name="dc_value")
	private String dcValue;
	@Column(name="dc_weight")
	private String dcWeight;
	@Column(name="dc_avatar")
	private String dcAvatar;
	@Column(name="dc_avatarb")
	private String dcAvatarb;
	@Column(name="dc_remark")
	private String dcRemark;
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
	public void setDcType(String dcType){
		this.dcType=dcType;
	}
	public String getDcType(){
		return dcType;
	}
	public void setDcSubtype(String dcSubtype){
		this.dcSubtype=dcSubtype;
	}
	public String getDcSubtype(){
		return dcSubtype;
	}
	public void setDcValue(String dcValue){
		this.dcValue=dcValue;
	}
	public String getDcValue(){
		return dcValue;
	}
	public void setDcWeight(String dcWeight){
		this.dcWeight=dcWeight;
	}
	public String getDcWeight(){
		return dcWeight;
	}
	public void setDcAvatar(String dcAvatar){
		this.dcAvatar=dcAvatar;
	}
	public String getDcAvatar(){
		return dcAvatar;
	}
	public void setDcAvatarb(String dcAvatarb){
		this.dcAvatarb=dcAvatarb;
	}
	public String getDcAvatarb(){
		return dcAvatarb;
	}
	public void setDcRemark(String dcRemark){
		this.dcRemark=dcRemark;
	}
	public String getDcRemark(){
		return dcRemark;
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

