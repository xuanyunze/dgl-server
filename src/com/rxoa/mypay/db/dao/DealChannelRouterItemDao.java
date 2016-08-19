package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IDealChannelRouterItemDao;
import com.rxoa.mypay.db.po.DealChannelRouterItem;

/**
 * deal_channel_router_item DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("dealChannelRouterItemDao")
public class DealChannelRouterItemDao extends AbstractHibernateDao<DealChannelRouterItem> implements IDealChannelRouterItemDao {
	public DealChannelRouterItemDao() {
		super();
		setClazz(DealChannelRouterItem.class);
	}

}

