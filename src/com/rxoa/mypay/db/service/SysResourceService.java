package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysResourceService;
import com.rxoa.mypay.db.dao.in.ISysResourceDao;
import com.rxoa.mypay.db.po.SysResource;

/**
 * sys_resource Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysResourceService")
public class SysResourceService extends AbstractService<SysResource> implements ISysResourceService {
	@Resource(name="sysResourceDao")
	private ISysResourceDao dao;

	public SysResourceService() {
		super();
	}
	@Override
	protected IOperations<SysResource> getDao() {
		return this.dao;
	}

}

