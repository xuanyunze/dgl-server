package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilChannelDao;
import com.rxoa.mypay.db.po.MbilChannel;

/**
 * mbil_channel DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilChannelDao")
public class MbilChannelDao extends AbstractHibernateDao<MbilChannel> implements IMbilChannelDao {
	public MbilChannelDao() {
		super();
		setClazz(MbilChannel.class);
	}

}

