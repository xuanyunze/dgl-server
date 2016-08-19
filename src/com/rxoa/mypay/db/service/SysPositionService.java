package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysPositionService;
import com.rxoa.mypay.db.dao.in.ISysPositionDao;
import com.rxoa.mypay.db.po.SysPosition;

/**
 * sys_position Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysPositionService")
public class SysPositionService extends AbstractService<SysPosition> implements ISysPositionService {
	@Resource(name="sysPositionDao")
	private ISysPositionDao dao;

	public SysPositionService() {
		super();
	}
	@Override
	protected IOperations<SysPosition> getDao() {
		return this.dao;
	}

}

