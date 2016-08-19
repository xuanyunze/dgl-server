package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IDealChannelMchgroupDao;
import com.rxoa.mypay.db.po.DealChannelMchgroup;

/**
 * deal_channel_mchgroup DAO操作类
 * Tue Apr 05 11:23:26 CST 2016 baiyu
 */ 

@Repository("dealChannelMchgroupDao")
public class DealChannelMchgroupDao extends AbstractHibernateDao<DealChannelMchgroup> implements IDealChannelMchgroupDao {
	public DealChannelMchgroupDao() {
		super();
		setClazz(DealChannelMchgroup.class);
	}

}

