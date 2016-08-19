package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IDealMchGroupService;
import com.rxoa.mypay.db.dao.in.IDealMchGroupDao;
import com.rxoa.mypay.db.po.DealMchGroup;

/**
 * deal_mch_group Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("dealMchGroupService")
public class DealMchGroupService extends AbstractService<DealMchGroup> implements IDealMchGroupService {
	@Resource(name="dealMchGroupDao")
	private IDealMchGroupDao dao;

	public DealMchGroupService() {
		super();
	}
	@Override
	protected IOperations<DealMchGroup> getDao() {
		return this.dao;
	}

}

