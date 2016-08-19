package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysPoolService;
import com.rxoa.mypay.db.dao.in.ISysPoolDao;
import com.rxoa.mypay.db.po.SysPool;

/**
 * sys_pool Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysPoolService")
public class SysPoolService extends AbstractService<SysPool> implements ISysPoolService {
	@Resource(name="sysPoolDao")
	private ISysPoolDao dao;

	public SysPoolService() {
		super();
	}
	@Override
	protected IOperations<SysPool> getDao() {
		return this.dao;
	}

}

