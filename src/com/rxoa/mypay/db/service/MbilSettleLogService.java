package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilSettleLogService;
import com.rxoa.mypay.db.dao.in.IMbilSettleLogDao;
import com.rxoa.mypay.db.po.MbilSettleLog;

/**
 * mbil_settle_log Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilSettleLogService")
public class MbilSettleLogService extends AbstractService<MbilSettleLog> implements IMbilSettleLogService {
	@Resource(name="mbilSettleLogDao")
	private IMbilSettleLogDao dao;

	public MbilSettleLogService() {
		super();
	}
	@Override
	protected IOperations<MbilSettleLog> getDao() {
		return this.dao;
	}

}

