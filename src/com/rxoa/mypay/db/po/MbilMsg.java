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
 * mbil_msg 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilMsg")
@Table(name="mbil_msg")
@DynamicInsert
@DynamicUpdate

public class MbilMsg extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="uuid")
	private String uuid;
	@Column(name="msg_from")
	private String msgFrom;
	@Column(name="msg_to")
	private String msgTo;
	@Column(name="msg_title")
	private String msgTitle;
	@Column(name="msg_cate")
	private Integer msgCate;
	@Column(name="msg_content")
	private String msgContent;
	@Column(name="msg_readcount")
	private Integer msgReadcount;
	@Column(name="msg_stat")
	private String msgStat;
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
	public void setMsgFrom(String msgFrom){
		this.msgFrom=msgFrom;
	}
	public String getMsgFrom(){
		return msgFrom;
	}
	public void setMsgTo(String msgTo){
		this.msgTo=msgTo;
	}
	public String getMsgTo(){
		return msgTo;
	}
	public void setMsgTitle(String msgTitle){
		this.msgTitle=msgTitle;
	}
	public String getMsgTitle(){
		return msgTitle;
	}
	public void setMsgCate(Integer msgCate){
		this.msgCate=msgCate;
	}
	public Integer getMsgCate(){
		return msgCate;
	}
	public void setMsgContent(String msgContent){
		this.msgContent=msgContent;
	}
	public String getMsgContent(){
		return msgContent;
	}
	public void setMsgReadcount(Integer msgReadcount){
		this.msgReadcount=msgReadcount;
	}
	public Integer getMsgReadcount(){
		return msgReadcount;
	}
	public void setMsgStat(String msgStat){
		this.msgStat=msgStat;
	}
	public String getMsgStat(){
		return msgStat;
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

