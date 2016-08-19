package com.rxoa.mypay.sys.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rxoa.mypay.sys.service.AuthService;
import com.rxoa.mypay.sys.service.AuthService.AuthCode;
import com.rxoa.mypay.sys.vo.UserLoginVo;

@Controller
@RequestMapping("/auth")
public class AuthController {
	@Resource(name="authService")
	private AuthService authService;
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public ModelAndView getLoginPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/login");
		return mv;
	}
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String doUserLoginJsp(@ModelAttribute("mObject") UserLoginVo user,HttpServletRequest req,HttpSession session) {
		AuthCode code = authService.login(req,session, user);
		if(code.equals(AuthCode.LOGIN_SUCCESS)){
			return "redirect:../index";
		}
		return "redirect:login?errcode=1";
	}
	@RequestMapping(value="login.json",method=RequestMethod.POST)
	public ModelAndView doUserLoginJson() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index");
		return mv;
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String doUserLogoutJsp(HttpSession session) {
		AuthCode code = authService.logout(session);
		if(code.equals(AuthCode.LOGOUT_SUCCESS)){
			return "redirect:../index";
		}
		return "redirect:auth/logout";
	}
	@RequestMapping(value="/logout.json",method=RequestMethod.GET)
	public String doUserLogoutJson(HttpSession session) {
		AuthCode code = authService.logout(session);
		if(code.equals(AuthCode.LOGOUT_SUCCESS)){
			return "redirect:../index";
		}
		return "redirect:auth/logout";
	}
}
