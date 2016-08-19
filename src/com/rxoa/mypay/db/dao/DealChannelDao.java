package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IDealChannelDao;
import com.rxoa.mypay.db.po.DealChannel;

/**
 * deal_channel DAO操作类
 * Tue Apr 05 11:23:26 CST 2016 baiyu
 */ 

@Repository("dealChannelDao")
public class DealChannelDao extends AbstractHibernateDao<DealChannel> implements IDealChannelDao {
	public DealChannelDao() {
		super();
		setClazz(DealChannel.class);
	}

}

