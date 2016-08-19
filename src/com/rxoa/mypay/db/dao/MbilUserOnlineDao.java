package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilUserOnlineDao;
import com.rxoa.mypay.db.po.MbilUserOnline;

/**
 * mbil_user_online DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilUserOnlineDao")
public class MbilUserOnlineDao extends AbstractHibernateDao<MbilUserOnline> implements IMbilUserOnlineDao {
	public MbilUserOnlineDao() {
		super();
		setClazz(MbilUserOnline.class);
	}

}

