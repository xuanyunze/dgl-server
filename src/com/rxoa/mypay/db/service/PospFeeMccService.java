package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IPospFeeMccService;
import com.rxoa.mypay.db.dao.in.IPospFeeMccDao;
import com.rxoa.mypay.db.po.PospFeeMcc;

/**
 * posp_fee_mcc Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("pospFeeMccService")
public class PospFeeMccService extends AbstractService<PospFeeMcc> implements IPospFeeMccService {
	@Resource(name="pospFeeMccDao")
	private IPospFeeMccDao dao;

	public PospFeeMccService() {
		super();
	}
	@Override
	protected IOperations<PospFeeMcc> getDao() {
		return this.dao;
	}

}

