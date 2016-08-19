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
import com.rxoa.mypay.db.po.DealChannel;
import com.rxoa.mypay.db.po.DealChannelMcc;
import com.rxoa.mypay.db.po.DealChannelMchinfo;
import com.rxoa.mypay.db.po.MbilAreacode;
import com.rxoa.mypay.db.service.in.IDealChannelMccService;
import com.rxoa.mypay.db.service.in.IDealChannelMchinfoService;
import com.rxoa.mypay.db.service.in.IDealChannelService;
import com.rxoa.mypay.db.service.in.IMbilAreacodeService;
import com.rxoa.mypay.sys.vo.RmchAddReqVo;
import com.rxoa.mypay.util.CodeUtil;

@Controller
@RequestMapping("/channel")
public class ChannelController {
	@Resource(name="dealChannelService")
	private IDealChannelService dealChannelService;
	@Resource(name="dealChannelMchinfoService")
	private IDealChannelMchinfoService dealChannelMchinfoService;
	@Resource(name="dealChannelMccService")
	private IDealChannelMccService dealChannelMccService;
	@Resource(name="mbilAreacodeService")
	private IMbilAreacodeService mbilAreacodeService;
	
	@RequestMapping(value="/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getChannelPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("channel/channel_page");
		return mv;
	}
	@RequestMapping(value="/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getChannelPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		PageView mpage = dealChannelService.findPage(web.prepare());
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.DealChannel");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		//String json = JsonUtil.genObjJson(mv.getModel());
		//mv.clear();
		//mv.addObject("mObject", json);
		//mv.setViewName("devmgr/mbil_user_device_unactived");
		JsonUtil.print(mv.getModel(), printWriter);
	}
	//商户信息
	@RequestMapping(value="/mch/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getChannelMchPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("channel/channel_mch_page");
		return mv;
	}
	@RequestMapping(value="/mch/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getChannelMchPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		PageView mpage = dealChannelMchinfoService.findPage(web.prepare());
		mpage.setBtnNew(true);
		mpage.setBtnCheckbox(true);
		//mpage.setBtnItemEdit(true);
		mpage.setBtnItemDel(true);
		//mpage.setBtnItemShow(true);
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.DealChannelMchinfo");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		//String json = JsonUtil.genObjJson(mv.getModel());
		//mv.clear();
		//mv.addObject("mObject", json);
		//mv.setViewName("devmgr/mbil_user_device_unactived");
		JsonUtil.print(mv.getModel(), printWriter);
	}
	@RequestMapping(value="/mch/add/{usetype}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getChannelMchAddJsp(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		List<DealChannel> channels = dealChannelService.findByCondition(" and 1=1");
		List<MbilAreacode> areas = mbilAreacodeService.findByCondition(" and acLevel='1'");
		mv.addObject("channels",channels);
		mv.addObject("areas",areas);
		mv.setViewName("channel/channel_mch_add");
		return mv;
	}
	@RequestMapping(value="/mch/save.json/{usetype}",method=RequestMethod.POST)
	@SessionPermission
	public void doChannelMchAddSave(HttpServletRequest req,@ModelAttribute("mObject") RmchAddReqVo reqVo,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		if(reqVo.checkData()){
			DealChannelMchinfo mch = new DealChannelMchinfo();
			mch.setNscmChlid(reqVo.getChlId());
			mch.setNscmRfeecode(reqVo.getChlMcc());
			mch.setNscmAreacode(reqVo.getMchAreacode());
			mch.setNscmRmchname(reqVo.getMchName());
			mch.setNscmRmid(reqVo.getMchMid());
			mch.setNscmRtid(reqVo.getMchTid());
			mch.setNscmRtsn(reqVo.getMchTsn());
			mch.setNscmRsignstat("0");
			mch.setNscmStat(Integer.parseInt(reqVo.getMchStat()));
			dealChannelMchinfoService.create(mch);
			mv.addObject("resp","success");JsonUtil.print(mv.getModel(), printWriter);return;
		}	
		mv.addObject("resp","error");
		JsonUtil.print(mv.getModel(), printWriter);
	}
	@RequestMapping(value="/mch/dict/{dtype}/{usetype}/{channelid}",method=RequestMethod.GET)
	@SessionPermission
	public void getChannelMcc(HttpServletRequest req,@PathVariable String usetype,@PathVariable String dtype,@PathVariable String channelid,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		if(dtype.equals("mcc")){
			List<DealChannelMcc> mccs = dealChannelMccService.findByCondition(" and cfeeChannelid='"+channelid+"' and cfeeStat='1'");
			mv.addObject("mccs",mccs);
		}else if(dtype.equals("city")){
			List<MbilAreacode> cities = mbilAreacodeService.findByCondition(" and acPcode='"+channelid+"'");
			mv.addObject("cities",cities);
		}
		JsonUtil.print(mv.getModel(), printWriter);
	}
	//MCC信息
	@RequestMapping(value="/mcc/page/{usetype}/{curpage}/{psize}",method=RequestMethod.GET)
	@SessionPermission
	public ModelAndView getChannelMccPageJsp(HttpServletRequest req,@PathVariable String curpage,
	@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("channel/channel_mcc_page");
		return mv;
	}
	@RequestMapping(value="/mcc/page.json/{usetype}/{curpage}/{psize}",method=RequestMethod.POST)
	@SessionPermission
	public void getChannelMccPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
		@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter){
		ModelAndView mv = new ModelAndView();
		PageView mpage = dealChannelMccService.findPage(web.prepare());
		List<Map<String,String>> varObject = CodeUtil.getPoFields("com.rxoa.mypay.db.po.DealChannelMcc");
		PageStyle pStyle = PageStyle.getInstance();
		pStyle.getTableStyle().initColStyleByFields(varObject);
		mv.addObject("pStyle",pStyle);
		mv.addObject("mObject", mpage);
		//String json = JsonUtil.genObjJson(mv.getModel());
		//mv.clear();
		//mv.addObject("mObject", json);
		//mv.setViewName("devmgr/mbil_user_device_unactived");
		JsonUtil.print(mv.getModel(), printWriter);
	}
}
