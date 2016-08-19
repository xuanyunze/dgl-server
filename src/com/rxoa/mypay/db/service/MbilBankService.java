package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilBankService;
import com.rxoa.mypay.db.dao.in.IMbilBankDao;
import com.rxoa.mypay.db.po.MbilBank;

/**
 * mbil_bank Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("mbilBankService")
public class MbilBankService extends AbstractService<MbilBank> implements IMbilBankService {
	@Resource(name="mbilBankDao")
	private IMbilBankDao dao;

	public MbilBankService() {
		super();
	}
	@Override
	protected IOperations<MbilBank> getDao() {
		return this.dao;
	}

}

