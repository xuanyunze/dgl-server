package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilWfActivateService;
import com.rxoa.mypay.db.dao.in.IMbilWfActivateDao;
import com.rxoa.mypay.db.po.MbilWfActivate;

/**
 * mbil_wf_activate Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilWfActivateService")
public class MbilWfActivateService extends AbstractService<MbilWfActivate> implements IMbilWfActivateService {
	@Resource(name="mbilWfActivateDao")
	private IMbilWfActivateDao dao;

	public MbilWfActivateService() {
		super();
	}
	@Override
	protected IOperations<MbilWfActivate> getDao() {
		return this.dao;
	}

}

