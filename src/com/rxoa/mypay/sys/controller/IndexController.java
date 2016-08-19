package com.rxoa.mypay.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rxoa.mypay.base.auth.SessionPermission;
import com.rxoa.mypay.base.security.DataValidator;
import com.rxoa.mypay.base.security.WebSessionEntity;
import com.rxoa.mypay.base.util.JsonUtil;
import com.rxoa.mypay.sys.auth.SessionMgr;

@Controller
@RequestMapping("/")
public class IndexController{
	@RequestMapping(value="/index",method=RequestMethod.GET)
	@SessionPermission
	@DataValidator(value="good",clear=false)
	public ModelAndView getIndex(HttpServletRequest req,HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		WebSessionEntity websesison = SessionMgr.getWebSession(req);
		mv.addObject("sessionInfo",websesison);
		String json = JsonUtil.genObjJson(mv.getModel());
		mv.clear();
		mv.addObject("mObject", json);
		mv.setViewName("/index");
		return mv;
	}
	@RequestMapping(value="",method=RequestMethod.GET)
	@SessionPermission
	@DataValidator(value="good",clear=false)
	public ModelAndView getIndexDefault(HttpServletRequest req,HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		WebSessionEntity websesison = SessionMgr.getWebSession(req);
		mv.addObject("sessionInfo",websesison);
		String json = JsonUtil.genObjJson(mv.getModel());
		mv.clear();
		mv.addObject("mObject", json);
		mv.setViewName("/index");
		return mv;
	}
	@RequestMapping(value="/index/mainpage",method=RequestMethod.GET)
	@SessionPermission
	@DataValidator(value="good",clear=false)
	public ModelAndView getMainpage(HttpServletRequest req,HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		WebSessionEntity websesison = SessionMgr.getWebSession(req);
		mv.addObject("sessionInfo",websesison);
		String json = JsonUtil.genObjJson(mv.getModel());
		mv.clear();
		mv.addObject("mObject", json);
		mv.setViewName("/mainpage");
		return mv;
	}
}
