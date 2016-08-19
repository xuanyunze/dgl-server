package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilSmsCounterService;
import com.rxoa.mypay.db.dao.in.IMbilSmsCounterDao;
import com.rxoa.mypay.db.po.MbilSmsCounter;

/**
 * mbil_sms_counter Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilSmsCounterService")
public class MbilSmsCounterService extends AbstractService<MbilSmsCounter> implements IMbilSmsCounterService {
	@Resource(name="mbilSmsCounterDao")
	private IMbilSmsCounterDao dao;

	public MbilSmsCounterService() {
		super();
	}
	@Override
	protected IOperations<MbilSmsCounter> getDao() {
		return this.dao;
	}

}

