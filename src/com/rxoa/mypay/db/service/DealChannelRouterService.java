package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IDealChannelRouterService;
import com.rxoa.mypay.db.dao.in.IDealChannelRouterDao;
import com.rxoa.mypay.db.po.DealChannelRouter;

/**
 * deal_channel_router Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("dealChannelRouterService")
public class DealChannelRouterService extends AbstractService<DealChannelRouter> implements IDealChannelRouterService {
	@Resource(name="dealChannelRouterDao")
	private IDealChannelRouterDao dao;

	public DealChannelRouterService() {
		super();
	}
	@Override
	protected IOperations<DealChannelRouter> getDao() {
		return this.dao;
	}

}

