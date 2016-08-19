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
 * mbil_user 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilUser")
@Table(name="mbil_user")
@DynamicInsert
@DynamicUpdate

public class MbilUser extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="uuid")
	private String uuid;
	@Column(name="u_id")
	private String uid;
	@Column(name="u_orgid")
	private String uorgid;
	@Column(name="u_pwd")
	private String upwd;
	@Column(name="u_paypwd")
	private String upaypwd;
	@Column(name="u_type")
	private String utype;
	@Column(name="u_workkey")
	private String uworkkey;
	@Column(name="u_signtime")
	private String usigntime;
	@Column(name="u_realname")
	private String urealname;
	@Column(name="u_idtype")
	private String uidtype;
	@Column(name="u_idno")
	private String uidno;
	@Column(name="u_realauthtime")
	private String urealauthtime;
	@Column(name="u_actitype")
	private String uactitype;
	@Column(name="u_actitime")
	private String uactitime;
	@Column(name="u_routercate")
	private Integer uroutercate;
	@Column(name="u_routerid")
	private String urouterid;
	@Column(name="u_dstat")
	private Integer udstat;
	@Column(name="u_sstat")
	private Integer usstat;
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
	public void setUorgid(String uorgid){
		this.uorgid=uorgid;
	}
	public String getUorgid(){
		return uorgid;
	}
	public void setUpwd(String upwd){
		this.upwd=upwd;
	}
	public String getUpwd(){
		return upwd;
	}
	public void setUpaypwd(String upaypwd){
		this.upaypwd=upaypwd;
	}
	public String getUpaypwd(){
		return upaypwd;
	}
	public void setUtype(String utype){
		this.utype=utype;
	}
	public String getUtype(){
		return utype;
	}
	public void setUworkkey(String uworkkey){
		this.uworkkey=uworkkey;
	}
	public String getUworkkey(){
		return uworkkey;
	}
	public void setUsigntime(String usigntime){
		this.usigntime=usigntime;
	}
	public String getUsigntime(){
		return usigntime;
	}
	public void setUrealname(String urealname){
		this.urealname=urealname;
	}
	public String getUrealname(){
		return urealname;
	}
	public void setUidtype(String uidtype){
		this.uidtype=uidtype;
	}
	public String getUidtype(){
		return uidtype;
	}
	public void setUidno(String uidno){
		this.uidno=uidno;
	}
	public String getUidno(){
		return uidno;
	}
	public void setUrealauthtime(String urealauthtime){
		this.urealauthtime=urealauthtime;
	}
	public String getUrealauthtime(){
		return urealauthtime;
	}
	public void setUactitype(String uactitype){
		this.uactitype=uactitype;
	}
	public String getUactitype(){
		return uactitype;
	}
	public void setUactitime(String uactitime){
		this.uactitime=uactitime;
	}
	public String getUactitime(){
		return uactitime;
	}
	public void setUroutercate(Integer uroutercate){
		this.uroutercate=uroutercate;
	}
	public Integer getUroutercate(){
		return uroutercate;
	}
	public void setUrouterid(String urouterid){
		this.urouterid=urouterid;
	}
	public String getUrouterid(){
		return urouterid;
	}
	public void setUdstat(Integer udstat){
		this.udstat=udstat;
	}
	public Integer getUdstat(){
		return udstat;
	}
	public void setUsstat(Integer usstat){
		this.usstat=usstat;
	}
	public Integer getUsstat(){
		return usstat;
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

