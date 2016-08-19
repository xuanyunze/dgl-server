package com.rxoa.mypay.db.controller;

import java.util.List;
import java.util.Map;
import java.util.Date;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rxoa.mypay.util.CodeUtil;
import com.rxoa.mypay.sys.auth.SessionMgr;
import com.rxoa.mypay.base.auth.SessionPermission;
import com.rxoa.mypay.base.security.PasswordMgr;
import com.rxoa.mypay.base.security.SessionEntity;
import com.rxoa.mypay.base.util.JsonUtil;
import com.rxoa.mypay.base.view.PageView;
import com.rxoa.mypay.base.view.PageWeb;
import com.rxoa.mypay.base.view.PageStyle;
import com.rxoa.mypay.db.service.in.ISysOrgService;
import com.rxoa.mypay.db.service.in.ISysUserService;
import com.rxoa.mypay.db.po.SysOrg;
import com.rxoa.mypay.db.po.SysUser;
import com.rxoa.mypay.db.query.HibQueryMgr;

/**
 * sys_user Controller控制器类
 * Wed Mar 11 15:11:52 CST 2015 baiyu
 */ 

@Controller
@RequestMapping("/dbmgr/sysuser")
public class SysUserController {
	private String basedir = "dbmgr";
	@Resource(name="sysUserService")
	private ISysUserService mService;
	@Resource(name="sysOrgService")
	private ISysOrgService sysOrgService;
	
	@RequestMapping(value="/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_user_page", printWriter, usetype, 1);
		getPage(mv,null,curpage,psize,printWriter,usetype,0);
		return mv;
	}

	@RequestMapping(value="/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_user_page", printWriter, usetype, 1);
		getPageData(req,mv,web,curpage,psize,printWriter,usetype,1);
	}

	@RequestMapping(value="/search/{usetype}",method=RequestMethod.GET)
	@SessionPermission
	public void getSearchJsp(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_user_search", printWriter, usetype, 1);
		getSearch(mv,printWriter,usetype,0);
	}

	@RequestMapping(value="/search.json/{usetype}",method=RequestMethod.POST)
	@SessionPermission
	public void getSearchJson(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_user_search", printWriter, usetype, 1);
		doSearch(mv,printWriter,usetype,1);
	}

	@RequestMapping(value="/add/{usetype}/{orgid}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getNewJsp(HttpServletRequest req,@PathVariable String orgid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_user_add", printWriter, usetype, 1);
		getCreate(mv,orgid,printWriter,usetype,0);
		return mv;
	}

	@RequestMapping(value="/add.json/{usetype}/{orgid}",method=RequestMethod.GET)
	@SessionPermission
	public void getAddJson(HttpServletRequest req,@PathVariable String orgid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_user_add", printWriter, usetype, 1);
		getCreate(mv,orgid,printWriter,usetype,1);
	}

	@RequestMapping(value="/save.json/{usetype}",method=RequestMethod.POST)
	@SessionPermission
	public void execSaveJson(HttpServletRequest req,@ModelAttribute("mObject") SysUser mObject,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_user_save", printWriter, usetype, 1);
		doSave(mv,mObject,printWriter,usetype,1);
	}

	@RequestMapping(value="/del.json/{usetype}/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public void execDelJson(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_user_del", printWriter, usetype, 1);
		doDelete(mv,unid,printWriter,usetype,0);
	}

	@RequestMapping(value="/edit/{usetype}/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getEditJsp(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_user_edit", printWriter, usetype, 1);
		getEdit(mv,unid,null,usetype,0);
		return mv;
	}

	@RequestMapping(value="/edit.json/{usetype}/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public void getEditJson(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_user_update", printWriter, usetype, 1);
		getEdit(mv,unid,printWriter,usetype,1);
	}

	@RequestMapping(value="/update.json/{usetype}/{unid}",method=RequestMethod.POST)
	@SessionPermission
	public void execUpdateJson(HttpServletRequest req,@ModelAttribute("mObject") SysUser mObject,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_user_update", printWriter, usetype, 1);
		doUpdate(mv,mObject,unid,printWriter,usetype,1);
	}
	
	@RequestMapping(value="/resetpwd.json/{usetype}/{unid}",method=RequestMethod.POST)
	@SessionPermission
	public void execResetpwdJson(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		int result = 1;
		try{
			SysUser user = mService.findOne(unid);
			if(user.getUorgid().length()>4&&user.getUorgid().substring(0,4).equals("1011")){
				String encpwd = PasswordMgr.encrypt(user.getUid(), "123456");
				user.setUpwd(encpwd);
				mService.update(user);
				result = 0;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		mv.addObject("result",result);
		JsonUtil.print(mv.getModel(), printWriter);
	}
	@RequestMapping(value="/show/{usetype}/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getShowJsp(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_user_show", printWriter, usetype, 1);
		showDetail(mv,unid,printWriter,usetype,0);
		return mv;
	}

	@RequestMapping(value="/show.json/{usetype}/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public void getShowJson(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_user_show", printWriter, usetype, 1);
		showDetail(mv,unid,printWriter,usetype,1);
	}

	//============METHOD==============//
	public void getSearch(ModelAndView mv,PrintWriter printWriter,String useType,int resType){
		if(resType==0){
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}

	public void doSearch(ModelAndView mv,PrintWriter printWriter,String useType,int resType){
		if(resType==0){
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}

	public void getPage(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		if(resType==0){
			mv.setViewName(basedir+"/sys_user_page");
		}else if(resType==1){
		}
	}

	public void getPageData(HttpServletRequest req,ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		PageView mpage = mService.findPage(web.prepare());
		SessionEntity session = SessionMgr.getCurSession(req);
		String curorg = web.getCateString().substring(web.getCateString().indexOf("'")+1,web.getCateString().lastIndexOf("'"));
		if(session.getUserType().equals("1")){
			mpage.setBtnNew(true);
			mpage.setBtnCheckbox(true);
			mpage.setBtnItemEdit(true);
			mpage.setBtnItemDel(true);
			mpage.setBtnItemShow(true);
		}else if(session.getUserType().equals("2")||session.getUserType().equals("3")){
			String subs = HibQueryMgr.getQueryContext().getSubOrgs(session.getOrgId(), false);
			if(subs!=null){
				subs = ","+session.getOrgId()+","+subs+",";
				if(subs.indexOf(","+curorg+",")!=-1){
					mpage.setBtnNew(true);
					mpage.setBtnCheckbox(true);
					mpage.setBtnItemEdit(true);
					mpage.setBtnItemDel(true);
					mpage.setBtnItemShow(true);
				}
			}
		}
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.SysUser");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		if(resType==0){
			String json = JsonUtil.genObjJson(mv.getModel());
			mv.clear();
			mv.addObject("mObject", json);
			mv.setViewName(basedir+"/sys_user_page");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}

	public void getCreate(ModelAndView mv,String targetorg,PrintWriter printWriter,String useType,int resType){
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.SysUser");
		SysOrg org = sysOrgService.findOneByCondition(" and oid = '"+targetorg+"'");
		mv.addObject("subpath","sysuser");
		mv.addObject("targetoid",targetorg);
		mv.addObject("targetotype",org.getOtype());
		mv.addObject("targetoname",org.getOname());
		mv.addObject("varObject",varObject);
		if(resType==0){
			mv.setViewName(basedir+"/sys_user_add");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}

	public void doSave(ModelAndView mv,SysUser mObject,PrintWriter printWriter,String useType,int resType){
		SysUser user = mService.findOneByCondition(" and uid='"+mObject.getUid()+"'");
		int result = 1;
		if(user==null){
			mObject.setCreTime(new Date());
			String encpwd = PasswordMgr.encrypt(mObject.getUid(), mObject.getUpwd());
			mObject.setUpwd(encpwd);
			mObject.setUroleid(mObject.getUroleid());
			boolean v = mService.create(mObject);
			if(v){
				result = 0;
			}
		}else{
			result = 2;
		}
		mv.addObject("result",result);
		if(resType==0){
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}

	public void doDelete(ModelAndView mv,String unid,PrintWriter printWriter,String useType,int resType){
		boolean result = mService.deleteById(unid);
		mv.addObject("result",result);
		if(resType==0){
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}

	public void getEdit(ModelAndView mv,String unid,PrintWriter printWriter,String useType,int resType){
		SysUser mObject = mService.findOne(unid);
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.SysUser");
		SysOrg org = sysOrgService.findOneByCondition(" and oid = '"+mObject.getUorgid()+"'");
		mv.addObject("subpath","sysuser");
		mv.addObject("targetotype",org.getOtype());
		mv.addObject("targetoname",org.getOname());
		mv.addObject("varObject",varObject);
		mv.addObject("mObject", mObject);
		if(resType==0){
			mv.setViewName(basedir+"/sys_user_edit");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}

	public void doUpdate(ModelAndView mv,SysUser mObject,String unid,PrintWriter printWriter,String useType,int resType){
		int result = 1;
		try{
			SysUser user = mService.findOne(unid);
			user.setUname(mObject.getUname());
			user.setUmail(mObject.getUmail());
			user.setUphone(mObject.getUphone());
			user.setUtelephone(mObject.getUtelephone());
			user.setUroleid(mObject.getUroleid());
			user.setUposition(mObject.getUposition());
			mService.update(user);
			result = 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		mv.addObject("result",result);
		if(resType==0){
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}

	public void showDetail(ModelAndView mv,String unid,PrintWriter printWriter,String useType,int resType){
		SysUser mObject = mService.findOne(unid);
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.SysUser");
		SysOrg org = sysOrgService.findOneByCondition(" and oid = '"+mObject.getUorgid()+"'");
		mv.addObject("targetotype",org.getOtype());
		mv.addObject("targetoname",org.getOname());
		mv.addObject("varObject",varObject);
		mv.addObject("mObject", mObject);
		if(resType==0){
			mv.setViewName(basedir+"/sys_user_show");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}

}

