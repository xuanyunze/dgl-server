package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilOrderTransaccountService;
import com.rxoa.mypay.db.dao.in.IMbilOrderTransaccountDao;
import com.rxoa.mypay.db.po.MbilOrderTransaccount;

/**
 * mbil_order_transaccount Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilOrderTransaccountService")
public class MbilOrderTransaccountService extends AbstractService<MbilOrderTransaccount> implements IMbilOrderTransaccountService {
	@Resource(name="mbilOrderTransaccountDao")
	private IMbilOrderTransaccountDao dao;

	public MbilOrderTransaccountService() {
		super();
	}
	@Override
	protected IOperations<MbilOrderTransaccount> getDao() {
		return this.dao;
	}

}

