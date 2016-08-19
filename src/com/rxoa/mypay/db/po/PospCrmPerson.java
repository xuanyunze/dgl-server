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
 * posp_crm_person 实体类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Entity(name="PospCrmPerson")
@Table(name="posp_crm_person")
@DynamicInsert
@DynamicUpdate

public class PospCrmPerson extends AbstractEntity{
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
	@Column(name="pper_id")
	private String pperId;
	@Column(name="pper_orgid")
	private String pperOrgid;
	@Column(name="pper_busicode")
	private String pperBusicode;
	@Column(name="pper_name")
	private String pperName;
	@Column(name="pper_idcard")
	private String pperIdcard;
	@Column(name="pper_phone")
	private String pperPhone;
	@Column(name="pper_areacode")
	private String pperAreacode;
	@Column(name="pper_bankaccname")
	private String pperBankaccname;
	@Column(name="pper_bankaccno")
	private String pperBankaccno;
	@Column(name="pper_bankname")
	private String pperBankname;
	@Column(name="pper_bankno")
	private String pperBankno;
	@Column(name="pper_bankbranch")
	private String pperBankbranch;
	@Column(name="pper_bankdistr")
	private String pperBankdistr;
	@Column(name="pper_local")
	private String pperLocal;
	@Column(name="pper_localdetail")
	private String pperLocaldetail;
	@Column(name="pper_stat")
	private String pperStat;

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
	public void setPperId(String pperId){
		this.pperId=pperId;
	}
	public String getPperId(){
		return pperId;
	}
	public void setPperOrgid(String pperOrgid){
		this.pperOrgid=pperOrgid;
	}
	public String getPperOrgid(){
		return pperOrgid;
	}
	public void setPperBusicode(String pperBusicode){
		this.pperBusicode=pperBusicode;
	}
	public String getPperBusicode(){
		return pperBusicode;
	}
	public void setPperName(String pperName){
		this.pperName=pperName;
	}
	public String getPperName(){
		return pperName;
	}
	public void setPperIdcard(String pperIdcard){
		this.pperIdcard=pperIdcard;
	}
	public String getPperIdcard(){
		return pperIdcard;
	}
	public void setPperPhone(String pperPhone){
		this.pperPhone=pperPhone;
	}
	public String getPperPhone(){
		return pperPhone;
	}
	public void setPperAreacode(String pperAreacode){
		this.pperAreacode=pperAreacode;
	}
	public String getPperAreacode(){
		return pperAreacode;
	}
	public void setPperBankaccname(String pperBankaccname){
		this.pperBankaccname=pperBankaccname;
	}
	public String getPperBankaccname(){
		return pperBankaccname;
	}
	public void setPperBankaccno(String pperBankaccno){
		this.pperBankaccno=pperBankaccno;
	}
	public String getPperBankaccno(){
		return pperBankaccno;
	}
	public void setPperBankname(String pperBankname){
		this.pperBankname=pperBankname;
	}
	public String getPperBankname(){
		return pperBankname;
	}
	public void setPperBankno(String pperBankno){
		this.pperBankno=pperBankno;
	}
	public String getPperBankno(){
		return pperBankno;
	}
	public void setPperBankbranch(String pperBankbranch){
		this.pperBankbranch=pperBankbranch;
	}
	public String getPperBankbranch(){
		return pperBankbranch;
	}
	public void setPperBankdistr(String pperBankdistr){
		this.pperBankdistr=pperBankdistr;
	}
	public String getPperBankdistr(){
		return pperBankdistr;
	}
	public void setPperLocal(String pperLocal){
		this.pperLocal=pperLocal;
	}
	public String getPperLocal(){
		return pperLocal;
	}
	public void setPperLocaldetail(String pperLocaldetail){
		this.pperLocaldetail=pperLocaldetail;
	}
	public String getPperLocaldetail(){
		return pperLocaldetail;
	}
	public void setPperStat(String pperStat){
		this.pperStat=pperStat;
	}
	public String getPperStat(){
		return pperStat;
	}
}

