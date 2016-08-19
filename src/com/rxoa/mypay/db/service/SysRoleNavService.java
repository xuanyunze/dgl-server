package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysRoleNavService;
import com.rxoa.mypay.db.dao.in.ISysRoleNavDao;
import com.rxoa.mypay.db.po.SysRoleNav;

/**
 * sys_role_nav Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysRoleNavService")
public class SysRoleNavService extends AbstractService<SysRoleNav> implements ISysRoleNavService {
	@Resource(name="sysRoleNavDao")
	private ISysRoleNavDao dao;

	public SysRoleNavService() {
		super();
	}
	@Override
	protected IOperations<SysRoleNav> getDao() {
		return this.dao;
	}

}

