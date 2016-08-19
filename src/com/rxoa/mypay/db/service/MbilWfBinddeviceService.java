package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilWfBinddeviceService;
import com.rxoa.mypay.db.dao.in.IMbilWfBinddeviceDao;
import com.rxoa.mypay.db.po.MbilWfBinddevice;

/**
 * mbil_wf_binddevice Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("mbilWfBinddeviceService")
public class MbilWfBinddeviceService extends AbstractService<MbilWfBinddevice> implements IMbilWfBinddeviceService {
	@Resource(name="mbilWfBinddeviceDao")
	private IMbilWfBinddeviceDao dao;

	public MbilWfBinddeviceService() {
		super();
	}
	@Override
	protected IOperations<MbilWfBinddevice> getDao() {
		return this.dao;
	}

}

