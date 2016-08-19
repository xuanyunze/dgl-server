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
 * mbil_settle_log 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilSettleLog")
@Table(name="mbil_settle_log")
@DynamicInsert
@DynamicUpdate

public class MbilSettleLog extends AbstractEntity{
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
	@Column(name="sl_uid")
	private String slUid;
	@Column(name="sl_orderid")
	private String slOrderid;
	@Column(name="sl_ordertype")
	private String slOrdertype;
	@Column(name="sl_odarrivetype")
	private String slOdarrivetype;
	@Column(name="sl_ordertime")
	private Date slOrdertime;
	@Column(name="sl_settlevalue")
	private Double slSettlevalue;
	@Column(name="sl_stfeerate")
	private Double slStfeerate;
	@Column(name="sl_settletime")
	private Date slSettletime;
	@Column(name="sl_stchannel")
	private String slStchannel;
	@Column(name="sl_remoteid")
	private String slRemoteid;
	@Column(name="sl_stvalue")
	private Double slStvalue;
	@Column(name="sl_staccname")
	private String slStaccname;
	@Column(name="sl_staccno")
	private String slStaccno;
	@Column(name="sl_acccate")
	private Integer slAcccate;
	@Column(name="sl_stbankname")
	private String slStbankname;
	@Column(name="sl_stbankdistr")
	private String slStbankdistr;
	@Column(name="sl_stbankbranch")
	private String slStbankbranch;
	@Column(name="sl_stbankcode")
	private String slStbankcode;
	@Column(name="sl_stprovince")
	private String slStprovince;
	@Column(name="sl_stcity")
	private String slStcity;
	@Column(name="sl_sendtime")
	private Date slSendtime;
	@Column(name="sl_succtime")
	private Date slSucctime;
	@Column(name="sl_querycount")
	private Integer slQuerycount;
	@Column(name="sl_sttype")
	private Integer slSttype;
	@Column(name="sl_reason")
	private String slReason;
	@Column(name="sl_stat")
	private Integer slStat;

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
	public void setSlUid(String slUid){
		this.slUid=slUid;
	}
	public String getSlUid(){
		return slUid;
	}
	public void setSlOrderid(String slOrderid){
		this.slOrderid=slOrderid;
	}
	public String getSlOrderid(){
		return slOrderid;
	}
	public void setSlOrdertype(String slOrdertype){
		this.slOrdertype=slOrdertype;
	}
	public String getSlOrdertype(){
		return slOrdertype;
	}
	public void setSlOdarrivetype(String slOdarrivetype){
		this.slOdarrivetype=slOdarrivetype;
	}
	public String getSlOdarrivetype(){
		return slOdarrivetype;
	}
	public void setSlOrdertime(Date slOrdertime){
		this.slOrdertime=slOrdertime;
	}
	public Date getSlOrdertime(){
		return slOrdertime;
	}
	public void setSlSettlevalue(Double slSettlevalue){
		this.slSettlevalue=slSettlevalue;
	}
	public Double getSlSettlevalue(){
		return slSettlevalue;
	}
	public void setSlStfeerate(Double slStfeerate){
		this.slStfeerate=slStfeerate;
	}
	public Double getSlStfeerate(){
		return slStfeerate;
	}
	public void setSlSettletime(Date slSettletime){
		this.slSettletime=slSettletime;
	}
	public Date getSlSettletime(){
		return slSettletime;
	}
	public void setSlStchannel(String slStchannel){
		this.slStchannel=slStchannel;
	}
	public String getSlStchannel(){
		return slStchannel;
	}
	public void setSlRemoteid(String slRemoteid){
		this.slRemoteid=slRemoteid;
	}
	public String getSlRemoteid(){
		return slRemoteid;
	}
	public void setSlStvalue(Double slStvalue){
		this.slStvalue=slStvalue;
	}
	public Double getSlStvalue(){
		return slStvalue;
	}
	public void setSlStaccname(String slStaccname){
		this.slStaccname=slStaccname;
	}
	public String getSlStaccname(){
		return slStaccname;
	}
	public void setSlStaccno(String slStaccno){
		this.slStaccno=slStaccno;
	}
	public String getSlStaccno(){
		return slStaccno;
	}
	public void setSlAcccate(Integer slAcccate){
		this.slAcccate=slAcccate;
	}
	public Integer getSlAcccate(){
		return slAcccate;
	}
	public void setSlStbankname(String slStbankname){
		this.slStbankname=slStbankname;
	}
	public String getSlStbankname(){
		return slStbankname;
	}
	public void setSlStbankdistr(String slStbankdistr){
		this.slStbankdistr=slStbankdistr;
	}
	public String getSlStbankdistr(){
		return slStbankdistr;
	}
	public void setSlStbankbranch(String slStbankbranch){
		this.slStbankbranch=slStbankbranch;
	}
	public String getSlStbankbranch(){
		return slStbankbranch;
	}
	public void setSlStbankcode(String slStbankcode){
		this.slStbankcode=slStbankcode;
	}
	public String getSlStbankcode(){
		return slStbankcode;
	}
	public void setSlStprovince(String slStprovince){
		this.slStprovince=slStprovince;
	}
	public String getSlStprovince(){
		return slStprovince;
	}
	public void setSlStcity(String slStcity){
		this.slStcity=slStcity;
	}
	public String getSlStcity(){
		return slStcity;
	}
	public void setSlSendtime(Date slSendtime){
		this.slSendtime=slSendtime;
	}
	public Date getSlSendtime(){
		return slSendtime;
	}
	public void setSlSucctime(Date slSucctime){
		this.slSucctime=slSucctime;
	}
	public Date getSlSucctime(){
		return slSucctime;
	}
	public void setSlQuerycount(Integer slQuerycount){
		this.slQuerycount=slQuerycount;
	}
	public Integer getSlQuerycount(){
		return slQuerycount;
	}
	public void setSlSttype(Integer slSttype){
		this.slSttype=slSttype;
	}
	public Integer getSlSttype(){
		return slSttype;
	}
	public void setSlReason(String slReason){
		this.slReason=slReason;
	}
	public String getSlReason(){
		return slReason;
	}
	public void setSlStat(Integer slStat){
		this.slStat=slStat;
	}
	public Integer getSlStat(){
		return slStat;
	}
}

