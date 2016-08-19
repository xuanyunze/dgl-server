package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IDictBlistIdcardService;
import com.rxoa.mypay.db.dao.in.IDictBlistIdcardDao;
import com.rxoa.mypay.db.po.DictBlistIdcard;

/**
 * dict_blist_idcard Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("dictBlistIdcardService")
public class DictBlistIdcardService extends AbstractService<DictBlistIdcard> implements IDictBlistIdcardService {
	@Resource(name="dictBlistIdcardDao")
	private IDictBlistIdcardDao dao;

	public DictBlistIdcardService() {
		super();
	}
	@Override
	protected IOperations<DictBlistIdcard> getDao() {
		return this.dao;
	}

}

