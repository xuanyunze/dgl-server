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
 * deal_trans_log 实体类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Entity(name="DealTransLog")
@Table(name="deal_trans_log")
@DynamicInsert
@DynamicUpdate

public class DealTransLog extends AbstractEntity{
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
	@Column(name="trl_trid")
	private String trlTrid;
	@Column(name="trl_sendmsg")
	private String trlSendmsg;
	@Column(name="trl_backmsg")
	private String trlBackmsg;
	@Column(name="trl_sendtime")
	private String trlSendtime;
	@Column(name="trl_backtime")
	private String trlBacktime;

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
	public void setTrlTrid(String trlTrid){
		this.trlTrid=trlTrid;
	}
	public String getTrlTrid(){
		return trlTrid;
	}
	public void setTrlSendmsg(String trlSendmsg){
		this.trlSendmsg=trlSendmsg;
	}
	public String getTrlSendmsg(){
		return trlSendmsg;
	}
	public void setTrlBackmsg(String trlBackmsg){
		this.trlBackmsg=trlBackmsg;
	}
	public String getTrlBackmsg(){
		return trlBackmsg;
	}
	public void setTrlSendtime(String trlSendtime){
		this.trlSendtime=trlSendtime;
	}
	public String getTrlSendtime(){
		return trlSendtime;
	}
	public void setTrlBacktime(String trlBacktime){
		this.trlBacktime=trlBacktime;
	}
	public String getTrlBacktime(){
		return trlBacktime;
	}
}

