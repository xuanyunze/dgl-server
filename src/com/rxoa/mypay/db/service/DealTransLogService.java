package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IDealTransLogService;
import com.rxoa.mypay.db.dao.in.IDealTransLogDao;
import com.rxoa.mypay.db.po.DealTransLog;

/**
 * deal_trans_log Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("dealTransLogService")
public class DealTransLogService extends AbstractService<DealTransLog> implements IDealTransLogService {
	@Resource(name="dealTransLogDao")
	private IDealTransLogDao dao;

	public DealTransLogService() {
		super();
	}
	@Override
	protected IOperations<DealTransLog> getDao() {
		return this.dao;
	}

}

