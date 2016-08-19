package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysRoleService;
import com.rxoa.mypay.db.dao.in.ISysRoleDao;
import com.rxoa.mypay.db.po.SysRole;

/**
 * sys_role Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysRoleService")
public class SysRoleService extends AbstractService<SysRole> implements ISysRoleService {
	@Resource(name="sysRoleDao")
	private ISysRoleDao dao;

	public SysRoleService() {
		super();
	}
	@Override
	protected IOperations<SysRole> getDao() {
		return this.dao;
	}

}

