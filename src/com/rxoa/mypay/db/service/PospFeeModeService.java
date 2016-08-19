package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IPospFeeModeService;
import com.rxoa.mypay.db.dao.in.IPospFeeModeDao;
import com.rxoa.mypay.db.po.PospFeeMode;

/**
 * posp_fee_mode Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("pospFeeModeService")
public class PospFeeModeService extends AbstractService<PospFeeMode> implements IPospFeeModeService {
	@Resource(name="pospFeeModeDao")
	private IPospFeeModeDao dao;

	public PospFeeModeService() {
		super();
	}
	@Override
	protected IOperations<PospFeeMode> getDao() {
		return this.dao;
	}

}

