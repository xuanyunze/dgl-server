package com.rxoa.mypay.sys.combx;

import java.util.Iterator;
import java.util.List;

import com.rxoa.mypay.base.BaseEntity;

public class NavTopCate extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String topCateId;
	private String topCateName;
	private String topCateHref;
	private String topCateWeight;
	private List<NavLeftCate> leftCate;
	
	public NavLeftCate getLeftCateById(String leftCateId){
		NavLeftCate curLeftCate = null;
		try{
			Iterator<NavLeftCate> it = leftCate.iterator();
			while(it.hasNext()){
				curLeftCate = it.next();
				if(curLeftCate.getCateId().equals(leftCateId)){
					return curLeftCate;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return curLeftCate;
	}
	public String getTopCateId() {
		return topCateId;
	}
	public void setTopCateId(String topCateId) {
		this.topCateId = topCateId;
	}
	public String getTopCateName() {
		return topCateName;
	}
	public void setTopCateName(String topCateName) {
		this.topCateName = topCateName;
	}
	public String getTopCateHref() {
		return topCateHref;
	}
	public void setTopCateHref(String topCateHref) {
		this.topCateHref = topCateHref;
	}
	public List<NavLeftCate> getLeftCate() {
		return leftCate;
	}
	public void setLeftCate(List<NavLeftCate> leftCate) {
		this.leftCate = leftCate;
	}
	public String getTopCateWeight() {
		return topCateWeight;
	}
	public void setTopCateWeight(String topCateWeight) {
		this.topCateWeight = topCateWeight;
	}
}