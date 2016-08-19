package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilOrderReceivemoneyService;
import com.rxoa.mypay.db.dao.in.IMbilOrderReceivemoneyDao;
import com.rxoa.mypay.db.po.MbilOrderReceivemoney;

/**
 * mbil_order_receivemoney Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilOrderReceivemoneyService")
public class MbilOrderReceivemoneyService extends AbstractService<MbilOrderReceivemoney> implements IMbilOrderReceivemoneyService {
	@Resource(name="mbilOrderReceivemoneyDao")
	private IMbilOrderReceivemoneyDao dao;

	public MbilOrderReceivemoneyService() {
		super();
	}
	@Override
	protected IOperations<MbilOrderReceivemoney> getDao() {
		return this.dao;
	}

}

