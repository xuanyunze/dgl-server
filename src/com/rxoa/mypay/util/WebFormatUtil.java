package com.rxoa.mypay.util;


public class WebFormatUtil {
	public static String hideCardNo(String accno,String rep){
		try{
			if(StringUtil.isDbNull(accno)) return "";
			String pre =  accno.substring(0,6);
			String annx = accno.substring(accno.length()-4);
			String mx = "";
			for(int i=0;i<accno.length()-10;i++){
				mx+=rep;
			}
			return pre+mx+annx;
		}catch(Exception e){
			e.printStackTrace();
		}
		return accno;
	}
	public static String getTrantype(String tran){
		if(tran.equals("1")){return "普通收款";}
		if(tran.equals("2")){return "用户提现";}
		if(tran.equals("8")){return "零手续费";}
		if(tran.equals("9")){return "普通收款";}
		if(tran.equals("10")){return "快速收款";}
		if(tran.equals("11")){return "快速收款S0";}
		return "";
	}
	public static String getBlooean(String value,String[] values,String[] texts){
		for(int i=0;i<values.length;i++){
			if(value.equals(values[i])){
				return texts[i];
			}
		}
		return "";
	}
	public static String replaceNull(String value){
		if(StringUtil.isDbNull(value)){return "";}
		return value;
	}
}
