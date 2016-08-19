package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilUserBlanceService;
import com.rxoa.mypay.db.dao.in.IMbilUserBlanceDao;
import com.rxoa.mypay.db.po.MbilUserBlance;

/**
 * mbil_user_blance Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilUserBlanceService")
public class MbilUserBlanceService extends AbstractService<MbilUserBlance> implements IMbilUserBlanceService {
	@Resource(name="mbilUserBlanceDao")
	private IMbilUserBlanceDao dao;

	public MbilUserBlanceService() {
		super();
	}
	@Override
	protected IOperations<MbilUserBlance> getDao() {
		return this.dao;
	}

}

