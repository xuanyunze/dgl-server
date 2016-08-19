package com.rxoa.mypay.sys.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rxoa.mypay.base.auth.SessionPermission;

@Controller
@RequestMapping("/sysmgr")
public class SysmgrController {
	
	@RequestMapping(value="/statusshow/{usetype}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getPageJsp(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_user_page", printWriter, usetype, 1);
		mv.setViewName("sysmgr/statusshow");
		return mv;
	}
}
