package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IDealTransService;
import com.rxoa.mypay.db.dao.in.IDealTransDao;
import com.rxoa.mypay.db.po.DealTrans;

/**
 * deal_trans Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("dealTransService")
public class DealTransService extends AbstractService<DealTrans> implements IDealTransService {
	@Resource(name="dealTransDao")
	private IDealTransDao dao;

	public DealTransService() {
		super();
	}
	@Override
	protected IOperations<DealTrans> getDao() {
		return this.dao;
	}

}

