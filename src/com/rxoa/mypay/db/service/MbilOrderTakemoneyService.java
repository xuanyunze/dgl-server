package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilOrderTakemoneyService;
import com.rxoa.mypay.db.dao.in.IMbilOrderTakemoneyDao;
import com.rxoa.mypay.db.po.MbilOrderTakemoney;

/**
 * mbil_order_takemoney Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilOrderTakemoneyService")
public class MbilOrderTakemoneyService extends AbstractService<MbilOrderTakemoney> implements IMbilOrderTakemoneyService {
	@Resource(name="mbilOrderTakemoneyDao")
	private IMbilOrderTakemoneyDao dao;

	public MbilOrderTakemoneyService() {
		super();
	}
	@Override
	protected IOperations<MbilOrderTakemoney> getDao() {
		return this.dao;
	}

}

