package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilSmsRecordService;
import com.rxoa.mypay.db.dao.in.IMbilSmsRecordDao;
import com.rxoa.mypay.db.po.MbilSmsRecord;

/**
 * mbil_sms_record Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilSmsRecordService")
public class MbilSmsRecordService extends AbstractService<MbilSmsRecord> implements IMbilSmsRecordService {
	@Resource(name="mbilSmsRecordDao")
	private IMbilSmsRecordDao dao;

	public MbilSmsRecordService() {
		super();
	}
	@Override
	protected IOperations<MbilSmsRecord> getDao() {
		return this.dao;
	}

}

