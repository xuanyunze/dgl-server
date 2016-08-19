package com.rxoa.mypay.sys.controller;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rxoa.mypay.base.auth.SessionPermission;
import com.rxoa.mypay.base.config.BaseConfig;
import com.rxoa.mypay.sys.auth.SysAuthChecker;
import com.rxoa.mypay.util.StringUtil;

@Controller
@RequestMapping("/image")
public class ImageController {
	
	@RequestMapping("/{usetype}/{imgtype}/{id}/{flowid}")
	@SessionPermission
	public void getSigImgage(HttpServletRequest req,HttpServletResponse response,
			@PathVariable String usetype,@PathVariable String imgtype,@PathVariable String id,@PathVariable String flowid) throws IOException {
		String filepath = "";
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"image_show", response, usetype, 1);
		if(imgtype.equals("sig")){
			String path = BaseConfig.getProperty("user.upload.sigimg_path");
			filepath = path+"/"+id+"/"+flowid+"_sig.jpg";
		}System.out.println(filepath);
		getImgage(response,filepath.trim());
	}
	
	@RequestMapping("/bankcard/{usetype}/{imgtype}/{id}/{cardnum}")
	@SessionPermission
	public void getBankcardImgage(HttpServletRequest req,HttpServletResponse response,
			@PathVariable String usetype,@PathVariable String imgtype,@PathVariable String id,@PathVariable String cardnum) throws IOException {
		String filepath = "";
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"image_show", response, usetype, 1);
			String path = BaseConfig.getProperty("user.upload.authimg_path");
			if(imgtype.equals("pos")){
				filepath = path+"/"+id+"/"+StringUtil.hideCardNo(cardnum,"")+"_pos.jpg";
			}else{
				filepath = path+"/"+id+"/"+StringUtil.hideCardNo(cardnum,"")+"_nav.jpg";
			}
		getImgage(response,filepath);
	}
	
	@RequestMapping("/{usetype}/{imgtype}/{id}")
	@SessionPermission
	public void getRealNameImgage(HttpServletRequest req,HttpServletResponse response,
			@PathVariable String usetype,@PathVariable String imgtype,@PathVariable String id) throws IOException {
		String filepath = "";
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"image_show", response, usetype, 1);
		if(imgtype.equals("pos")){
			String path = BaseConfig.getProperty("user.upload.authimg_path");
			filepath = path+"/"+id+"/realname_pos.jpg";
		}else if(imgtype.equals("nag")){
			String path = BaseConfig.getProperty("user.upload.authimg_path");
			filepath = path+"/"+id+"/realname_nage.jpg";
		}else if(imgtype.equals("self")){
			String path = BaseConfig.getProperty("user.upload.authimg_path");
			filepath = path+"/"+id+"/realname_self.jpg";
		}
		getImgage(response,filepath);
	}
	public void getImgage(HttpServletResponse response,String filepath) throws IOException {
		try {  
            //图片读取路径
			FileInputStream in=new FileInputStream(filepath);
			int i=in.available();  
			byte[]data=new byte[i];  
			in.read(data);  
			in.close();  
             
			//写图片  
			OutputStream outputStream=new BufferedOutputStream(response.getOutputStream());  
			outputStream.write(data);
			outputStream.flush();  
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
