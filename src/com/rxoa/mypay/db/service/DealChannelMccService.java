package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IDealChannelMccService;
import com.rxoa.mypay.db.dao.in.IDealChannelMccDao;
import com.rxoa.mypay.db.po.DealChannelMcc;

/**
 * deal_channel_mcc Service服务类
 * Tue Apr 05 11:23:26 CST 2016 baiyu
 */ 

@Service("dealChannelMccService")
public class DealChannelMccService extends AbstractService<DealChannelMcc> implements IDealChannelMccService {
	@Resource(name="dealChannelMccDao")
	private IDealChannelMccDao dao;

	public DealChannelMccService() {
		super();
	}
	@Override
	protected IOperations<DealChannelMcc> getDao() {
		return this.dao;
	}

}

