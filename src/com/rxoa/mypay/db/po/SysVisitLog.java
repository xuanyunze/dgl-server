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
 * sys_visit_log 实体类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Entity(name="SysVisitLog")
@Table(name="sys_visit_log")
@DynamicInsert
@DynamicUpdate

public class SysVisitLog extends AbstractEntity{
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
	@Column(name="vl_uid")
	private String vlUid;
	@Column(name="vi_uri")
	private String viUri;
	@Column(name="vl_ip")
	private String vlIp;
	@Column(name="vi_action")
	private String viAction;
	@Column(name="vi_time")
	private Date viTime;

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
	public void setVlUid(String vlUid){
		this.vlUid=vlUid;
	}
	public String getVlUid(){
		return vlUid;
	}
	public void setViUri(String viUri){
		this.viUri=viUri;
	}
	public String getViUri(){
		return viUri;
	}
	public void setVlIp(String vlIp){
		this.vlIp=vlIp;
	}
	public String getVlIp(){
		return vlIp;
	}
	public void setViAction(String viAction){
		this.viAction=viAction;
	}
	public String getViAction(){
		return viAction;
	}
	public void setViTime(Date viTime){
		this.viTime=viTime;
	}
	public Date getViTime(){
		return viTime;
	}
}

