package com.rxoa.mypay.util;

public class IDString {
	private String id;
	public IDString(String id){this.id = id;}
	public IDString(){this.id="";};
	
	public String getIDString(){
		return this.id;
	}
	public IDString prefixTolen(String pre,int len){
		while(id.length()<len){
			id = pre+id;
		}
		return this;
	}
	public IDString suffixTolen(String suf,int len){
		while(id.length()<len){
			id = id+suf;
		}
		return this;
	}
}
