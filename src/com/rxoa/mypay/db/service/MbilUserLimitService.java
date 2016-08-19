package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilUserLimitService;
import com.rxoa.mypay.db.dao.in.IMbilUserLimitDao;
import com.rxoa.mypay.db.po.MbilUserLimit;

/**
 * mbil_user_limit Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilUserLimitService")
public class MbilUserLimitService extends AbstractService<MbilUserLimit> implements IMbilUserLimitService {
	@Resource(name="mbilUserLimitDao")
	private IMbilUserLimitDao dao;

	public MbilUserLimitService() {
		super();
	}
	@Override
	protected IOperations<MbilUserLimit> getDao() {
		return this.dao;
	}

}

