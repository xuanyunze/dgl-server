package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IDealChannelFeemodelService;
import com.rxoa.mypay.db.dao.in.IDealChannelFeemodelDao;
import com.rxoa.mypay.db.po.DealChannelFeemodel;

/**
 * deal_channel_feemodel Service服务类
 * Tue Apr 05 11:23:26 CST 2016 baiyu
 */ 

@Service("dealChannelFeemodelService")
public class DealChannelFeemodelService extends AbstractService<DealChannelFeemodel> implements IDealChannelFeemodelService {
	@Resource(name="dealChannelFeemodelDao")
	private IDealChannelFeemodelDao dao;

	public DealChannelFeemodelService() {
		super();
	}
	@Override
	protected IOperations<DealChannelFeemodel> getDao() {
		return this.dao;
	}

}

