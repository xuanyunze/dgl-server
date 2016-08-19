package com.rxoa.mypay.sys.vo;

import com.rxoa.mypay.base.BaseEntity;

public class BenefitEntityVo extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String oid;
	private String oname;
	
	private int s0Count;
	private int t1Count;
	private int totalCount;
	
	private Double s0Value;
	private Double t1Value;
	private Double totalValue;
	
	private Double s0Benefit;
	private Double t1Benefit;
	private Double totalBenefit;
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public int getS0Count() {
		return s0Count;
	}
	public void setS0Count(int s0Count) {
		this.s0Count = s0Count;
	}
	public int getT1Count() {
		return t1Count;
	}
	public void setT1Count(int t1Count) {
		this.t1Count = t1Count;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public Double getS0Value() {
		return s0Value;
	}
	public void setS0Value(Double s0Value) {
		this.s0Value = s0Value;
	}
	public Double getT1Value() {
		return t1Value;
	}
	public void setT1Value(Double t1Value) {
		this.t1Value = t1Value;
	}
	public Double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	public Double getS0Benefit() {
		return s0Benefit;
	}
	public void setS0Benefit(Double s0Benefit) {
		this.s0Benefit = s0Benefit;
	}
	public Double getT1Benefit() {
		return t1Benefit;
	}
	public void setT1Benefit(Double t1Benefit) {
		this.t1Benefit = t1Benefit;
	}
	public Double getTotalBenefit() {
		return totalBenefit;
	}
	public void setTotalBenefit(Double totalBenefit) {
		this.totalBenefit = totalBenefit;
	}
}
