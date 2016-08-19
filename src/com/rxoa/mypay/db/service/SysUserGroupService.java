package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysUserGroupService;
import com.rxoa.mypay.db.dao.in.ISysUserGroupDao;
import com.rxoa.mypay.db.po.SysUserGroup;

/**
 * sys_user_group Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysUserGroupService")
public class SysUserGroupService extends AbstractService<SysUserGroup> implements ISysUserGroupService {
	@Resource(name="sysUserGroupDao")
	private ISysUserGroupDao dao;

	public SysUserGroupService() {
		super();
	}
	@Override
	protected IOperations<SysUserGroup> getDao() {
		return this.dao;
	}

}

