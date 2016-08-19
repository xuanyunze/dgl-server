package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilSettlecateService;
import com.rxoa.mypay.db.dao.in.IMbilSettlecateDao;
import com.rxoa.mypay.db.po.MbilSettlecate;

/**
 * mbil_settlecate Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilSettlecateService")
public class MbilSettlecateService extends AbstractService<MbilSettlecate> implements IMbilSettlecateService {
	@Resource(name="mbilSettlecateDao")
	private IMbilSettlecateDao dao;

	public MbilSettlecateService() {
		super();
	}
	@Override
	protected IOperations<MbilSettlecate> getDao() {
		return this.dao;
	}

}

