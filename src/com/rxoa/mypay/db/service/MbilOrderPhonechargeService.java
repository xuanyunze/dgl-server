package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilOrderPhonechargeService;
import com.rxoa.mypay.db.dao.in.IMbilOrderPhonechargeDao;
import com.rxoa.mypay.db.po.MbilOrderPhonecharge;

/**
 * mbil_order_phonecharge Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilOrderPhonechargeService")
public class MbilOrderPhonechargeService extends AbstractService<MbilOrderPhonecharge> implements IMbilOrderPhonechargeService {
	@Resource(name="mbilOrderPhonechargeDao")
	private IMbilOrderPhonechargeDao dao;

	public MbilOrderPhonechargeService() {
		super();
	}
	@Override
	protected IOperations<MbilOrderPhonecharge> getDao() {
		return this.dao;
	}

}

