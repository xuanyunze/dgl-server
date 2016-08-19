package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IBasePointerService;
import com.rxoa.mypay.db.dao.in.IBasePointerDao;
import com.rxoa.mypay.db.po.BasePointer;

/**
 * base_pointer Service服务类
 * Tue Apr 05 11:23:26 CST 2016 baiyu
 */ 

@Service("basePointerService")
public class BasePointerService extends AbstractService<BasePointer> implements IBasePointerService {
	@Resource(name="basePointerDao")
	private IBasePointerDao dao;

	public BasePointerService() {
		super();
	}
	@Override
	protected IOperations<BasePointer> getDao() {
		return this.dao;
	}

}

