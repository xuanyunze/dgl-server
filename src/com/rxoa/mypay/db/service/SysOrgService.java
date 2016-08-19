package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysOrgService;
import com.rxoa.mypay.db.dao.in.ISysOrgDao;
import com.rxoa.mypay.db.po.SysOrg;

/**
 * sys_org Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysOrgService")
public class SysOrgService extends AbstractService<SysOrg> implements ISysOrgService {
	@Resource(name="sysOrgDao")
	private ISysOrgDao dao;

	public SysOrgService() {
		super();
	}
	@Override
	protected IOperations<SysOrg> getDao() {
		return this.dao;
	}

}

