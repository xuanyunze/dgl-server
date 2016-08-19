package com.rxoa.mypay.sys.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rxoa.mypay.base.security.WebSessionEntity;
import com.rxoa.mypay.base.util.JsonUtil;
import com.rxoa.mypay.sys.service.WebSessionService;

@Controller
@RequestMapping("/websession")
public class WebSessionController {
	@Resource(name="webSessionService")
	private WebSessionService webSessionService;
	
	@RequestMapping(value="/session.json",method=RequestMethod.GET)
	public void getSessionJson(HttpServletRequest req,PrintWriter printWriter) {
		try{
			ModelAndView mv = new ModelAndView();
			WebSessionEntity websession = webSessionService.getWebSession(req);
			mv.addObject("mObject",websession);
			JsonUtil.print(mv.getModel(), printWriter);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/session.json/{userid}",method=RequestMethod.GET)
	public void getSessionByUserJson(@PathVariable String userid,HttpServletRequest req,PrintWriter printWriter) {
		try{
			ModelAndView mv = new ModelAndView();
			WebSessionEntity websession = webSessionService.getWebSession(req);
			mv.addObject("mObject",websession);
			JsonUtil.print(mv.getModel(), printWriter);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
