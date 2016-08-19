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
 * mbil_goods_tpl 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilGoodsTpl")
@Table(name="mbil_goods_tpl")
@DynamicInsert
@DynamicUpdate

public class MbilGoodsTpl extends AbstractEntity{
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
	@Column(name="gtpl_id")
	private String gtplId;
	@Column(name="gtpl_feecode")
	private String gtplFeecode;
	@Column(name="gtpl_name")
	private String gtplName;
	@Column(name="gtpl_price")
	private String gtplPrice;
	@Column(name="gtpl_imgurl")
	private String gtplImgurl;
	@Column(name="gtpl_stat")
	private String gtplStat;

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
	public void setGtplId(String gtplId){
		this.gtplId=gtplId;
	}
	public String getGtplId(){
		return gtplId;
	}
	public void setGtplFeecode(String gtplFeecode){
		this.gtplFeecode=gtplFeecode;
	}
	public String getGtplFeecode(){
		return gtplFeecode;
	}
	public void setGtplName(String gtplName){
		this.gtplName=gtplName;
	}
	public String getGtplName(){
		return gtplName;
	}
	public void setGtplPrice(String gtplPrice){
		this.gtplPrice=gtplPrice;
	}
	public String getGtplPrice(){
		return gtplPrice;
	}
	public void setGtplImgurl(String gtplImgurl){
		this.gtplImgurl=gtplImgurl;
	}
	public String getGtplImgurl(){
		return gtplImgurl;
	}
	public void setGtplStat(String gtplStat){
		this.gtplStat=gtplStat;
	}
	public String getGtplStat(){
		return gtplStat;
	}
}

