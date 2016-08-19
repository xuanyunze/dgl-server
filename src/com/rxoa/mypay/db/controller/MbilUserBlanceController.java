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
import com.rxoa.mypay.sys.auth.SysAuthChecker;
import com.rxoa.mypay.base.auth.SessionPermission;
import com.rxoa.mypay.base.util.JsonUtil;
import com.rxoa.mypay.base.view.PageView;
import com.rxoa.mypay.base.view.PageWeb;
import com.rxoa.mypay.base.view.PageStyle;
import com.rxoa.mypay.db.service.in.IMbilUserBlanceService;
import com.rxoa.mypay.db.po.MbilUserBlance;

/**
 * mbil_user_blance Controller控制器类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Controller
@RequestMapping("/dbmgr/mbiluserblance")
public class MbilUserBlanceController {
	private String basedir = "dbmgr";
	@Resource(name="mbilUserBlanceService")
	private IMbilUserBlanceService mService;

	@RequestMapping(value="/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		getPage(mv,null,curpage,psize,printWriter,usetype,0);
		return mv;
	}

	@RequestMapping(value="/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		getPageData(mv,web,curpage,psize,printWriter,usetype,1);
	}

	@RequestMapping(value="/search/{usetype}",method=RequestMethod.GET)
	@SessionPermission
	public void getSearchJsp(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		getSearch(mv,printWriter,usetype,0);
	}

	@RequestMapping(value="/search.json/{usetype}",method=RequestMethod.POST)
	@SessionPermission
	public void getSearchJson(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		doSearch(mv,printWriter,usetype,1);
	}

	@RequestMapping(value="/add/{usetype}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getNewJsp(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		getCreate(mv,printWriter,usetype,0);
		return mv;
	}

	@RequestMapping(value="/add.json/{usetype}",method=RequestMethod.GET)
	@SessionPermission
	public void getAddJson(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		getCreate(mv,printWriter,usetype,1);
	}

	@RequestMapping(value="/save.json/{usetype}",method=RequestMethod.POST)
	@SessionPermission
	public void execSaveJson(HttpServletRequest req,@ModelAttribute("mObject") MbilUserBlance mObject,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		doSave(mv,mObject,printWriter,usetype,1);
	}

	@RequestMapping(value="/del.json/{usetype}/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public void execDelJson(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		doDelete(mv,unid,printWriter,usetype,0);
	}

	@RequestMapping(value="/edit/{usetype}/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getEditJsp(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		getEdit(mv,unid,null,usetype,0);
		return mv;
	}

	@RequestMapping(value="/edit.json/{usetype}/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public void getEditJson(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		getEdit(mv,unid,printWriter,usetype,1);
	}

	@RequestMapping(value="/update.json/{usetype}/{unid}",method=RequestMethod.POST)
	@SessionPermission
	public void execUpdateJson(HttpServletRequest req,@ModelAttribute("mObject") MbilUserBlance mObject,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		doUpdate(mv,mObject,unid,printWriter,usetype,1);
	}

	@RequestMapping(value="/show/{usetype}/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getShowJsp(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		showDetail(mv,unid,printWriter,usetype,0);
		return mv;
	}

	@RequestMapping(value="/show.json/{usetype}/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public void getShowJson(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
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
			mv.setViewName(basedir+"/mbil_user_blance_page");
		}else if(resType==1){
		}
	}

	public void getPageData(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		PageView mpage = mService.findPage(web.prepare());
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilUserBlance");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		if(resType==0){
			String json = JsonUtil.genObjJson(mv.getModel());
			mv.clear();
			mv.addObject("mObject", json);
			mv.setViewName(basedir+"/mbil_user_blance_page");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}

	public void getCreate(ModelAndView mv,PrintWriter printWriter,String useType,int resType){
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilUserBlance");
		mv.addObject("subpath","mbiluserblance");
		mv.addObject("varObject",varObject);
		if(resType==0){
			mv.setViewName(basedir+"/mbil_user_blance_add");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}

	public void doSave(ModelAndView mv,MbilUserBlance mObject,PrintWriter printWriter,String useType,int resType){
		((MbilUserBlance)mObject).setCreTime(new Date());
		boolean result = mService.create(mObject);
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
		MbilUserBlance mObject = mService.findOne(unid);
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilUserBlance");
		mv.addObject("subpath","mbiluserblance");
		mv.addObject("varObject",varObject);
		mv.addObject("mObject", mObject);
		if(resType==0){
			mv.setViewName(basedir+"/mbil_user_blance_edit");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}

	public void doUpdate(ModelAndView mv,MbilUserBlance mObject,String unid,PrintWriter printWriter,String useType,int resType){
		mService.update(mObject);
		if(resType==0){
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}

	public void showDetail(ModelAndView mv,String unid,PrintWriter printWriter,String useType,int resType){
		MbilUserBlance mObject = mService.findOne(unid);
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilUserBlance");
		mv.addObject("varObject",varObject);
		mv.addObject("mObject", mObject);
		if(resType==0){
			mv.setViewName(basedir+"/mbil_user_blance_show");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}

}

