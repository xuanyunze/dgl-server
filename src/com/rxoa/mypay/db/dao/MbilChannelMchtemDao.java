package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilChannelMchtemDao;
import com.rxoa.mypay.db.po.MbilChannelMchtem;

/**
 * mbil_channel_mchtem DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilChannelMchtemDao")
public class MbilChannelMchtemDao extends AbstractHibernateDao<MbilChannelMchtem> implements IMbilChannelMchtemDao {
	public MbilChannelMchtemDao() {
		super();
		setClazz(MbilChannelMchtem.class);
	}

}

