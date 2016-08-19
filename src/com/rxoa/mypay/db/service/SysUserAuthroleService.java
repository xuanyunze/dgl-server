package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysUserAuthroleService;
import com.rxoa.mypay.db.dao.in.ISysUserAuthroleDao;
import com.rxoa.mypay.db.po.SysUserAuthrole;

/**
 * sys_user_authrole Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysUserAuthroleService")
public class SysUserAuthroleService extends AbstractService<SysUserAuthrole> implements ISysUserAuthroleService {
	@Resource(name="sysUserAuthroleDao")
	private ISysUserAuthroleDao dao;

	public SysUserAuthroleService() {
		super();
	}
	@Override
	protected IOperations<SysUserAuthrole> getDao() {
		return this.dao;
	}

}

