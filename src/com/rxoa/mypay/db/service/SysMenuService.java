package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysMenuService;
import com.rxoa.mypay.db.dao.in.ISysMenuDao;
import com.rxoa.mypay.db.po.SysMenu;

/**
 * sys_menu Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysMenuService")
public class SysMenuService extends AbstractService<SysMenu> implements ISysMenuService {
	@Resource(name="sysMenuDao")
	private ISysMenuDao dao;

	public SysMenuService() {
		super();
	}
	@Override
	protected IOperations<SysMenu> getDao() {
		return this.dao;
	}

}

