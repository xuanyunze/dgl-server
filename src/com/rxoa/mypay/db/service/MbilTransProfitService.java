package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilTransProfitService;
import com.rxoa.mypay.db.dao.in.IMbilTransProfitDao;
import com.rxoa.mypay.db.po.MbilTransProfit;

/**
 * mbil_trans_profit Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilTransProfitService")
public class MbilTransProfitService extends AbstractService<MbilTransProfit> implements IMbilTransProfitService {
	@Resource(name="mbilTransProfitDao")
	private IMbilTransProfitDao dao;

	public MbilTransProfitService() {
		super();
	}
	@Override
	protected IOperations<MbilTransProfit> getDao() {
		return this.dao;
	}

}

