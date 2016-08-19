package com.rxoa.mypay.sys.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rxoa.mypay.base.BaseController;
import com.rxoa.mypay.base.auth.SessionPermission;
import com.rxoa.mypay.base.util.JsonUtil;
import com.rxoa.mypay.db.po.MbilBusiFeeOrg;
import com.rxoa.mypay.db.po.MbilBusiSettleOrg;
import com.rxoa.mypay.db.po.PospCrmEnterprise;
import com.rxoa.mypay.db.po.PospCrmPerson;
import com.rxoa.mypay.db.po.PospCrmStudio;
import com.rxoa.mypay.db.po.SysOrg;
import com.rxoa.mypay.db.service.in.IMbilBusiFeeOrgService;
import com.rxoa.mypay.db.service.in.IMbilBusiSettleOrgService;
import com.rxoa.mypay.db.service.in.IPospCrmEnterpriseService;
import com.rxoa.mypay.db.service.in.IPospCrmPersonService;
import com.rxoa.mypay.db.service.in.IPospCrmStudioService;
import com.rxoa.mypay.db.service.in.ISysOrgService;
import com.rxoa.mypay.sys.auth.SessionMgr;
import com.rxoa.mypay.sys.auth.SysAuthChecker;
import com.rxoa.mypay.sys.combx.OrgTreeEntity;
import com.rxoa.mypay.sys.service.OrgService;

@Controller
@RequestMapping("/org")
public class OrgController extends BaseController{
	@Resource(name="sysOrgService")
	private ISysOrgService sysOrgService;
	@Resource(name="mbilBusiFeeOrgService")
	private IMbilBusiFeeOrgService bsofService;
	@Resource(name="mbilBusiSettleOrgService")
	private IMbilBusiSettleOrgService bsosService;
	@Resource(name="pospCrmEnterpriseService")
	private IPospCrmEnterpriseService entService;
	@Resource(name="pospCrmPersonService")
	private IPospCrmPersonService perService;
	@Resource(name="pospCrmStudioService")
	private IPospCrmStudioService stuService;
	
	@Resource(name="orgService")
	private OrgService orgService;
	
	@RequestMapping(value="/showtree.json/{usetype}",method=RequestMethod.GET)
	@SessionPermission
	public void getOrgTreeJson(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter) {
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"m_org_showtree", printWriter, usetype, 1);
		String topid = "";
		String showtype = "direct";
		if(usetype.equals("all")){
			topid = "10";
			showtype = "all";
		}else if(usetype.equals("agency")||usetype.equals("oemhq")){
			topid = SessionMgr.getCurSession(req).getTopOrgId();
			showtype = "all";
		}else if(usetype.equals("agencyd")||usetype.equals("oemhqd")){
			topid = SessionMgr.getCurSession(req).getTopOrgId();
			showtype = "direct";
		}else if(usetype.equals("manage")){
				topid = SessionMgr.getCurSession(req).getTopOrgId();
				showtype = "all";
		}else if(usetype.equals("mmgr")){
			topid = "1010";
			showtype="all";
		}else if(usetype.equals("omgr")){
			topid = "1011";
			showtype="all";
		}else{
			topid = SessionMgr.getCurSession(req).getOrgId();
			showtype = "direct";
		}
		OrgTreeEntity tree = orgService.getTreeByTopNode(showtype, topid);
		mv.addObject("tree", tree);
		JsonUtil.print(mv.getModel(), printWriter);
	}
	
	@RequestMapping(value="/showtree/{usetype}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getOrgTreeJsp(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter) {
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"m_org_showtree", printWriter, usetype, 1);
		mv.setViewName("/combx/tree");
		return mv;
	}
	
	@RequestMapping(value="/orginfo/{usetype}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getOrgInfoJsp(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter) {
		ModelAndView mv = new ModelAndView();
		String oid = SessionMgr.getCurSession(req).getOrgId();
		SysOrg org = sysOrgService.findOneByCondition(" and oid='"+oid+"'");
		List<MbilBusiFeeOrg> fees = bsofService.findByCondition(" and bsofOid='"+oid+"'");
		List<MbilBusiSettleOrg> settles = bsosService.findByCondition(" and bsosOid='"+oid+"'");
		mv.addObject("org",org);
		mv.addObject("fees",fees);
		mv.addObject("settles",settles);
		if(org.getOrelform().equals("1")){
			PospCrmPerson form = perService.findOneByCondition(" and pperOrgid='"+oid+"'");
			mv.addObject("form",form);
		}else if(org.getOrelform().equals("2")){
			PospCrmEnterprise form = entService.findOneByCondition(" and pcomOrgid='"+oid+"'");
			mv.addObject("form",form);
		}else if(org.getOrelform().equals("3")){
			PospCrmStudio form = stuService.findOneByCondition(" and pstuOrgid='"+oid+"'");
			mv.addObject("form",form);
		}
		mv.setViewName("orgmgr/org_info_show");
		return mv;
	}
}
