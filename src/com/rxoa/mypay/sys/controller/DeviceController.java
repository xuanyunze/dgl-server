package com.rxoa.mypay.sys.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.rxoa.mypay.db.po.MbilDevice;
import com.rxoa.mypay.db.po.SysOrg;
import com.rxoa.mypay.db.query.HibQueryMgr;
import com.rxoa.mypay.db.service.in.IMbilDeviceService;
import com.rxoa.mypay.db.service.in.ISysOrgService;
import com.rxoa.mypay.sys.auth.SessionMgr;
import com.rxoa.mypay.sys.auth.SysAuthChecker;
import com.rxoa.mypay.sys.service.OrgService;
import com.rxoa.mypay.sys.vo.DeviceBatchReqVo;
import com.rxoa.mypay.sys.vo.DevicelistRespVo;
import com.rxoa.mypay.sys.vo.OrglistRespVo;
import com.rxoa.mypay.sys.vo.QueryDeviceReqVo;
import com.rxoa.mypay.util.CodeUtil;
import com.rxoa.mypay.util.StringUtil;

@Controller
@RequestMapping("/device")
public class DeviceController {
	@Resource(name="mbilDeviceService")
	private IMbilDeviceService mbilDeviceService;
	@Resource(name="sysOrgService")
	private ISysOrgService oService;
	@Resource(name="orgService")
	private OrgService orgService;
	
	@RequestMapping(value="/unactived/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_device_page", printWriter, usetype, 1);
		getPage(mv,null,curpage,psize,printWriter,usetype,0);
		return mv;
	}
	@RequestMapping(value="/unactived/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		SysAuthChecker.doMethodAuthCheck(req,mv,"mbil_device_page_unactived", printWriter, usetype, 1);
		getPageData(mv,web,curpage,psize,printWriter,usetype,1);
	}
	public void getPage(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		if(resType==0){
			mv.setViewName("devmgr/mbil_device_page_unactived");
		}else if(resType==1){
		}
	}
	public void getPageData(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType){
		web.setHqlCondition(" and (deOrg='' or deOrg='null' or deOrg=null)");
		PageView mpage = mbilDeviceService.findPage(web.prepare());
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.MbilDevice");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		if(resType==0){
			String json = JsonUtil.genObjJson(mv.getModel());
			mv.clear();
			mv.addObject("mObject", json);
			mv.setViewName("devmgr/mbil_user_device_unactived");
		}else if(resType==1){
			JsonUtil.print(mv.getModel(), printWriter);
		}
	}
	@RequestMapping(value="/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getDevicePageJsp(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		String dtype = SessionMgr.getCurSession(req).getUserType();
		String oid = SessionMgr.getCurSession(req).getOrgId();
		List<OrglistRespVo> list = null;
		SysOrg porg = null;
		if(dtype.equals("1")){
			list = HibQueryMgr.getQueryContext().getOrglist("1011", false);
			porg = oService.findOneByCondition(" and oid='1011'");
		}else{
			list = HibQueryMgr.getQueryContext().getOrglist(oid, false);
			porg = oService.findOneByCondition(" and oid='"+oid+"'");
		}
		OrglistRespVo vo = new OrglistRespVo();
		vo.setOid(porg.getOid());
		vo.setOname(porg.getOname());
		vo.setObref(porg.getOnamebref());
		vo.setOparentid(porg.getOparentid());
		list.add(0,vo);
		mv.addObject("olist",list);
		mv.setViewName("devmgr/mbil_device_page");
		return mv;
	}
	@RequestMapping(value="/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getDevicePageJson(HttpServletRequest req,QueryDeviceReqVo qReqVo,PageWeb web,
			@PathVariable String curpage,@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		int start = (Integer.parseInt(curpage)-1)*Integer.parseInt(psize);int count = 0;int dtype = 1;
		PageView pageview = null;
		List<DevicelistRespVo> list = new ArrayList<DevicelistRespVo>();
		String utype = SessionMgr.getCurSession(req).getUserType();
		String oid =  SessionMgr.getCurSession(req).getOrgId();
		String qstat = "",ostat = "";
		if(!StringUtil.isDbNull(qReqVo.getStartDate())){qstat+=" and date(device.cre_time)>='"+qReqVo.getStartDate()+"'";}
		if(!StringUtil.isDbNull(qReqVo.getEndDate())){qstat+=" and date(device.cre_time)<='"+qReqVo.getEndDate()+"'";}
		if(!StringUtil.isDbNull(qReqVo.getDeSn())){qstat+=" and device.de_sn like '%"+qReqVo.getDeSn()+"%'";}
		if(!StringUtil.isDbNull(qReqVo.getDeType())&&!qReqVo.getDeType().equals("all")){qstat+=" and device.de_type='"+qReqVo.getDeType()+"'";}
		if(!StringUtil.isDbNull(qReqVo.getDeStat())&&!qReqVo.getDeStat().equals("all")){qstat+=" and device.de_stat='"+qReqVo.getDeStat()+"'";}
		if(!StringUtil.isDbNull(qReqVo.getOrgName())){qstat+=" and org.o_pathname like '%"+qReqVo.getOrgName()+"%'";}
		if(!StringUtil.isDbNull(qReqVo.getUid())){qstat+=" and device.de_uid like '%"+qReqVo.getUid()+"%'";}
		
		if(utype.equals("2")||utype.equals("3")){
			ostat = " and find_in_set('"+oid+"',org.o_pathtrack)";dtype = 0;
		}
		qstat+=ostat;
		String querySql = "from mbil_device as device left join sys_org as org on org.o_id=device.de_org where device.stat=0"+qstat+" order by device.cre_time desc";
		count = HibQueryMgr.getQueryContext().getCount("select count(*) "+querySql);
		list = HibQueryMgr.getQueryContext().getDevicelist("select * "+querySql+" limit "+start+","+psize,dtype);
		pageview = PageView.wrap(list, count,Integer.parseInt(curpage), Integer.parseInt(psize));
		mv.addObject("pStyle","");
		mv.addObject("mObject",pageview);
		JsonUtil.print(mv.getModel(), printWriter);
	}
	@RequestMapping(value="/batch/{usetype}/{orgid}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getBatchDeviceJsp(HttpServletRequest req,@PathVariable String orgid,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		String dtype = SessionMgr.getCurSession(req).getUserType();
		String oid = SessionMgr.getCurSession(req).getOrgId();
		if(orgid.equals("1000")){
			List<OrglistRespVo> list = null;
			SysOrg porg = null;
			if(dtype.equals("1")){
				list = HibQueryMgr.getQueryContext().getOrglist("1011", false);
				porg = oService.findOneByCondition(" and oid='1011'");
			}else{
				list = HibQueryMgr.getQueryContext().getOrglist(oid, false);
				porg = oService.findOneByCondition(" and oid='"+oid+"'");
			}
			OrglistRespVo vo = new OrglistRespVo();
			vo.setOid(porg.getOid());
			vo.setOname(porg.getOname());
			vo.setObref(porg.getOnamebref());
			vo.setOparentid(porg.getOparentid());
			list.add(0,vo);
			mv.addObject("list",list);
			mv.addObject("usetype","1");
		}else{
			SysOrg org = oService.findOneByCondition(" and oid = '"+orgid+"'");
			mv.addObject("usetype","0");
			mv.addObject("targetoid",orgid);
			mv.addObject("targetoname",org.getOname());
		}
		if(dtype.equals("1")){
			mv.setViewName("devmgr/mbil_device_batch");
		}else{
			mv.setViewName("devmgr/mbil_device_batch_agent");
		}
		return mv;
	}
	@RequestMapping(value="/batch/save.json/{usetype}",method=RequestMethod.POST)
	@SessionPermission
	public void doBatchDeviceOper(HttpServletRequest req,DeviceBatchReqVo mObject,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		String uoid = SessionMgr.getCurSession(req).getOrgId();
		SysOrg org = oService.findOneByCondition(" and oid = '"+uoid+"'");
		boolean isAgent = true;
		if(org.getOtype().equals("1")||org.getOtype().equals("2")){
			isAgent = false;
		}
		String success = "";String fail = "";
		try{
			String inType = mObject.getInType();
			String deType = mObject.getDeType();
			String startSn = mObject.getStartSn();
			String endSn = mObject.getEndSn();
			String anySn = mObject.getAnySn();
			String deOrg = mObject.getDeOrg();
			if(StringUtil.isDbNull(deOrg)){deOrg = mObject.getDeOrgNew();System.out.println("ccc");}
			String preSn = mObject.getPreSn();
			String snNum = mObject.getSnNum();
			List<String> sns = new ArrayList<String>();
			if(!StringUtil.isDbNull(startSn)&&!StringUtil.isDbNull(endSn)
					&&!StringUtil.isDbNull(preSn)&&!StringUtil.isDbNull(snNum)){
				int start = Integer.parseInt(startSn);
				int end = Integer.parseInt(endSn);
				int len = Integer.parseInt(snNum);
				for(int i=start;i<=end;i++){
					String psn = preSn+StringUtil.appendLeft(i+"", "0", len);
					if(!StringUtil.isDbNull(psn)){
						sns.add(psn);
					}
				}
			}
			if(!StringUtil.isDbNull(anySn)){
				String[] vsn = anySn.split(",");
				for(int i=0;i<vsn.length;i++){
					if(!StringUtil.isDbNull(vsn[i])&&!StringUtil.isDbNull(vsn[i].trim())){
						sns.add(vsn[i]);
					}
				}
			}
			
			if(sns!=null&&sns.size()>0){
				if(inType.equals("1")&&isAgent==false){
					Iterator<String> it = sns.iterator();
					while(it.hasNext()){
						String sn = (String) it.next();
						try{
							MbilDevice de = mbilDeviceService.findOneByCondition(" and deSn = '"+sn+"'");
							if(de==null){
								MbilDevice nde = new MbilDevice();
								String tid = genDeviceTid();
								nde.setDeSn(sn.trim().replace("\\r\\n", ""));
								nde.setDeOrg(deOrg);
								nde.setDeTid(tid);
								nde.setDeType(deType);
								nde.setCreAuthor(SessionMgr.getCurSession(req).getUserId());
								mbilDeviceService.create(nde);
								success+=","+sn;
							}else{
								fail+=","+sn;
							}
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}else if(inType.equals("2")){
					Iterator<String> it = sns.iterator();
					while(it.hasNext()){
						String sn = (String) it.next();
						try{
							MbilDevice de = mbilDeviceService.findOneByCondition(" and deSn = '"+sn.trim().replace("\\r\\n", "")+"' and deStat = '0' and (deUid='' or deUid='null' or deUid is null) and stat='0'");
							if(de!=null){
								if(isAgent){
									if(!StringUtil.isDbNull(de.getDeOrg())
											&&!de.getDeOrg().equals("1010")&&!de.getDeOrg().equals("1011")
											&&orgService.isSubOrg(uoid, de.getDeOrg())){
										de.setDeOrg(deOrg);
										de.setModAuthor(SessionMgr.getCurSession(req).getUserId());
										mbilDeviceService.update(de);
										success+=","+sn;
									}else{
										fail+=","+sn;
									}
								}else{
									de.setDeOrg(deOrg);
									de.setModAuthor(SessionMgr.getCurSession(req).getUserId());
									mbilDeviceService.update(de);
									success+=","+sn;
								}
							}else{
								fail+=","+sn;
							}
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}else if(inType.equals("3")){
					Iterator<String> it = sns.iterator();
					while(it.hasNext()){
						String sn = (String) it.next();
						try{
							MbilDevice de = mbilDeviceService.findOneByCondition(" and deSn = '"+sn.trim().replace("\\r\\n", "")+"'");
							if(de!=null){
								if(isAgent){
									if(!StringUtil.isDbNull(de.getDeOrg())
											&&!de.getDeOrg().equals("1010")&&!de.getDeOrg().equals("1011")
											&&orgService.isSubOrg(uoid, de.getDeOrg())){
										de.setDeUid("");
										de.setDeStat("0");
										de.setModAuthor(SessionMgr.getCurSession(req).getUserId());
										mbilDeviceService.update(de);
										success+=","+sn;
									}else{
										fail+=","+sn;
									}
								}else{
									de.setDeUid("");
									de.setDeStat("0");
									de.setModAuthor(SessionMgr.getCurSession(req).getUserId());
									mbilDeviceService.update(de);
									success+=","+sn;
								}
							}else{
								fail+=","+sn;
							}
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}else if(inType.equals("4")){
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		mv.addObject("fail",fail);
		mv.addObject("success",success);
		JsonUtil.print(mv.getModel(), printWriter);
	}
	public String genDeviceTid(){
		String randCode = "10000001";
		try{
			MbilDevice device = mbilDeviceService.findOneByCondition(" order by deTid desc");
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
