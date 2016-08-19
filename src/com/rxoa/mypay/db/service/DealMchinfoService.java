package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IDealMchinfoService;
import com.rxoa.mypay.db.dao.in.IDealMchinfoDao;
import com.rxoa.mypay.db.po.DealMchinfo;

/**
 * deal_mchinfo Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("dealMchinfoService")
public class DealMchinfoService extends AbstractService<DealMchinfo> implements IDealMchinfoService {
	@Resource(name="dealMchinfoDao")
	private IDealMchinfoDao dao;

	public DealMchinfoService() {
		super();
	}
	@Override
	protected IOperations<DealMchinfo> getDao() {
		return this.dao;
	}

}

