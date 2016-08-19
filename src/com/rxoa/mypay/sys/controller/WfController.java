package com.rxoa.mypay.sys.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import com.rxoa.mypay.base.view.PageStyle;
import com.rxoa.mypay.base.view.PageView;
import com.rxoa.mypay.base.view.PageWeb;
import com.rxoa.mypay.db.po.MbilCard;
import com.rxoa.mypay.db.po.MbilOrderTakemoney;
import com.rxoa.mypay.db.po.MbilUser;
import com.rxoa.mypay.db.po.MbilWfBindcard;
import com.rxoa.mypay.db.po.MbilWfRealname;
import com.rxoa.mypay.db.po.SysWfHistory;
import com.rxoa.mypay.db.service.in.IMbilCardService;
import com.rxoa.mypay.db.service.in.IMbilOrderTakemoneyService;
import com.rxoa.mypay.db.service.in.IMbilUserService;
import com.rxoa.mypay.db.service.in.IMbilWfBindcardService;
import com.rxoa.mypay.db.service.in.IMbilWfRealnameService;
import com.rxoa.mypay.db.service.in.ISysWfHistoryService;
import com.rxoa.mypay.sys.auth.SessionMgr;
import com.rxoa.mypay.sys.auth.SysAuthChecker;
import com.rxoa.mypay.sys.config.DictReader;
import com.rxoa.mypay.util.CodeUtil;
import com.rxoa.mypay.util.DateUtil;
import com.rxoa.mypay.util.StringUtil;

@Controller
@RequestMapping("/wf")
public class WfController {
	@Resource(name="mbilUserService")
	private IMbilUserService mbilUserService;
	@Resource(name="mbilWfRealnameService")
	private IMbilWfRealnameService wfService;
	@Resource(name="mbilWfBindcardService")
	private IMbilWfBindcardService wfBindcardService;
	
	@Resource(name="sysWfHistoryService")
	private ISysWfHistoryService wfHistoryService;
	
	@Resource(name="mbilOrderTakemoneyService")
	private IMbilOrderTakemoneyService takemoneyService;
	
	@Resource(name="mbilCardService")
	private IMbilCardService mbilCardService;
	
	
	@RequestMapping(value="/realname/undeal/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getRealnameUndealPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_undeal_page", printWriter, usetype, 1);
		getRealnameUndealPage(mv,null,curpage,psize,printWriter,usetype,0);
		return mv;
	}
	@RequestMapping(value="/realname/undeal/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getRealnameUndealPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_undeal_page", printWriter, usetype, 1);
		getRealnameUndealPageData(mv,web,curpage,psize,printWriter,usetype,1);
	}
	public void getRealnameUndealPage(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		if(resType==0){
			mv.setViewName("wf/wf_realname_undeal_page");
		}else if(resType==1){
		}
	}
	public void getRealnameUndealPageData(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		web.setHqlCondition(" and wfStat='0'");
		PageView mpage = wfService.findPage(web.prepare());
		mpage.setBtnItemEdit(true);
		mpage.setBtnItemDel(true);
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilWfRealname");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		Map<String,String> table = new HashMap<String,String>();
		table.put("wfStat", "order_stat");
		mv.addObject("avatar", DictReader.getValueMap(table));
		if(resType==0){
			String json = JsonUtil.genObjJson(mv.getModel());
			mv.clear();
			mv.addObject("mObject", json);
			mv.setViewName("wf/wf_realname_undeal_page");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}
	
	@RequestMapping(value="/realname/undeal/edit/{usetype}/{id}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getRealnameUndealEditJsp(HttpServletRequest req,
			@PathVariable String usetype,@PathVariable String id,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_undeal_edit", printWriter, usetype, 1);
		MbilWfRealname mObject = wfService.findOne(id);
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilWfRealname");
		mv.addObject("subpath","dealchannelrouteritem");
		mv.addObject("varObject",varObject);
		mv.addObject("mObject", mObject);
		mv.setViewName("wf/wf_realname_undeal_edit");
		return mv;
	}
	@RequestMapping(value="/realname/undeal/edit.json/{usetype}/{id}",method=RequestMethod.POST)
	@SessionPermission
	public void getRealnameUndealEditJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,
			@PathVariable String usetype,@PathVariable String id,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_undeal_edit", printWriter, usetype, 1);
		
	}
	@RequestMapping(value="/realname/undeal/update.json/{usetype}/{unid}",method=RequestMethod.POST)
	@SessionPermission
	public void execRealnameUndealUpdateJson(HttpServletRequest req,@ModelAttribute("mObject") MbilWfRealname mObject,@PathVariable String unid,@PathVariable String usetype,
			String spyj,String result,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_undeal_update", printWriter, usetype, 1);
		int vresult = 1;
		try{
			MbilWfRealname wf = wfService.findOne(unid);
			if(wf!=null){
				MbilUser user = mbilUserService.findOneByCondition(" and uid='"+wf.getWfUid()+"'");
				if(user!=null){
					if(user.getUrealname()==null||user.getUrealname().equals("null")||user.getUrealname().equals("")){
						if(!StringUtil.isDbNull(result)&&result.equals("1")){
							user.setUrealname(wf.getWfRealname().trim());
							user.setUidno(wf.getWfIdno().trim());
							user.setUidtype(StringUtil.isDbNull(wf.getWfIdtype())?"0":wf.getWfIdtype());
							user.setUrealauthtime(DateUtil.getNowFullDateTime());
							mbilUserService.update(user);
							wf.setWfStat("9999");
						}else{
							wf.setWfStat("8888");
						}
						SysWfHistory wfh = new SysWfHistory();
						wfh.setCreTime(new Date());
						wfh.setWhTaskid(unid);
						wfh.setWhDealer(SessionMgr.getCurSession(req).getUserId());
						wfh.setWhDealresult(result);
						wfh.setWhDealyj(spyj);
						wfh.setWhDealtime(DateUtil.getNowFullDateTime());
						wfHistoryService.create(wfh);
												
						wfService.update(wf);
						vresult = 0;
					}else{
						vresult = 2; //已认证
					}
				}else{
					vresult = 3;//用户不存在
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(vresult);
		mv.addObject("result",vresult);
		JsonUtil.print(mv.getModel(), printWriter);
	}
	@RequestMapping(value="/realname/undeal/del.json/{usetype}/{id}",method=RequestMethod.POST)
	@SessionPermission
	public void getRealnameUndealDelJson(HttpServletRequest req,
			@PathVariable String usetype,@PathVariable String id,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		MbilWfRealname rname = wfService.findOneByCondition(" and uuid='"+id+"'");
		if(rname!=null){
			wfService.deleteReal(rname);
			mv.addObject("resp","success");
		}else{
			mv.addObject("resp","error");
		}
		JsonUtil.print(mv.getModel(), printWriter);
		
	}
	@RequestMapping(value="/realname/dealed/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getRealnameDealedPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_dealed_page", printWriter, usetype, 1);
		getRealnameDealedPage(mv,null,curpage,psize,printWriter,usetype,0);
		return mv;
	}
	@RequestMapping(value="/realname/dealed/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getRealnameDealedPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_dealed_page", printWriter, usetype, 1);
		getRealnameDealedPageData(mv,web,curpage,psize,printWriter,usetype,1);
	}
	public void getRealnameDealedPage(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		if(resType==0){
			mv.setViewName("wf/wf_realname_dealed_page");
		}else if(resType==1){
		}
	}
	public void getRealnameDealedPageData(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		web.setHqlCondition(" and wfStat!='0'");
		PageView mpage = wfService.findPage(web.prepare());
		mpage.setBtnItemShow(true);
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilWfRealname");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		if(resType==0){
			String json = JsonUtil.genObjJson(mv.getModel());
			mv.clear();
			mv.addObject("mObject", json);
			mv.setViewName("wf/wf_realname_dealed_page");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}
	@RequestMapping(value="/realname/dealed/show/{usetype}/{id}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView geRealnameUndealShowJsp(HttpServletRequest req,
			@PathVariable String usetype,@PathVariable String id,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_dealed_show", printWriter, usetype, 1);
		MbilWfRealname mObject = wfService.findOne(id);
		List<SysWfHistory> list = new ArrayList<SysWfHistory>();
		list = wfHistoryService.findByCondition(" and whTaskid='"+id+"'");
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilWfRealname");
		mv.addObject("subpath","wfrealnamedealedshow");
		mv.addObject("varObject",varObject);
		mv.addObject("mObject", mObject);
		mv.addObject("listObj",list);
		mv.setViewName("wf/wf_realname_dealed_show");
		return mv;
	}
	
	///////////////////////////===========//////////////////////////////////
	@RequestMapping(value="/takemoney/undeal/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getTakemoneyUndealPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_takemoney_undeal_page", printWriter, usetype, 1);
		getTakemoneyUndealPage(mv,null,curpage,psize,printWriter,usetype,0);
		return mv;
	}
	@RequestMapping(value="/takemoney/undeal/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getTakemoneyUndealPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_takemoney_undeal_page", printWriter, usetype, 1);
		getTakemoneyUndealPageData(mv,web,curpage,psize,printWriter,usetype,1);
	}
	public void getTakemoneyUndealPage(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		if(resType==0){
			mv.setViewName("wf/wf_takemoney_undeal_page");
		}else if(resType==1){
		}
	}
	public void getTakemoneyUndealPageData(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		web.setHqlCondition(" and odStat='4'");
		PageView mpage = takemoneyService.findPage(web.prepare());
		mpage.setBtnItemEdit(true);
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilOrderTakemoney");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		Map<String,String> table = new HashMap<String,String>();
		table.put("odStat", "order_stat");
		table.put("odTaketype", "takemoney_type");
		mv.addObject("avatar", DictReader.getValueMap(table));
		if(resType==0){
			String json = JsonUtil.genObjJson(mv.getModel());
			mv.clear();
			mv.addObject("mObject", json);
			mv.setViewName("wf/wf_takemoney_undeal_page");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}
	
	@RequestMapping(value="/takemoney/undeal/edit/{usetype}/{id}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView geTakemoneyUndealEditJsp(HttpServletRequest req,
			@PathVariable String usetype,@PathVariable String id,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_takemoney_undeal_edit", printWriter, usetype, 1);
		MbilOrderTakemoney mObject = takemoneyService.findOne(id);
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilOrderTakemoney");
		mv.addObject("subpath","takemoney");
		mv.addObject("varObject",varObject);
		mv.addObject("mObject", mObject);
		mv.setViewName("wf/wf_takemoney_undeal_edit");
		return mv;
	}
	@RequestMapping(value="/takemoney/undeal/edit.json/{usetype}/{id}",method=RequestMethod.POST)
	@SessionPermission
	public void getTakemoneyUndealEditJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,
			@PathVariable String usetype,@PathVariable String id,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_takemoney_undeal_edit", printWriter, usetype, 1);
		
	}
	@RequestMapping(value="/takemoney/undeal/update.json/{usetype}/{unid}",method=RequestMethod.POST)
	@SessionPermission
	public void execTakemoneyUndealUpdateJson(HttpServletRequest req,@ModelAttribute("mObject") MbilWfRealname mObject,@PathVariable String unid,@PathVariable String usetype,
			String spyj,String result,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_takemoney_undeal_update", printWriter, usetype, 1);
		int vresult = 1;
		try{
			MbilWfRealname wf = wfService.findOne(unid);
			if(wf!=null){
				MbilUser user = mbilUserService.findOneByCondition(" and uid='"+wf.getWfUid()+"'");
				if(user!=null){
					if(user.getUrealname()==null||user.getUrealname().equals("null")||user.getUrealname().equals("")){
						user.setUrealname(wf.getWfRealname());
						user.setUidno(wf.getWfIdno());
						user.setUidtype(wf.getWfIdtype());
						user.setUrealauthtime(DateUtil.getNowFullDateTime());
						mbilUserService.update(user);
						
						SysWfHistory wfh = new SysWfHistory();
						wfh.setCreTime(new Date());
						wfh.setWhTaskid(unid);
						wfh.setWhDealer(SessionMgr.getCurSession(req).getUserId());
						wfh.setWhDealresult(result);
						wfh.setWhDealyj(spyj);
						wfh.setWhDealtime(DateUtil.getNowFullDateTime());
						wfHistoryService.create(wfh);
						
						wf.setWfStat("9999");
						wfService.update(wf);
						vresult = 0;
					}else{
						vresult = 2; //已认证
					}
				}else{
					vresult = 3;//用户不存在
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(vresult);
		mv.addObject("result",vresult);
		JsonUtil.print(mv.getModel(), printWriter);
	}
	
	@RequestMapping(value="/takemoney/dealed/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getTakemoneyDealedPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_takemoney_dealed_page", printWriter, usetype, 1);
		getTakemoneyDealedPage(mv,null,curpage,psize,printWriter,usetype,0);
		return mv;
	}
	@RequestMapping(value="/takemoney/dealed/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getTakemoneyDealedPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_takemoney_dealed_page", printWriter, usetype, 1);
		getTakemoneyDealedPageData(mv,web,curpage,psize,printWriter,usetype,1);
	}
	public void getTakemoneyDealedPage(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		if(resType==0){
			mv.setViewName("wf/wf_takemoney_dealed_page");
		}else if(resType==1){
		}
	}
	public void getTakemoneyDealedPageData(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		web.setHqlCondition(" and (odStat='5' or odStat='6')");
		PageView mpage = takemoneyService.findPage(web.prepare());
		mpage.setBtnItemShow(true);
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilOrderTakemoney");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		Map<String,String> table = new HashMap<String,String>();
		table.put("odStat", "order_stat");
		table.put("odTaketype", "takemoney_type");
		mv.addObject("avatar", DictReader.getValueMap(table));
		if(resType==0){
			String json = JsonUtil.genObjJson(mv.getModel());
			mv.clear();
			mv.addObject("mObject", json);
			mv.setViewName("wf/wf_takemoney_dealed_page");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}
	@RequestMapping(value="/takemoney/dealed/show/{usetype}/{id}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView geTakemoneyUndealedShowJsp(HttpServletRequest req,
			@PathVariable String usetype,@PathVariable String id,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_takemoney_dealed_show", printWriter, usetype, 1);
		MbilOrderTakemoney mObject = takemoneyService.findOne(id);
		List<SysWfHistory> list = new ArrayList<SysWfHistory>();
		list = wfHistoryService.findByCondition(" and whTaskid='"+id+"'");
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilOrderTakemoney");
		mv.addObject("subpath","wftakemoneydealedshow");
		mv.addObject("varObject",varObject);
		mv.addObject("mObject", mObject);
		mv.addObject("listObj",list);
		mv.setViewName("wf/wf_takemoney_dealed_show");
		return mv;
	}
	
	//主银行卡绑定--未审批
	@RequestMapping(value="/bindcard/undeal/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getMaincardUndealPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_undeal_page", printWriter, usetype, 1);
		getMaincardUndealPage(mv,null,curpage,psize,printWriter,usetype,0);
		return mv;
	}
	@RequestMapping(value="/bindcard/undeal/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getMaincardUndealPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_undeal_page", printWriter, usetype, 1);
		getMaincardUndealPageData(mv,web,curpage,psize,printWriter,usetype,1);
	}
	public void getMaincardUndealPage(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		if(resType==0){
			mv.setViewName("wf/wf_bindcard_undeal_page");
		}else if(resType==1){
			
		}
	}
	public void getMaincardUndealPageData(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		web.setHqlCondition(" and wfStat='0'");
		PageView mpage = wfBindcardService.findPage(web.prepare());
		mpage.setBtnItemEdit(true);
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilWfBindcard");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		Map<String,String> table = new HashMap<String,String>();
		table.put("wfStat", "order_stat");
		mv.addObject("avatar", DictReader.getValueMap(table));
		if(resType==0){
			String json = JsonUtil.genObjJson(mv.getModel());
			mv.clear();
			mv.addObject("mObject", json);
			mv.setViewName("wf/wf_bindcard_undeal_page");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}
	
	@RequestMapping(value="/bindcard/undeal/edit/{usetype}/{id}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getBindcardUndealEditJsp(HttpServletRequest req,
			@PathVariable String usetype,@PathVariable String id,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_bindcard_undeal_edit", printWriter, usetype, 1);
		MbilWfBindcard mObject = wfBindcardService.findOne(id);
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilWfBindcard");
		mv.addObject("subpath","wfmbilbindcard");
		mv.addObject("varObject",varObject);
		mv.addObject("mObject", mObject);
		mv.setViewName("wf/wf_bindcard_undeal_edit");
		return mv;
	}
	@RequestMapping(value="/bindcard/undeal/edit.json/{usetype}/{id}",method=RequestMethod.POST)
	@SessionPermission
	public void getBindcardUndealEditJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,
			@PathVariable String usetype,@PathVariable String id,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_undeal_edit", printWriter, usetype, 1);
		
	}
	@RequestMapping(value="/bindcard/undeal/update.json/{usetype}/{unid}",method=RequestMethod.POST)
	@SessionPermission
	public void execBindcardUndealUpdateJson(HttpServletRequest req,@ModelAttribute("mObject") MbilWfRealname mObject,@PathVariable String unid,@PathVariable String usetype,
			String spyj,String result,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_undeal_update", printWriter, usetype, 1);
		int vresult = 1;
		try{
			MbilWfBindcard wf = wfBindcardService.findOne(unid);
			if(wf!=null){
				if(result.equals("1")){
					updateMaincard(wf.getWfUid(),wf.getWfAccno());//重置原来的主银行卡
					MbilCard card = new MbilCard();
					card.setCdUid(wf.getWfUid());
					card.setCreAuthor(wf.getWfUid());
					card.setModAuthor(wf.getWfUid());
					card.setCdProvince(wf.getWfProvince());
					card.setCdCity(wf.getWfCity());
					card.setCdAccname(wf.getWfAccname());
					card.setCdAccno(wf.getWfAccno());
					card.setCdBankname(wf.getWfBankname());
					card.setCdBankno(wf.getWfBankno());
					card.setCdBankbranch(wf.getWfBankbranch());
					card.setCdBankdistr(wf.getWfBankdistr());
					card.setCdIsmaincard(wf.getWfIsmaincard());
					card.setCdType(wf.getWfCardtyp());
					card.setCdFastpay(wf.getWfIsfastpay());
					card.setCdStat("1");
					card.setCdCate(wf.getWfCardcate());
					boolean ic = mbilCardService.create(card);
					wf.setWfStat("9999");
				}else if(result.equals("0")){
					wf.setWfStat("8888");
				}
					
				SysWfHistory wfh = new SysWfHistory();
				wfh.setCreTime(new Date());
				wfh.setWhTaskid(unid);
				wfh.setWhDealer(SessionMgr.getCurSession(req).getUserId());
				wfh.setWhDealresult(result);
				wfh.setWhDealyj(spyj);
				wfh.setWhDealtime(DateUtil.getNowFullDateTime());
				wfHistoryService.create(wfh);
				
				wfBindcardService.update(wf);
				vresult = 0;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(vresult);
		mv.addObject("result",vresult);
		JsonUtil.print(mv.getModel(), printWriter);
	}
	
	
	//主银行卡绑定--已审批
	@RequestMapping(value="/bindcard/dealed/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getMaincardDealedPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_undeal_page", printWriter, usetype, 1);
		getMaincardDealedPage(mv,null,curpage,psize,printWriter,usetype,0);
		return mv;
	}
	@RequestMapping(value="/bindcard/dealed/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getMaincardDealedPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_undeal_page", printWriter, usetype, 1);
		getMaincardDealedPageData(mv,web,curpage,psize,printWriter,usetype,1);
	}
	public void getMaincardDealedPage(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		if(resType==0){
			mv.setViewName("wf/wf_bindcard_dealed_page");
		}else if(resType==1){
			
		}
	}
	public void getMaincardDealedPageData(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		web.setHqlCondition(" and wfStat!='0'");
		PageView mpage = wfBindcardService.findPage(web.prepare());
		mpage.setBtnItemShow(true);
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilWfBindcard");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		Map<String,String> table = new HashMap<String,String>();
		table.put("wfStat", "order_stat");
		mv.addObject("avatar", DictReader.getValueMap(table));
		if(resType==0){
			String json = JsonUtil.genObjJson(mv.getModel());
			mv.clear();
			mv.addObject("mObject", json);
			mv.setViewName("wf/wf_bindcard_deaeld_page");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}
	@RequestMapping(value="/bindcard/dealed/show/{usetype}/{id}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getBindUndealShowJsp(HttpServletRequest req,
			@PathVariable String usetype,@PathVariable String id,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_dealed_show", printWriter, usetype, 1);
		MbilWfBindcard mObject = wfBindcardService.findOne(id);
		List<SysWfHistory> list = new ArrayList<SysWfHistory>();
		list = wfHistoryService.findByCondition(" and whTaskid='"+id+"'");
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilWfBindcard");
		mv.addObject("subpath","wfrealnamedealedshow");
		mv.addObject("varObject",varObject);
		mv.addObject("mObject", mObject);
		mv.addObject("listObj",list);
		mv.setViewName("wf/wf_bindcard_dealed_show");
		return mv;
	}
	
	public boolean updateMaincard(String uid,String cardno){
		try{
			List<MbilCard> cards = mbilCardService.findByCondition(" and cdUid='"+uid+"'");
			Iterator<MbilCard> it = cards.iterator();
			while(it.hasNext()){
				MbilCard icard = it.next();
				if(icard.getCdAccno().equals(cardno)){
					mbilCardService.delete(icard);
				}else if(icard.getCdIsmaincard().equals("1")){
					icard.setCdStat("0");
					icard.setStat(1);
					mbilCardService.update(icard);
				}
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	//信用银卡绑定--未审批
	@RequestMapping(value="/bindothercard/undeal/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getOthercardUndealPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_undeal_page", printWriter, usetype, 1);
		mv.setViewName("wf/wf_othercard_undeal_page");
		return mv;
	}
	@RequestMapping(value="/bindothercard/undeal/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getOthercardUndealPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_undeal_page", printWriter, usetype, 1);
		getOthercardUndealPageData(mv,web,curpage,psize,printWriter,usetype,1);
	}
	public void getOthercardUndealPageData(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		web.setHqlCondition(" and wfCardtyp='0' and wfIsmaincard='0' and wfStat='0'");
		PageView mpage = wfBindcardService.findPage(web.prepare());
		mpage.setBtnItemEdit(true);
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilWfBindcard");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		Map<String,String> table = new HashMap<String,String>();
		table.put("wfStat", "order_stat");
		mv.addObject("avatar", DictReader.getValueMap(table));
		if(resType==0){
			String json = JsonUtil.genObjJson(mv.getModel());
			mv.clear();
			mv.addObject("mObject", json);
			mv.setViewName("wf/wf_othercard_undeal_page");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}
	
	@RequestMapping(value="/bindothercard/undeal/edit/{usetype}/{id}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getBindOthercardUndealEditJsp(HttpServletRequest req,
			@PathVariable String usetype,@PathVariable String id,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_bindcard_undeal_edit", printWriter, usetype, 1);
		MbilWfBindcard mObject = wfBindcardService.findOne(id);
		MbilUser user = mbilUserService.findOneByCondition(" and uid='"+mObject.getWfUid()+"'");
		String idcardno = "";
		if(user!=null){idcardno=user.getUidno();}
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilWfBindcard");
		mv.addObject("subpath","wfmbilbindcard");
		mv.addObject("varObject",varObject);
		mv.addObject("idcardno", idcardno);
		mv.addObject("mObject", mObject);
		mv.setViewName("wf/wf_othercard_undeal_edit");
		return mv;
	}
	@RequestMapping(value="/bindothercard/undeal/update.json/{usetype}/{unid}",method=RequestMethod.POST)
	@SessionPermission
	public void execBindOthercardUndealUpdateJson(HttpServletRequest req,@ModelAttribute("mObject") MbilWfRealname mObject,@PathVariable String unid,@PathVariable String usetype,
			String spyj,String result,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_undeal_update", printWriter, usetype, 1);
		int vresult = 1;
		try{
			MbilWfBindcard wf = wfBindcardService.findOne(unid);
			if(wf!=null){
				if(result.equals("1")){
					MbilCard card = mbilCardService.findOneByCondition(" and cdAccno='"+wf.getWfAccno()+"'");
					if(card!=null) mbilCardService.delete(card);
					
					card = new MbilCard();
					card.setCdUid(wf.getWfUid());
					card.setCreAuthor(wf.getWfUid());
					card.setModAuthor(wf.getWfUid());
					card.setCdAccname(wf.getWfAccname());
					card.setCdAccno(wf.getWfAccno());
					card.setCdBankname(wf.getWfBankname());
					card.setCdVcode(wf.getWfVcode());
					card.setCdVdate(wf.getWfVdate());
					card.setCdVphone(wf.getWfVphone());
					card.setCdIsmaincard("0");
					card.setCdType("0");
					card.setCdFastpay(wf.getWfIsfastpay());
					card.setCdStat("1");
					mbilCardService.create(card);
					wf.setWfStat("9999");
				}else if(result.equals("0")){
					wf.setWfStat("8888");
				}
				SysWfHistory wfh = new SysWfHistory();
				wfh.setCreTime(new Date());
				wfh.setWhTaskid(unid);
				wfh.setWhDealer(SessionMgr.getCurSession(req).getUserId());
				wfh.setWhDealresult(result);
				wfh.setWhDealyj(spyj);
				wfh.setWhDealtime(DateUtil.getNowFullDateTime());
				wfHistoryService.create(wfh);
				wfBindcardService.update(wf);
				vresult = 0;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(vresult);
		mv.addObject("result",vresult);
		JsonUtil.print(mv.getModel(), printWriter);
	}
	
	//信用卡绑定--已审批
	@RequestMapping(value="/bindothercard/dealed/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getOthercardDealedPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_undeal_page", printWriter, usetype, 1);
		mv.setViewName("wf/wf_othercard_dealed_page");
		return mv;
	}
	@RequestMapping(value="/bindothercard/dealed/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getOthercardDealedPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_undeal_page", printWriter, usetype, 1);
		getOthercardDealedPageData(mv,web,curpage,psize,printWriter,usetype,1);
	}

	public void getOthercardDealedPageData(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		web.setHqlCondition(" and wfCardtyp='0' and wfIsmaincard='0' and wfStat!='0'");
		PageView mpage = wfBindcardService.findPage(web.prepare());
		mpage.setBtnItemShow(true);
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilWfBindcard");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		Map<String,String> table = new HashMap<String,String>();
		table.put("wfStat", "order_stat");
		mv.addObject("avatar", DictReader.getValueMap(table));
		if(resType==0){
			String json = JsonUtil.genObjJson(mv.getModel());
			mv.clear();
			mv.addObject("mObject", json);
			mv.setViewName("wf/wf_othercard_deaeld_page");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}
	@RequestMapping(value="/bindothercard/dealed/show/{usetype}/{id}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getOthercardUndealShowJsp(HttpServletRequest req,
			@PathVariable String usetype,@PathVariable String id,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"wf_realname_dealed_show", printWriter, usetype, 1);
		MbilWfBindcard mObject = wfBindcardService.findOne(id);
		List<SysWfHistory> list = new ArrayList<SysWfHistory>();
		list = wfHistoryService.findByCondition(" and whTaskid='"+id+"'");
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilWfBindcard");
		mv.addObject("subpath","wfrealnamedealedshow");
		mv.addObject("varObject",varObject);
		mv.addObject("mObject", mObject);
		mv.addObject("listObj",list);
		mv.setViewName("wf/wf_othercard_dealed_show");
		return mv;
	}
}
