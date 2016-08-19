package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IPospErpDeviceService;
import com.rxoa.mypay.db.dao.in.IPospErpDeviceDao;
import com.rxoa.mypay.db.po.PospErpDevice;

/**
 * posp_erp_device Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("pospErpDeviceService")
public class PospErpDeviceService extends AbstractService<PospErpDevice> implements IPospErpDeviceService {
	@Resource(name="pospErpDeviceDao")
	private IPospErpDeviceDao dao;

	public PospErpDeviceService() {
		super();
	}
	@Override
	protected IOperations<PospErpDevice> getDao() {
		return this.dao;
	}

}

