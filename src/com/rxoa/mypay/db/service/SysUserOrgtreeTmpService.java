package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysUserOrgtreeTmpService;
import com.rxoa.mypay.db.dao.in.ISysUserOrgtreeTmpDao;
import com.rxoa.mypay.db.po.SysUserOrgtreeTmp;

/**
 * sys_user_orgtree_tmp Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysUserOrgtreeTmpService")
public class SysUserOrgtreeTmpService extends AbstractService<SysUserOrgtreeTmp> implements ISysUserOrgtreeTmpService {
	@Resource(name="sysUserOrgtreeTmpDao")
	private ISysUserOrgtreeTmpDao dao;

	public SysUserOrgtreeTmpService() {
		super();
	}
	@Override
	protected IOperations<SysUserOrgtreeTmp> getDao() {
		return this.dao;
	}

}

