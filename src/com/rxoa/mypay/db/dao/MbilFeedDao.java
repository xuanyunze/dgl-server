package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilFeedDao;
import com.rxoa.mypay.db.po.MbilFeed;

/**
 * mbil_feed DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilFeedDao")
public class MbilFeedDao extends AbstractHibernateDao<MbilFeed> implements IMbilFeedDao {
	public MbilFeedDao() {
		super();
		setClazz(MbilFeed.class);
	}

}

