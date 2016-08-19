package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IDealTransProfitService;
import com.rxoa.mypay.db.dao.in.IDealTransProfitDao;
import com.rxoa.mypay.db.po.DealTransProfit;

/**
 * deal_trans_profit Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("dealTransProfitService")
public class DealTransProfitService extends AbstractService<DealTransProfit> implements IDealTransProfitService {
	@Resource(name="dealTransProfitDao")
	private IDealTransProfitDao dao;

	public DealTransProfitService() {
		super();
	}
	@Override
	protected IOperations<DealTransProfit> getDao() {
		return this.dao;
	}

}

