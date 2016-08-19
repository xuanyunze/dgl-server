package com.rxoa.mypay.sys.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
import com.rxoa.mypay.base.view.PageView;
import com.rxoa.mypay.base.view.PageWeb;
import com.rxoa.mypay.db.po.MbilSettleLog;
import com.rxoa.mypay.db.po.SysOrg;
import com.rxoa.mypay.db.query.HibQueryMgr;
import com.rxoa.mypay.db.service.in.IMbilSettleLogService;
import com.rxoa.mypay.db.service.in.ISysOrgService;
import com.rxoa.mypay.sys.auth.SessionMgr;
import com.rxoa.mypay.sys.entity.ReportQueryEntity;
import com.rxoa.mypay.sys.vo.BenefitEntityVo;
import com.rxoa.mypay.sys.vo.QuerySettlelogReqVo;
import com.rxoa.mypay.util.DateUtil;
import com.rxoa.mypay.util.StringUtil;

@Controller
@RequestMapping("/report")
public class ReportController {
	@Resource(name="mbilSettleLogService")
	private IMbilSettleLogService mbilSettleLogService;
	
	@Resource(name="sysOrgService")
	private ISysOrgService orgService;
	
	@RequestMapping(value="/order/manage/{usetype}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getOrderReportJsp(HttpServletRequest req,@PathVariable String usetype,ReportQueryEntity query,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		if(usetype.equals("page")){
			mv.setViewName("report/order_manage_trans");
		}else if(usetype.equals("xls")){
			List<Map<String,Object>> list = HibQueryMgr.getQueryContext().getTransReport(query);
			mv.addObject("mObject",list);
			mv.addObject("filename", "trans_"+DateUtil.format(new Date(), "yyyyMMdd"));
			mv.setViewName("report/order_manage_trans_rpt");
		}
		return mv;
	}
	
	@RequestMapping(value="/order/manage/page.json",method=RequestMethod.POST)
	@SessionPermission
	public ModelAndView getOrderReportJson(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("channel/channel_page");
		return mv;
	}
	@RequestMapping(value="/settle/manage/{usetype}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getSettleReportJsp(HttpServletRequest req,@PathVariable String usetype,ReportQueryEntity query,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		if(usetype.equals("page")){
			mv.setViewName("report/order_manage_settle");
		}else if(usetype.equals("xls")){
			List<Map<String,Object>> list = HibQueryMgr.getQueryContext().getSettleReport(query);
			mv.addObject("mObject",list);
			mv.addObject("filename", "rbsettle_"+DateUtil.format(new Date(), "yyyyMMdd"));
			mv.setViewName("report/order_manage_settle_rpt");
		}
		return mv;
	}
	
	@RequestMapping(value="/settle/manage/page.json",method=RequestMethod.POST)
	@SessionPermission
	public ModelAndView getSettleReportJson(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("channel/channel_page");
		return mv;
	}
	
	@RequestMapping(value="/hsettle/manage/{usetype}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getHSettleReportJsp(HttpServletRequest req,@PathVariable String usetype,ReportQueryEntity query,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		if(usetype.equals("page")){
			mv.setViewName("report/order_manage_hsettle");
		}else if(usetype.equals("xls")){
			List<Map<String,Object>> list = HibQueryMgr.getQueryContext().getHSettleReport(query);
			mv.addObject("mObject",list);
			mv.addObject("filename", "hsettle_"+DateUtil.format(new Date(), "yyyyMMdd"));
			mv.setViewName("report/order_manage_hsettle_rpt");
		}
		return mv;
	}
	
	@RequestMapping(value="/settlefail/manage/{usetype}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getSettlefailReportJsp(HttpServletRequest req,@PathVariable String usetype,ReportQueryEntity query,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		if(usetype.equals("page")){
			mv.setViewName("report/order_manage_settlefail");
		}else if(usetype.equals("xls")){
			List<Map<String,Object>> list = HibQueryMgr.getQueryContext().getSettlefailReport(query);
			mv.addObject("mObject",list);
			mv.addObject("filename", "settlefail_"+DateUtil.format(new Date(), "yyyyMMdd"));
			mv.setViewName("report/order_manage_settlefail_rpt");
		}
		return mv;
	}
	
	@RequestMapping(value="/benefit/{utype}/page",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getBenefitReportJsp(HttpServletRequest req,@PathVariable String utype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("report/benefit_page");
		return mv;
	}
	@RequestMapping(value="/benefit/{utype}/json",method=RequestMethod.GET)
	@SessionPermission
	public void getBenefitReportJson(HttpServletRequest req,@PathVariable String utype,ReportQueryEntity query,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		List<BenefitEntityVo> vlist = getBenefitPagedata(req,query);
		mv.addObject("list",vlist);
		JsonUtil.print(mv.getModel(), printWriter);
	}
	@RequestMapping(value="/benefit/{utype}/xls",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getBenefitReportData(HttpServletRequest req,@PathVariable String utype,
			ReportQueryEntity query,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
			
		List<Map<String,Object>> list = HibQueryMgr.getQueryContext().getSettlefailReport(query);
		mv.addObject("mObject",list);
		mv.addObject("filename", "benefit_"+DateUtil.format(new Date(), "yyyyMMdd"));
		mv.setViewName("report/benefit_page_rpt");
		return mv;
	}
	public List<BenefitEntityVo> getBenefitPagedata(HttpServletRequest req,ReportQueryEntity query){
		List<BenefitEntityVo> vlist = new ArrayList<BenefitEntityVo>();
		SysOrg org = orgService.findOneByCondition(" and o_id='"+SessionMgr.getCurSession(req).getOrgId()+"'");
		String[] orgs = new String[]{};
		if(org.getOid().length()<6||org.getOid().substring(0,4).equals("1010")){
			String vorgs = HibQueryMgr.getQueryContext().getSubOrgs("1011", false);
			if(!StringUtil.isDbNull(vorgs)){
				orgs = vorgs.split(",");
			}
		}else{
			String vorgs = HibQueryMgr.getQueryContext().getSubOrgs(org.getOid(), false);
			orgs = (org.getOid()+","+vorgs).split(",");
		}
		Map<String,Object> busiConfig = HibQueryMgr.getQueryContext().getBusiConfig();
		if(orgs!=null&&orgs.length>0){
			for(String uorg:orgs){
				SysOrg corg = orgService.findOneByCondition(" and o_id='"+uorg+"'");
				if(corg!=null){
					BenefitEntityVo vo = HibQueryMgr.getQueryContext().getBenefitReport(query, busiConfig, uorg, true);
					vo.setOname(corg.getOname());
					vlist.add(vo);
				}
			}
		}
		return vlist;
	}
	@RequestMapping(value="/settlelog/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getSettlelogPage(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		if(usetype.equals("s0")){
			mv.addObject("utype","s0");
		}else if(usetype.equals("t1")){
			mv.addObject("utype","t1");
		}
		mv.setViewName("report/settlelog_manage_page");
		return mv;
	}
	@RequestMapping(value="/settlelog/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getSettlelogJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@ModelAttribute("qObject") QuerySettlelogReqVo queryVo,@PathVariable String curpage,
			@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		String qhql = "";
		if(usetype.equals("s0")){
			qhql = " and slOdarrivetype='S0'";
		}else if(usetype.equals("t1")){
			qhql =" and slOdarrivetype='AT1'";
		}
		if(!StringUtil.isDbNull(queryVo.getStartDate())) qhql+= " and date_format(creTime,'%Y-%m-%d')>='"+queryVo.getStartDate()+"'";
		if(!StringUtil.isDbNull(queryVo.getEndDate())) qhql+= " and date_format(creTime,'%Y-%m-%d')<='"+queryVo.getEndDate()+"'";
		if(!StringUtil.isDbNull(queryVo.getSlUid())) qhql+= " and slUid like '%"+queryVo.getSlUid()+"%'";
		if(!StringUtil.isDbNull(queryVo.getSlUname())) qhql+= " and slStaccname like '%"+queryVo.getSlUname()+"%'";
		if(!StringUtil.isDbNull(queryVo.getSlUaccno())) qhql+= " and slStaccno like '%"+queryVo.getSlUaccno()+"%'";
		if(!StringUtil.isDbNull(queryVo.getSlStat())&&!queryVo.getSlStat().equals("all")) qhql+= " and slStat='"+queryVo.getSlStat()+"'";
		web.setHqlCondition(qhql);
		PageView mpage = mbilSettleLogService.findPage(web.prepare());
		if(usetype.equals("s0")){
			mpage.setBtnItemEdit(true);
		}
		mv.addObject("mObject", mpage);
		JsonUtil.print(mv.getModel(), printWriter);
	}
	
	@RequestMapping(value="/settlelog/edit/manage/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getSettlelogEdit(HttpServletRequest req,@PathVariable String unid,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		MbilSettleLog slog = mbilSettleLogService.findOneByCondition(" and uuid='"+unid+"'");
		mv.addObject("mObject",slog);
		mv.setViewName("report/settlelog_manage_edit");
		return mv;
	}
	@RequestMapping(value="/settlelog/resettle.json/manage/{unid}",method=RequestMethod.POST)
	@SessionPermission
	public void doReSettle(HttpServletRequest req,@PathVariable String unid,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		MbilSettleLog slog = mbilSettleLogService.findOneByCondition(" and uuid='"+unid+"'");
		slog.setSlStat(-1);
		mbilSettleLogService.update(slog);
		mv.addObject("RESULT","SUCCESS");
		JsonUtil.print(mv.getModel(), printWriter);
	}
	@RequestMapping(value="/statis/{usetype}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getStatisJsp(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("report/statistic_trans");
		return mv;
	}
	@RequestMapping(value="/statis/trans.json/{usetype}",method=RequestMethod.GET)
	@SessionPermission
	public void doGetStatisTranjson(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		List<Map<String,Object>> list = HibQueryMgr.getQueryContext().getStatisTrans();
		mv.addObject("list",list);
		mv.addObject("RESULT","SUCCESS");
		JsonUtil.print(mv.getModel(), printWriter);
	}
}
