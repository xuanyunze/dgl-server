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
 * sys_user 实体类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Entity(name="SysUser")
@Table(name="sys_user")
@DynamicInsert
@DynamicUpdate

public class SysUser extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="uuid")
	private String uuid;
	@Column(name="u_id")
	private String uid;
	@Column(name="u_roleid")
	private String uroleid;
	@Column(name="u_pwd")
	private String upwd;
	@Column(name="u_name")
	private String uname;
	@Column(name="u_mail")
	private String umail;
	@Column(name="u_phone")
	private String uphone;
	@Column(name="u_telephone")
	private String utelephone;
	@Column(name="u_type")
	private String utype;
	@Column(name="u_orgid")
	private String uorgid;
	@Column(name="u_position")
	private String uposition;
	@Column(name="u_stat")
	private String ustat;
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
	public void setUid(String uid){
		this.uid=uid;
	}
	public String getUid(){
		return uid;
	}
	public void setUroleid(String uroleid){
		this.uroleid=uroleid;
	}
	public String getUroleid(){
		return uroleid;
	}
	public void setUpwd(String upwd){
		this.upwd=upwd;
	}
	public String getUpwd(){
		return upwd;
	}
	public void setUname(String uname){
		this.uname=uname;
	}
	public String getUname(){
		return uname;
	}
	public void setUmail(String umail){
		this.umail=umail;
	}
	public String getUmail(){
		return umail;
	}
	public void setUphone(String uphone){
		this.uphone=uphone;
	}
	public String getUphone(){
		return uphone;
	}
	public void setUtelephone(String utelephone){
		this.utelephone=utelephone;
	}
	public String getUtelephone(){
		return utelephone;
	}
	public void setUtype(String utype){
		this.utype=utype;
	}
	public String getUtype(){
		return utype;
	}
	public void setUorgid(String uorgid){
		this.uorgid=uorgid;
	}
	public String getUorgid(){
		return uorgid;
	}
	public void setUposition(String uposition){
		this.uposition=uposition;
	}
	public String getUposition(){
		return uposition;
	}
	public void setUstat(String ustat){
		this.ustat=ustat;
	}
	public String getUstat(){
		return ustat;
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

