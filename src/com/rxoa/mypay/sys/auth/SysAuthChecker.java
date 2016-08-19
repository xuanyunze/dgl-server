package com.rxoa.mypay.sys.auth;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.rxoa.mypay.base.auth.AuthResultEnum;
import com.rxoa.mypay.base.config.BaseConfig;
import com.rxoa.mypay.base.util.JsonUtil;
import com.rxoa.mypay.db.query.HibQueryMgr;

public class SysAuthChecker {
	
	public static AuthResultEnum authCheck(HttpServletRequest req){
		try{
			AuthResultEnum islogin = SessionMgr.checkSession(req);
			if(!islogin.equals(AuthResultEnum.CHECK_SESSION_SUCCESS)){
				return islogin;
			}else{
				return AuthResultEnum.CHECK_SESSION_SUCCESS;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return AuthResultEnum.CHECK_SESSION_ERROR;
	}
	
	public static boolean doMethodAuthCheck(HttpServletRequest req,ModelAndView mv,String srcid,PrintWriter printWriter,String usetype,int resType){
		try{
			String userid = SessionMgr.getCurSession(req).getUserId();
			boolean auth = HibQueryMgr.getQueryContext().getResourceCheck(userid,srcid,usetype);
			if(!auth){
				if(resType==0){
					
				}else if(resType==1){
					mv.addObject("resCode","100");
					System.out.println("没有权限bb＝＝＝＝＝＝");
					mv.setViewName("redict:/page_no_auth");
					//response.sendRedirect("/page_on_auth");
					JsonUtil.print(mv.getModel(), printWriter);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean doMethodAuthCheck(HttpServletRequest req,ModelAndView mv,String srcid,HttpServletResponse response,String usetype,int resType){
		try{
			String userid = SessionMgr.getCurSession(req).getUserId();
			boolean auth = HibQueryMgr.getQueryContext().getResourceCheck(userid,srcid,usetype);
			if(!auth){
				if(resType==0){
					
				}else if(resType==1){
					//mv.addObject("resCode","100");
					System.out.println("没有权限xx＝＝＝＝＝＝");
					mv.setViewName("redict:/page_no_auth");
					//JsonUtil.print(mv.getModel(), response.getWriter());
					response.sendRedirect("/"+BaseConfig.getProperty("com.web.server.path")+"/page_on_auth");
				}
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
}
