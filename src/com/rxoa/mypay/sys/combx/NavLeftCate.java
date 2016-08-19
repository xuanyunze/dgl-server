package com.rxoa.mypay.sys.combx;

import java.util.List;
import com.rxoa.mypay.base.BaseEntity;

public class NavLeftCate extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String cateId;
	private String cateName;
	private String cateWeight;
	private List<NavLeftNode> leftNode;
	
	public String getCateId() {
		return cateId;
	}
	public void setCateId(String cateId) {
		this.cateId = cateId;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public List<NavLeftNode> getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(List<NavLeftNode> leftNode) {
		this.leftNode = leftNode;
	}
	public String getCateWeight() {
		return cateWeight;
	}
	public void setCateWeight(String cateWeight) {
		this.cateWeight = cateWeight;
	}
}