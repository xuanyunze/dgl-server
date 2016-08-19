package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IPospCrmEnterpriseService;
import com.rxoa.mypay.db.dao.in.IPospCrmEnterpriseDao;
import com.rxoa.mypay.db.po.PospCrmEnterprise;

/**
 * posp_crm_enterprise Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("pospCrmEnterpriseService")
public class PospCrmEnterpriseService extends AbstractService<PospCrmEnterprise> implements IPospCrmEnterpriseService {
	@Resource(name="pospCrmEnterpriseDao")
	private IPospCrmEnterpriseDao dao;

	public PospCrmEnterpriseService() {
		super();
	}
	@Override
	protected IOperations<PospCrmEnterprise> getDao() {
		return this.dao;
	}

}

