package com.rxoa.mypay.sys.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.codehaus.jackson.JsonNode;
import org.springframework.stereotype.Service;

import com.rxoa.mypay.base.util.JsonUtil;
import com.rxoa.mypay.util.StringUtil;

@Service("certifyService")
public class CertifyService {
	private String cardauth_url = "http://reagw.reapal.com/reagw/bankcard/cardAuth.htm";
	private String nameauth_url = "https://trust.reapal.com/reagw/agreement/auth.htm";
	private String oid = "100000000229664";
	private String key = "d7538004dgcf6a11ab4b7aec42309f7ac9745143e55g9d76gfc9gb9dcc49158b";
	
	public String doCertify(String name,String id){
        String applyTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
        String content="{\"userName\":\""+name+"\",\"userIdentity\":\""+id+"\",\"applyTime\":\""+applyTime+"\"}";
        return doRealCertify(content,"reapal.trust.realNameAuth",nameauth_url);
	}
	public String doCertify(String name,String id,String cardno){
        String applyTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
        String content = "{\"userName\":\""+name+"\",\"certType\":\"01\",\"userIdentity\":\""+id+"\",\"cardNo\":\""+cardno+"\",\"applyTime\":\""+applyTime+"\"}";
        return doRealCertify(content,"reapal.trust.cardDebitAuth",cardauth_url);
	}
	public String doCertify(String name,String id,String phone,String cardno){
        String applyTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
        String content = "{\"userName\":\""+name+"\",\"certType\":\"01\",\"userIdentity\":\""+id+"\",\"userMobile\":\""+phone+"\",\"cardNo\":\""+cardno+"\",\"applyTime\":\""+applyTime+"\"}";
        return doRealCertify(content,"reapal.trust.cardDebitAuth",cardauth_url);
	}
	private String doRealCertify(String content,String taskName,String url){
		String res = "99|HTTP请求错误～";
		try{
	        /**
	         * 二要素   实名认证（姓名，身份证号）：content="{\"userName\":\"小明\",\"userIdentity\":\"410725199203122027\",\"applyTime\":\""+applyTime+"\"}";
	         * 三要素  （姓名，身份证号，卡号）：content = "{\"userName\":\"小明\",\"certType\":\"01\",\"userIdentity\":\"410725199203122027\",\"cardNo\":\"6226220118830589\",\"applyTime\":\""+applyTime+"\"}";
	         * 四要素  （姓名，身份证号，手机号，卡号）：content = "{\"userName\":\"小明\",\"certType\":\"01\",\"userIdentity\":\"410725199203122027\",\"userMobile\":\"13552550781\",\"cardNo\":\"6226220118830589\",\"applyTime\":\""+applyTime+"\"}";
	         */
	        //生成签名
	        String sign = sign(content, key, "UTF-8");

	        //拼接请求字符串
	        Map<String,Object> map = new HashMap<String,Object>();
	        map.put("version", "1.0");                              //接口版本
	        map.put("service", "reapal.trust.cardDebitAuth");       //接口名称
	        map.put("partner", oid);                                //合作伙伴ID
	        map.put("signType", "0");                               //签名类型 MD5：0
	        map.put("sign", sign);
	        map.put("reqData",content);
	        StringBuilder sb = new StringBuilder();
	        for(String string : map.keySet()){
	            sb.append(string);
	            sb.append("=");
	            sb.append(map.get(string));
	            sb.append("&");
	        }
	        sb.deleteCharAt(sb.lastIndexOf("&"));   //删除字符串最后的“&”

	        System.out.println("请求参数：" + sb.toString());
	        String responseString = sendAndRecv(url,sb.toString(),"UTF-8");
	        System.out.println("响应参数：" + responseString);
	        
	        //解析返回字符串:根据返回的字符串是否包含result，判断不同的解析方式
	        if(responseString.indexOf("result")>0){
	            String [] respArray = responseString.split("&");
	    		Map<String,String> respMap = new HashMap<String,String>();
	    		for(int i = 0; i < respArray.length;i ++){
	    			respMap.put(respArray[i].split("=")[0], respArray[i].split("=")[1]);
	    		}
	    		String respData = respMap.get("resData").trim();
	            String sign1 = sign(respData, key, "UTF-8");
	           	if(!sign1.equals(respMap.get("sign"))){
	           		return "30|响应签名信息不正确~";
	           	}
	           	JsonNode jnode = JsonUtil.getJsonNode(respData);
	           	String jres = jnode.get("result").toString().trim().replaceAll("\"", "");
		        if(jres.equals("0")){
		           	return "0|鉴权成功~";
		        }else{
		           	return "1|"+jnode.get("resultMsg").toString().replaceAll("\"", "");
		        }
	        }else{
	           	JsonNode jnode = JsonUtil.getJsonNode(responseString);
	           	return jnode.get("errorCode").toString().replaceAll("\"", "")+"|"+jnode.get("errorMsg").toString().replaceAll("\"", "");
	        }
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	
	private String sendAndRecv(String sendURL, String reqStr,String charset) {
		String result = "";
	    BufferedInputStream in = null;
	    BufferedOutputStream out = null;
	    try {
	            URL url = new URL(sendURL);
	            HttpURLConnection con =(HttpURLConnection) url.openConnection();
				con.setConnectTimeout(15000);
	            con.setRequestProperty("ContentType","text/xml");
	            con.setRequestProperty("charset", "UTF-8");
	            con.setUseCaches(false);
	            con.setDoInput(true);
	            con.setDoOutput(true);
	            con.setRequestMethod("POST");

	            out = new BufferedOutputStream(con.getOutputStream());
	            byte outBuf[] = reqStr.getBytes("UTF-8");
	            out.write(outBuf);
	            out.close();
	            in = new BufferedInputStream(con.getInputStream());

	            InputStreamReader in1= new InputStreamReader(con.getInputStream(), charset);
	            //用于获取资源文件类容
	            int n;
	            String res = "";
	            while((n=in1.read())!=-1)
	            {
	                char c=(char)n;
	                res += c;
	            }
	            result =res;
	    } catch (Exception ex) {
	            ex.printStackTrace();
	    } finally {
	            if (out != null) {
	                try {
	                    out.close();
	                } catch (IOException e) {
	                }
	            }
	            if (in != null) {
	                try {
	                    in.close();
	                } catch (IOException e) {
	                }
	            }
	    }
	    return result;
	}
	private String sign(String content, String key, String charset) throws Exception {
		String signData = content + key;
	    return DigestUtils.md5Hex(signData.getBytes(charset));
	}
	
	public static void main(String[] args){
		CertifyService service = new CertifyService();
		String m = service.doCertify("李艳丰","110105198312255328","13701298039","6226019920442188");
		System.out.println(m);
	}
}
