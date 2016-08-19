package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysNavigationService;
import com.rxoa.mypay.db.dao.in.ISysNavigationDao;
import com.rxoa.mypay.db.po.SysNavigation;

/**
 * sys_navigation Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysNavigationService")
public class SysNavigationService extends AbstractService<SysNavigation> implements ISysNavigationService {
	@Resource(name="sysNavigationDao")
	private ISysNavigationDao dao;

	public SysNavigationService() {
		super();
	}
	@Override
	protected IOperations<SysNavigation> getDao() {
		return this.dao;
	}

}

