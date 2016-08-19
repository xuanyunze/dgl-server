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
import com.rxoa.mypay.sys.auth.SysAuthChecker;
import com.rxoa.mypay.base.auth.SessionPermission;
import com.rxoa.mypay.base.security.SessionEntity;
import com.rxoa.mypay.base.util.JsonUtil;
import com.rxoa.mypay.base.view.PageView;
import com.rxoa.mypay.base.view.PageWeb;
import com.rxoa.mypay.base.view.PageStyle;
import com.rxoa.mypay.db.service.in.IMbilDeviceService;
import com.rxoa.mypay.db.service.in.ISysOrgService;
import com.rxoa.mypay.db.po.MbilActiveCode;
import com.rxoa.mypay.db.po.MbilDevice;
import com.rxoa.mypay.db.po.SysOrg;

/**
 * mbil_device Controller控制器类
 * Wed May 27 18:48:28 CST 2015 baiyu
 */ 

@Controller
@RequestMapping("/dbmgr/mbildevice")
public class MbilDeviceController {
	private String basedir = "dbmgr";
	@Resource(name="mbilDeviceService")
	private IMbilDeviceService mService;
	@Resource(name="sysOrgService")
	private ISysOrgService oService;
	
	@RequestMapping(value="/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_device_page", printWriter, usetype, 1);
		getPage(mv,null,curpage,psize,printWriter,usetype,0);
		return mv;
	}

	@RequestMapping(value="/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_device_page", printWriter, usetype, 1);
		getPageData(req,mv,web,curpage,psize,printWriter,usetype,1);
	}

	@RequestMapping(value="/search/{usetype}",method=RequestMethod.GET)
	@SessionPermission
	public void getSearchJsp(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_device_search", printWriter, usetype, 1);
		getSearch(mv,printWriter,usetype,0);
	}

	@RequestMapping(value="/search.json/{usetype}",method=RequestMethod.POST)
	@SessionPermission
	public void getSearchJson(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_device_search", printWriter, usetype, 1);
		doSearch(mv,printWriter,usetype,1);
	}

	@RequestMapping(value="/add/{usetype}/{orgid}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getNewJsp(HttpServletRequest req,@PathVariable String orgid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_device_add", printWriter, usetype, 1);
		getCreate(mv,orgid,printWriter,usetype,0);
		return mv;
	}

	@RequestMapping(value="/add.json/{usetype}/{orgid}",method=RequestMethod.GET)
	@SessionPermission
	public void getAddJson(HttpServletRequest req,@PathVariable String orgid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_device_add", printWriter, usetype, 1);
		getCreate(mv,orgid,printWriter,usetype,1);
	}

	@RequestMapping(value="/save.json/{usetype}",method=RequestMethod.POST)
	@SessionPermission
	public void execSaveJson(HttpServletRequest req,@ModelAttribute("mObject") MbilDevice mObject,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_device_save", printWriter, usetype, 1);
		doSave(mv,mObject,printWriter,usetype,1);
	}

	@RequestMapping(value="/del.json/{usetype}/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public void execDelJson(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_device_del", printWriter, usetype, 1);
		doDelete(mv,unid,printWriter,usetype,0);
	}

	@RequestMapping(value="/edit/{usetype}/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getEditJsp(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_device_edit", printWriter, usetype, 1);
		getEdit(mv,unid,null,usetype,0);
		return mv;
	}

	@RequestMapping(value="/edit.json/{usetype}/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public void getEditJson(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_device_update", printWriter, usetype, 1);
		getEdit(mv,unid,printWriter,usetype,1);
	}

	@RequestMapping(value="/update.json/{usetype}/{unid}",method=RequestMethod.POST)
	@SessionPermission
	public void execUpdateJson(HttpServletRequest req,@ModelAttribute("mObject") MbilDevice mObject,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_device_update", printWriter, usetype, 1);
		doUpdate(mv,mObject,unid,printWriter,usetype,1);
	}
	@RequestMapping(value="/show/{usetype}/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getShowJsp(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_device_show", printWriter, usetype, 1);
		showDetail(mv,unid,printWriter,usetype,0);
		return mv;
	}

	@RequestMapping(value="/show.json/{usetype}/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public void getShowJson(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_device_show", printWriter, usetype, 1);
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
			mv.setViewName(basedir+"/mbil_device_page");
		}else if(resType==1){
		}
	}

	public void getPageData(HttpServletRequest req,ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		SessionEntity session = SessionMgr.getCurSession(req);
		PageView mpage = mService.findPage(web.prepare());
		String curorg = web.getCateString().substring(web.getCateString().indexOf("'")+1,web.getCateString().lastIndexOf("'"));
		if(session.getUserType().equals("2")||session.getUserType().equals("3")){
			System.out.println(curorg);
			System.out.println(session.getOrgId());
			System.out.println(session.getVorgId());
			System.out.println(session.getTopOrgId());
			if(session.getOrgId().equals(curorg)){
				mpage.setBtnCheckbox(true);
				mpage.setBtnItemEdit(true);
				mpage.setBtnItemShow(true);
			}
		}else if(session.getUserType().equals("1")&&session.getOrgId().length()<6){
			mpage.setBtnNew(true);
			mpage.setBtnCheckbox(true);
			mpage.setBtnItemEdit(true);
			mpage.setBtnItemShow(true);
			mpage.setBtnItemDel(true);
		}else if(session.getUserType().equals("1")){
			mpage.setBtnNew(true);
			mpage.setBtnCheckbox(true);
			mpage.setBtnItemEdit(true);
			mpage.setBtnItemShow(true);
		}
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilDevice");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		if(resType==0){
			String json = JsonUtil.genObjJson(mv.getModel());
			mv.clear();
			mv.addObject("mObject", json);
			mv.setViewName(basedir+"/mbil_device_page");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}

	public void getCreate(ModelAndView mv,String targetorg,PrintWriter printWriter,String useType,int resType){
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilDevice");
		SysOrg org = oService.findOneByCondition(" and oid = '"+targetorg+"'");
		mv.addObject("targetoid",targetorg);
		mv.addObject("targetoname",org.getOname());
		mv.addObject("subpath","mbildevice");
		mv.addObject("varObject",varObject);
		if(resType==0){
			mv.setViewName(basedir+"/mbil_device_add");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}

	public void doSave(ModelAndView mv,MbilDevice mObject,PrintWriter printWriter,String useType,int resType){
		String mResult = "1";
		MbilDevice device = mService.findOneByCondition(" and deSn='"+mObject.getDeSn()+"'");
		if(device==null){
			String tid = genDeviceTid();
			if(tid!=null){
				mObject.setCreTime(new Date());
				mObject.setDeTid(tid);
				mObject.setDeStat("1");
				boolean result = mService.create(mObject);
				if(result){
					mResult="0";
				}
			}else{
				mResult = "3";
			}
		}else{
			mResult = "2";
		}
		mv.addObject("result",mResult);
		JsonUtil.print(mv.getModel(), printWriter);
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
		MbilDevice mObject = mService.findOne(unid);
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilDevice");
		mv.addObject("subpath","mbildevice");
		mv.addObject("varObject",varObject);
		mv.addObject("mObject", mObject);
		if(resType==0){
			mv.setViewName(basedir+"/mbil_device_edit");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}

	public void doUpdate(ModelAndView mv,MbilDevice mObject,String unid,PrintWriter printWriter,String useType,int resType){
		mService.update(mObject);
		if(resType==0){
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}

	public void showDetail(ModelAndView mv,String unid,PrintWriter printWriter,String useType,int resType){
		MbilDevice mObject = mService.findOne(unid);
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilDevice");
		mv.addObject("varObject",varObject);
		mv.addObject("mObject", mObject);
		if(resType==0){
			mv.setViewName(basedir+"/mbil_device_show");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}
	public String genDeviceTid(){
		String randCode = "10000001";
		try{
			MbilDevice device = mService.findOneByCondition(" order by deTid desc");
			if(device!=null){
				String maxid = device.getDeTid();
				randCode = (Long.parseLong(maxid)+1)+"";
			}
			return randCode;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}

