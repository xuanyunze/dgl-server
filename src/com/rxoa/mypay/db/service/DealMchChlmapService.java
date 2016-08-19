package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IDealMchChlmapService;
import com.rxoa.mypay.db.dao.in.IDealMchChlmapDao;
import com.rxoa.mypay.db.po.DealMchChlmap;

/**
 * deal_mch_chlmap Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("dealMchChlmapService")
public class DealMchChlmapService extends AbstractService<DealMchChlmap> implements IDealMchChlmapService {
	@Resource(name="dealMchChlmapDao")
	private IDealMchChlmapDao dao;

	public DealMchChlmapService() {
		super();
	}
	@Override
	protected IOperations<DealMchChlmap> getDao() {
		return this.dao;
	}

}

