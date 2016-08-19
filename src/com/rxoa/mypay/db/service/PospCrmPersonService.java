package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IPospCrmPersonService;
import com.rxoa.mypay.db.dao.in.IPospCrmPersonDao;
import com.rxoa.mypay.db.po.PospCrmPerson;

/**
 * posp_crm_person Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("pospCrmPersonService")
public class PospCrmPersonService extends AbstractService<PospCrmPerson> implements IPospCrmPersonService {
	@Resource(name="pospCrmPersonDao")
	private IPospCrmPersonDao dao;

	public PospCrmPersonService() {
		super();
	}
	@Override
	protected IOperations<PospCrmPerson> getDao() {
		return this.dao;
	}

}

