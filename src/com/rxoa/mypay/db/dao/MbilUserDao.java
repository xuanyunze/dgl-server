package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilUserDao;
import com.rxoa.mypay.db.po.MbilUser;

/**
 * mbil_user DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilUserDao")
public class MbilUserDao extends AbstractHibernateDao<MbilUser> implements IMbilUserDao {
	public MbilUserDao() {
		super();
		setClazz(MbilUser.class);
	}

}

