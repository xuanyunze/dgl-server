package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilUserService;
import com.rxoa.mypay.db.dao.in.IMbilUserDao;
import com.rxoa.mypay.db.po.MbilUser;

/**
 * mbil_user Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilUserService")
public class MbilUserService extends AbstractService<MbilUser> implements IMbilUserService {
	@Resource(name="mbilUserDao")
	private IMbilUserDao dao;

	public MbilUserService() {
		super();
	}
	@Override
	protected IOperations<MbilUser> getDao() {
		return this.dao;
	}

}

