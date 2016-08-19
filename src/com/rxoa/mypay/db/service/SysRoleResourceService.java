package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysRoleResourceService;
import com.rxoa.mypay.db.dao.in.ISysRoleResourceDao;
import com.rxoa.mypay.db.po.SysRoleResource;

/**
 * sys_role_resource Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysRoleResourceService")
public class SysRoleResourceService extends AbstractService<SysRoleResource> implements ISysRoleResourceService {
	@Resource(name="sysRoleResourceDao")
	private ISysRoleResourceDao dao;

	public SysRoleResourceService() {
		super();
	}
	@Override
	protected IOperations<SysRoleResource> getDao() {
		return this.dao;
	}

}

