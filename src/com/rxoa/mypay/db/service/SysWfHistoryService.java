package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.ISysWfHistoryService;
import com.rxoa.mypay.db.dao.in.ISysWfHistoryDao;
import com.rxoa.mypay.db.po.SysWfHistory;

/**
 * sys_wf_history Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("sysWfHistoryService")
public class SysWfHistoryService extends AbstractService<SysWfHistory> implements ISysWfHistoryService {
	@Resource(name="sysWfHistoryDao")
	private ISysWfHistoryDao dao;

	public SysWfHistoryService() {
		super();
	}
	@Override
	protected IOperations<SysWfHistory> getDao() {
		return this.dao;
	}

}

