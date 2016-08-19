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
 * posp_crm_enterprise 实体类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Entity(name="PospCrmEnterprise")
@Table(name="posp_crm_enterprise")
@DynamicInsert
@DynamicUpdate

public class PospCrmEnterprise extends AbstractEntity{
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
	@Column(name="pcom_id")
	private String pcomId;
	@Column(name="pcom_orgid")
	private String pcomOrgid;
	@Column(name="pcom_busicode")
	private String pcomBusicode;
	@Column(name="pcom_name")
	private String pcomName;
	@Column(name="pcom_code")
	private String pcomCode;
	@Column(name="pcom_lawname")
	private String pcomLawname;
	@Column(name="pcom_lawidcard")
	private String pcomLawidcard;
	@Column(name="pcom_lawphone")
	private String pcomLawphone;
	@Column(name="pcom_finname")
	private String pcomFinname;
	@Column(name="pcom_finphone")
	private String pcomFinphone;
	@Column(name="pcom_bankaccname")
	private String pcomBankaccname;
	@Column(name="pcom_bankaccno")
	private String pcomBankaccno;
	@Column(name="pcom_bankname")
	private String pcomBankname;
	@Column(name="pcom_bankno")
	private String pcomBankno;
	@Column(name="pcom_bankbranch")
	private String pcomBankbranch;
	@Column(name="pcom_bankdistr")
	private String pcomBankdistr;
	@Column(name="pcom_local")
	private String pcomLocal;
	@Column(name="pcom_localdetail")
	private String pcomLocaldetail;
	@Column(name="pcom_stat")
	private String pcomStat;

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
	public void setPcomId(String pcomId){
		this.pcomId=pcomId;
	}
	public String getPcomId(){
		return pcomId;
	}
	public void setPcomOrgid(String pcomOrgid){
		this.pcomOrgid=pcomOrgid;
	}
	public String getPcomOrgid(){
		return pcomOrgid;
	}
	public void setPcomBusicode(String pcomBusicode){
		this.pcomBusicode=pcomBusicode;
	}
	public String getPcomBusicode(){
		return pcomBusicode;
	}
	public void setPcomName(String pcomName){
		this.pcomName=pcomName;
	}
	public String getPcomName(){
		return pcomName;
	}
	public void setPcomCode(String pcomCode){
		this.pcomCode=pcomCode;
	}
	public String getPcomCode(){
		return pcomCode;
	}
	public void setPcomLawname(String pcomLawname){
		this.pcomLawname=pcomLawname;
	}
	public String getPcomLawname(){
		return pcomLawname;
	}
	public void setPcomLawidcard(String pcomLawidcard){
		this.pcomLawidcard=pcomLawidcard;
	}
	public String getPcomLawidcard(){
		return pcomLawidcard;
	}
	public void setPcomLawphone(String pcomLawphone){
		this.pcomLawphone=pcomLawphone;
	}
	public String getPcomLawphone(){
		return pcomLawphone;
	}
	public void setPcomFinname(String pcomFinname){
		this.pcomFinname=pcomFinname;
	}
	public String getPcomFinname(){
		return pcomFinname;
	}
	public void setPcomFinphone(String pcomFinphone){
		this.pcomFinphone=pcomFinphone;
	}
	public String getPcomFinphone(){
		return pcomFinphone;
	}
	public void setPcomBankaccname(String pcomBankaccname){
		this.pcomBankaccname=pcomBankaccname;
	}
	public String getPcomBankaccname(){
		return pcomBankaccname;
	}
	public void setPcomBankaccno(String pcomBankaccno){
		this.pcomBankaccno=pcomBankaccno;
	}
	public String getPcomBankaccno(){
		return pcomBankaccno;
	}
	public void setPcomBankname(String pcomBankname){
		this.pcomBankname=pcomBankname;
	}
	public String getPcomBankname(){
		return pcomBankname;
	}
	public void setPcomBankno(String pcomBankno){
		this.pcomBankno=pcomBankno;
	}
	public String getPcomBankno(){
		return pcomBankno;
	}
	public void setPcomBankbranch(String pcomBankbranch){
		this.pcomBankbranch=pcomBankbranch;
	}
	public String getPcomBankbranch(){
		return pcomBankbranch;
	}
	public void setPcomBankdistr(String pcomBankdistr){
		this.pcomBankdistr=pcomBankdistr;
	}
	public String getPcomBankdistr(){
		return pcomBankdistr;
	}
	public void setPcomLocal(String pcomLocal){
		this.pcomLocal=pcomLocal;
	}
	public String getPcomLocal(){
		return pcomLocal;
	}
	public void setPcomLocaldetail(String pcomLocaldetail){
		this.pcomLocaldetail=pcomLocaldetail;
	}
	public String getPcomLocaldetail(){
		return pcomLocaldetail;
	}
	public void setPcomStat(String pcomStat){
		this.pcomStat=pcomStat;
	}
	public String getPcomStat(){
		return pcomStat;
	}
}

