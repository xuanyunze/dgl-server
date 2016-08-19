package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IDealConfigService;
import com.rxoa.mypay.db.dao.in.IDealConfigDao;
import com.rxoa.mypay.db.po.DealConfig;

/**
 * deal_config Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("dealConfigService")
public class DealConfigService extends AbstractService<DealConfig> implements IDealConfigService {
	@Resource(name="dealConfigDao")
	private IDealConfigDao dao;

	public DealConfigService() {
		super();
	}
	@Override
	protected IOperations<DealConfig> getDao() {
		return this.dao;
	}

}

