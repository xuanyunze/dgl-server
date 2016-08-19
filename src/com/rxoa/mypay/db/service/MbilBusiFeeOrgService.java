package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilBusiFeeOrgService;
import com.rxoa.mypay.db.dao.in.IMbilBusiFeeOrgDao;
import com.rxoa.mypay.db.po.MbilBusiFeeOrg;

/**
 * mbil_busi_fee_org Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("mbilBusiFeeOrgService")
public class MbilBusiFeeOrgService extends AbstractService<MbilBusiFeeOrg> implements IMbilBusiFeeOrgService {
	@Resource(name="mbilBusiFeeOrgDao")
	private IMbilBusiFeeOrgDao dao;

	public MbilBusiFeeOrgService() {
		super();
	}
	@Override
	protected IOperations<MbilBusiFeeOrg> getDao() {
		return this.dao;
	}

}

