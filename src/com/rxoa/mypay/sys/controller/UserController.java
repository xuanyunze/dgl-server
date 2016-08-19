package com.rxoa.mypay.sys.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rxoa.mypay.base.auth.SessionPermission;
import com.rxoa.mypay.base.security.PasswordMgr;
import com.rxoa.mypay.base.security.SessionEntity;
import com.rxoa.mypay.base.util.JsonUtil;
import com.rxoa.mypay.db.po.SysOrg;
import com.rxoa.mypay.db.po.SysUser;
import com.rxoa.mypay.db.service.in.ISysOrgService;
import com.rxoa.mypay.db.service.in.ISysUserService;
import com.rxoa.mypay.sys.auth.SessionMgr;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name="sysUserService")
	private ISysUserService uService;
	@Resource(name="sysOrgService")
	private ISysOrgService oService;
	
	@RequestMapping("/showinfo/{usetype}")
	@SessionPermission
	public ModelAndView showUserInfo(HttpServletRequest req,HttpServletResponse resp){
		ModelAndView mv = new ModelAndView();
		try{
			SessionEntity session = SessionMgr.getCurSession(req);
			SysUser user = uService.findOneByCondition(" and uid='"+session.getUserId()+"'");
			SysOrg org = oService.findOneByCondition(" and oid='"+session.getOrgId()+"'");
			mv.addObject("mOrg",org);
			mv.addObject("mUser",user);
			mv.setViewName("usermgr/user_selfinfo_show");
		}catch(Exception e){
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping("/chgpwd/page/{usetype}")
	@SessionPermission
	public ModelAndView changePwd(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("action","page");
		mv.setViewName("usermgr/user_chgpwd_page");
		return mv;
	}
	@RequestMapping("/chgpwd/save/{usetype}")
	@SessionPermission
	public void doChangePwd(HttpServletRequest req,String oldpwd,String newpwd,String renewpwd,PrintWriter printWriter){
		int result = 1;
		ModelAndView mv = new ModelAndView();
		try{
			if(oldpwd.equals("")||newpwd.equals("")||!newpwd.equals(renewpwd)){
				result = 2;
			}else{
				String encpwd = PasswordMgr.encrypt(SessionMgr.getCurSession(req).getUserId(), oldpwd);
				SysUser user = uService.findOneByCondition(" and uid='"+SessionMgr.getCurSession(req).getUserId()+"' and upwd='"+encpwd+"'");
				if(user==null){
					result=3;
				}else{
					encpwd = PasswordMgr.encrypt(SessionMgr.getCurSession(req).getUserId(), newpwd);
					user.setUpwd(encpwd);
					uService.update(user);
					result = 0;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		mv.addObject("result",result);
		JsonUtil.print(mv.getModel(), printWriter);
	}
}
