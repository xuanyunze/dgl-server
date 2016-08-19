package com.rxoa.mypay.sys.auth;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.rxoa.mypay.base.view.PageWeb;
import com.rxoa.mypay.db.po.SysUser;

public interface IPageController {
	abstract public void getCreate(ModelAndView mv,PrintWriter printWriter,String useType,int resType);
	abstract public void doSave(ModelAndView mv,SysUser mObject,PrintWriter printWriter,String useType,int resType);
	
	abstract public void getEdit(ModelAndView mv,String unid,PrintWriter printWriter,String useType,int resType);
	abstract public void doUpdate(ModelAndView mv,Object mObject,String unid,PrintWriter printWriter,String useType,int resType);
	
	abstract public void showDetail(ModelAndView mv,String unid,PrintWriter printWriter,String useType,int resType);
	abstract public void doDelete(ModelAndView mv,String unid,PrintWriter printWriter,String useType,int resType);
	
	abstract public void getPageData(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType);
	abstract public void getPage(ModelAndView mv,PageWeb web,String curpage,String psize,PrintWriter printWriter,String useType,int resType);
	
	abstract public void getSearch(ModelAndView mv,PrintWriter printWriter,String useType,int resType);
	abstract public void doSearch(ModelAndView mv,PrintWriter printWriter,String useType,int resType);

	abstract public void getShowJson(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter);
	abstract public ModelAndView getShowJsp(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter);
	
	abstract public ModelAndView getEditJsp(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter);
	abstract public void getEditJson(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter);
	abstract public void execUpdateJson(HttpServletRequest req,@ModelAttribute("mObject") Object mObject,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter);
	
	abstract public void execDelJson(HttpServletRequest req,@PathVariable String unid,@PathVariable String usetype,PrintWriter printWriter);

	abstract public ModelAndView getAddJsp(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter);
	abstract public void getAddJson(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter);
	abstract public void execSaveJson(HttpServletRequest req,@ModelAttribute("mObject") SysUser mObject,@PathVariable String usetype,PrintWriter printWriter);
	
	abstract public void getSearchJsp(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter);
	abstract public void getSearchJson(HttpServletRequest req,@PathVariable String usetype,PrintWriter printWriter);

	abstract public void getPageJson(HttpServletRequest req,@ModelAttribute("mObject") PageWeb web,@PathVariable String curpage,
			@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter);
	abstract public ModelAndView getPageJsp(HttpServletRequest req,@PathVariable String curpage,
			@PathVariable String psize,@PathVariable String usetype,PrintWriter printWriter);
}
