package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysRoleRoleService;
import com.rxoa.mypay.db.dao.in.ISysRoleRoleDao;
import com.rxoa.mypay.db.po.SysRoleRole;

/**
 * sys_role_role Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysRoleRoleService")
public class SysRoleRoleService extends AbstractService<SysRoleRole> implements ISysRoleRoleService {
	@Resource(name="sysRoleRoleDao")
	private ISysRoleRoleDao dao;

	public SysRoleRoleService() {
		super();
	}
	@Override
	protected IOperations<SysRoleRole> getDao() {
		return this.dao;
	}

}

