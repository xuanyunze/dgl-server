package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysResourceUsetypeService;
import com.rxoa.mypay.db.dao.in.ISysResourceUsetypeDao;
import com.rxoa.mypay.db.po.SysResourceUsetype;

/**
 * sys_resource_usetype Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysResourceUsetypeService")
public class SysResourceUsetypeService extends AbstractService<SysResourceUsetype> implements ISysResourceUsetypeService {
	@Resource(name="sysResourceUsetypeDao")
	private ISysResourceUsetypeDao dao;

	public SysResourceUsetypeService() {
		super();
	}
	@Override
	protected IOperations<SysResourceUsetype> getDao() {
		return this.dao;
	}

}

