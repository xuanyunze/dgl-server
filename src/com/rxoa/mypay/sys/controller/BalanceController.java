package com.rxoa.mypay.sys.controller;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rxoa.mypay.base.auth.SessionPermission;
import com.rxoa.mypay.base.util.JsonUtil;
import com.rxoa.mypay.sys.auth.SessionMgr;
import com.rxoa.mypay.sys.auth.SysAuthChecker;
import com.rxoa.mypay.sys.combx.OrgTreeEntity;
import com.rxoa.mypay.sys.entity.ProfitQueryEntity;
import com.rxoa.mypay.sys.entity.ProfitReportEntity;
import com.rxoa.mypay.sys.service.BalanceService;
import com.rxoa.mypay.sys.service.OrgService;

@Controller
@RequestMapping("/balance")
public class BalanceController {
	@Resource(name="orgService")
	private OrgService orgService;
	
	@Resource(name="balanceService")
	private BalanceService balanceService;
	
	@RequestMapping(value="/profitshow/{usetype}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getProfitShow(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		SysAuthChecker.doMethodAuthCheck(req,mv,"balance_profit_show", printWriter, usetype, 1);
		mv.setViewName("balance/profitshow");
		return mv;
	}
	@RequestMapping(value="/profitquery/{usetype}",method=RequestMethod.GET)
	@SessionPermission
	public void getProfitQuery(HttpServletRequest req,@PathVariable String usetype,ProfitQueryEntity query,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		try{
			SysAuthChecker.doMethodAuthCheck(req,mv,"balance_profit_query", printWriter, usetype, 1);
			String otype = SessionMgr.getCurSession(req).getUserType();
			String topid = "",showtype = "all";
			if(otype.equals("1")){
				topid = "1011";
			}else{
				topid = SessionMgr.getCurSession(req).getTopOrgId();
			}
			String startTime = query.getStartDate() + " 00:00:00";
			String endTime = query.getEndDate() + " 23:59:59";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			long sTime = df.parse(startTime).getTime();
			long eTime = df.parse(endTime).getTime();
			if((eTime-sTime)>30*24*60*60*1000L){
				endTime = df.format(new Date(sTime+(31*24*60*60*1000L-1)));
			}
			
			query.setStartDate(startTime);
			query.setEndDate(endTime);
			
			query.setTopOrgid(topid);
			query.setWithChild(query.getWithChild()==null?"0":"1");
			OrgTreeEntity tree = orgService.getTreeByTopNode(showtype, topid);
			List<ProfitReportEntity> list = balanceService.getProfitByOrgtree(tree, query);
			mv.addObject("tree", tree);
			mv.addObject("list", list);
		}catch(Exception e){
			e.printStackTrace();
		}
		JsonUtil.print(mv.getModel(), printWriter);
	}
	
	
	@RequestMapping(value="/settleshow/{usetype}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getSettleShow(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"balance_profit_show", printWriter, usetype, 1);
		mv.setViewName("balance/settleshow");
		return mv;
	}
}
