package com.rxoa.mypay.util;

public class StringUtil {
	public static boolean isDbNull(Object str){
		try{
			if(str==null||str.toString().toLowerCase().equals("null")||str.toString().trim().equals("")){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
    public static String initUpper(String str) {
        char[] ch = str.toCharArray();  
        if(ch[0] >= 'a' && ch[0] <= 'z'){  
            ch[0] = (char)(ch[0] - 32);  
        }
        return new String(ch);  
    }
    public static String readAsLine(String str){
    	String strRes = str;
    	try{
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return str;
    }
	public static String hidePhoneNo(String accno,String rep){
		try{
			if(StringUtil.isDbNull(accno)) return "";
			String pre =  accno.substring(0,3);
			String annx = accno.substring(accno.length()-4);
			String mx = "";
			for(int i=0;i<accno.length()-7;i++){
				mx+=rep;
			}
			return pre+mx+annx;
		}catch(Exception e){
			e.printStackTrace();
		}
		return accno;
	}
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
	public static String hideName(String name,String rep){
		if(!isDbNull(name)){
			return rep+name.substring(1);
		}
		return name;
	}
	public static String appendLeft(String src,String cr,int len){
		if(StringUtil.isDbNull(cr)) return null;
		while(src.length()<len){
			src=cr+src;
			if(src.length()>30) return null;
		}
		return src;
	}
	public static int d36toint(String d36){
		int res = 0;
		try{
			String mx = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			int ilen = d36.length()-1;
			for(int i=ilen;i>=0;i--){
				res += Math.pow(36, i)*mx.indexOf(d36.charAt(ilen-i));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	public static String inttod36(int value){
		try{
			String res = "";
			String mx = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			do{
				res = mx.charAt(value%36)+res;
				value = value/36;
			}while(value>36);
			if(value!=0){
				if(value==36){res = 1+res;}
				else{res = mx.charAt(value)+res;}
			}
			return res;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args){
		System.out.println(d36toint("X"));
		System.out.println(inttod36(37));
	}
}
