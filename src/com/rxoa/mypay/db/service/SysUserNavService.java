package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysUserNavService;
import com.rxoa.mypay.db.dao.in.ISysUserNavDao;
import com.rxoa.mypay.db.po.SysUserNav;

/**
 * sys_user_nav Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysUserNavService")
public class SysUserNavService extends AbstractService<SysUserNav> implements ISysUserNavService {
	@Resource(name="sysUserNavDao")
	private ISysUserNavDao dao;

	public SysUserNavService() {
		super();
	}
	@Override
	protected IOperations<SysUserNav> getDao() {
		return this.dao;
	}

}

