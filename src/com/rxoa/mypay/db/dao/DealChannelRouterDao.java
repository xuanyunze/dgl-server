package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IDealChannelRouterDao;
import com.rxoa.mypay.db.po.DealChannelRouter;

/**
 * deal_channel_router DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("dealChannelRouterDao")
public class DealChannelRouterDao extends AbstractHibernateDao<DealChannelRouter> implements IDealChannelRouterDao {
	public DealChannelRouterDao() {
		super();
		setClazz(DealChannelRouter.class);
	}

}

