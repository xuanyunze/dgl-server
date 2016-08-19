package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilBanktypeService;
import com.rxoa.mypay.db.dao.in.IMbilBanktypeDao;
import com.rxoa.mypay.db.po.MbilBanktype;

/**
 * mbil_banktype Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("mbilBanktypeService")
public class MbilBanktypeService extends AbstractService<MbilBanktype> implements IMbilBanktypeService {
	@Resource(name="mbilBanktypeDao")
	private IMbilBanktypeDao dao;

	public MbilBanktypeService() {
		super();
	}
	@Override
	protected IOperations<MbilBanktype> getDao() {
		return this.dao;
	}

}

