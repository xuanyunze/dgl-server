package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilUserLimitDao;
import com.rxoa.mypay.db.po.MbilUserLimit;

/**
 * mbil_user_limit DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilUserLimitDao")
public class MbilUserLimitDao extends AbstractHibernateDao<MbilUserLimit> implements IMbilUserLimitDao {
	public MbilUserLimitDao() {
		super();
		setClazz(MbilUserLimit.class);
	}

}

