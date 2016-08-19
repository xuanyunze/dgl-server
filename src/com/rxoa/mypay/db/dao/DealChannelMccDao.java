package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IDealChannelMccDao;
import com.rxoa.mypay.db.po.DealChannelMcc;

/**
 * deal_channel_mcc DAO操作类
 * Tue Apr 05 11:23:26 CST 2016 baiyu
 */ 

@Repository("dealChannelMccDao")
public class DealChannelMccDao extends AbstractHibernateDao<DealChannelMcc> implements IDealChannelMccDao {
	public DealChannelMccDao() {
		super();
		setClazz(DealChannelMcc.class);
	}

}

