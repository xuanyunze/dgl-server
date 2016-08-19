package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysUserNavTmpService;
import com.rxoa.mypay.db.dao.in.ISysUserNavTmpDao;
import com.rxoa.mypay.db.po.SysUserNavTmp;

/**
 * sys_user_nav_tmp Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysUserNavTmpService")
public class SysUserNavTmpService extends AbstractService<SysUserNavTmp> implements ISysUserNavTmpService {
	@Resource(name="sysUserNavTmpDao")
	private ISysUserNavTmpDao dao;

	public SysUserNavTmpService() {
		super();
	}
	@Override
	protected IOperations<SysUserNavTmp> getDao() {
		return this.dao;
	}

}

