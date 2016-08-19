package com.rxoa.mypay.sys.util;

public class DataUtil {
	public static boolean isLogicNull(String data){
		if(data==null||data.equals(null)||data.equals("null")||data.trim().equals("")){
			return true;
		}
		return false;
	}
	public static boolean isNotLogicNull(String data){
		return !isLogicNull(data);
	}
}
