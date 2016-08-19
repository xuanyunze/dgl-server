package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilDeviceService;
import com.rxoa.mypay.db.dao.in.IMbilDeviceDao;
import com.rxoa.mypay.db.po.MbilDevice;

/**
 * mbil_device Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilDeviceService")
public class MbilDeviceService extends AbstractService<MbilDevice> implements IMbilDeviceService {
	@Resource(name="mbilDeviceDao")
	private IMbilDeviceDao dao;

	public MbilDeviceService() {
		super();
	}
	@Override
	protected IOperations<MbilDevice> getDao() {
		return this.dao;
	}

}

