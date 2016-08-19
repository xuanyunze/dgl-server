package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IDealChannelRouterItemService;
import com.rxoa.mypay.db.dao.in.IDealChannelRouterItemDao;
import com.rxoa.mypay.db.po.DealChannelRouterItem;

/**
 * deal_channel_router_item Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("dealChannelRouterItemService")
public class DealChannelRouterItemService extends AbstractService<DealChannelRouterItem> implements IDealChannelRouterItemService {
	@Resource(name="dealChannelRouterItemDao")
	private IDealChannelRouterItemDao dao;

	public DealChannelRouterItemService() {
		super();
	}
	@Override
	protected IOperations<DealChannelRouterItem> getDao() {
		return this.dao;
	}

}

