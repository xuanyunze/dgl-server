package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilBusinessService;
import com.rxoa.mypay.db.dao.in.IMbilBusinessDao;
import com.rxoa.mypay.db.po.MbilBusiness;

/**
 * mbil_business Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilBusinessService")
public class MbilBusinessService extends AbstractService<MbilBusiness> implements IMbilBusinessService {
	@Resource(name="mbilBusinessDao")
	private IMbilBusinessDao dao;

	public MbilBusinessService() {
		super();
	}
	@Override
	protected IOperations<MbilBusiness> getDao() {
		return this.dao;
	}

}

