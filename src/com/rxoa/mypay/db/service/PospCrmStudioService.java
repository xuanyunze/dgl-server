package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IPospCrmStudioService;
import com.rxoa.mypay.db.dao.in.IPospCrmStudioDao;
import com.rxoa.mypay.db.po.PospCrmStudio;

/**
 * posp_crm_studio Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("pospCrmStudioService")
public class PospCrmStudioService extends AbstractService<PospCrmStudio> implements IPospCrmStudioService {
	@Resource(name="pospCrmStudioDao")
	private IPospCrmStudioDao dao;

	public PospCrmStudioService() {
		super();
	}
	@Override
	protected IOperations<PospCrmStudio> getDao() {
		return this.dao;
	}

}

