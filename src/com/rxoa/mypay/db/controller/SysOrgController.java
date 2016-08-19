package com.rxoa.mypay.db.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rxoa.mypay.util.CodeUtil;
import com.rxoa.mypay.util.StringUtil;
import com.rxoa.mypay.sys.auth.SessionMgr;
import com.rxoa.mypay.sys.auth.SysAuthChecker;
import com.rxoa.mypay.sys.service.OrgService;
import com.rxoa.mypay.sys.vo.OrgAddReqVo;
import com.rxoa.mypay.base.auth.SessionPermission;
import com.rxoa.mypay.base.security.SessionEntity;
import com.rxoa.mypay.base.util.JsonUtil;
import com.rxoa.mypay.base.view.PageView;
import com.rxoa.mypay.base.view.PageWeb;
import com.rxoa.mypay.base.view.PageStyle;
import com.rxoa.mypay.db.service.in.IBasePointerService;
import com.rxoa.mypay.db.service.in.IMbilBusiFeeOrgService;
import com.rxoa.mypay.db.service.in.IMbilBusiSettleOrgService;
import com.rxoa.mypay.db.service.in.IMbilFeecodeService;
import com.rxoa.mypay.db.service.in.IMbilSettlecateService;
import com.rxoa.mypay.db.service.in.IPospCrmEnterpriseService;
import com.rxoa.mypay.db.service.in.IPospCrmPersonService;
import com.rxoa.mypay.db.service.in.IPospCrmStudioService;
import com.rxoa.mypay.db.service.in.IPospFeeMccService;
import com.rxoa.mypay.db.service.in.ISysOrgService;
import com.rxoa.mypay.db.po.BasePointer;
import com.rxoa.mypay.db.po.MbilBusiFeeOrg;
import com.rxoa.mypay.db.po.MbilBusiSettleOrg;
import com.rxoa.mypay.db.po.PospCrmEnterprise;
import com.rxoa.mypay.db.po.PospCrmPerson;
import com.rxoa.mypay.db.po.PospCrmStudio;
import com.rxoa.mypay.db.po.SysOrg;
import com.rxoa.mypay.db.query.HibQueryMgr;

/**
 * sys_org Controller控制器类
 * Wed Mar 11 15:11:52 CST 2015 baiyu
 */ 

@Controller
@RequestMapping("/dbmgr/sysorg")
public class SysOrgController {
	private String basedir = "dbmgr";
	@Resource(name="sysOrgService")
	private ISysOrgService mService;

	@Resource(name="orgService")
	private OrgService orgService;
	
	@Resource(name="pospCrmPersonService")
	private IPospCrmPersonService pospCrmPersonService;
	@Resource(name="pospCrmEnterpriseService")
	private IPospCrmEnterpriseService pospCrmEnterpriseService;
	@Resource(name="pospCrmStudioService")
	private IPospCrmStudioService pospCrmStudioService;
	
	@Resource(name="pospFeeMccService")
	private IPospFeeMccService pospFeeMccService;
	
	@Resource(name="basePointerService")
	private IBasePointerService basePointerService;
	
	@Resource(name="mbilBusiFeeOrgService")
	private IMbilBusiFeeOrgService mbilBusiFeeOrgService;
	@Resource(name="mbilBusiSettleOrgService")
	private IMbilBusiSettleOrgService mbilBusiSettleOrgService;
	
	@Resource(name="mbilSettlecateService")
	private IMbilSettlecateService mbilSettlecateService;
	@Resource(name="mbilFeecodeService")
	private IMbilFeecodeService mbilFeecodeService;
	
	
	@RequestMapping(value="/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_org_page", printWriter, usetype, 1);
		getPage(mv,null,curpage,psize,printWriter,usetype,0);
		return mv;
	}

	@RequestMapping(value="/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_org_page", printWriter, usetype, 1);
		getPageData(req,mv,web,curpage,psize,printWriter,usetype,1);
	}

	@RequestMapping(value="/search/{usetype}",method=RequestMethod.GET)
	@SessionPermission
	public void getSearchJsp(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_org_search", printWriter, usetype, 1);
		getSearch(mv,printWriter,usetype,0);
	}

	@RequestMapping(value="/search.json/{usetype}",method=RequestMethod.POST)
	@SessionPermission
	public void getSearchJson(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_org_search", printWriter, usetype, 1);
		doSearch(mv,printWriter,usetype,1);
	}

	@RequestMapping(value="/add/{usetype}/{orgid}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getNewJsp(HttpServletRequest req,@PathVariable String orgid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_org_add", printWriter, usetype, 1);
		getCreate(mv,orgid,printWriter,usetype,0);
		return mv;
	}

	@RequestMapping(value="/add.json/{usetype}/{orgid}",method=RequestMethod.GET)
	@SessionPermission
	public void getAddJson(HttpServletRequest req,@PathVariable String orgid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_org_add", printWriter, usetype, 1);
		getCreate(mv,orgid,printWriter,usetype,1);
	}

	@RequestMapping(value="/save.json/{usetype}",method=RequestMethod.POST)
	@SessionPermission
	public void execSaveJson(HttpServletRequest req,@ModelAttribute("mObject") OrgAddReqVo mObject,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_org_save", printWriter, usetype, 1);
		doSave(mv,mObject,printWriter,usetype,1);
	}

	@RequestMapping(value="/del.json/{usetype}/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public void execDelJson(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_org_del", printWriter, usetype, 1);
		doDelete(mv,unid,printWriter,usetype,0);
	}

	@RequestMapping(value="/edit/{usetype}/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getEditJsp(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_org_edit", printWriter, usetype, 1);
		getEdit(mv,unid,null,usetype,0);
		return mv;
	}

	@RequestMapping(value="/edit.json/{usetype}/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public void getEditJson(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_org_update", printWriter, usetype, 1);
		getEdit(mv,unid,printWriter,usetype,1);
	}

	@RequestMapping(value="/update.json/{usetype}/{unid}",method=RequestMethod.POST)
	@SessionPermission
	public void execUpdateJson(HttpServletRequest req,@ModelAttribute("mObject") OrgAddReqVo mObject,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_org_update", printWriter, usetype, 1);
		doUpdate(mv,mObject,unid,printWriter,usetype,1);
	}

	@RequestMapping(value="/show/{usetype}/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getShowJsp(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_org_show", printWriter, usetype, 1);
		showDetail(mv,unid,printWriter,usetype,0);
		return mv;
	}

	@RequestMapping(value="/show.json/{usetype}/{unid}",method=RequestMethod.GET)
	@SessionPermission
	public void getShowJson(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		//SysAuthChecker.doMethodAuthCheck(req,mv,"sys_org_show", printWriter, usetype, 1);
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
			mv.setViewName(basedir+"/sys_org_page");
		}else if(resType==1){
		}
	}

	public void getPageData(HttpServletRequest req,ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		PageView mpage = mService.findPage(web.prepare());
		SessionEntity session = SessionMgr.getCurSession(req);
		String curorg = web.getCateString().substring(web.getCateString().indexOf("'")+1,web.getCateString().lastIndexOf("'"));
		if(session.getUserType().equals("1")
				||((session.getUserType().equals("2")||session.getUserType().equals("3"))&&session.getOrgId().equals(curorg))){
			mpage.setBtnNew(true);
			mpage.setBtnCheckbox(true);
			mpage.setBtnItemEdit(true);
			mpage.setBtnItemDel(true);
			mpage.setBtnItemShow(true);
		}
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.SysOrg");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		if(resType==0){
			String json = JsonUtil.genObjJson(mv.getModel());
			mv.clear();
			mv.addObject("mObject", json);
			mv.setViewName(basedir+"/sys_org_page");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}

	public void getCreate(ModelAndView mv,String targetorg,PrintWriter printWriter,String useType,int resType){
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.SysOrg");
		SysOrg org = mService.findOneByCondition(" and oid = '"+targetorg+"'");
		mv.addObject("targetoid",targetorg);
		mv.addObject("targetoname",org.getOname());
		mv.addObject("targetotype",org.getOtype());
		mv.addObject("subpath","sysorg");
		mv.addObject("varObject",varObject);
		if(resType==0){
			mv.setViewName(basedir+"/sys_org_add");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}
	@Transactional
	public void doSave(ModelAndView mv,OrgAddReqVo mObject,PrintWriter printWriter,String useType,int resType){
		int result = 1;
		try{
			SysOrg org = new SysOrg();
			String newoid = orgService.genOrgId(mObject.getOparentid());
			if(StringUtil.isDbNull(newoid)){JsonUtil.print(mv.getModel(), printWriter);return;}
			org.setCreTime(new Date());
			org.setOid(newoid);
			org.setOname(mObject.getOname());
			org.setOnamebref(mObject.getOnamebref());
			org.setOparentid(mObject.getOparentid());
			org.setOweight(mObject.getOweight());
			String relform = mObject.getOrelform();
			if(mObject.getOtype().equals("1")||mObject.getOtype().equals("2")){
				
			}else{
				String idtype = "POSP_CRM_PCOM";
				String formid = "";
				
				if(relform.equals("1")){
					idtype = "POSP_CRM_PPER";
					formid = getEntityId(idtype);
					PospCrmPerson person = new PospCrmPerson();
					person.setCreTime(new Date());
					person.setPperName(mObject.getPperName());
					person.setPperIdcard(mObject.getPperIdcard());
					person.setPperPhone(mObject.getPperPhone());
					person.setPperOrgid(newoid);
					person.setPperId(formid);
					//person.setPperFeecode(feecode);
					person.setPperBankaccname(mObject.getPperBankaccname());
					person.setPperBankaccno(mObject.getPperBankaccno());
					person.setPperBankname(mObject.getPperBankname());
					person.setPperBankno(mObject.getPperBankno());
					person.setPperBankbranch(mObject.getPperBankbranch());
					person.setPperBankdistr(mObject.getPperBankdistr());
					person.setPperStat("0");
					pospCrmPersonService.create(person);
				}else if(relform.equals("2")){
					idtype = "POSP_CRM_PCOM";
					formid = getEntityId(idtype);
					PospCrmEnterprise enterprise = new PospCrmEnterprise();
					enterprise.setCreTime(new Date());
					enterprise.setPcomName(mObject.getPcomName());
					enterprise.setPcomCode(mObject.getPcomCode());
					enterprise.setPcomLawname(mObject.getPcomLawname());
					enterprise.setPcomLawidcard(mObject.getPcomLawidcard());
					enterprise.setPcomLawphone(mObject.getPcomLawphone());
					enterprise.setPcomFinname(mObject.getPcomFinname());
					enterprise.setPcomFinphone(mObject.getPcomFinphone());
					enterprise.setPcomOrgid(newoid);
					enterprise.setPcomId(formid);
					//enterprise.setPcomFeecode(feecode);
					enterprise.setPcomBankaccname(mObject.getPcomBankaccname());
					enterprise.setPcomBankaccno(mObject.getPcomBankaccno());
					enterprise.setPcomBankname(mObject.getPcomBankname());
					enterprise.setPcomBankno(mObject.getPcomBankno());
					enterprise.setPcomBankbranch(mObject.getPcomBankbranch());
					enterprise.setPcomBankdistr(mObject.getPcomBankdistr());
					enterprise.setPcomStat("0");
					pospCrmEnterpriseService.create(enterprise);
				}else if(relform.equals("3")){
					idtype = "POSP_CRM_PSTU";
					formid = getEntityId(idtype);
					PospCrmStudio studio = new PospCrmStudio();
					studio.setCreTime(new Date());
					studio.setPstuName(mObject.getPstuName());
					studio.setPstuCode(mObject.getPstuCode());
					studio.setPstuLawname(mObject.getPstuLawName());
					studio.setPstuLawidcard(mObject.getPstuLawidcard());
					studio.setPstuLawphone(mObject.getPstuLawPhone());
					studio.setPstuOrgid(newoid);
					studio.setPstuId(formid);
					//studio.setPstuFeecode(feecode);
					studio.setPstuBankaccname(mObject.getPstuBankaccname());
					studio.setPstuBankaccno(mObject.getPstuBankaccno());
					studio.setPstuBankname(mObject.getPstuBankname());
					studio.setPstuBankno(mObject.getPstuBankno());
					studio.setPstuBankbranch(mObject.getPstuBankbranch());
					studio.setPstuBankdistr(mObject.getPstuBankdistr());
					studio.setPstuStat("0");
					pospCrmStudioService.create(studio);
				}
				org.setOrelform(relform);
				org.setOrelid(formid);
			}
			org.setOtype(mObject.getOtype());
			mService.create(org);
			SysOrg iorg = mService.findOneByCondition(" and oid='"+org.getOid()+"'");
			String path = HibQueryMgr.getQueryContext().getOrgtrack(org.getOid());
			if(path!=null){
				String[] vpath = path.split("#\\*#");
				iorg.setOpathtrack(vpath[0]);
				iorg.setOpathname(vpath[1]);
			}
			mService.update(iorg);
			createCode(mObject,newoid,relform);
			result = 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		mv.addObject("result",result);
		JsonUtil.print(mv.getModel(), printWriter);
	}
	@Transactional
	public void doDelete(ModelAndView mv,String unid,PrintWriter printWriter,String useType,int resType){
		String result = "1";
		try{
			SysOrg org = mService.findOne(unid);
			if(org!=null){
				mbilBusiFeeOrgService.updateHql("delete MbilBusiFeeOrg where bsofOid='"+org.getOid()+"'");
				mbilBusiSettleOrgService.updateHql("delete MbilBusiSettleOrg where bsosOid='"+org.getOid()+"'");
				if(org.getOrelform().equals("1")){
					pospCrmPersonService.updateHql("delete PospCrmPerson where pperOrgid='"+org.getOid()+"'");
				}else if(org.getOrelform().equals("2")){
					pospCrmEnterpriseService.updateHql("delete PospCrmEnterprise where pcomOrgid='"+org.getOid()+"'");
				}else if(org.getOrelform().equals("3")){
					pospCrmStudioService.updateHql("delete PospCrmStudio where pstuOrgid='"+org.getOid()+"'");
				}
				mService.deleteByIdReal(unid);
				result = "0";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		mv.addObject("result",result);
		if(resType==0){
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}

	public void getEdit(ModelAndView mv,String unid,PrintWriter printWriter,String useType,int resType){
		SysOrg org = mService.findOne(unid);
		//String feecode = "default";
		if(org.getOrelform().equals("1")){
			PospCrmPerson person = pospCrmPersonService.findOneByCondition(" and pperOrgid='"+org.getOid()+"'");
			//if(!(person.getPperFeecode()==null||person.getPperFeecode().equals("null")||person.getPperFeecode().equals(""))){
			//	feecode = person.getPperFeecode();
			//}
			mv.addObject("mPerson", person);
		}else if(org.getOrelform().equals("2")){
			PospCrmEnterprise enterprise = pospCrmEnterpriseService.findOneByCondition(" and pcomOrgid='"+org.getOid()+"'");
			//if(!(enterprise.getPcomFeecode()==null||enterprise.getPcomFeecode().equals("null")||enterprise.getPcomFeecode().equals(""))){
			//	feecode = enterprise.getPcomFeecode();
			//}
			mv.addObject("mEnterprise", enterprise);
		}else if(org.getOrelform().equals("3")){
			PospCrmStudio studio = pospCrmStudioService.findOneByCondition(" and pstuOrgid='"+org.getOid()+"'");
			//if(!(studio.getPstuFeecode()==null||studio.getPstuFeecode().equals("null")||studio.getPstuFeecode().equals(""))){
			//	feecode = studio.getPstuFeecode();
			//}
			mv.addObject("mStudio", studio);
		}
		//if(feecode.equals("default")){
			//mv.addObject("feetype","2");
		//}else{
			//mv.addObject("feetype","1");
		//}
		List<MbilBusiFeeOrg> list = mbilBusiFeeOrgService.findByCondition(" and bsofOid='"+org.getOid()+"'");
		Map<String,MbilBusiFeeOrg> map = new HashMap<String,MbilBusiFeeOrg>();
		for(int i=0;i<list.size();i++){
			map.put(list.get(i).getBsofFeeid(),list.get(i));
		}
		mv.addObject("mFee",map);
		List<MbilBusiSettleOrg> slist = mbilBusiSettleOrgService.findByCondition(" and bsosOid='"+org.getOid()+"'");
		Map<String,MbilBusiSettleOrg> smap = new HashMap<String,MbilBusiSettleOrg>();
		for(int i=0;i<slist.size();i++){
			smap.put(slist.get(i).getBsosFeeid(), slist.get(i));
		}
		mv.addObject("mSettle",smap);
		mv.addObject("mOrg",org);
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.SysOrg");
		mv.addObject("subpath","sysorg");
		mv.addObject("varObject",varObject);
		
		if(resType==0){
			mv.setViewName(basedir+"/sys_org_edit");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}
	@Transactional
	public void doUpdate(ModelAndView mv,OrgAddReqVo mObject,String unid,PrintWriter printWriter,String useType,int resType){
		int result = 1;
		try{
			SysOrg org = mService.findOne(unid);
			String oid = org.getOid();
			org.setModTime(new Date());
			org.setOname(mObject.getOname());
			org.setOnamebref(mObject.getOnamebref());
			org.setOweight(mObject.getOweight());
			String path = HibQueryMgr.getQueryContext().getOrgtrack(oid);
			if(path!=null){
				String[] vpath = path.split("#\\*#");
				org.setOpathtrack(vpath[0]);
				org.setOpathname(vpath[1]);
			}
			if(org.getOtype().equals("1")||org.getOtype().equals("2")){
				
			}else{
				//String feecode = "default";
				mbilBusiFeeOrgService.updateHql("delete MbilBusiFeeOrg where bsofOid='"+org.getOid()+"'");
				mbilBusiSettleOrgService.updateHql("delete MbilBusiSettleOrg where bsosOid='"+org.getOid()+"'");
				
				String relform = mObject.getOrelform();
				createCode(mObject,oid,relform);
				
				if(relform.equals("1")){
					PospCrmPerson person = pospCrmPersonService.findOneByCondition(" and pperId='"+mObject.getOrelformId()+"'");
					person.setModTime(new Date());
					person.setPperName(mObject.getPperName());
					person.setPperIdcard(mObject.getPperIdcard());
					person.setPperPhone(mObject.getPperPhone());
					person.setPperOrgid(oid);

					//person.setPperFeecode(feecode);
					person.setPperBankaccname(mObject.getPperBankaccname());
					person.setPperBankaccno(mObject.getPperBankaccno());
					person.setPperBankname(mObject.getPperBankname());
					person.setPperBankno(mObject.getPperBankno());
					person.setPperBankbranch(mObject.getPperBankbranch());
					person.setPperBankdistr(mObject.getPperBankdistr());
					pospCrmPersonService.update(person);
				}else if(relform.equals("2")){
					PospCrmEnterprise enterprise = pospCrmEnterpriseService.findOneByCondition(" and pcomId='"+mObject.getOrelformId()+"'");
					enterprise.setModTime(new Date());
					enterprise.setPcomName(mObject.getPcomName());
					enterprise.setPcomCode(mObject.getPcomCode());
					enterprise.setPcomLawname(mObject.getPcomLawname());
					enterprise.setPcomLawidcard(mObject.getPcomLawidcard());
					enterprise.setPcomLawphone(mObject.getPcomLawphone());
					enterprise.setPcomFinname(mObject.getPcomFinname());
					enterprise.setPcomFinphone(mObject.getPcomFinphone());
					enterprise.setPcomOrgid(oid);
					
					//enterprise.setPcomFeecode(feecode);
					enterprise.setPcomBankaccname(mObject.getPcomBankaccname());
					enterprise.setPcomBankaccno(mObject.getPcomBankaccno());
					enterprise.setPcomBankname(mObject.getPcomBankname());
					enterprise.setPcomBankno(mObject.getPcomBankno());
					enterprise.setPcomBankbranch(mObject.getPcomBankbranch());
					enterprise.setPcomBankdistr(mObject.getPcomBankdistr());
					pospCrmEnterpriseService.update(enterprise);
				}else if(relform.equals("3")){
					PospCrmStudio studio = pospCrmStudioService.findOneByCondition(" and pstuId='"+mObject.getOrelformId()+"'");
					studio.setModTime(new Date());
					studio.setPstuName(mObject.getPstuName());
					studio.setPstuCode(mObject.getPstuCode());
					studio.setPstuLawname(mObject.getPstuLawName());
					studio.setPstuLawidcard(mObject.getPstuLawidcard());
					studio.setPstuLawphone(mObject.getPstuLawPhone());
					studio.setPstuOrgid(oid);
					
					//studio.setPstuFeecode(feecode);
					studio.setPstuBankaccname(mObject.getPstuBankaccname());
					studio.setPstuBankaccno(mObject.getPstuBankaccno());
					studio.setPstuBankname(mObject.getPstuBankname());
					studio.setPstuBankno(mObject.getPstuBankno());
					studio.setPstuBankbranch(mObject.getPstuBankbranch());
					studio.setPstuBankdistr(mObject.getPstuBankdistr());
					pospCrmStudioService.update(studio);
				}
			}
			org.setOtype(mObject.getOtype());
			mService.update(org);
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
		SysOrg org = mService.findOne(unid);
		//String feecode = "default";
		if(org.getOrelform().equals("1")){
			PospCrmPerson person = pospCrmPersonService.findOneByCondition(" and pperOrgid='"+org.getOid()+"'");
			//if(!(person.getPperFeecode()==null||person.getPperFeecode().equals("null")||person.getPperFeecode().equals(""))){
				//feecode = person.getPperFeecode();
			//}
			mv.addObject("mPerson", person);
		}else if(org.getOrelform().equals("2")){
			PospCrmEnterprise enterprise = pospCrmEnterpriseService.findOneByCondition(" and pcomOrgid='"+org.getOid()+"'");
			//if(!(enterprise.getPcomFeecode()==null||enterprise.getPcomFeecode().equals("null")||enterprise.getPcomFeecode().equals(""))){
				//feecode = enterprise.getPcomFeecode();
			//}
			mv.addObject("mEnterprise", enterprise);
		}else if(org.getOrelform().equals("3")){
			PospCrmStudio studio = pospCrmStudioService.findOneByCondition(" and pstuOrgid='"+org.getOid()+"'");
			//if(!(studio.getPstuFeecode()==null||studio.getPstuFeecode().equals("null")||studio.getPstuFeecode().equals(""))){
				//feecode = studio.getPstuFeecode();
			//}
			mv.addObject("mStudio", studio);
		}
		//if(feecode.equals("default")){
			//mv.addObject("feetype","2");
		//}else{
			//mv.addObject("feetype","1");
		//}
		List<MbilBusiFeeOrg> list = mbilBusiFeeOrgService.findByCondition(" and bsofOid='"+org.getOid()+"'");
		Map<String,MbilBusiFeeOrg> map = new HashMap<String,MbilBusiFeeOrg>();
		for(int i=0;i<list.size();i++){
			map.put(list.get(i).getBsofFeeid(),list.get(i));
		}
		mv.addObject("mFee",map);
		List<MbilBusiSettleOrg> slist = mbilBusiSettleOrgService.findByCondition(" and bsosOid='"+org.getOid()+"'");
		Map<String,MbilBusiSettleOrg> smap = new HashMap<String,MbilBusiSettleOrg>();
		for(int i=0;i<slist.size();i++){
			smap.put(slist.get(i).getBsosFeeid(), slist.get(i));
		}
		mv.addObject("mSettle",smap);
		
		mv.addObject("mOrg",org);
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.SysOrg");
		mv.addObject("subpath","sysorg");
		mv.addObject("varObject",varObject);
		
		if(resType==0){
			mv.setViewName(basedir+"/sys_org_show");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}
	public String getEntityId(String entityName){
		try{
			BasePointer pointer = (BasePointer) basePointerService.findOneByCondition(" and pt_name='"+entityName+"'");
			if(pointer!=null){
				String newid = Long.parseLong(pointer.getPtValue())+Long.parseLong(pointer.getPtStep())+"";
				pointer.setPtValue(newid);
				basePointerService.update(pointer);
				return newid;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public void createCode(OrgAddReqVo mObject,String newoid,String relform){
		if(StringUtil.isDbNull(mObject.getFeeMsfwValue())) mObject.setFeeMsfwValue("0.0040");
		if(StringUtil.isDbNull(mObject.getFeeDMsfwValue())) mObject.setFeeMsfwValue("1.00");
		if(StringUtil.isDbNull(mObject.getFeeMsfwTop())) mObject.setFeeMsfwTop("0.00");
		if(StringUtil.isDbNull(mObject.getFeeMsfwAnnx())) mObject.setFeeMsfwAnnx("0.00");
		if(StringUtil.isDbNull(mObject.getFeeBmbhValue())) mObject.setFeeBmbhValue("0.0060");
		if(StringUtil.isDbNull(mObject.getFeeDBmbhValue())) mObject.setFeeBmbhValue("1.00");
		if(StringUtil.isDbNull(mObject.getFeeBmbhTop())) mObject.setFeeBmbhTop("0.00");
		if(StringUtil.isDbNull(mObject.getFeeBmbhAnnx())) mObject.setFeeBmbhAnnx("0.00");
		if(StringUtil.isDbNull(mObject.getFeeDzpfValue())) mObject.setFeeDzpfValue("1.00");
		if(StringUtil.isDbNull(mObject.getFeeDDzpfValue())) mObject.setFeeDDzpfValue("1.00");
		if(StringUtil.isDbNull(mObject.getFeeDzpfTop())) mObject.setFeeDzpfTop("30.00");
		if(StringUtil.isDbNull(mObject.getFeeDzpfAnnx())) mObject.setFeeDzpfAnnx("0.00");
		if(StringUtil.isDbNull(mObject.getFeeS0Value())) mObject.setFeeS0Value("0.0040");
		if(StringUtil.isDbNull(mObject.getFeeDS0Value())) mObject.setFeeDS0Value("1.00");
		if(StringUtil.isDbNull(mObject.getFeeS0Top())) mObject.setFeeS0Top("0.00");
		if(StringUtil.isDbNull(mObject.getFeeS0Annx())) mObject.setFeeS0Annx("0.00");
		
		if(StringUtil.isDbNull(mObject.getSettleT0Value())) mObject.setSettleT0Value("0.0020");
		if(StringUtil.isDbNull(mObject.getSettleT0DValue())) mObject.setSettleT0DValue("1.00");
		if(StringUtil.isDbNull(mObject.getSettleD0Value())) mObject.setSettleD0Value("0.0020");
		if(StringUtil.isDbNull(mObject.getSettleD0DValue())) mObject.setSettleD0DValue("1.00");
		if(StringUtil.isDbNull(mObject.getSettleS0Value())) mObject.setSettleS0Value("0.0020");
		if(StringUtil.isDbNull(mObject.getSettleS0DValue())) mObject.setSettleS0DValue("1.00");
		
		MbilBusiFeeOrg feeMsfw = new MbilBusiFeeOrg();
		MbilBusiFeeOrg feeBmbh = new MbilBusiFeeOrg();
		MbilBusiFeeOrg feeDzpf = new MbilBusiFeeOrg();
		MbilBusiFeeOrg feeS0 = new MbilBusiFeeOrg();
		
		MbilBusiSettleOrg settleT0 = new MbilBusiSettleOrg();
		MbilBusiSettleOrg settleD0 = new MbilBusiSettleOrg();
		MbilBusiSettleOrg settleS0 = new MbilBusiSettleOrg();
				
		feeMsfw.setBsofOid(newoid);
		feeMsfw.setBsofFeeid(mObject.getFeeMsfwid());
		feeMsfw.setBsofRate(Double.parseDouble(mObject.getFeeMsfwValue()));
		feeMsfw.setBsofDrate(Double.parseDouble(mObject.getFeeDMsfwValue()));
			
		feeBmbh.setBsofOid(newoid);
		feeBmbh.setBsofFeeid(mObject.getFeeBmbhid());
		feeBmbh.setBsofRate(Double.parseDouble(mObject.getFeeBmbhValue()));
		feeBmbh.setBsofDrate(Double.parseDouble(mObject.getFeeDBmbhValue()));
			
		feeDzpf.setBsofOid(newoid);
		feeDzpf.setBsofFeeid(mObject.getFeeDzpfid());
		feeDzpf.setBsofIstop(1);
		feeDzpf.setBsofRate(Double.parseDouble(mObject.getFeeDzpfValue()));
		feeDzpf.setBsofToprate(Double.parseDouble(mObject.getFeeDzpfTop()));
		feeDzpf.setBsofDrate(Double.parseDouble(mObject.getFeeDDzpfValue()));
			
		feeS0.setBsofOid(newoid);
		feeS0.setBsofFeeid(mObject.getFeeS0id());
		feeS0.setBsofRate(Double.parseDouble(mObject.getFeeS0Value()));
		feeS0.setBsofDrate(Double.parseDouble(mObject.getFeeDS0Value()));
		
		settleT0.setBsosOid(newoid);
		settleT0.setBsosFeeid(mObject.getSettleT0id());
		settleT0.setBsosRate(Double.parseDouble(mObject.getSettleT0Value()));
		settleT0.setBsosDrate(Double.parseDouble(mObject.getSettleT0DValue()));
			
		settleD0.setBsosOid(newoid);
		settleD0.setBsosFeeid(mObject.getSettleD0id());
		settleD0.setBsosRate(Double.parseDouble(mObject.getSettleD0Value()));
		settleD0.setBsosDrate(Double.parseDouble(mObject.getSettleD0DValue()));
			
		settleS0.setBsosOid(newoid);
		settleS0.setBsosFeeid(mObject.getSettleS0id());
		settleS0.setBsosRate(Double.parseDouble(mObject.getSettleS0Value()));
		settleS0.setBsosDrate(Double.parseDouble(mObject.getSettleS0DValue()));
		
		mbilBusiFeeOrgService.create(feeMsfw);
		mbilBusiFeeOrgService.create(feeBmbh);
		mbilBusiFeeOrgService.create(feeDzpf);
		mbilBusiFeeOrgService.create(feeS0);
		
		mbilBusiSettleOrgService.create(settleT0);
		mbilBusiSettleOrgService.create(settleD0);
		mbilBusiSettleOrgService.create(settleS0);
		
		//更新分润路径
		String f_mstrack = HibQueryMgr.getQueryContext().getDistributionInfo(newoid, mObject.getFeeMsfwid());
		String f_bmtrack = HibQueryMgr.getQueryContext().getDistributionInfo(newoid, mObject.getFeeBmbhid());
		String f_pftrack = HibQueryMgr.getQueryContext().getDistributionInfo(newoid, mObject.getFeeDzpfid());
		String f_s0track = HibQueryMgr.getQueryContext().getDistributionInfo(newoid, mObject.getFeeS0id());
		
		String t0track = HibQueryMgr.getQueryContext().getTakemoneyDistrInfo(newoid, mObject.getSettleT0id());
		String d0track = HibQueryMgr.getQueryContext().getTakemoneyDistrInfo(newoid, mObject.getSettleD0id());
		String s0track = HibQueryMgr.getQueryContext().getTakemoneyDistrInfo(newoid, mObject.getSettleS0id());
		//System.out.println(mstrack);
		//System.out.println(bmtrack);
		//System.out.println(pftrack);
		//System.out.println(t0track);
		//System.out.println(d0track);
		
		MbilBusiFeeOrg f_msfee = mbilBusiFeeOrgService.findOneByCondition(" and bsofOid ='"+newoid+"' and bsofFeeid='"+mObject.getFeeMsfwid()+"'");
		MbilBusiFeeOrg f_bmfee = mbilBusiFeeOrgService.findOneByCondition(" and bsofOid ='"+newoid+"' and bsofFeeid='"+mObject.getFeeBmbhid()+"'");
		MbilBusiFeeOrg f_pffee = mbilBusiFeeOrgService.findOneByCondition(" and bsofOid ='"+newoid+"' and bsofFeeid='"+mObject.getFeeDzpfid()+"'");
		MbilBusiFeeOrg f_s0fee = mbilBusiFeeOrgService.findOneByCondition(" and bsofOid ='"+newoid+"' and bsofFeeid='"+mObject.getFeeS0id()+"'");
		
		MbilBusiSettleOrg t0fee = mbilBusiSettleOrgService.findOneByCondition(" and bsosOid='"+newoid+"' and bsosFeeid='"+mObject.getSettleT0id()+"'");
		MbilBusiSettleOrg d0fee = mbilBusiSettleOrgService.findOneByCondition(" and bsosOid='"+newoid+"' and bsosFeeid='"+mObject.getSettleD0id()+"'");
		MbilBusiSettleOrg s0fee = mbilBusiSettleOrgService.findOneByCondition(" and bsosOid='"+newoid+"' and bsosFeeid='"+mObject.getSettleS0id()+"'");
		//System.out.println(msfee.getBsofFeeid());
		//System.out.println(bmfee.getBsofFeeid());
		//System.out.println(pffee.getBsofFeeid());
		
		//System.out.println(t0fee.getBsosFeeid());
		//System.out.println(t0fee.getBsosFeeid());
		
		f_msfee.setBsofDistrack(f_mstrack);
		f_bmfee.setBsofDistrack(f_bmtrack);
		f_pffee.setBsofDistrack(f_pftrack);
		f_s0fee.setBsofDistrack(f_s0track);
		
		t0fee.setBsosDistrack(t0track);
		d0fee.setBsosDistrack(d0track);
		s0fee.setBsosDistrack(s0track);
		
		mbilBusiFeeOrgService.update(f_msfee);
		mbilBusiFeeOrgService.update(f_bmfee);
		mbilBusiFeeOrgService.update(f_pffee);
		mbilBusiFeeOrgService.update(f_s0fee);
		
		mbilBusiSettleOrgService.update(t0fee);
		mbilBusiSettleOrgService.update(d0fee);
		mbilBusiSettleOrgService.update(s0fee);
	}
}

