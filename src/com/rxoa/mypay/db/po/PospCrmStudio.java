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
 * posp_crm_studio 实体类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Entity(name="PospCrmStudio")
@Table(name="posp_crm_studio")
@DynamicInsert
@DynamicUpdate

public class PospCrmStudio extends AbstractEntity{
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
	@Column(name="pstu_id")
	private String pstuId;
	@Column(name="pstu_orgid")
	private String pstuOrgid;
	@Column(name="pstu_busicode")
	private String pstuBusicode;
	@Column(name="pstu_name")
	private String pstuName;
	@Column(name="pstu_code")
	private String pstuCode;
	@Column(name="pstu_lawname")
	private String pstuLawname;
	@Column(name="pstu_lawidcard")
	private String pstuLawidcard;
	@Column(name="pstu_lawphone")
	private String pstuLawphone;
	@Column(name="pstu_bankaccname")
	private String pstuBankaccname;
	@Column(name="pstu_bankaccno")
	private String pstuBankaccno;
	@Column(name="pstu_bankname")
	private String pstuBankname;
	@Column(name="pstu_bankno")
	private String pstuBankno;
	@Column(name="pstu_bankbranch")
	private String pstuBankbranch;
	@Column(name="pstu_bankdistr")
	private String pstuBankdistr;
	@Column(name="pstu_local")
	private String pstuLocal;
	@Column(name="pstu_localdetail")
	private String pstuLocaldetail;
	@Column(name="pstu_stat")
	private String pstuStat;

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
	public void setPstuId(String pstuId){
		this.pstuId=pstuId;
	}
	public String getPstuId(){
		return pstuId;
	}
	public void setPstuOrgid(String pstuOrgid){
		this.pstuOrgid=pstuOrgid;
	}
	public String getPstuOrgid(){
		return pstuOrgid;
	}
	public void setPstuBusicode(String pstuBusicode){
		this.pstuBusicode=pstuBusicode;
	}
	public String getPstuBusicode(){
		return pstuBusicode;
	}
	public void setPstuName(String pstuName){
		this.pstuName=pstuName;
	}
	public String getPstuName(){
		return pstuName;
	}
	public void setPstuCode(String pstuCode){
		this.pstuCode=pstuCode;
	}
	public String getPstuCode(){
		return pstuCode;
	}
	public void setPstuLawname(String pstuLawname){
		this.pstuLawname=pstuLawname;
	}
	public String getPstuLawname(){
		return pstuLawname;
	}
	public void setPstuLawidcard(String pstuLawidcard){
		this.pstuLawidcard=pstuLawidcard;
	}
	public String getPstuLawidcard(){
		return pstuLawidcard;
	}
	public void setPstuLawphone(String pstuLawphone){
		this.pstuLawphone=pstuLawphone;
	}
	public String getPstuLawphone(){
		return pstuLawphone;
	}
	public void setPstuBankaccname(String pstuBankaccname){
		this.pstuBankaccname=pstuBankaccname;
	}
	public String getPstuBankaccname(){
		return pstuBankaccname;
	}
	public void setPstuBankaccno(String pstuBankaccno){
		this.pstuBankaccno=pstuBankaccno;
	}
	public String getPstuBankaccno(){
		return pstuBankaccno;
	}
	public void setPstuBankname(String pstuBankname){
		this.pstuBankname=pstuBankname;
	}
	public String getPstuBankname(){
		return pstuBankname;
	}
	public void setPstuBankno(String pstuBankno){
		this.pstuBankno=pstuBankno;
	}
	public String getPstuBankno(){
		return pstuBankno;
	}
	public void setPstuBankbranch(String pstuBankbranch){
		this.pstuBankbranch=pstuBankbranch;
	}
	public String getPstuBankbranch(){
		return pstuBankbranch;
	}
	public void setPstuBankdistr(String pstuBankdistr){
		this.pstuBankdistr=pstuBankdistr;
	}
	public String getPstuBankdistr(){
		return pstuBankdistr;
	}
	public void setPstuLocal(String pstuLocal){
		this.pstuLocal=pstuLocal;
	}
	public String getPstuLocal(){
		return pstuLocal;
	}
	public void setPstuLocaldetail(String pstuLocaldetail){
		this.pstuLocaldetail=pstuLocaldetail;
	}
	public String getPstuLocaldetail(){
		return pstuLocaldetail;
	}
	public void setPstuStat(String pstuStat){
		this.pstuStat=pstuStat;
	}
	public String getPstuStat(){
		return pstuStat;
	}
}

