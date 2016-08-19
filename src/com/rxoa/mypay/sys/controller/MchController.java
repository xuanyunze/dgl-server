package com.rxoa.mypay.sys.controller;

import java.io.PrintWriter;
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
import com.rxoa.mypay.db.po.MbilDevice;
import com.rxoa.mypay.db.po.MbilUser;
import com.rxoa.mypay.db.po.MbilUserLimit;
import com.rxoa.mypay.db.query.HibQueryMgr;
import com.rxoa.mypay.db.service.in.IMbilCardService;
import com.rxoa.mypay.db.service.in.IMbilDeviceService;
import com.rxoa.mypay.db.service.in.IMbilUserLimitService;
import com.rxoa.mypay.db.service.in.IMbilUserService;
import com.rxoa.mypay.sys.auth.SessionMgr;
import com.rxoa.mypay.sys.auth.SysAuthChecker;
import com.rxoa.mypay.sys.vo.MbilUserlistRespVo;
import com.rxoa.mypay.sys.vo.QueryMchInfoReqVo;
import com.rxoa.mypay.util.CodeUtil;
import com.rxoa.mypay.util.StringUtil;

@Controller
@RequestMapping("/mch")
public class MchController {
	@Resource(name="mbilUserService")
	private IMbilUserService mbilUserService;
	@Resource(name="mbilCardService")
	private IMbilCardService mbilCardService;
	@Resource(name="mbilDeviceService")
	private IMbilDeviceService mbilDeviceService;
	@Resource(name="mbilUserLimitService")
	private IMbilUserLimitService mbilUserLimitService;
	
	@RequestMapping(value="/unactived/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_user_page", printWriter, usetype, 1);
		getPage(mv,null,curpage,psize,printWriter,usetype,0);
		return mv;
	}
	@RequestMapping(value="/unactived/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_user_page_unactived", printWriter, usetype, 1);
		getPageData(mv,web,curpage,psize,printWriter,usetype,1);
	}
	public void getPage(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		if(resType==0){
			mv.setViewName("mchmgr/mbil_user_page_unactived");
		}else if(resType==1){
		}
	}
	public void getPageData(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		web.setHqlCondition(" and (uorgid='' or uorgid='null' or uorgid=null)");
		PageView mpage = mbilUserService.findPage(web.prepare());
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilUser");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		if(resType==0){
			String json = JsonUtil.genObjJson(mv.getModel());
			mv.clear();
			mv.addObject("mObject", json);
			mv.setViewName("mchmgr/mbil_user_page_unactived");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}
	@RequestMapping(value="/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getMchPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_user_page", printWriter, usetype, 1);
		if(usetype.equals("manage")){
			mv.setViewName("mchmgr/mch_manage_page");
		}
		return mv;
	}
	@RequestMapping(value="/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getMchPageJson(HttpServletRequest req,QueryMchInfoReqVo qReqVo,PageWeb web,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_user_page", printWriter, usetype, 1);
		PageView pageview = null;boolean isEdit = true;
		int start = (Integer.parseInt(curpage)-1)*Integer.parseInt(psize);int count = 0;int dtype = 1;
		String utype = SessionMgr.getCurSession(req).getUserType();
		String oid =  SessionMgr.getCurSession(req).getOrgId();
		String qsql = "",ostat = "";
		if(!StringUtil.isDbNull(qReqVo.getQrStartDate())) qsql+=" and date(user.cre_time)>='"+qReqVo.getQrStartDate()+"'";
		if(!StringUtil.isDbNull(qReqVo.getQrEndDate())) qsql+=" and date(user.cre_time)<='"+qReqVo.getQrEndDate()+"'";
		if(!StringUtil.isDbNull(qReqVo.getQrUid())) qsql+=" and user.u_id like '%"+qReqVo.getQrUid()+"%'";
		if(!StringUtil.isDbNull(qReqVo.getQrUname())) qsql+=" and user.u_realname like '%"+qReqVo.getQrUname()+"%'";
		if(!StringUtil.isDbNull(qReqVo.getQrDsn())) qsql+=" and find_in_set('"+qReqVo.getQrDsn()+"',dsns.ksn)";
		
		if(utype.equals("2")||utype.equals("3")){
			ostat = " and find_in_set('"+oid+"',org.o_pathtrack)";dtype = 0;isEdit = false;
		}
		qsql+=ostat;
		String querySql = "left join sys_org as org on user.u_orgid = org.o_id"
					+" left join mbil_card as card on user.u_id = card.cd_uid and (isnull(card.cd_stat) or (card.cd_stat='1' and card.cd_ismaincard='1'))"
					+" left join (select uid,group_concat(sn) as ksn from(select device.de_uid as uid,device.de_sn as sn from mbil_device as device where !isnull(device.de_uid) and device.de_uid!='') as sns group by sns.uid) as dsns on dsns.uid = user.u_id"
					+" where 1=1"+qsql;
		
		count = HibQueryMgr.getQueryContext().getCount("select count(*) as count from mbil_user as user "+querySql);
		List<MbilUserlistRespVo> list = HibQueryMgr.getQueryContext().getMbilUserlist("select * from mbil_user as user "+querySql+" order by user.cre_time desc limit "+start+","+psize,dtype);
		pageview = PageView.wrap(list, count,Integer.parseInt(curpage), Integer.parseInt(psize));
		pageview.setBtnItemEdit(isEdit);
		mv.addObject("mObject", pageview);
		JsonUtil.print(mv.getModel(), printWriter);
	}
	@RequestMapping(value="/edit/{usetype}/{uid}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getMchEditJsp(HttpServletRequest req,@PathVariable String uid,
	@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_user_page", printWriter, usetype, 1);
		if(usetype.equals("manage")){
			MbilUser user = mbilUserService.findOneByCondition(" and uid='"+uid+"'");
			MbilCard card = mbilCardService.findOneByCondition(" and cdUid='"+uid+"' and cdIsmaincard='1' and cdStat='1'");
			MbilUserLimit limit = mbilUserLimitService.findOneByCondition(" and ulUid='"+uid+"'");
			List<MbilDevice> devices = mbilDeviceService.findByCondition(" and deUid='"+uid+"'");
			Iterator<MbilDevice> it = devices.iterator();
			String dsns = "";
			while(it.hasNext()){
				MbilDevice dv = (MbilDevice) it.next();
				if(dsns.equals("")) dsns = dv.getDeSn();
				else dsns+=","+dv.getDeSn();
			}
			mv.addObject("mUser",user);
			mv.addObject("mCard",card);
			mv.addObject("mLimit",limit);
			mv.addObject("sns",dsns);
			mv.setViewName("mchmgr/mch_manage_edit");
		}
		return mv;
	}
	@RequestMapping(value="/clearrealname/{usetype}/{uid}",method=RequestMethod.GET)
	@SessionPermission
	public void getMchClearRealname(HttpServletRequest req,@PathVariable String uid,
	@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_user_page", printWriter, usetype, 1);
		if(usetype.equals("manage")){
			MbilUser user = mbilUserService.findOneByCondition(" and uid='"+uid+"'");
			user.setUrealname("");
			user.setUidno("");
			mbilUserService.update(user);
			mv.addObject("resp","success");
			JsonUtil.print(mv.getModel(), printWriter); return;
		}
		mv.addObject("resp","error");
		JsonUtil.print(mv.getModel(), printWriter);
	}
	@RequestMapping(value="/changedstat/{usetype}/{tovalue}/{uid}",method=RequestMethod.GET)
	@SessionPermission
	public void getMchForbidTrans(HttpServletRequest req,@PathVariable String uid,@PathVariable String tovalue,
	@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_user_page", printWriter, usetype, 1);
		if(usetype.equals("manage")){
			MbilUserLimit limit = mbilUserLimitService.findOneByCondition(" and ulUid='"+uid+"'");
			limit.setUlDstat(Integer.parseInt(tovalue));
			mbilUserLimitService.update(limit);
			mv.addObject("resp","success");
			JsonUtil.print(mv.getModel(), printWriter); return;
		}
		mv.addObject("resp","error");
		JsonUtil.print(mv.getModel(), printWriter);
	}
	@RequestMapping(value="/changesstat/{usetype}/{tovalue}/{uid}",method=RequestMethod.GET)
	@SessionPermission
	public void getMchForbidSettle(HttpServletRequest req,@PathVariable String uid,@PathVariable String tovalue,
	@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_user_page", printWriter, usetype, 1);
		if(usetype.equals("manage")){
			MbilUserLimit limit = mbilUserLimitService.findOneByCondition(" and ulUid='"+uid+"'");
			limit.setUlSstat(Integer.parseInt(tovalue));
			mbilUserLimitService.update(limit);
			mv.addObject("resp","success");
			JsonUtil.print(mv.getModel(), printWriter); return;
		}
		mv.addObject("resp","error");
		JsonUtil.print(mv.getModel(), printWriter);
	}
}
