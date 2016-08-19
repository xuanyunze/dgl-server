package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IDealChannelMchinfoDao;
import com.rxoa.mypay.db.po.DealChannelMchinfo;

/**
 * deal_channel_mchinfo DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("dealChannelMchinfoDao")
public class DealChannelMchinfoDao extends AbstractHibernateDao<DealChannelMchinfo> implements IDealChannelMchinfoDao {
	public DealChannelMchinfoDao() {
		super();
		setClazz(DealChannelMchinfo.class);
	}

}

