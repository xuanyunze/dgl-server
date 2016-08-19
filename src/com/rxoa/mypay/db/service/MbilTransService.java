package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilTransService;
import com.rxoa.mypay.db.dao.in.IMbilTransDao;
import com.rxoa.mypay.db.po.MbilTrans;

/**
 * mbil_trans Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilTransService")
public class MbilTransService extends AbstractService<MbilTrans> implements IMbilTransService {
	@Resource(name="mbilTransDao")
	private IMbilTransDao dao;

	public MbilTransService() {
		super();
	}
	@Override
	protected IOperations<MbilTrans> getDao() {
		return this.dao;
	}

}

