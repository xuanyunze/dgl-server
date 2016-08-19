package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IDealChannelService;
import com.rxoa.mypay.db.dao.in.IDealChannelDao;
import com.rxoa.mypay.db.po.DealChannel;

/**
 * deal_channel Service服务类
 * Tue Apr 05 11:23:26 CST 2016 baiyu
 */ 

@Service("dealChannelService")
public class DealChannelService extends AbstractService<DealChannel> implements IDealChannelService {
	@Resource(name="dealChannelDao")
	private IDealChannelDao dao;

	public DealChannelService() {
		super();
	}
	@Override
	protected IOperations<DealChannel> getDao() {
		return this.dao;
	}

}

