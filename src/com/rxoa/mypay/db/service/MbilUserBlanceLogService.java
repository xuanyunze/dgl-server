package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilUserBlanceLogService;
import com.rxoa.mypay.db.dao.in.IMbilUserBlanceLogDao;
import com.rxoa.mypay.db.po.MbilUserBlanceLog;

/**
 * mbil_user_blance_log Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilUserBlanceLogService")
public class MbilUserBlanceLogService extends AbstractService<MbilUserBlanceLog> implements IMbilUserBlanceLogService {
	@Resource(name="mbilUserBlanceLogDao")
	private IMbilUserBlanceLogDao dao;

	public MbilUserBlanceLogService() {
		super();
	}
	@Override
	protected IOperations<MbilUserBlanceLog> getDao() {
		return this.dao;
	}

}

