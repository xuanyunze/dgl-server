package com.rxoa.mypay.util;

public class WebAvatorUtil {
	private static String[] ReceOrderStat = {};
	private static String[] TakeOrderStat = {"已受理|0","正在审核|1"};
	
	public static String v2t_ReceOrderStat(String value,int orient){
		return doTransfer(ReceOrderStat,value,orient);
	}
	public static String v2t_TakeOrderStat(String value,int orient){
		return doTransfer(TakeOrderStat,value,orient);
	}
	
	public static String doTransfer(String[] obj,String value,int orient){
		try{
			for(String con:obj){
				String[] iv = con.split("\\|");
				if(orient==1){
					if(iv[1].equals(value)){
						return iv[0];
					}
				}else if(orient==-1){
					if(iv[0].equals(value)){
						return iv[1];
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
