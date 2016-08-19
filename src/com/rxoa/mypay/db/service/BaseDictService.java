package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IBaseDictService;
import com.rxoa.mypay.db.dao.in.IBaseDictDao;
import com.rxoa.mypay.db.po.BaseDict;

/**
 * base_dict Service服务类
 * Tue Apr 05 11:23:26 CST 2016 baiyu
 */ 

@Service("baseDictService")
public class BaseDictService extends AbstractService<BaseDict> implements IBaseDictService {
	@Resource(name="baseDictDao")
	private IBaseDictDao dao;

	public BaseDictService() {
		super();
	}
	@Override
	protected IOperations<BaseDict> getDao() {
		return this.dao;
	}

}

