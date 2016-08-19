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
 * sys_wf_history 实体类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Entity(name="SysWfHistory")
@Table(name="sys_wf_history")
@DynamicInsert
@DynamicUpdate

public class SysWfHistory extends AbstractEntity{
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
	@Column(name="wh_tasktype")
	private String whTasktype;
	@Column(name="wh_taskid")
	private String whTaskid;
	@Column(name="wh_dealer")
	private String whDealer;
	@Column(name="wh_action")
	private String whAction;
	@Column(name="wh_dealtime")
	private String whDealtime;
	@Column(name="wh_dealresult")
	private String whDealresult;
	@Column(name="wh_dealyj")
	private String whDealyj;

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
	public void setWhTasktype(String whTasktype){
		this.whTasktype=whTasktype;
	}
	public String getWhTasktype(){
		return whTasktype;
	}
	public void setWhTaskid(String whTaskid){
		this.whTaskid=whTaskid;
	}
	public String getWhTaskid(){
		return whTaskid;
	}
	public void setWhDealer(String whDealer){
		this.whDealer=whDealer;
	}
	public String getWhDealer(){
		return whDealer;
	}
	public void setWhAction(String whAction){
		this.whAction=whAction;
	}
	public String getWhAction(){
		return whAction;
	}
	public void setWhDealtime(String whDealtime){
		this.whDealtime=whDealtime;
	}
	public String getWhDealtime(){
		return whDealtime;
	}
	public void setWhDealresult(String whDealresult){
		this.whDealresult=whDealresult;
	}
	public String getWhDealresult(){
		return whDealresult;
	}
	public void setWhDealyj(String whDealyj){
		this.whDealyj=whDealyj;
	}
	public String getWhDealyj(){
		return whDealyj;
	}
}

