package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilOrderChargeaccountService;
import com.rxoa.mypay.db.dao.in.IMbilOrderChargeaccountDao;
import com.rxoa.mypay.db.po.MbilOrderChargeaccount;

/**
 * mbil_order_chargeaccount Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilOrderChargeaccountService")
public class MbilOrderChargeaccountService extends AbstractService<MbilOrderChargeaccount> implements IMbilOrderChargeaccountService {
	@Resource(name="mbilOrderChargeaccountDao")
	private IMbilOrderChargeaccountDao dao;

	public MbilOrderChargeaccountService() {
		super();
	}
	@Override
	protected IOperations<MbilOrderChargeaccount> getDao() {
		return this.dao;
	}

}

