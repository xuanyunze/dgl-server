package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilOrderRepaycreditService;
import com.rxoa.mypay.db.dao.in.IMbilOrderRepaycreditDao;
import com.rxoa.mypay.db.po.MbilOrderRepaycredit;

/**
 * mbil_order_repaycredit Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilOrderRepaycreditService")
public class MbilOrderRepaycreditService extends AbstractService<MbilOrderRepaycredit> implements IMbilOrderRepaycreditService {
	@Resource(name="mbilOrderRepaycreditDao")
	private IMbilOrderRepaycreditDao dao;

	public MbilOrderRepaycreditService() {
		super();
	}
	@Override
	protected IOperations<MbilOrderRepaycredit> getDao() {
		return this.dao;
	}

}

