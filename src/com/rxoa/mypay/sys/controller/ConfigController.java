package com.rxoa.mypay.sys.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rxoa.mypay.base.auth.SessionPermission;
import com.rxoa.mypay.base.util.JsonUtil;
import com.rxoa.mypay.db.po.DealConfig;
import com.rxoa.mypay.db.service.in.IDealConfigService;
import com.rxoa.mypay.util.StringUtil;

@Controller
@RequestMapping("/config")
public class ConfigController {
	@Resource(name="dealConfigService")
	private IDealConfigService dealConfigService;
	
	@RequestMapping("/dealconfig/edit/{usetype}")
	@SessionPermission
	public ModelAndView showConfigInfo(HttpServletRequest req,HttpServletResponse resp){
		ModelAndView mv = new ModelAndView();
		try{
			DealConfig dealConfig = dealConfigService.findOneByCondition(" and cfCode='deal'");
			mv.addObject("dealConfig",dealConfig);
			mv.setViewName("config/deal_config_edit");
		}catch(Exception e){
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("/dealconfig/save/{usetype}")
	@SessionPermission
	public void doChangeDealConfig(HttpServletRequest req,DealConfig mObject,PrintWriter printWriter){
		int result = 1;
		ModelAndView mv = new ModelAndView();
		try{
			if(StringUtil.isDbNull(mObject.getCfDt1zone())||StringUtil.isDbNull(mObject.getCfDs0zone())
					||StringUtil.isDbNull(mObject.getCfDt1perday())||StringUtil.isDbNull(mObject.getCfDs0perday())
					||StringUtil.isDbNull(mObject.getCfDt1pertran())||StringUtil.isDbNull(mObject.getCfDs0pertran())
					||mObject.getCfDt1zone().length()!=11||mObject.getCfDs0zone().length()!=11){
				result = 2;
			}else{
				DealConfig dealConfig = dealConfigService.findOneByCondition(" and cfCode='deal'");
				dealConfig.setCfDt1zone(mObject.getCfDt1zone());
				dealConfig.setCfDs0zone(mObject.getCfDs0zone());
				dealConfig.setCfDt1stat(mObject.getCfDt1stat());
				dealConfig.setCfDs0stat(mObject.getCfDs0stat());
				dealConfig.setCfDt1perday(mObject.getCfDt1perday());
				dealConfig.setCfDs0perday(mObject.getCfDs0perday());
				dealConfig.setCfDt1pertran(mObject.getCfDt1pertran());
				dealConfig.setCfDs0pertran(mObject.getCfDs0pertran());
				dealConfigService.update(dealConfig);
				result = 0;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		mv.addObject("result",result);
		JsonUtil.print(mv.getModel(), printWriter);
	}
}
