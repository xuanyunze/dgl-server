package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilActiveCodeService;
import com.rxoa.mypay.db.dao.in.IMbilActiveCodeDao;
import com.rxoa.mypay.db.po.MbilActiveCode;

/**
 * mbil_active_code Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("mbilActiveCodeService")
public class MbilActiveCodeService extends AbstractService<MbilActiveCode> implements IMbilActiveCodeService {
	@Resource(name="mbilActiveCodeDao")
	private IMbilActiveCodeDao dao;

	public MbilActiveCodeService() {
		super();
	}
	@Override
	protected IOperations<MbilActiveCode> getDao() {
		return this.dao;
	}

}

