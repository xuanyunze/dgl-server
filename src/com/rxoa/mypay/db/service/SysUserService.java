package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysUserService;
import com.rxoa.mypay.db.dao.in.ISysUserDao;
import com.rxoa.mypay.db.po.SysUser;

/**
 * sys_user Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysUserService")
public class SysUserService extends AbstractService<SysUser> implements ISysUserService {
	@Resource(name="sysUserDao")
	private ISysUserDao dao;

	public SysUserService() {
		super();
	}
	@Override
	protected IOperations<SysUser> getDao() {
		return this.dao;
	}

}

