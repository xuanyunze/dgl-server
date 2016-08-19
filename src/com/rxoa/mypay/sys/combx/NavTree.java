package com.rxoa.mypay.sys.combx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rxoa.mypay.base.BaseEntity;
import com.rxoa.mypay.base.util.JsonUtil;

public class NavTree extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String curTopCateId;
	private String curLeftCateId;
	private String curLeftNodeId;
	private List<NavTopCate> topCate;
	
	public static NavTree initFromJson(String json){
		try{
			return (NavTree)JsonUtil.jsonToBean(json, NavTree.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new NavTree();
	}
	public NavTree keepOneById(String topCateId){
		try{
			List<NavTopCate> list = new ArrayList<NavTopCate>();
			list.add(getTopCateById(topCateId));
			this.setCurTopCateId(topCateId);
			this.setTopCate(list);
		}catch(Exception e){
			e.printStackTrace();
		}
		return this;
	}
	public NavTopCate getTopCateById(String topCateId){
		NavTopCate curTopCate = null;
		try{
			Iterator<NavTopCate> it = topCate.iterator();
			while(it.hasNext()){
				curTopCate = (NavTopCate) it.next();
				if(curTopCate.getTopCateId().equals(topCateId)){
					return curTopCate;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return curTopCate;
	}
	public String getCurTopCateId() {
		return curTopCateId;
	}
	public void setCurTopCateId(String curTopCateId) {
		this.curTopCateId = curTopCateId;
	}
	public String getCurLeftCateId() {
		return curLeftCateId;
	}
	public void setCurLeftCateId(String curLeftCateId) {
		this.curLeftCateId = curLeftCateId;
	}
	public String getCurLeftNodeId() {
		return curLeftNodeId;
	}
	public void setCurLeftNodeId(String curLeftNodeId) {
		this.curLeftNodeId = curLeftNodeId;
	}
	public List<NavTopCate> getTopCate() {
		return topCate;
	}
	public void setTopCate(List<NavTopCate> topCate) {
		this.topCate = topCate;
	}	
}
