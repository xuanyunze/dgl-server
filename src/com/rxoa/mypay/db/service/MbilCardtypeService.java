package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilCardtypeService;
import com.rxoa.mypay.db.dao.in.IMbilCardtypeDao;
import com.rxoa.mypay.db.po.MbilCardtype;

/**
 * mbil_cardtype Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilCardtypeService")
public class MbilCardtypeService extends AbstractService<MbilCardtype> implements IMbilCardtypeService {
	@Resource(name="mbilCardtypeDao")
	private IMbilCardtypeDao dao;

	public MbilCardtypeService() {
		super();
	}
	@Override
	protected IOperations<MbilCardtype> getDao() {
		return this.dao;
	}

}

