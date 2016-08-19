package com.rxoa.mypay.sys.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.rxoa.mypay.base.BaseController;
import com.rxoa.mypay.base.view.PageWeb;
import com.rxoa.mypay.db.po.SysUser;
import com.rxoa.mypay.sys.auth.IPageController;

public class AuthorizeController extends BaseController implements IPageController{

	@Override
	public void getCreate(ModelAndView mv, PrintWriter printWriter,
			String useType, int resType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doSave(ModelAndView mv, SysUser mObject,
			PrintWriter printWriter, String useType, int resType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getEdit(ModelAndView mv, String unid, PrintWriter printWriter,
			String useType, int resType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doUpdate(ModelAndView mv, Object mObject, String unid,
			PrintWriter printWriter, String useType, int resType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showDetail(ModelAndView mv, String unid,
			PrintWriter printWriter, String useType, int resType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doDelete(ModelAndView mv, String unid, PrintWriter printWriter,
			String useType, int resType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPageData(ModelAndView mv, PageWeb web, String curpage,
			String psize, PrintWriter printWriter, String useType, int resType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPage(ModelAndView mv, PageWeb web, String curpage,
			String psize, PrintWriter printWriter, String useType, int resType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getSearch(ModelAndView mv, PrintWriter printWriter,
			String useType, int resType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doSearch(ModelAndView mv, PrintWriter printWriter,
			String useType, int resType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getShowJson(HttpServletRequest req, String unid,
			String usetype, PrintWriter printWriter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ModelAndView getShowJsp(HttpServletRequest req, String unid,
			String usetype, PrintWriter printWriter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView getEditJsp(HttpServletRequest req, String unid,
			String usetype, PrintWriter printWriter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getEditJson(HttpServletRequest req, String unid,
			String usetype, PrintWriter printWriter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execUpdateJson(HttpServletRequest req, Object mObject,
			String unid, String usetype, PrintWriter printWriter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execDelJson(HttpServletRequest req, String unid,
			String usetype, PrintWriter printWriter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ModelAndView getAddJsp(HttpServletRequest req, String usetype,
			PrintWriter printWriter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getAddJson(HttpServletRequest req, String usetype,
			PrintWriter printWriter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execSaveJson(HttpServletRequest req, SysUser mObject,
			String usetype, PrintWriter printWriter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getSearchJsp(HttpServletRequest req, String usetype,
			PrintWriter printWriter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getSearchJson(HttpServletRequest req, String usetype,
			PrintWriter printWriter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPageJson(HttpServletRequest req, PageWeb web,
			String curpage, String psize, String usetype,
			PrintWriter printWriter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ModelAndView getPageJsp(HttpServletRequest req, String curpage,
			String psize, String usetype, PrintWriter printWriter) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
