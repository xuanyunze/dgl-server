package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IDictBlistPhoneService;
import com.rxoa.mypay.db.dao.in.IDictBlistPhoneDao;
import com.rxoa.mypay.db.po.DictBlistPhone;

/**
 * dict_blist_phone Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("dictBlistPhoneService")
public class DictBlistPhoneService extends AbstractService<DictBlistPhone> implements IDictBlistPhoneService {
	@Resource(name="dictBlistPhoneDao")
	private IDictBlistPhoneDao dao;

	public DictBlistPhoneService() {
		super();
	}
	@Override
	protected IOperations<DictBlistPhone> getDao() {
		return this.dao;
	}

}

