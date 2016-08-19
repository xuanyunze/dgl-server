package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysUserRoleService;
import com.rxoa.mypay.db.dao.in.ISysUserRoleDao;
import com.rxoa.mypay.db.po.SysUserRole;

/**
 * sys_user_role Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysUserRoleService")
public class SysUserRoleService extends AbstractService<SysUserRole> implements ISysUserRoleService {
	@Resource(name="sysUserRoleDao")
	private ISysUserRoleDao dao;

	public SysUserRoleService() {
		super();
	}
	@Override
	protected IOperations<SysUserRole> getDao() {
		return this.dao;
	}

}

