package com.rxoa.mypay.sys.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rxoa.mypay.base.auth.SessionPermission;
import com.rxoa.mypay.base.util.JsonUtil;
import com.rxoa.mypay.sys.service.AuthService;
import com.rxoa.mypay.sys.service.JhsjService;
import com.rxoa.mypay.util.StringUtil;

@Controller
@RequestMapping("/certify")
public class CertifyController {
	@Resource(name="authService")
	private AuthService authService;
	
	@RequestMapping(value="/realname/json/{usetype}",method=RequestMethod.POST)
	@SessionPermission
	public void doRealNameCertify(HttpServletRequest req,@ModelAttribute("uname") String uname,@ModelAttribute("uidcard") String idcardno,
			@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		String res = "ERROR_NOAUTH";
		if(authService.isManageOrg(req)){
			if(StringUtil.isDbNull(uname)||StringUtil.isDbNull(idcardno)){
				res = "ERROR_WRONG_AUGUMENT";
			}else{
				res = JhsjService.doRealnameCetify(uname, idcardno);
			}
		}
		mv.addObject("res",res);
		JsonUtil.print(mv.getModel(), printWriter);
	}
	@RequestMapping(value="/bankcard3/json/{usetype}",method=RequestMethod.POST)
	@SessionPermission
	public void doBankcardCertify(HttpServletRequest req,@ModelAttribute("uname") String uname,@ModelAttribute("uidcard") String idcardno,
			@ModelAttribute("cardno") String cardno,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		String res = "ERROR_NOAUTH";
		if(authService.isManageOrg(req)){
			if(StringUtil.isDbNull(uname)||StringUtil.isDbNull(idcardno)){
				res = "ERROR_WRONG_AUGUMENT";
			}else{
				res = JhsjService.doBankcardCertify(uname, idcardno,cardno);
			}
		}
		mv.addObject("res",res);
		JsonUtil.print(mv.getModel(), printWriter);
	}
}
