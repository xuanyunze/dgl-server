package com.rxoa.mypay.sys.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rxoa.mypay.base.auth.SessionPermission;
import com.rxoa.mypay.base.util.JsonUtil;
import com.rxoa.mypay.base.view.PageStyle;
import com.rxoa.mypay.base.view.PageView;
import com.rxoa.mypay.base.view.PageWeb;
import com.rxoa.mypay.db.service.in.IDealTransService;
import com.rxoa.mypay.sys.auth.SysAuthChecker;
import com.rxoa.mypay.util.CodeUtil;

@Controller
@RequestMapping("/trans")
public class TransController {
	@Resource(name="dealTransService")
	private IDealTransService mService;
	
	@RequestMapping(value="/real/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getRealPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"deal_trans_real_page", printWriter, usetype, 1);
		getRealPage(mv,null,curpage,psize,printWriter,usetype,0);
		return mv;
	}

	@RequestMapping(value="/real/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getRealPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"deal_trans_real_page", printWriter, usetype, 1);
		getRealPageData(mv,web,curpage,psize,printWriter,usetype,1);
	}
	public void getRealPage(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		if(resType==0){
			mv.setViewName("transmgr/deal_trans_real_page");
		}else if(resType==1){
		}
	}

	public void getRealPageData(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		web.setHqlCondition(" and trType=1");
		PageView mpage = mService.findPage(web.prepare());
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.DealTrans");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		if(resType==0){
			String json = JsonUtil.genObjJson(mv.getModel());
			mv.clear();
			mv.addObject("mObject", json);
			mv.setViewName("transmgr/deal_trans_real_page");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}
	@RequestMapping(value="/history/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getHisPageJsp(HttpServletRequest req,HttpServletResponse resp,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"deal_trans_history_page",resp, usetype, 1);
		getHisPage(mv,null,curpage,psize,printWriter,usetype,0);
		return mv;
	}

	@RequestMapping(value="/history/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getHisPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"deal_trans_history_page", printWriter, usetype, 1);
		getHisPageData(mv,web,curpage,psize,printWriter,usetype,1);
	}
	public void getHisPage(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		if(resType==0){
			mv.setViewName("transmgr/deal_trans_history_page");
		}else if(resType==1){
		}
	}

	public void getHisPageData(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		PageView mpage = mService.findPage(web.prepare());
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.DealTrans");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		if(resType==0){
			String json = JsonUtil.genObjJson(mv.getModel());
			mv.clear();
			mv.addObject("mObject", json);
			mv.setViewName("transmgr/deal_trans_history_page");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}
}
