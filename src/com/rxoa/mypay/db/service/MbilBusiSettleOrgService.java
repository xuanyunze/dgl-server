package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilBusiSettleOrgService;
import com.rxoa.mypay.db.dao.in.IMbilBusiSettleOrgDao;
import com.rxoa.mypay.db.po.MbilBusiSettleOrg;

/**
 * mbil_busi_settle_org Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilBusiSettleOrgService")
public class MbilBusiSettleOrgService extends AbstractService<MbilBusiSettleOrg> implements IMbilBusiSettleOrgService {
	@Resource(name="mbilBusiSettleOrgDao")
	private IMbilBusiSettleOrgDao dao;

	public MbilBusiSettleOrgService() {
		super();
	}
	@Override
	protected IOperations<MbilBusiSettleOrg> getDao() {
		return this.dao;
	}

}

