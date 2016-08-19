package com.rxoa.mypay.sys.combx;

import com.rxoa.mypay.base.BaseEntity;

public class NavLeftNode extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String nodeId;
	private String nodeName;
	private String nodeHref;
	private String nodeWeight;
	
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getNodeHref() {
		return nodeHref;
	}
	public void setNodeHref(String nodeHref) {
		this.nodeHref = nodeHref;
	}
	public String getNodeWeight() {
		return nodeWeight;
	}
	public void setNodeWeight(String nodeWeight) {
		this.nodeWeight = nodeWeight;
	}
}