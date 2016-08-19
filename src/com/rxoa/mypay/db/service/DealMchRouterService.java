package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IDealMchRouterService;
import com.rxoa.mypay.db.dao.in.IDealMchRouterDao;
import com.rxoa.mypay.db.po.DealMchRouter;

/**
 * deal_mch_router Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("dealMchRouterService")
public class DealMchRouterService extends AbstractService<DealMchRouter> implements IDealMchRouterService {
	@Resource(name="dealMchRouterDao")
	private IDealMchRouterDao dao;

	public DealMchRouterService() {
		super();
	}
	@Override
	protected IOperations<DealMchRouter> getDao() {
		return this.dao;
	}

}

