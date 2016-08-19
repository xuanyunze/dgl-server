package com.rxoa.mypay.sys.controller;

import java.io.PrintWriter;
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
import com.rxoa.mypay.db.po.MbilOrderReceivemoney;
import com.rxoa.mypay.db.po.SysOrg;
import com.rxoa.mypay.db.query.HibQueryMgr;
import com.rxoa.mypay.db.service.in.IMbilOrderReceivemoneyService;
import com.rxoa.mypay.db.service.in.IMbilOrderTakemoneyService;
import com.rxoa.mypay.db.service.in.ISysOrgService;
import com.rxoa.mypay.sys.auth.SessionMgr;
import com.rxoa.mypay.sys.vo.OrderlistRespVo;
import com.rxoa.mypay.sys.vo.QueryOrderInfoReqVo;
import com.rxoa.mypay.sys.vo.TakemoneylistRespVo;
import com.rxoa.mypay.util.CodeUtil;
import com.rxoa.mypay.util.StringUtil;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Resource(name="mbilOrderReceivemoneyService")
	private IMbilOrderReceivemoneyService mbilOrderReceivemoneyService;
	@Resource(name="mbilOrderTakemoneyService")
	private IMbilOrderTakemoneyService mbilOrderTakemoneyService;
	@Resource(name="sysOrgService")
	private ISysOrgService sysOrgService;
	
	@RequestMapping(value="/receivemoney/{ordertype}/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,@PathVariable String ordertype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		mv.addObject("ordertype",ordertype);
		if(usetype.equals("agent")){
			mv.setViewName("order/order_receivemoney_agent_page");
		}else if(usetype.equals("manage")||usetype.equals("settle")){
			mv.setViewName("order/order_receivemoney_manage_page");
		}else if(usetype.equals("service")){
			mv.setViewName("order/order_receivemoney_page");
		}
		return mv;
	}
	@RequestMapping(value="/receivemoney/{ordertype}/show/{usetype}/{orderid}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getReceiveMoneyDetailJsp(HttpServletRequest req,
	@PathVariable String orderid,@PathVariable String usetype,@PathVariable String ordertype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		mv.addObject("ordertype",ordertype);
		if(usetype.equals("manage")||usetype.equals("service")){
			MbilOrderReceivemoney order = mbilOrderReceivemoneyService.findOne(orderid);
			mv.addObject("mObject",order);
			mv.setViewName("order/order_receivemoney_show");
		}
		return mv;
	}
	@RequestMapping(value="/receivemoney/{ordertype}/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@ModelAttribute("qObject") QueryOrderInfoReqVo qReqvo,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,@PathVariable String ordertype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilOrderReceivemoney");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		String uid = SessionMgr.getCurSession(req).getUserId();
		String oid = SessionMgr.getCurSession(req).getOrgId();
		PageView mpage = getOrderData(usetype,ordertype,uid,oid,qReqvo,Integer.parseInt(curpage),Integer.parseInt(psize));
		if(usetype.equals("manage")||usetype.equals("service")){mpage.setBtnItemShow(true);}
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		JsonUtil.print(mv.getModel(), printWriter);
	}
	
	@RequestMapping(value="/takemoney/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getTakemoneyPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		if(usetype.equals("agent")){
			mv.setViewName("order/order_takemoney_agent_page");
		}else if(usetype.equals("manage")||usetype.equals("settle")){
			mv.setViewName("order/order_takemoney_manage_page");
		}else if(usetype.equals("service")){
			mv.setViewName("order/order_takemoney_page");
		}
		return mv;
	}
	@RequestMapping(value="/takemoney/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getTakemoneyPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilOrderTakemoney");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		String uid = SessionMgr.getCurSession(req).getUserId();
		String oid = SessionMgr.getCurSession(req).getOrgId();
		PageView mpage = getTakemoneyData(usetype,uid,oid,Integer.parseInt(curpage),Integer.parseInt(psize));
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		JsonUtil.print(mv.getModel(), printWriter);
	}
	
	public PageView getTakemoneyData(String type,String uid,String oid,int page,int psize){
		PageView pageview = null;
		int start = (page-1)*psize;int count = 0;
		List<TakemoneylistRespVo> list = null;
		try{
			SysOrg org = sysOrgService.findOneByCondition(" and oid='"+oid+"'");
			String psql = "",sql = "";
			if(org.getOtype().equals("3")||org.getOtype().equals("4")||org.getOtype().equals("5")||org.getOtype().equals("6")){
				String opath = org.getOpathtrack();
				if(!StringUtil.isDbNull(opath)){
					String[] porg = opath.trim().split(",");
					for(int i=0;i<porg.length;i++){
						if(psql.equals("")){psql = "od_oid='"+porg[i].trim()+"'";}
						else{psql+=" or od_oid='"+porg[i].trim()+"'";}
					}
					if(!psql.equals("")){psql = " and ("+psql+")";}
				}else{
					return pageview;
				}
				psql = " and morder.od_oid in (select o_id from sys_org where find_in_set('"+oid+"',o_pathtrack) order by o_id desc)";
			}
			
			String countSql = "select count(*) as count from mbil_order_takemoney as morder left join mbil_user as user on morder.od_uid=user.u_id where morder.stat = '0'"+psql+" order by morder.cre_time desc";
			count = HibQueryMgr.getQueryContext().getCount(countSql);
			sql = "select * from mbil_order_takemoney as morder left join mbil_user as user on morder.od_uid=user.u_id where morder.stat = '0'"+psql+" order by morder.cre_time desc limit "+start+","+psize+"";
			list = HibQueryMgr.getQueryContext().getTakemoneylist(sql);
			pageview = PageView.wrap(list, count,page, psize);
		}catch(Exception e){
			e.printStackTrace();
		}
		return pageview;
	}
	
	public PageView getOrderData(String type,String ordertype,String uid,String oid,QueryOrderInfoReqVo qReqvo,int page,int psize){
		PageView pageview = null;
		int start = (page-1)*psize;int count = 0;
		List<OrderlistRespVo> list = null;
		try{
			SysOrg org = sysOrgService.findOneByCondition(" and oid='"+oid+"'");
			String pjoin = "",pwhere="",sql = "",qsql="";
			if(!StringUtil.isDbNull(qReqvo.getStartDate())) qsql+= " and date(morder.cre_time)>='"+qReqvo.getStartDate()+"'";
			if(!StringUtil.isDbNull(qReqvo.getEndDate())) qsql+= " and date(morder.cre_time)<='"+qReqvo.getEndDate()+"'";
			if(!StringUtil.isDbNull(qReqvo.getUserId())) qsql+= " and morder.od_uid like '%"+qReqvo.getUserId()+"%'";
			if(!StringUtil.isDbNull(qReqvo.getUserName())) qsql+= " and user.u_realname like '%"+qReqvo.getUserName()+"%'";
			if(!StringUtil.isDbNull(qReqvo.getDeSn())) qsql+= " and morder.od_paydesn like '%"+qReqvo.getDeSn()+"%'";
			if(!StringUtil.isDbNull(qReqvo.getCardNo())) qsql+= " and morder.od_payaccno like '%"+qReqvo.getCardNo()+"%'";
			if(!StringUtil.isDbNull(qReqvo.getDealStat())&&qReqvo.getDealStat().equals("1")){
				qsql+= " and (morder.od_stat='5' or morder.od_stat='7' or morder.od_stat='8' or morder.od_stat='9')";
			}else if(!StringUtil.isDbNull(qReqvo.getDealStat())&&qReqvo.getDealStat().equals("0")){
				qsql+= " and morder.od_stat!='5' and morder.od_stat!='7' and morder.od_stat!='8' and morder.od_stat!='9'";
			}
			
			if(org.getOtype().equals("3")||org.getOtype().equals("4")||org.getOtype().equals("5")||org.getOtype().equals("6")){
				//psql = " and morder.od_oid in (select o_id from sys_org where find_in_set('"+oid+"',o_pathtrack) order by o_id desc)";
				pwhere = " and find_in_set('"+oid+"',org.o_pathtrack)";
				pjoin = " left join sys_org as org on org.o_id = morder.od_oid";
			}
			pwhere+=qsql;
			String countSql = "select count(*) as count from mbil_order_receivemoney as morder left join deal_trans as tran on morder.od_flowid=tran.tr_orderid left join mbil_user as user on morder.od_uid=user.u_id"+pjoin+" where morder.stat = '0'"+pwhere+" and tran.uuid is not null and morder.od_type='"+ordertype+"' order by morder.cre_time desc";
			count = HibQueryMgr.getQueryContext().getCount(countSql);
			sql = "select * from mbil_order_receivemoney as morder left join deal_trans as tran on morder.od_flowid=tran.tr_orderid left join mbil_user as user on morder.od_uid=user.u_id"+pjoin+" where morder.stat = '0'"+pwhere+" and tran.uuid is not null and morder.od_type='"+ordertype+"' order by morder.cre_time desc limit "+start+","+psize+"";
			list = HibQueryMgr.getQueryContext().getOrderlist(sql);
			pageview = PageView.wrap(list, count,page, psize);
		}catch(Exception e){
			e.printStackTrace();
		}
		return pageview;
	}
}
