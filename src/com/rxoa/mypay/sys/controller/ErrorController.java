package com.rxoa.mypay.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("*")
public class ErrorController {
	@RequestMapping("")
	public ModelAndView goto404Page(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/page_not_found");
		return mv;
	}
}
