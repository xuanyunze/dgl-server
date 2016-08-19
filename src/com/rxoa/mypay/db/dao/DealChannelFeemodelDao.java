package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IDealChannelFeemodelDao;
import com.rxoa.mypay.db.po.DealChannelFeemodel;

/**
 * deal_channel_feemodel DAO操作类
 * Tue Apr 05 11:23:26 CST 2016 baiyu
 */ 

@Repository("dealChannelFeemodelDao")
public class DealChannelFeemodelDao extends AbstractHibernateDao<DealChannelFeemodel> implements IDealChannelFeemodelDao {
	public DealChannelFeemodelDao() {
		super();
		setClazz(DealChannelFeemodel.class);
	}

}

