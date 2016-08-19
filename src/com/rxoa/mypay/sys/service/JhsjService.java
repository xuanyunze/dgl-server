package com.rxoa.mypay.sys.service;

import java.net.URLEncoder;
import java.util.Date;

import org.codehaus.jackson.JsonNode;

import com.rxoa.mypay.base.config.BaseConfig;
import com.rxoa.mypay.base.util.JsonUtil;
import com.rxoa.mypay.util.DateUtil;
import com.rxoa.mypay.util.HttpUtil;
import com.rxoa.mypay.util.StringUtil;

public class JhsjService {
	
	public static String doRealnameCetify(String name,String idcardno){
		String resString = "[验证失败～][原因：未知～]";
		try{
			String baseurl = "http://op.juhe.cn/idcard/query?key="+BaseConfig.getProperty("sys.certify.jhkey.realname")+"&idcard="+idcardno+"&realname="+URLEncoder.encode(name,"utf-8");
			String res = HttpUtil.doPOST(baseurl, null);
			if(!StringUtil.isDbNull(res)){
				JsonNode jnode = JsonUtil.getJsonNode(res);
				int rescode = Integer.parseInt(jnode.get("error_code").toString());
				if(rescode==0){
					JsonNode jres = jnode.get("result");
					int ires = Integer.parseInt(jres.get("res").toString());
					if(ires==1){
						resString = "[验证通过～]";
					}else{
						resString = "[验证失败~][二元素信息不匹配~]";
					}
				}else{
					resString = "[验证失败~]["+jnode.get("reason").toString().replaceAll("\"", "")+"~]";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "["+DateUtil.getFullDateTime(new Date())+"]"+resString;
	}
	public static String doBankcardCertify(String name,String idcardno,String bankcardno){
		String resString = "[验证失败～][原因：未知～]";
		try{
			String baseurl = "http://v.juhe.cn/verifybankcard3/query?key="+BaseConfig.getProperty("sys.certify.jhkey.bankcard3")+"&realname="+URLEncoder.encode(name,"utf-8")+"&bankcard="+bankcardno+"&idcard="+idcardno;
			String res = HttpUtil.doPOST(baseurl, null);
			if(!StringUtil.isDbNull(res)){
				JsonNode jnode = JsonUtil.getJsonNode(res);
				int rescode = Integer.parseInt(jnode.get("error_code").toString());
				if(rescode==0){
					JsonNode jres = jnode.get("result");
					int ires = Integer.parseInt(jres.get("res").toString());
					if(ires==1){
						resString = "[验证通过～]";
					}else{
						resString = "[验证失败~][三元素信息不匹配~]";
					}
				}else{
					resString = "[验证失败~]["+jnode.get("reason").toString().replaceAll("\"", "")+"~]";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "["+DateUtil.getFullDateTime(new Date())+"]"+resString;
	}
	public static void main(String[] args){
		
	}
}
