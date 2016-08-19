package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IDictBlistCardService;
import com.rxoa.mypay.db.dao.in.IDictBlistCardDao;
import com.rxoa.mypay.db.po.DictBlistCard;

/**
 * dict_blist_card Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("dictBlistCardService")
public class DictBlistCardService extends AbstractService<DictBlistCard> implements IDictBlistCardService {
	@Resource(name="dictBlistCardDao")
	private IDictBlistCardDao dao;

	public DictBlistCardService() {
		super();
	}
	@Override
	protected IOperations<DictBlistCard> getDao() {
		return this.dao;
	}

}

