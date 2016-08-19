package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilOrderTypeService;
import com.rxoa.mypay.db.dao.in.IMbilOrderTypeDao;
import com.rxoa.mypay.db.po.MbilOrderType;

/**
 * mbil_order_type Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilOrderTypeService")
public class MbilOrderTypeService extends AbstractService<MbilOrderType> implements IMbilOrderTypeService {
	@Resource(name="mbilOrderTypeDao")
	private IMbilOrderTypeDao dao;

	public MbilOrderTypeService() {
		super();
	}
	@Override
	protected IOperations<MbilOrderType> getDao() {
		return this.dao;
	}

}

