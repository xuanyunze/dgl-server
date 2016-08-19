package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilLogService;
import com.rxoa.mypay.db.dao.in.IMbilLogDao;
import com.rxoa.mypay.db.po.MbilLog;

/**
 * mbil_log Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilLogService")
public class MbilLogService extends AbstractService<MbilLog> implements IMbilLogService {
	@Resource(name="mbilLogDao")
	private IMbilLogDao dao;

	public MbilLogService() {
		super();
	}
	@Override
	protected IOperations<MbilLog> getDao() {
		return this.dao;
	}

}

