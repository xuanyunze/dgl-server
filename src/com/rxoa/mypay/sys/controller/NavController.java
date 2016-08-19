package com.rxoa.mypay.sys.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rxoa.mypay.base.BaseController;
import com.rxoa.mypay.base.util.JsonUtil;
import com.rxoa.mypay.sys.auth.SessionMgr;
import com.rxoa.mypay.sys.combx.NavTree;
import com.rxoa.mypay.sys.service.NavService;

@Controller
@RequestMapping("/nav")
public class NavController extends BaseController{
	@Resource(name="navService")
	private NavService navService;
	
	@RequestMapping(value="/navone.json/{cateid}",method=RequestMethod.GET)
	public void getNavLeftJson(HttpServletRequest req,@PathVariable String cateid,PrintWriter printWriter) {
		try{
			ModelAndView mv = new ModelAndView();
			String navjson = navService.getNavContent(SessionMgr.getCurSession(req).getUserId(),SessionMgr.getCurSession(req).getUserRoleid());
			NavTree navtree = NavTree.initFromJson(navjson).keepOneById(cateid);
			mv.addObject("navtree",navtree);
			JsonUtil.print(mv.getModel(), printWriter);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/navall.json",method=RequestMethod.GET)
	public void getNavAllJson(HttpServletRequest req,PrintWriter printWriter) {
		try{
			ModelAndView mv = new ModelAndView();
			String navjson = navService.getNavContent(SessionMgr.getCurSession(req).getUserId(),SessionMgr.getCurSession(req).getUserRoleid());//.replaceAll("\\s", "");
			NavTree navtree = NavTree.initFromJson(navjson);
			mv.addObject("navtree",navtree);
			JsonUtil.print(mv.getModel(), printWriter);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/navone",method=RequestMethod.GET)
	public ModelAndView getNavAllJsp() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/combx/navtree");
		return mv;
	}
}
