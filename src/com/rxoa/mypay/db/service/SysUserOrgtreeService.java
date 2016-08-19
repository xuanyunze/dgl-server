package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysUserOrgtreeService;
import com.rxoa.mypay.db.dao.in.ISysUserOrgtreeDao;
import com.rxoa.mypay.db.po.SysUserOrgtree;

/**
 * sys_user_orgtree Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysUserOrgtreeService")
public class SysUserOrgtreeService extends AbstractService<SysUserOrgtree> implements ISysUserOrgtreeService {
	@Resource(name="sysUserOrgtreeDao")
	private ISysUserOrgtreeDao dao;

	public SysUserOrgtreeService() {
		super();
	}
	@Override
	protected IOperations<SysUserOrgtree> getDao() {
		return this.dao;
	}

}

