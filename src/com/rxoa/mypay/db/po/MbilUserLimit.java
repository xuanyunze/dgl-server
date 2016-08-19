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
 * mbil_user_limit 实体类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Entity(name="MbilUserLimit")
@Table(name="mbil_user_limit")
@DynamicInsert
@DynamicUpdate

public class MbilUserLimit extends AbstractEntity{
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
	@Column(name="ul_uid")
	private String ulUid;
	@Column(name="ul_dflow_s0")
	private Double ulDflowS0;
	@Column(name="ul_dlimit_s0")
	private Double ulDlimitS0;
	@Column(name="ul_plimit_s0")
	private Double ulPlimitS0;
	@Column(name="ul_pmin_s0")
	private Double ulPminS0;
	@Column(name="ul_dflow_t0")
	private Double ulDflowT0;
	@Column(name="ul_dlimit_t0")
	private Double ulDlimitT0;
	@Column(name="ul_plimit_t0")
	private Double ulPlimitT0;
	@Column(name="ul_pmin_t0")
	private Double ulPminT0;
	@Column(name="ul_dflow_t1")
	private Double ulDflowT1;
	@Column(name="ul_dlimit_t1")
	private Double ulDlimitT1;
	@Column(name="ul_plimit_t1")
	private Double ulPlimitT1;
	@Column(name="ul_pmin_t1")
	private Double ulPminT1;
	@Column(name="ul_dflow_tk0")
	private Double ulDflowTk0;
	@Column(name="ul_dlimit_tk0")
	private Double ulDlimitTk0;
	@Column(name="ul_plimit_tk0")
	private Double ulPlimitTk0;
	@Column(name="ul_pmin_tk0")
	private Double ulPminTk0;
	@Column(name="ul_dflow_tk1")
	private Double ulDflowTk1;
	@Column(name="ul_dlimit_tk1")
	private Double ulDlimitTk1;
	@Column(name="ul_plimit_tk1")
	private Double ulPlimitTk1;
	@Column(name="ul_pmin_tk1")
	private Double ulPminTk1;
	@Column(name="ul_dstat")
	private Integer ulDstat;
	@Column(name="ul_sstat")
	private Integer ulSstat;
	@Column(name="ul_lastdeal")
	private Date ulLastdeal;

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
	public void setUlUid(String ulUid){
		this.ulUid=ulUid;
	}
	public String getUlUid(){
		return ulUid;
	}
	public void setUlDflowS0(Double ulDflowS0){
		this.ulDflowS0=ulDflowS0;
	}
	public Double getUlDflowS0(){
		return ulDflowS0;
	}
	public void setUlDlimitS0(Double ulDlimitS0){
		this.ulDlimitS0=ulDlimitS0;
	}
	public Double getUlDlimitS0(){
		return ulDlimitS0;
	}
	public void setUlPlimitS0(Double ulPlimitS0){
		this.ulPlimitS0=ulPlimitS0;
	}
	public Double getUlPlimitS0(){
		return ulPlimitS0;
	}
	public void setUlPminS0(Double ulPminS0){
		this.ulPminS0=ulPminS0;
	}
	public Double getUlPminS0(){
		return ulPminS0;
	}
	public void setUlDflowT0(Double ulDflowT0){
		this.ulDflowT0=ulDflowT0;
	}
	public Double getUlDflowT0(){
		return ulDflowT0;
	}
	public void setUlDlimitT0(Double ulDlimitT0){
		this.ulDlimitT0=ulDlimitT0;
	}
	public Double getUlDlimitT0(){
		return ulDlimitT0;
	}
	public void setUlPlimitT0(Double ulPlimitT0){
		this.ulPlimitT0=ulPlimitT0;
	}
	public Double getUlPlimitT0(){
		return ulPlimitT0;
	}
	public void setUlPminT0(Double ulPminT0){
		this.ulPminT0=ulPminT0;
	}
	public Double getUlPminT0(){
		return ulPminT0;
	}
	public void setUlDflowT1(Double ulDflowT1){
		this.ulDflowT1=ulDflowT1;
	}
	public Double getUlDflowT1(){
		return ulDflowT1;
	}
	public void setUlDlimitT1(Double ulDlimitT1){
		this.ulDlimitT1=ulDlimitT1;
	}
	public Double getUlDlimitT1(){
		return ulDlimitT1;
	}
	public void setUlPlimitT1(Double ulPlimitT1){
		this.ulPlimitT1=ulPlimitT1;
	}
	public Double getUlPlimitT1(){
		return ulPlimitT1;
	}
	public void setUlPminT1(Double ulPminT1){
		this.ulPminT1=ulPminT1;
	}
	public Double getUlPminT1(){
		return ulPminT1;
	}
	public void setUlDflowTk0(Double ulDflowTk0){
		this.ulDflowTk0=ulDflowTk0;
	}
	public Double getUlDflowTk0(){
		return ulDflowTk0;
	}
	public void setUlDlimitTk0(Double ulDlimitTk0){
		this.ulDlimitTk0=ulDlimitTk0;
	}
	public Double getUlDlimitTk0(){
		return ulDlimitTk0;
	}
	public void setUlPlimitTk0(Double ulPlimitTk0){
		this.ulPlimitTk0=ulPlimitTk0;
	}
	public Double getUlPlimitTk0(){
		return ulPlimitTk0;
	}
	public void setUlPminTk0(Double ulPminTk0){
		this.ulPminTk0=ulPminTk0;
	}
	public Double getUlPminTk0(){
		return ulPminTk0;
	}
	public void setUlDflowTk1(Double ulDflowTk1){
		this.ulDflowTk1=ulDflowTk1;
	}
	public Double getUlDflowTk1(){
		return ulDflowTk1;
	}
	public void setUlDlimitTk1(Double ulDlimitTk1){
		this.ulDlimitTk1=ulDlimitTk1;
	}
	public Double getUlDlimitTk1(){
		return ulDlimitTk1;
	}
	public void setUlPlimitTk1(Double ulPlimitTk1){
		this.ulPlimitTk1=ulPlimitTk1;
	}
	public Double getUlPlimitTk1(){
		return ulPlimitTk1;
	}
	public void setUlPminTk1(Double ulPminTk1){
		this.ulPminTk1=ulPminTk1;
	}
	public Double getUlPminTk1(){
		return ulPminTk1;
	}
	public void setUlDstat(Integer ulDstat){
		this.ulDstat=ulDstat;
	}
	public Integer getUlDstat(){
		return ulDstat;
	}
	public void setUlSstat(Integer ulSstat){
		this.ulSstat=ulSstat;
	}
	public Integer getUlSstat(){
		return ulSstat;
	}
	public void setUlLastdeal(Date ulLastdeal){
		this.ulLastdeal=ulLastdeal;
	}
	public Date getUlLastdeal(){
		return ulLastdeal;
	}
}

