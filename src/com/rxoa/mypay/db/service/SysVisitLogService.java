package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysVisitLogService;
import com.rxoa.mypay.db.dao.in.ISysVisitLogDao;
import com.rxoa.mypay.db.po.SysVisitLog;

/**
 * sys_visit_log Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysVisitLogService")
public class SysVisitLogService extends AbstractService<SysVisitLog> implements ISysVisitLogService {
	@Resource(name="sysVisitLogDao")
	private ISysVisitLogDao dao;

	public SysVisitLogService() {
		super();
	}
	@Override
	protected IOperations<SysVisitLog> getDao() {
		return this.dao;
	}

}

