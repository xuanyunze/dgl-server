package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilBanklistService;
import com.rxoa.mypay.db.dao.in.IMbilBanklistDao;
import com.rxoa.mypay.db.po.MbilBanklist;

/**
 * mbil_banklist Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("mbilBanklistService")
public class MbilBanklistService extends AbstractService<MbilBanklist> implements IMbilBanklistService {
	@Resource(name="mbilBanklistDao")
	private IMbilBanklistDao dao;

	public MbilBanklistService() {
		super();
	}
	@Override
	protected IOperations<MbilBanklist> getDao() {
		return this.dao;
	}

}

