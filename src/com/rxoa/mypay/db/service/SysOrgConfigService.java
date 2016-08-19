package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysOrgConfigService;
import com.rxoa.mypay.db.dao.in.ISysOrgConfigDao;
import com.rxoa.mypay.db.po.SysOrgConfig;

/**
 * sys_org_config Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysOrgConfigService")
public class SysOrgConfigService extends AbstractService<SysOrgConfig> implements ISysOrgConfigService {
	@Resource(name="sysOrgConfigDao")
	private ISysOrgConfigDao dao;

	public SysOrgConfigService() {
		super();
	}
	@Override
	protected IOperations<SysOrgConfig> getDao() {
		return this.dao;
	}

}

